package com.example.to_much_todo.to_docompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.example.to_much_todo.to_docompose.navigation.destinations.listComposable
import com.example.to_much_todo.to_docompose.navigation.destinations.taskComposable
import com.example.to_much_todo.ui.theme.util.Constants.LIST_SCREEN
import com.example.to_much_todo.ui.viewmodels.SharedViewModel

@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
){
     val screen = remember(navController){
         Screens(navController = navController)
     }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ){
    listComposable(
        onFabClicked = screen.task,
        sharedViewModel = sharedViewModel
    )
    taskComposable(
        navigateToListScreen = screen.list
    )
    }
}