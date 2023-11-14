package com.example.to_much_todo.to_docompose.data.models

import androidx.compose.ui.graphics.Color
import com.example.to_much_todo.ui.theme.HighPriorityColor
import com.example.to_much_todo.ui.theme.LowPriorityColor
import com.example.to_much_todo.ui.theme.MediumPriorityColor
import com.example.to_much_todo.ui.theme.NonePriorityColor

enum class Priority(val color: Color){
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}