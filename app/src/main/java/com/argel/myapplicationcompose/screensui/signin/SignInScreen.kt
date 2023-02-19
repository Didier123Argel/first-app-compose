package com.argel.myapplicationcompose.screensui.signin

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import com.argel.myapplicationcompose.navigation.appnavigation.AppRoutes
import com.argel.myapplicationcompose.ui.theme.MyApplicationComposeTheme
import com.argel.myapplicationcompose.utils.BiometricAuthHelper

/**
 * Created by Argel Chan on 18/02/2023.
 * didier.chan@ingenierosmafur.com
 */

@Composable
fun SigInScreen(navController: NavController) {
    val biometricAuthHelper = BiometricAuthHelper(LocalContext.current as AppCompatActivity)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bienvenido",
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Acceda mediante autenticación biométrica",
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                biometricAuthHelper.authenticate {
                    navController.navigate(route =
                    AppRoutes.RouteNavigationMessageListScreen.route,
                        navOptions = NavOptions.Builder()
                            .setPopUpTo(
                                route = AppRoutes.RouteNavigationSignInScreen.route,
                                inclusive = true)
                            .build()
                    )
                }
            }) {
                Text(text = "Iniciar sesión")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SigInPreview(){
    MyApplicationComposeTheme {
        SigInScreen(rememberNavController())
    }
}