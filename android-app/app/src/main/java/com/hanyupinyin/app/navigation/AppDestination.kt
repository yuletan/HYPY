package com.hanyupinyin.app.navigation

sealed class AppDestination(
    val route: String,
    val title: String,
    val topLevel: Boolean,
) {
    data object Upload : AppDestination(
        route = "upload",
        title = "Upload",
        topLevel = true,
    )

    data object Reader : AppDestination(
        route = "reader",
        title = "Reader",
        topLevel = false,
    )

    data object Settings : AppDestination(
        route = "settings",
        title = "Settings",
        topLevel = true,
    )

    data object Saved : AppDestination(
        route = "saved",
        title = "Saved",
        topLevel = true,
    )

    companion object {
        val topLevelDestinations = listOf(Upload, Saved, Settings)

        fun fromRoute(route: String?): AppDestination {
            return when (route?.substringBefore("/")) {
                Reader.route -> Reader
                Saved.route -> Saved
                Settings.route -> Settings
                else -> Upload
            }
        }
    }
}
