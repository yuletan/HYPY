package com.hanyupinyin.feature.flashcards

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
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
import com.hanyupinyin.core.model.GlossaryEntry
import com.hanyupinyin.core.model.SavedStudyItem
import com.hanyupinyin.core.model.StudySentence
import com.hanyupinyin.core.model.toToneMarkedPinyin
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

private val FlashcardSavedTimeFormatter: DateTimeFormatter = DateTimeFormatter
    .ofPattern("dd MMM, HH:mm")
    .withZone(ZoneId.systemDefault())

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlashcardsOverlay(
    savedStudies: List<SavedStudyItem>,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var selectedStudyId by rememberSaveable(savedStudies.firstOrNull()?.id, savedStudies.size) {
        mutableStateOf(savedStudies.firstOrNull()?.id)
    }
    val effectiveSelectedStudyId = selectedStudyId?.takeIf { selectedId ->
        savedStudies.any { study -> study.id == selectedId }
    }
    val selectedStudies = remember(savedStudies, effectiveSelectedStudyId) {
        if (effectiveSelectedStudyId == null) {
            savedStudies
        } else {
            savedStudies.filter { study -> study.id == effectiveSelectedStudyId }
        }
    }
    val cards = remember(selectedStudies) { selectedStudies.toFlashcardDeck() }
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
                .statusBarsPadding()
                .padding(top = 12.dp, end = 12.dp)
                .size(48.dp),
        ) {
            Icon(
                imageVector = Icons.Outlined.Close,
                contentDescription = "Close flashcards",
            )
        }

        if (savedStudies.isNotEmpty()) {
            FlashcardStudyChooser(
                savedStudies = savedStudies,
                selectedStudyId = effectiveSelectedStudyId,
                onSelectStudy = { selectedStudyId = it },
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .statusBarsPadding()
                    .padding(start = 16.dp, top = 12.dp, end = 72.dp),
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FlashcardStudyChooser(
    savedStudies: List<SavedStudyItem>,
    selectedStudyId: String?,
    onSelectStudy: (String?) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.96f),
        tonalElevation = 6.dp,
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = "Deck",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                FilterChip(
                    selected = selectedStudyId == null,
                    onClick = { onSelectStudy(null) },
                    label = { Text("All saves") },
                )
                savedStudies.forEachIndexed { index, study ->
                    FilterChip(
                        selected = selectedStudyId == study.id,
                        onClick = { onSelectStudy(study.id) },
                        label = {
                            Text(
                                text = study.deckLabel(isLatest = index == 0),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        },
                    )
                }
            }
        }
    }
}

@Composable
private fun EmptyFlashcardsState(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.widthIn(max = 360.dp),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 6.dp,
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = "No flashcards yet",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Saved glossary words will appear here.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        }
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
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.92f),
                    shape = RoundedCornerShape(999.dp),
                )
                .padding(horizontal = 14.dp, vertical = 8.dp),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface,
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
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = card.hanzi,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.42f),
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
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
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
            style = MaterialTheme.typography.displayLarge,
            fontSize = fontSize,
            fontWeight = FontWeight.SemiBold,
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
        )
        FlashcardSection(
            title = "Han yu pin yin",
            body = card.pinyin?.toToneMarkedPinyin() ?: "Pinyin not available yet.",
        )
        FlashcardSection(
            title = "Literal meaning",
            body = card.meaning ?: "Meaning not available yet.",
        )
        FlashcardSection(
            title = "Sentence",
            body = card.sentence ?: "Sentence not available yet.",
            supporting = card.sentencePinyin?.toToneMarkedPinyin(),
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
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = body,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
        )
        supporting?.let { detail ->
            Text(
                text = detail,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
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

private fun SavedStudyItem.deckLabel(isLatest: Boolean): String {
    val prefix = if (isLatest) "Latest" else FlashcardSavedTimeFormatter.format(
        Instant.ofEpochMilli(savedAtEpochMillis),
    )
    return "$prefix: ${title.take(24)}"
}

private fun StudySentence.contains(entry: GlossaryEntry): Boolean {
    return tokens.any { token -> token.hanzi == entry.hanzi } || hanzi.contains(entry.hanzi)
}

private fun String?.cleanOrNull(): String? {
    return this?.trim()?.takeIf { it.isNotBlank() }
}
