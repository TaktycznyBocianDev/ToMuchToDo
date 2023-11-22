package com.example.to_much_todo.to_docompose.navigation.destinations

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_much_todo.ui.screens.list.ListScreen
import com.example.to_much_todo.ui.theme.util.Constants.LIST_ARGUMENT_KEY
import com.example.to_much_todo.ui.theme.util.Constants.LIST_SCREEN
import com.example.to_much_todo.ui.viewmodels.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.listComposable(
    onFabClicked: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel

){
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ){

        ListScreen(
            onFabClicked = onFabClicked,
            sharedViewModel = sharedViewModel)

    }
}