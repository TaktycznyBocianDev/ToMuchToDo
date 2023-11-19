package com.example.to_much_todo.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_much_todo.ui.theme.Purple40
import com.example.to_much_todo.ui.theme.topAppBackgroundColor
import com.example.to_much_todo.ui.theme.topAppBarContentColor


@Composable
fun ListAppBar(){
    DefaultListAppBar(
        onSearchClicked = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit
){
    TopAppBar(
        title = {
            Text( text = "Tasks",
               color = topAppBarContentColor)
        },
        actions = {
            ListAppBarActions(onSearchClicked = onSearchClicked)
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = topAppBackgroundColor) //21

    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit
){
    SearchAction(onSearchClicked = onSearchClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
){
   IconButton(onClick = {onSearchClicked()}) {
       Icon(imageVector = Icons.Filled.Search,
           contentDescription = "Search Task",
           tint = topAppBarContentColor)
   }
}

@Composable
@Preview
private fun DefaultListAppBarPreview(){
    DefaultListAppBar(
        onSearchClicked = {}
    )
}
