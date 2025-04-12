package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(navController: NavHostController) {
    // Create the scaffold state for the BottomSheetScaffold.
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    val blueBackground = Color(0xFF1565C0)

    // Measure the height of the BodyContent area.
    var bodyContentHeightPx by remember { mutableStateOf(0f) }

    // Get the screen height in pixels.
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val screenHeightPx = with(density) { configuration.screenHeightDp.dp.toPx() }

    // When BodyContent is measured, set sheetPeekHeight = screenHeight - (bodyContentHeight + 100dp)
    // That makes the gap between the bottom of BodyContent and the top of bottom sheet equal to 100dp.
    // Compute the raw available height for the bottom sheet peek

    Box(modifier = Modifier.fillMaxSize()) {
        BottomSheetScaffold(
            scaffoldState = bottomSheetScaffoldState,
            // The bottom sheet content (your "To do" list).
            sheetContent = {
                TodoListContent()
            },
            // Use the computed peek height.
            sheetPeekHeight = 500.dp,
            sheetBackgroundColor = Color.White,
            sheetGesturesEnabled = true,
            topBar = {
                TopAppBar(
                    title = {
                        // You can style your title as needed.
                        androidx.compose.material.Text("Home", style = MaterialTheme.typography.h6)
                    },
                    // Include your navigation icon and actions if required.
                    backgroundColor = blueBackground,
                    elevation = 0.dp
                )
            }
        ) { innerPadding ->
            // The BodyContent (accounts section) is placed behind the bottom sheet.
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(blueBackground)
                    .padding(innerPadding)
                    // Capture the measured height for our BodyContent.
                    .onGloballyPositioned { coordinates ->
                        bodyContentHeightPx = coordinates.size.toSize().height
                    }
            ) {
                BodyContent()
            }
        }

        // The "Add receipt" button is overlaid in the bottom-right.
        AddReceiptButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            // Navigate to the permission screen when tapped.
            navController.navigate("permission")
        }
    }
}