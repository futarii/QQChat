package com.example.chatdemo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.chatdemo.ChatViewModel
import com.example.chatdemo.ui.theme.SearchBarColor
import com.example.chatdemo.ui.theme.SearchBarColor2

@Composable
fun SearchBar(index : Int, viewModel: ChatViewModel) {
    Column() {
        Spacer(modifier = Modifier.height(15.dp))
        Row() {
            Spacer(modifier = Modifier.width(20.dp))
            TextField(
                value = viewModel.searchInput,
                onValueChange = {
                    viewModel.setsearchInput(it)
                },
                modifier = Modifier
                    .background(color = if (index == 0) SearchBarColor2 else SearchBarColor)
                    .alpha(0.3f)
                    .height(55.dp)
                    .width(370.dp),
                label = { Text(text = "input something to search..") },
                singleLine = true,
                keyboardActions = KeyboardActions(onDone = { viewModel.setsearchInput("") })
            )
            Spacer(modifier = Modifier.width(20.dp))
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}