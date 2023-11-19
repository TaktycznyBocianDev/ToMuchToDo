package com.example.to_much_todo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.ExperimentalMaterial3Api

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val LowPriorityColor = Color(0xFF09FF00)
val HighPriorityColor  = Color(0xFFFF0000)
val MediumPriorityColor  = Color(0xFFFFF300)
val NonePriorityColor = Color(0xFFFFFFFF)

val LightGray = Color(0xFF999999)
val MediumtGray = Color(0xFF585858)
val DarktGray = Color(0xFF1F1F1F)

val Purple10 = Color(0xFF907CC9)

val topAppBarContentColor: Color
@Composable
get() = if(!isSystemInDarkTheme()) Color.White else LightGray

val topAppBackgroundColor: Color
    @Composable
    get() = if(!isSystemInDarkTheme()) Purple40 else Color.Black