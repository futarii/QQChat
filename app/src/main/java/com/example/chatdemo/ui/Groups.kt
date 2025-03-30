package com.example.chatdemo.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatdemo.ChatViewModel
import com.example.work_home.R

@Composable
fun Groups(viewModel: ChatViewModel) {
    Column() {
        LazyColumn() {
            itemsIndexed(viewModel.groupsList) {index, item ->
                GroupItem(item, index, viewModel)
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumn() {
            itemsIndexed(viewModel.chats.filter {
                it.user.group == viewModel.isWhichGroupMessageShow
            }) { index, chat ->
                ChatListItem(chat, Modifier.height(57.dp))  //组件复用
            }
        }
    }
}

@Composable
private fun GroupItem(
    item: Any,
    index: Int,
    viewModel: ChatViewModel
) {
    Row(
        Modifier
            .height(40.dp)
            .clickable { viewModel.setIsWhichGroupMessageShow(if (viewModel.isWhichGroupMessageShow == index) -1 else index) }
            .fillMaxWidth()) {
        Text(
            text = item.toString(),
            fontSize = 17.sp,
            fontWeight = FontWeight.W400,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = if (index in 0..1) 275.dp else 309.dp)
        )
        Text(
            text = "${viewModel.friends.get(index).get(0).size}/${
                viewModel.friends.get(index).get(0).size.plus(
                    viewModel.friends.get(index).get(1).size
                )
            }",
            Modifier
                .align(Alignment.CenterVertically)
                .alpha(0.3f)
        )
    }
}


