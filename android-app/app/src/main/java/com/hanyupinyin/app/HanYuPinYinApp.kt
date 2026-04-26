package com.hanyupinyin.app

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Style
import androidx.compose.material.icons.outlined.UploadFile
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hanyupinyin.app.navigation.AppDestination
import com.hanyupinyin.app.navigation.AppNavGraph
import com.hanyupinyin.app.data.AppSettings
import com.hanyupinyin.app.data.AppSettingsRepository
import com.hanyupinyin.app.data.BackendWarmupRepository
import com.hanyupinyin.app.theme.HanYuPinYinTheme
import com.hanyupinyin.app.theme.appColors
import com.hanyupinyin.app.theme.bottomBorder
import com.hanyupinyin.app.theme.topBorder
import com.hanyupinyin.core.model.AnalyzeImageResponse
import com.hanyupinyin.core.model.withoutDebug
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HanYuPinYinApp() {
    val context = LocalContext.current
    val settingsRepository = remember(context) {
        AppSettingsRepository(context.applicationContext as Context)
    }
    val backendWarmupRepository = remember { BackendWarmupRepository() }
    val appSettings by settingsRepository.settings.collectAsStateWithLifecycle(initialValue = AppSettings())
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = AppDestination.fromRoute(currentBackStackEntry?.destination?.route)
    var latestResponse by remember { mutableStateOf<AnalyzeImageResponse?>(null) }

    LaunchedEffect(appSettings.normalizedBaseUrl) {
        backendWarmupRepository.warmUp(appSettings)
    }

    HanYuPinYinTheme(darkTheme = appSettings.useDarkTheme) {
        val colors = MaterialTheme.appColors
        Box(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                containerColor = colors.bg,
                topBar = {
                    if (!currentDestination.topLevel) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(88.dp)
                                .bottomBorder(colors.border),
                            color = colors.bg,
                        ) {
                            androidx.compose.foundation.layout.Row(
                                modifier = Modifier
                                    .statusBarsPadding()
                                    .padding(horizontal = 8.dp),
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                            ) {
                                IconButton(onClick = { navController.popBackStack() }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = "Go back",
                                        tint = colors.textPrimary,
                                    )
                                }
                                Text(
                                    text = currentDestination.title,
                                    style = MaterialTheme.typography.titleLarge,
                                    color = colors.textPrimary,
                                )
                            }
                        }
                    }
                },
                bottomBar = {
                    if (currentDestination.topLevel) {
                        NavigationBar(
                            modifier = Modifier.topBorder(colors.border),
                            containerColor = colors.surface,
                            tonalElevation = 0.dp,
                        ) {
                            AppDestination.topLevelDestinations.forEach { destination ->
                                NavigationBarItem(
                                    selected = currentDestination.route == destination.route,
                                    onClick = {
                                        navController.navigate(destination.route) {
                                            launchSingleTop = true
                                            popUpTo(AppDestination.Upload.route)
                                        }
                                    },
                                    icon = {
                                        val icon = when (destination) {
                                            AppDestination.Upload -> Icons.Outlined.UploadFile
                                            AppDestination.Saved -> Icons.Outlined.Bookmarks
                                            AppDestination.Flashcards -> Icons.Outlined.Style
                                            AppDestination.Settings -> Icons.Outlined.Settings
                                            AppDestination.Reader -> Icons.Outlined.UploadFile
                                        }
                                        Icon(
                                            imageVector = icon,
                                            contentDescription = destination.title,
                                        )
                                    },
                                    label = { Text(destination.title) },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = colors.accentFg,
                                        selectedTextColor = colors.accentFg,
                                        indicatorColor = colors.accentBgAlpha,
                                        unselectedIconColor = colors.textMuted,
                                        unselectedTextColor = colors.textMuted,
                                    ),
                                )
                            }
                        }
                    }
                },
            ) { innerPadding ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colors.bg),
                    color = colors.bg,
                ) {
                    AppNavGraph(
                        navController = navController,
                        latestResponse = latestResponse,
                        onResponseReady = { response ->
                            latestResponse = response.withoutDebug()
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .then(
                                if (currentDestination.topLevel) {
                                    Modifier.statusBarsPadding()
                                } else {
                                    Modifier
                                },
                            ),
                    )
                }
            }
            IconButton(
                onClick = {
                    scope.launch {
                        settingsRepository.update(
                            appSettings.copy(useDarkTheme = !appSettings.useDarkTheme),
                        )
                    }
                },
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(top = 6.dp, end = 8.dp)
                    .align(androidx.compose.ui.Alignment.TopEnd),
            ) {
                Icon(
                    imageVector = if (appSettings.useDarkTheme) {
                        Icons.Outlined.LightMode
                    } else {
                        Icons.Outlined.DarkMode
                    },
                    contentDescription = if (appSettings.useDarkTheme) {
                        "Switch to light mode"
                    } else {
                        "Switch to dark mode"
                    },
                    tint = colors.textSecondary,
                )
            }
        }
    }
}
