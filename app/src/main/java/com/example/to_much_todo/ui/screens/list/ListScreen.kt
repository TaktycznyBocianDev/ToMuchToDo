@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.to_much_todo.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.to_much_todo.ui.theme.util.SearchAppBarState
import com.example.to_much_todo.ui.viewmodels.SharedViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    onFabClicked: (Int) -> Unit,
    sharedViewModel: SharedViewModel,

    ){

    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState


    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState)
                 },
        content = {},
        floatingActionButton = {
            ListFab(onFabClicked = onFabClicked)
        }

    )

}

@Composable
fun ListFab(

    onFabClicked: (taskId: Int) -> Unit

) {
    FloatingActionButton(
        onClick = {
                onFabClicked(-1)
        },
        Modifier.background(color = Color.Green)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add button",
            tint = Color.Black
        )
    }
}