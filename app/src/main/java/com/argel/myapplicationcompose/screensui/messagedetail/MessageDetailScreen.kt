package com.argel.myapplicationcompose.screensui.messagedetail

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/**
 * Created by Argel Chan on 11/02/2023.
 * didier.chan@ingenierosmafur.com
 */

@ExperimentalMaterial3Api
@Composable
fun MessageDetailScreen(navController: NavController, message: String?, body: String?) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "My message", color = MaterialTheme.colorScheme.onBackground)
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack()}) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary))
        }
    ) { paddingValues ->
        BodyContent(padding = paddingValues, message, body) {
            navController.popBackStack()
        }
    }
}

@Composable
fun BodyContent(padding: PaddingValues, message: String?, body: String?, clickable: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = message?: "", Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center)
        Text(
            text = body?: "",
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center)
        Button(onClick = clickable) {
            Text(text = "Back")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Preview() {
    BodyContent(PaddingValues(0.dp), "New Message", "This Message") {

    }
}