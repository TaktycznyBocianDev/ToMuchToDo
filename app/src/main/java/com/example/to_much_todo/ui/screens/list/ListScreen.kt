@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.to_much_todo.ui.screens.list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navigateToTaskScreen: (Int) -> Unit
){

    Scaffold(
        content = {},
        floatingActionButton = {
            ListFab(navigateToTaskScreen = navigateToTaskScreen)
        }
    )

}

@Composable
fun ListFab(

    navigateToTaskScreen: (Int) -> Unit

){
    FloatingActionButton(
        onClick = {
            navigateToTaskScreen(-1)
        }
    ){
        Icon(imageVector = Icons.Filled.Add,
            contentDescription = "Add button")
    }
}

@Composable
@Preview
private fun ListScreenPreview(){
    ListScreen(navigateToTaskScreen = {})
}
