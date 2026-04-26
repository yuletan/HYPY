package com.hanyupinyin.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hanyupinyin.core.model.AnalyzeImageResponse
import com.hanyupinyin.feature.flashcards.FlashcardsRoute
import com.hanyupinyin.feature.reader.ReaderRoute
import com.hanyupinyin.feature.saved.SavedRoute
import com.hanyupinyin.feature.settings.SettingsRoute
import com.hanyupinyin.feature.upload.UploadRoute

@Composable
fun AppNavGraph(
    navController: NavHostController,
    latestResponse: AnalyzeImageResponse?,
    onResponseReady: (AnalyzeImageResponse) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Upload.route,
        modifier = modifier,
    ) {
        composable(AppDestination.Upload.route) {
            UploadRoute(
                onOpenReader = { response ->
                    onResponseReady(response)
                    navController.navigate(AppDestination.Reader.route) {
                        launchSingleTop = true
                    }
                },
            )
        }
        composable(AppDestination.Reader.route) {
            ReaderRoute(response = latestResponse)
        }
        composable(AppDestination.Saved.route) {
            SavedRoute(
                onOpenReader = { response ->
                    onResponseReady(response)
                    navController.navigate(AppDestination.Reader.route) {
                        launchSingleTop = true
                    }
                },
                onOpenStudy = { studyId ->
                    navController.navigate(AppDestination.Flashcards.createRoute(studyId)) {
                        launchSingleTop = true
                    }
                },
            )
        }
        composable(
            route = "${AppDestination.Flashcards.route}?studyId={studyId}",
            arguments = listOf(
                navArgument("studyId") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                },
            ),
        ) { backStackEntry ->
            FlashcardsRoute(
                initialStudyId = backStackEntry.arguments?.getString("studyId"),
            )
        }
        composable(AppDestination.Settings.route) {
            SettingsRoute()
        }
    }
}
