package com.example.to_much_todo.to_docompose.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.to_much_todo.ui.theme.util.Action
import com.example.to_much_todo.ui.theme.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {

    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) {inclusive = true}
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")

    }

}

