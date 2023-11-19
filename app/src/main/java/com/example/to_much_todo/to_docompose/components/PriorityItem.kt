package com.example.to_much_todo.to_docompose.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_much_todo.to_docompose.data.models.Priority
import org.w3c.dom.Text
import java.time.format.TextStyle

@Composable
fun PriorityItem(priority: Priority){
    Row(
        verticalAlignment = Alignment.CenterVertically)
    {
        Canvas(modifier = Modifier.size(16.dp)){
            drawCircle(color = priority.color)
        }
        Text(
            text = priority.name,
            modifier = Modifier.padding(12.dp),
            color = Color.Black

        )
    }
}

@Composable
@Preview
fun PriorityItemPreview(){
    PriorityItem(priority = Priority.LOW)
}