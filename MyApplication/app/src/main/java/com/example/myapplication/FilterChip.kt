package com.example.myapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterChip(count: Int, label: String) {
    Surface(
        shape = MaterialTheme.shapes.small,
        color = Color(0xFFE0E0E0),
        modifier = Modifier.padding(4.dp)
    ) {
        Text(
            text = "$label ($count)",
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            fontSize = 13.sp
        )
    }
}