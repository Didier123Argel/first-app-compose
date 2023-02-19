package com.argel.myapplicationcompose.navigation.appnavigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.argel.myapplicationcompose.navigation.args.addArg
import com.argel.myapplicationcompose.screensui.messagedetail.MessageDetailScreen
import com.argel.myapplicationcompose.screensui.messageslist.MessageListScreen
import com.argel.myapplicationcompose.screensui.signin.SigInScreen

/**
 * Created by Argel Chan on 11/02/2023.
 * didier.chan@ingenierosmafur.com
 */

@ExperimentalMaterial3Api
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRoutes.RouteNavigationSignInScreen.route) {
        composable(route = AppRoutes.RouteNavigationMessageListScreen.route) {
            MessageListScreen(navController) // MESSAGE LIST SCREEN
        }
        val detailArgs = AppRoutes.RouteNavigationMessageDetailScreen.route
            .addArg("title", NavType.StringType)
            .addArg("body", NavType.StringType)

        composable(route = detailArgs.route, arguments = detailArgs.navArguments) {
            MessageDetailScreen(
                navController,
                it.arguments?.getString("title"),
                it.arguments?.getString("body")
            ) // MESSAGE DETAIL SCREEN
        }

        composable(route = AppRoutes.RouteNavigationSignInScreen.route){
            SigInScreen(navController = navController)
        }
    }
}