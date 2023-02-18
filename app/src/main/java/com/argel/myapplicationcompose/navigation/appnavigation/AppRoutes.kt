package com.argel.myapplicationcompose.navigation.appnavigation

/**
 * Created by Argel Chan on 11/02/2023.
 * didier.chan@ingenierosmafur.com
 */

sealed class AppRoutes(val route: String) {
    object RouteNavigationMessageListScreen: AppRoutes("message_detail_screen")
    object RouteNavigationMessageDetailScreen: AppRoutes("message_list_screen")
}