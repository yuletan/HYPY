package com.hanyupinyin.app

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hanyupinyin.app.navigation.AppDestination
import com.hanyupinyin.app.navigation.AppNavGraph
import com.hanyupinyin.app.data.AppSettings
import com.hanyupinyin.app.data.AppSettingsRepository
import com.hanyupinyin.app.data.BackendWarmupRepository
import com.hanyupinyin.app.theme.HanYuPinYinTheme
import com.hanyupinyin.core.model.AnalyzeImageResponse
import com.hanyupinyin.core.model.StudyJson
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

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
    var latestResponseJson by rememberSaveable { mutableStateOf<String?>(null) }
    val latestResponse = remember(latestResponseJson) {
        latestResponseJson?.let { serialized ->
            runCatching { StudyJson.decodeFromString<AnalyzeImageResponse>(serialized) }.getOrNull()
        }
    }

    LaunchedEffect(appSettings.normalizedBaseUrl) {
        backendWarmupRepository.warmUp(appSettings)
    }

    HanYuPinYinTheme(darkTheme = appSettings.useDarkTheme) {
        Box(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(currentDestination.title) },
                        navigationIcon = {
                            if (!currentDestination.topLevel) {
                                IconButton(onClick = { navController.popBackStack() }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = "Go back",
                                    )
                                }
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = {
                                    scope.launch {
                                        settingsRepository.update(
                                            appSettings.copy(useDarkTheme = !appSettings.useDarkTheme),
                                        )
                                    }
                                },
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
                                )
                            }
                        },
                    )
                },
                bottomBar = {
                    if (currentDestination.topLevel) {
                        NavigationBar {
                            AppDestination.topLevelDestinations.forEach { destination ->
                                NavigationBarItem(
                                    selected = currentDestination.route == destination.route,
                                    onClick = {
                                        navController.navigate(destination.route) {
                                            launchSingleTop = true
                                            restoreState = true
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
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
                                )
                            }
                        }
                    }
                },
            ) { innerPadding ->
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavGraph(
                        navController = navController,
                        latestResponse = latestResponse,
                        onResponseReady = { response ->
                            latestResponseJson = StudyJson.encodeToString(response)
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    )
                }
            }
        }
    }
}
