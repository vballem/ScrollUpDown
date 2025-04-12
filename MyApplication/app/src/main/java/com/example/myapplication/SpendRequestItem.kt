package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpendRequestItem(item: SpendRequest) {
    Card(
        elevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(Modifier.padding(12.dp)) {
            Text(item.name, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text(item.event, fontSize = 14.sp)
            Text(item.amount, fontSize = 13.sp, color = Color.Gray)
            Text(item.dateRange, fontSize = 12.sp, color = Color.Gray)
            Text("Created ${item.createdDate}", fontSize = 12.sp, color = Color.Gray)
            Text(
                item.type,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray
            )
        }
    }
}