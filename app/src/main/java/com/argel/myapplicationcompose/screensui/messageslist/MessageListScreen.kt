package com.argel.myapplicationcompose.screensui.messageslist

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.argel.myapplicationcompose.R
import com.argel.myapplicationcompose.navigation.appnavigation.AppRoutes
import com.argel.myapplicationcompose.ui.theme.MyApplicationComposeTheme

/**
 * Created by Argel Chan on 11/02/2023.
 * didier.chan@ingenierosmafur.com
 */

@ExperimentalMaterial3Api
@Composable
fun MessageListScreen(navController: NavController) {
    Scaffold(
        content = { padding ->
            BodyContent(padding, navController)
        }
    )
}

@Composable
fun BodyContent(padding: PaddingValues, navController: NavController) {
    Surface(Modifier.padding(padding)) {
        MyMessages(dummyMessages) { message ->
            navController.navigate(route =
            AppRoutes.RouteNavigationMessageDetailScreen.route + "/${message.title}/${message.body}")
        }
    }
}

@Composable
fun MyMessages(list: List<Message>, clickable: (Message) -> Unit) {
    LazyColumn {
        items(list.count()) { index ->
            MyMessage(message = list[index]) {
                clickable(list[index])
            }
        }
    }
}

@Composable
fun MyMessage(message: Message, clickable: () -> Unit) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
            .clickable(onClick = clickable)
    ) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    textStyle: TextStyle,
    lines: Int = Int.MAX_VALUE,
) {
    Text(text = text, color = color, style = textStyle, maxLines = lines, modifier = modifier)
}


@Composable
fun MyTexts(message: Message) {
    var expanded by remember { mutableStateOf(message.expanded) }
    Column(modifier = Modifier
        .padding(start = 8.dp)) {
        MyText(
            text = message.title,
            color = MaterialTheme.colorScheme.primary,
            textStyle = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            text = message.body,
            color = MaterialTheme.colorScheme.onBackground,
            textStyle = MaterialTheme.typography.bodyLarge,
            lines = if (expanded) Int.MAX_VALUE else 1,
            modifier = Modifier.clickable {
                expanded = !expanded
                message.expanded = expanded
            }
        )
    }
}
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    MyApplicationComposeTheme(dynamicColor = false) {
        BodyContent(PaddingValues(0.dp), rememberNavController())
    }
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "My first image composable",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

data class Message(
    val title: String,
    val body: String
) {
    var expanded = false
}

val dummyMessages = listOf(
    Message("Didier", "Hello, mi name is Didier"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
    Message("First Message", "First Body Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s")
)