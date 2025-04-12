package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TodoListContent() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Drag handle
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(4.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color.LightGray, shape = MaterialTheme.shapes.small)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text("To do", fontSize = 18.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        FilterRow()
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Recent spend approvals", fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Use a LazyColumn with a weight modifier so that it scrolls within the remaining space
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(dummySpendRequests) { request ->
                SpendRequestItem(request)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}