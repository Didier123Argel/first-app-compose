package com.argel.myapplicationcompose.navigation.args

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

/**
 * Created by Argel Chan on 12/02/2023.
 * didier.chan@ingenierosmafur.com
 */

fun String.addArg(nameArg: String, type: NavType<*>): ArgsBuild {
    return ArgsBuild(this.plus("/{$nameArg}"), listOf(
        navArgument(name = nameArg) {
            this.type = type
        }
    ))
}

fun ArgsBuild.addArg(nameArg: String, type: NavType<*>): ArgsBuild {
    return ArgsBuild(this.route.plus("/{$nameArg}"), mutableListOf<NamedNavArgument>().apply {
        addAll(this@addArg.navArguments)
        add(navArgument(name = nameArg) {
            this.type = type
        }
        )
    })
}

data class ArgsBuild (
    val route: String,
    val navArguments: List<NamedNavArgument>
    )