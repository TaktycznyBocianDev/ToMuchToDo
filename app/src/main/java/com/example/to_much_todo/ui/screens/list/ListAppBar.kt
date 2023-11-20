package com.example.to_much_todo.ui.screens.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import com.example.to_much_todo.ui.theme.topAppBackgroundColor
import com.example.to_much_todo.ui.theme.topAppBarContentColor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.to_much_todo.to_docompose.components.PriorityItem
import com.example.to_much_todo.ui.theme.util.SearchAppBarState
import com.example.to_much_todo.ui.viewmodels.SharedViewModel


@Composable
fun ListAppBar(
    sharedViewModel: SharedViewModel,
    searchAppBarState: SearchAppBarState,
    searchTextState: String
){
    when(searchAppBarState)
    {
        SearchAppBarState.CLOSED -> {DefaultListAppBar(
                    onSearchClicked = {
                                      sharedViewModel.searchAppBarState.value =
                                      SearchAppBarState.OPENED
                                      },
                    onSortClicked = {},
                    onDeleteClicked = {} ) }
    else -> {
            SearchAppBar(
            text = searchTextState,
            onTextChange = {newText ->
                sharedViewModel.searchTextState.value  = newText},
            onCloseClicked = { sharedViewModel.searchAppBarState.value =
                SearchAppBarState.CLOSED
                             sharedViewModel.searchTextState.value = ""},
            onSearchClicked = {})
         }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
){
    TopAppBar(
        title = {
            Text( text = "Tasks",
               color = topAppBarContentColor)
        },
        actions = {
            ListAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClicked
                )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = topAppBackgroundColor) //21

    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
){
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked)
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
        }
    }
}

@Composable
fun DeleteAllAction(
    onDeleteClicked: () -> Unit
){
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = { expanded = true})
    {
        Icon(
            painter = painterResource(id = R.drawable.baseline_vert_mer),
            contentDescription = "Delete all",
            tint = topAppBarContentColor
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ){
            DropdownMenuItem(
                text = {
                    Text(
                        text = "Delete all",
                        color = Color.Black
                    )
                },
                modifier = Modifier.padding(16.dp),
                onClick = {onDeleteClicked(); expanded = false})
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,) {

    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shadowElevation = 4.dp,
        color = topAppBackgroundColor

    ){
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = { Text(text = "Click to search")},
            textStyle = TextStyle(color = Color.Black,),
            singleLine = true,

            leadingIcon =
            { IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Black
                    )
                
                 }
            },
            trailingIcon = {
                           IconButton(
                               onClick = {
                                   onCloseClicked()
                               }) {
                               Icon(imageVector = Icons.Filled.Close,
                                   contentDescription = "Close",
                                   tint = Color.Black)
                           }
            } ,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = {onSearchClicked(text)}),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = topAppBarContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
@Preview
private fun DefaultListAppBarPreview(){
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}

@Composable
@Preview
private fun SearchAppBarPreview(){
    SearchAppBar(
        text = "",
        onTextChange = {},
        onCloseClicked = {},
        onSearchClicked = {}
    )
}
