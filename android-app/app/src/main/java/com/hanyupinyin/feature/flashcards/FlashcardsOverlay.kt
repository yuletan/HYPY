package com.hanyupinyin.feature.flashcards

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hanyupinyin.app.theme.AppCard
import com.hanyupinyin.app.theme.AppCjkFontFamily
import com.hanyupinyin.app.theme.AppPill
import com.hanyupinyin.app.theme.EmptyState
import com.hanyupinyin.app.theme.PrimaryPillButton
import com.hanyupinyin.app.theme.SecondaryPillButton
import com.hanyupinyin.app.theme.SectionLabel
import com.hanyupinyin.app.theme.appColors
import com.hanyupinyin.core.model.GlossaryEntry
import com.hanyupinyin.core.model.SavedStudyItem
import com.hanyupinyin.core.model.StudySentence
import com.hanyupinyin.core.model.toToneMarkedPinyin
import com.hanyupinyin.feature.saved.SavedStudiesViewModel
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

private val FlashcardSavedTimeFormatter: DateTimeFormatter = DateTimeFormatter
    .ofPattern("dd MMM, HH:mm")
    .withZone(ZoneId.systemDefault())

@Composable
fun FlashcardsRoute(
    viewModel: SavedStudiesViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val colors = MaterialTheme.appColors
    var selectedStudyId by rememberSaveable { mutableStateOf<String?>(null) }
    val selectedStudy = selectedStudyId?.let { id ->
        uiState.items.firstOrNull { item -> item.id == id }
    }
    val reviewableItems = uiState.items.filter { item -> item.response.glossary.isNotEmpty() }
    val totalCards = reviewableItems.sumOf { item -> item.response.glossary.size }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.bg),
    ) {
        when {
            uiState.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator(
                        color = colors.accentFg,
                        trackColor = colors.surfaceRaised,
                    )
                }
            }

            uiState.items.isEmpty() -> {
                EmptyFlashcardsPage(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(24.dp),
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(start = 20.dp, top = 24.dp, end = 20.dp, bottom = 28.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    item {
                        StudyHeader(
                            totalCards = totalCards,
                            deckCount = reviewableItems.size,
                            onReviewNow = {
                                selectedStudyId = reviewableItems.firstOrNull()?.id
                            },
                        )
                    }
                    items(uiState.items, key = { item -> item.id }) { item ->
                        FlashcardStudyCard(
                            item = item,
                            onStart = { selectedStudyId = item.id },
                            onDelete = { viewModel.deleteStudy(item.id) },
                        )
                    }
                }
            }
        }

        selectedStudy?.let { study ->
            FlashcardsOverlay(
                savedStudies = listOf(study),
                onClose = { selectedStudyId = null },
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}

@Composable
private fun FlashcardsOverlay(
    savedStudies: List<SavedStudyItem>,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val cards = remember(savedStudies) { savedStudies.toFlashcardDeck() }
    val blockerInteractionSource = remember { MutableInteractionSource() }

    BackHandler(onBack = onClose)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.66f))
            .clickable(
                interactionSource = blockerInteractionSource,
                indication = null,
                onClick = {},
            ),
    ) {
        FilledTonalIconButton(
            onClick = onClose,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 12.dp, end = 12.dp)
                .size(48.dp),
        ) {
            Icon(
                imageVector = Icons.Outlined.Close,
                contentDescription = "Close flashcards",
                tint = MaterialTheme.appColors.textPrimary,
            )
        }

        if (cards.isEmpty()) {
            EmptyFlashcardsState(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(28.dp),
            )
        } else {
            FlashcardStage(
                cards = cards,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 24.dp),
            )
        }
    }
}

@Composable
private fun StudyHeader(
    totalCards: Int,
    deckCount: Int,
    onReviewNow: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.appColors

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Text(
            text = "Study",
            style = MaterialTheme.typography.headlineSmall,
            color = colors.textPrimary,
        )
        AppCard(
            modifier = Modifier.fillMaxWidth(),
            containerColor = colors.accentBgAlpha,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        text = "$totalCards cards ready today",
                        style = MaterialTheme.typography.titleMedium,
                        color = colors.textPrimary,
                    )
                    Text(
                        text = "Across $deckCount decks",
                        style = MaterialTheme.typography.bodySmall,
                        color = colors.textSecondary,
                    )
                }
                PrimaryPillButton(
                    text = "Review now",
                    onClick = onReviewNow,
                    enabled = totalCards > 0,
                )
            }
        }
    }
}

