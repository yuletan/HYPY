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
    ) {
        private const val STUDY_ID_QUERY = "studyId"

        fun createRoute(studyId: String? = null): String {
            return if (studyId.isNullOrBlank()) {
                route
            } else {
                "$route?$STUDY_ID_QUERY=$studyId"
            }
        }
    }

    data object Settings : AppDestination(
        route = "settings",
        title = "Settings",
        topLevel = true,
    )

    data object Saved : AppDestination(
        route = "saved",
        title = "Library",
        topLevel = true,
    )

    data object Flashcards : AppDestination(
        route = "flashcards",
        title = "Study",
        topLevel = true,
    ) {
        private const val STUDY_ID_QUERY = "studyId"

        fun createRoute(studyId: String? = null): String {
            return if (studyId.isNullOrBlank()) {
                route
            } else {
                "$route?$STUDY_ID_QUERY=$studyId"
            }
        }
    }

    companion object {
        val topLevelDestinations = listOf(Upload, Saved, Flashcards, Settings)

        fun fromRoute(route: String?): AppDestination {
            val normalizedRoute = route
                ?.substringBefore("?")
                ?.substringBefore("/")
            return when (normalizedRoute) {
                Reader.route -> Reader
                Saved.route -> Saved
                Flashcards.route -> Flashcards
                Settings.route -> Settings
                else -> Upload
            }
        }
    }
}
