package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AddReceiptScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Receipt") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Choose how to add a receipt:", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                Toast.makeText(
                    navController.context,
                    "Camera launching (stub)...",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(Icons.Filled.Call, contentDescription = "Camera")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Take Photo")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                Toast.makeText(
                    navController.context,
                    "Opening gallery (stub)...",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(Icons.Filled.Refresh, contentDescription = "Gallery")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Pick from Gallery")
            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(onClick = { navController.popBackStack() }) {
                Text("Cancel")
            }
        }
    }
}