@Composable
private fun EmptyFlashcardsPage(modifier: Modifier = Modifier) {
    EmptyState(
        title = "No saved studies yet",
        body = "Save a reader study first, then choose it here to start flashcards.",
        modifier = modifier,
    )
}

@Composable
private fun FlashcardStudyCard(
    item: SavedStudyItem,
    onStart: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.appColors
    val previewTerms = item.response.glossary.take(3)
    var confirmDelete by rememberSaveable(item.id) { mutableStateOf(false) }

    AppCard(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            AppPill(label = item.response.language.uppercase())
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleLarge.copy(fontFamily = AppCjkFontFamily),
                fontWeight = FontWeight.Bold,
                color = colors.textPrimary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = "${item.response.glossary.size} cards - Saved ${FlashcardSavedTimeFormatter.format(Instant.ofEpochMilli(item.savedAtEpochMillis))}",
                style = MaterialTheme.typography.bodySmall,
                color = colors.textMuted,
            )
        }

        if (previewTerms.isNotEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                previewTerms.forEach { entry ->
                    Text(
                        text = entry.hanzi,
                        modifier = Modifier
                            .background(colors.surfaceRaised, RoundedCornerShape(8.dp))
                            .border(1.dp, colors.border, RoundedCornerShape(8.dp))
                            .padding(horizontal = 10.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.bodyMedium.copy(fontFamily = AppCjkFontFamily),
                        color = colors.textSecondary,
                        maxLines = 1,
                    )
                }
                if (item.response.glossary.size > previewTerms.size) {
                    Text(
                        text = "+${item.response.glossary.size - previewTerms.size} more",
                        style = MaterialTheme.typography.bodySmall,
                        color = colors.textMuted,
                    )
                }
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Ready deck",
                    style = MaterialTheme.typography.bodySmall,
                    color = colors.textSecondary,
                )
                Text(
                    text = if (item.response.glossary.isEmpty()) "0%" else "100%",
                    style = MaterialTheme.typography.labelMedium,
                    color = colors.textPrimary,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(colors.surfaceRaised, RoundedCornerShape(100.dp)),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(if (item.response.glossary.isEmpty()) 0f else 1f)
                        .height(4.dp)
                        .background(colors.accentBg, RoundedCornerShape(100.dp)),
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            PrimaryPillButton(
                text = "Start Flashcards",
                onClick = onStart,
                enabled = item.response.glossary.isNotEmpty(),
                modifier = Modifier.weight(2f),
            )
            SecondaryPillButton(
                text = if (confirmDelete) "Tap again to delete" else "Delete deck",
                onClick = {
                    if (confirmDelete) {
                        confirmDelete = false
                        onDelete()
                    } else {
                        confirmDelete = true
                    }
                },
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
private fun EmptyFlashcardsState(modifier: Modifier = Modifier) {
    AppCard(
        modifier = modifier.widthIn(max = 360.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = "No flashcards yet",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.appColors.textPrimary,
            textAlign = TextAlign.Center,
        )
        Text(
            text = "Saved glossary words will appear here.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.appColors.textSecondary,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun FlashcardStage(
    cards: List<FlashcardItem>,
    modifier: Modifier = Modifier,
) {
    var currentIndex by remember(cards) { mutableStateOf(0) }
    var flipped by remember(cards) { mutableStateOf(false) }
    val currentCard = cards[currentIndex]
    val nextCard = cards[(currentIndex + 1) % cards.size]
    val cardOffsetX = remember(cards) { Animatable(0f) }
    val cardOffsetY = remember(cards) { Animatable(0f) }
    val scope = rememberCoroutineScope()
    val swipeThresholdPx = with(LocalDensity.current) { 92.dp.toPx() }
    val stackOffsetPx = with(LocalDensity.current) { 18.dp.toPx() }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "${currentIndex + 1} / ${cards.size}",
            modifier = Modifier
                .background(
                    color = MaterialTheme.appColors.surface.copy(alpha = 0.92f),
                    shape = RoundedCornerShape(999.dp),
                )
                .border(1.dp, MaterialTheme.appColors.border, RoundedCornerShape(999.dp))
                .padding(horizontal = 14.dp, vertical = 8.dp),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.appColors.textPrimary,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .widthIn(max = 440.dp)
                .fillMaxWidth()
                .aspectRatio(0.72f),
            contentAlignment = Alignment.Center,
        ) {
            if (cards.size > 1) {
                FlashcardStackPreview(
                    card = nextCard,
                    modifier = Modifier
                        .matchParentSize()
                        .graphicsLayer {
                            scaleX = 0.93f
                            scaleY = 0.93f
                            translationY = stackOffsetPx
                        },
                )
            }
            FlashcardCard(
                card = currentCard,
                flipped = flipped,
                onFlip = { flipped = !flipped },
                modifier = Modifier
                    .matchParentSize()
                    .graphicsLayer {
                        translationX = cardOffsetX.value
                        translationY = cardOffsetY.value
                        rotationZ = cardOffsetX.value / 42f
                    }
                    .pointerInput(currentCard.id, cards.size) {
                        detectDragGestures(
                            onDrag = { change, dragAmount ->
                                change.consume()
                                scope.launch {
                                    cardOffsetX.snapTo(cardOffsetX.value + dragAmount.x)
                                    cardOffsetY.snapTo(cardOffsetY.value + dragAmount.y)
                                }
                            },
                            onDragCancel = {
                                scope.launch {
                                    val returnAnimation = spring<Float>(
                                        dampingRatio = Spring.DampingRatioMediumBouncy,
                                        stiffness = Spring.StiffnessMedium,
                                    )
                                    joinAll(
                                        launch {
                                            cardOffsetX.animateTo(
                                                targetValue = 0f,
                                                animationSpec = returnAnimation,
                                            )
                                        },
                                        launch {
                                            cardOffsetY.animateTo(
                                                targetValue = 0f,
                                                animationSpec = returnAnimation,
                                            )
                                        },
                                    )
                                }
                            },
                            onDragEnd = {
                                val releasedOffset = Offset(cardOffsetX.value, cardOffsetY.value)
                                scope.launch {
                                    if (releasedOffset.getDistance() >= swipeThresholdPx) {
                                        val distance = releasedOffset.getDistance().coerceAtLeast(1f)
                                        val direction = Offset(
                                            x = releasedOffset.x / distance,
                                            y = releasedOffset.y / distance,
                                        )
                                        val travelDistance = maxOf(size.width, size.height).toFloat() * 1.25f
                                        val exitAnimation = tween<Float>(
                                            durationMillis = 180,
                                            easing = FastOutLinearInEasing,
                                        )
                                        joinAll(
                                            launch {
                                                cardOffsetX.animateTo(
                                                    targetValue = direction.x * travelDistance,
                                                    animationSpec = exitAnimation,
                                                )
                                            },
                                            launch {
                                                cardOffsetY.animateTo(
                                                    targetValue = direction.y * travelDistance,
                                                    animationSpec = exitAnimation,
                                                )
                                            },
                                        )
                                        currentIndex = (currentIndex + 1) % cards.size
                                        flipped = false
                                        cardOffsetX.snapTo(0f)
                                        cardOffsetY.snapTo(0f)
                                    } else {
                                        val returnAnimation = spring<Float>(
                                            dampingRatio = Spring.DampingRatioMediumBouncy,
                                            stiffness = Spring.StiffnessMedium,
                                        )
                                        joinAll(
                                            launch {
                                                cardOffsetX.animateTo(
                                                    targetValue = 0f,
                                                    animationSpec = returnAnimation,
                                                )
                                            },
                                            launch {
                                                cardOffsetY.animateTo(
                                                    targetValue = 0f,
                                                    animationSpec = returnAnimation,
                                                )
                                            },
                                        )
                                    }
                                }
                            },
                        )
                    },
            )
        }
    }
}

@Composable
private fun FlashcardStackPreview(
    card: FlashcardItem,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier.alpha(0.68f),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.appColors.surfaceRaised,
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(1.dp, MaterialTheme.appColors.border, RoundedCornerShape(14.dp))
                .padding(32.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = card.hanzi,
                style = MaterialTheme.typography.displaySmall.copy(fontFamily = AppCjkFontFamily),
                color = MaterialTheme.appColors.textMuted,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun FlashcardCard(
    card: FlashcardItem,
    flipped: Boolean,
    onFlip: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val rotation by animateFloatAsState(
        targetValue = if (flipped) 180f else 0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMediumLow,
        ),
        label = "flashcard-flip",
    )
    val showBack = rotation > 90f
    val cameraDistance = 18f * LocalDensity.current.density

    ElevatedCard(
        modifier = modifier
            .graphicsLayer {
                rotationY = rotation
                this.cameraDistance = cameraDistance
            }
            .clickable(onClick = onFlip),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.appColors.surface,
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(1.dp, MaterialTheme.appColors.border, RoundedCornerShape(14.dp))
                .graphicsLayer {
                    if (showBack) {
                        rotationY = 180f
                    }
                },
        ) {
            if (showBack) {
                FlashcardBack(card = card)
            } else {
                FlashcardFront(card = card)
            }
        }
    }
}

@Composable
private fun FlashcardFront(
    card: FlashcardItem,
    modifier: Modifier = Modifier,
) {
    val fontSize = when {
        card.hanzi.length <= 2 -> 64.sp
        card.hanzi.length <= 4 -> 54.sp
        card.hanzi.length <= 7 -> 42.sp
        else -> 34.sp
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = card.hanzi,
            style = MaterialTheme.typography.displayLarge.copy(fontFamily = AppCjkFontFamily),
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.appColors.textPrimary,
            textAlign = TextAlign.Center,
            lineHeight = (fontSize.value * 1.18f).sp,
        )
    }
}

@Composable
private fun FlashcardBack(
    card: FlashcardItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        FlashcardSection(
            title = "Glossary",
            body = card.hanzi,
            useCjkFont = true,
        )
        FlashcardSection(
            title = "Han yu pin yin",
            body = card.pinyin?.toToneMarkedPinyin() ?: "Pinyin not available yet.",
            useCjkFont = true,
        )
        FlashcardSection(
            title = "Literal meaning",
            body = card.meaning ?: "Meaning not available yet.",
        )
        FlashcardSection(
            title = "Sentence",
            body = card.sentence ?: "Sentence not available yet.",
            supporting = card.sentencePinyin?.toToneMarkedPinyin(),
            useCjkFont = true,
        )
        card.sentenceTranslation?.let { translation ->
            FlashcardSection(
                title = "Translation",
                body = translation,
            )
        }
    }
}

@Composable
private fun FlashcardSection(
    title: String,
    body: String,
    modifier: Modifier = Modifier,
    supporting: String? = null,
    useCjkFont: Boolean = false,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        SectionLabel(text = title)
        Text(
            text = body,
            style = if (useCjkFont) {
                MaterialTheme.typography.bodyLarge.copy(fontFamily = AppCjkFontFamily)
            } else {
                MaterialTheme.typography.bodyLarge
            },
            color = MaterialTheme.appColors.textPrimary,
        )
        supporting?.let { detail ->
            Text(
                text = detail,
                style = MaterialTheme.typography.bodyMedium.copy(fontFamily = AppCjkFontFamily),
                color = MaterialTheme.appColors.textSecondary,
            )
        }
    }
}

