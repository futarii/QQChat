package com.example.chatdemo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatdemo.ChatViewModel
import com.example.chatdemo.data.Chat
import com.example.chatdemo.ui.theme.PageBackgroundColor
import com.example.chatdemo.ui.theme.TopBarBackground

// 消息页
@Composable
fun MessagePage(title : String, viewModel: ChatViewModel) {
    Column {
        TopBar(title, viewModel)
        ChatList(viewModel)
    }
}

@Composable
fun ChatList(viewModel: ChatViewModel) {
    Box(
        modifier = Modifier
            .background(PageBackgroundColor)
            .fillMaxSize()
    ) {
        Column {
            SearchBar(index = 0, viewModel)
            LazyColumn() {
                itemsIndexed(viewModel.chats) { index, chat ->
                    ChatListItem(chat)
                }
            }
        }
    }
}

@Composable
fun ChatListItem(chat: Chat, modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(bottom = 9.dp)
            .clickable { }
            .fillMaxSize()
    ) {
        Image(
            painterResource(chat.user.avator), contentDescription = chat.user.id,
            Modifier
                .size(70.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Column(Modifier.align(Alignment.CenterVertically)) {
            Text(text = chat.user.username, fontWeight = W500, fontSize = 19.sp, modifier = Modifier.onLine(chat.user.isOnline, TopBarBackground))
            Text(text = chat.messages.last().content, modifier = Modifier.alpha(0.5f))
        }
    }
}

//扩展函数 在在线的朋友昵称上画圆
fun Modifier.onLine(show : Boolean, color : Color) : Modifier {
    return this.drawWithContent {
        drawContent()  //描绘原本的图像
        if(show) {
            drawCircle(color, 4.dp.toPx(), Offset(size.width + 8.dp.toPx(), 23.dp.toPx())) //在图片上画圆
        }
    }
}