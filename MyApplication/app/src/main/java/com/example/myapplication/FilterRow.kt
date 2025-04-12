package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable

@Composable
fun FilterRow() {
    Row(
        modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        FilterChip(count = 18, label = "All")
        FilterChip(count = 5, label = "Approvals")
        FilterChip(count = 3, label = "Expenses")
    }
}