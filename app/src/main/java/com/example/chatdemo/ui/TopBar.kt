package com.example.chatdemo.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatdemo.ChatViewModel
import com.example.chatdemo.data.User
import com.example.chatdemo.ui.theme.BottomBarColor
import com.example.chatdemo.ui.theme.TopBarBackground
import com.example.work_home.R

//顶边栏
@Composable
fun TopBar(title : String, viewModel: ChatViewModel) {
//    顶边栏动画效果
    val animateUsernameText by animateColorAsState(if(viewModel.selectedIndex == 0) BottomBarColor else TopBarBackground)
    val animateOnlineStatusText by animateColorAsState(if(viewModel.selectedIndex == 0) Color.Black else TopBarBackground)

    Box(modifier = Modifier
        .background(TopBarBackground)
        .fillMaxWidth()
    )
    {
        TopBarContent(title, animateUsernameText, animateOnlineStatusText, viewModel)
    }
}

//顶边栏中的内容部分
@Composable
private fun TopBarContent(
    title: String,
    animateUsernameText: Color,
    animateOnlineStatusText: Color,
    viewModel: ChatViewModel
) {
    Row(Modifier.height(50.dp)) {
        Image(
            painterResource(id = User.CurrentUser.avator),
            contentDescription = "用户头像",
            Modifier
                .size(45.dp)
                .padding(all = 5.dp)
                .clip(CircleShape)
                .alpha(if (viewModel.selectedIndex == 2) 0f else 1f) //透明度
                .clickable { }
        )
        Column() {
            Text(
                text = User.CurrentUser.username,
                modifier = Modifier.padding(top = 5.dp, start = 5.dp),
                color = animateUsernameText,
                fontSize = 17.sp
            )
            Text(text = "Wifi在线-4G", fontSize = 11.sp, color = animateOnlineStatusText)
        }
        Column(
            Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 75.dp)
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                color = BottomBarColor,
                fontWeight = FontWeight.W600
            )
        }
    }
}



