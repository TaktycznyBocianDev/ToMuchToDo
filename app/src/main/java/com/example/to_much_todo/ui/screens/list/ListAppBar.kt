package com.example.to_much_todo.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_much_todo.R
import com.example.to_much_todo.to_docompose.data.models.Priority
import com.example.to_much_todo.ui.theme.Purple40
import com.example.to_much_todo.ui.theme.topAppBackgroundColor
import com.example.to_much_todo.ui.theme.topAppBarContentColor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.to_much_todo.to_docompose.components.PriorityItem


@Composable
fun ListAppBar(){
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit
){
    TopAppBar(
        title = {
            Text( text = "Tasks",
               color = topAppBarContentColor)
        },
        actions = {
            ListAppBarActions(onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked)
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = topAppBackgroundColor) //21

    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit
){
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
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
fun SortAction(
    onSortClicked: (Priority) -> Unit
){
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = { expanded = true})
    {
        Icon(
            painter = painterResource(id = R.drawable.baseline_filter_list),
            contentDescription = "Sort Tasks",
            tint = topAppBarContentColor
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ){
            DropdownMenuItem(text = { PriorityItem(priority = Priority.LOW)}, onClick = { expanded = false; onSortClicked(Priority.LOW)  })
            DropdownMenuItem(text = { PriorityItem(priority = Priority.HIGH)}, onClick = { expanded = false; onSortClicked(Priority.HIGH) })
            DropdownMenuItem(text = { PriorityItem(priority = Priority.NONE)}, onClick = { expanded = false; onSortClicked(Priority.NONE) })
            //22.ListScreen
        }
    }
}


@Composable
@Preview
private fun DefaultListAppBarPreview(){
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {}
    )
}
