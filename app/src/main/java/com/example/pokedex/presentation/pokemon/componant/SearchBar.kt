package com.example.pokedex.presentation.pokemon.componant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp


@Composable
fun SearchBar(
    hintText: String = "",
    onSearch: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var text by remember {
        mutableStateOf("")
    }

    var isHintDisplayed by remember {
        mutableStateOf(hintText != "")
    }
    Box(modifier = modifier.padding(horizontal = 20.dp)) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Black),
            modifier = modifier
                .fillMaxWidth()
                .shadow(20.dp, shape = CircleShape)
                .background(
                    color = Color.White,
                    CircleShape
                )
                .padding(vertical = 12.dp, horizontal = 20.dp)
                .onFocusChanged {
                   isHintDisplayed = !it.isFocused
                }
        )
        if (isHintDisplayed) {
            Text(
                hintText,
                modifier = modifier.padding(vertical = 12.dp, horizontal = 20.dp),
                style = TextStyle(color = Color.Black),
            )
        }
    }
}