private data class FlashcardItem(
    val id: String,
    val hanzi: String,
    val pinyin: String?,
    val meaning: String?,
    val sentence: String?,
    val sentencePinyin: String?,
    val sentenceTranslation: String?,
)

private fun List<SavedStudyItem>.toFlashcardDeck(): List<FlashcardItem> {
    val seenCards = mutableSetOf<String>()

    return flatMap { savedStudy ->
        savedStudy.response.glossary.mapIndexedNotNull { index, entry ->
            val sentenceMatch = savedStudy.response.sentences.firstOrNull { sentence ->
                sentence.contains(entry)
            }
            val tokenMatch = sentenceMatch?.tokens?.firstOrNull { token ->
                token.hanzi == entry.hanzi
            }
            val hanzi = entry.hanzi.cleanOrNull() ?: return@mapIndexedNotNull null
            val pinyin = entry.pinyin.cleanOrNull() ?: tokenMatch?.pinyin.cleanOrNull()
            val meaning = entry.meaning.cleanOrNull() ?: tokenMatch?.meaning.cleanOrNull()
            val sentence = entry.exampleSentence.cleanOrNull() ?: sentenceMatch?.hanzi.cleanOrNull()
            val sentencePinyin = entry.exampleSentencePinyin.cleanOrNull() ?: sentenceMatch?.pinyin.cleanOrNull()
            val sentenceTranslation = sentenceMatch?.translation.cleanOrNull()
            val key = listOf(hanzi, pinyin.orEmpty(), meaning.orEmpty()).joinToString("|")

            if (!seenCards.add(key)) {
                return@mapIndexedNotNull null
            }

            FlashcardItem(
                id = "${savedStudy.id}-$index-$hanzi",
                hanzi = hanzi,
                pinyin = pinyin,
                meaning = meaning,
                sentence = sentence,
                sentencePinyin = sentencePinyin,
                sentenceTranslation = sentenceTranslation,
            )
        }
    }
}

private fun StudySentence.contains(entry: GlossaryEntry): Boolean {
    return tokens.any { token -> token.hanzi == entry.hanzi } || hanzi.contains(entry.hanzi)
}

private fun String?.cleanOrNull(): String? {
    return this?.trim()?.takeIf { it.isNotBlank() }
}
