package com.example.navigationcompose.ui.theme.view.widget

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun DynamicSelectField(
    selectedValue: String,
    options: List<String>,
    label: String,
    onValueChangedEvent: (String) ->Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableListOf(false) }
}
