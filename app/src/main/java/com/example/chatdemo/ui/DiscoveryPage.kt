package com.example.chatdemo.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatdemo.ChatViewModel
import com.example.chatdemo.data.Discovery
import com.example.chatdemo.data.User
import com.example.chatdemo.ui.TopBar
import com.example.work_home.R

//动态页面
@Composable
fun DiscoveryPage(title : String, viewModel: ChatViewModel) {
    Column() {
        TopBar(title, viewModel)
        Box(modifier = Modifier
            .background(PageBackgroundColor)
            .fillMaxSize())
        {
            Column() {
                DiscoveryUserInfo(viewModel)
                DiscoveryColumn(viewModel)
            }
        }
    }
}

//动态列表
@Composable
private fun DiscoveryColumn(viewModel: ChatViewModel) {
    LazyColumn() {
        itemsIndexed(viewModel.discoveryList) {index, item ->
            DiscoveryColumnItem(item)
        }
    }
}

@Composable
private fun DiscoveryColumnItem(item: Discovery) {
    Box(
        modifier = Modifier
            .background(ContactsPageColor)
            .fillMaxWidth()
    ) {
        Column(Modifier.clickable {  }) {
            Row(
                Modifier
                    .height(45.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painterResource(id = item.user.avator),
                    contentDescription = "用户头像",
                    Modifier
                        .size(45.dp)
                        .padding(all = 5.dp)
                        .clip(CircleShape)
                )
                Column(Modifier.align(Alignment.CenterVertically)) {
                    Text(
                        text = item.user.username,
                        modifier = Modifier,
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Normal
                    )
                }
                Column(Modifier.align(Alignment.CenterVertically)) {
                    Text(
                        text = item.time,
                        modifier = Modifier
                            .alpha(0.3f)
                            .padding(start = 20.dp),
                        color = Color.Black,
                        fontSize = 10.sp,
                        fontStyle = FontStyle.Normal
                    )
                }
            }
            Row() {
                Text(
                    text = item.content,
                    modifier = Modifier
                        .alpha(0.8f)
                        .padding(top = 5.dp, start = 10.dp, bottom = 10.dp, end = 10.dp),
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Normal
                )
            }
            Row() {
                Image(
                    if(item.image != 0) painterResource(id = item.image)
                        else painterResource(R.drawable.emptyimage),
                    contentDescription = "动态图片",
                    Modifier.size(if (item.image != 0) 200.dp else 0.dp)
                        .padding(start = 10.dp).fillMaxSize()
                )
            }
            Divider(modifier = Modifier
                .background(PageBackgroundColor)
                .alpha(0.2f)
            )
        }
    }
}

// 动态页面的用户信息组件
@Composable
fun DiscoveryUserInfo(
    viewModel: ChatViewModel
) {
    Box(modifier = Modifier
        .background(ContactsPageColor)
        .fillMaxWidth()
    ) {
        Column() {
//            用户信息上半部分
            DiscoveryUserInfoHead()
//            用户信息下半部分
            DiscoveryUserInfoBottom()
        }
    }
}

@Composable
private fun DiscoveryUserInfoBottom() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .clickable { }
        ) {
            Icon(
                painterResource(id = R.drawable.ic_discovery_no2),
                contentDescription = "用户功能",
                Modifier.align(Alignment.CenterHorizontally),
                tint = Purple700
            )
            Text(text = "微视", Modifier.align(Alignment.CenterHorizontally))
        }
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .clickable { }
        ) {
            Icon(
                painterResource(id = R.drawable.ic_discovery_no3),
                contentDescription = "用户功能",
                Modifier.align(Alignment.CenterHorizontally),
                tint = Color.Red
            )
            Text(text = "直播", Modifier.align(Alignment.CenterHorizontally))
        }
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .clickable { }
        ) {
            Icon(
                painterResource(id = R.drawable.ic_discovery_no4),
                contentDescription = "用户功能",
                Modifier.align(Alignment.CenterHorizontally),
                tint = Color.Yellow
            )
            Text(text = "收藏", Modifier.align(Alignment.CenterHorizontally))
        }
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .clickable { }
        ) {
            Icon(
                painterResource(id = R.drawable.ic_discovery_no5),
                contentDescription = "用户功能",
                Modifier.align(Alignment.CenterHorizontally),
                tint = TopBarBackground
            )
            Text(text = "相册", Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
private fun DiscoveryUserInfoHead() {
    Row(
        Modifier
            .height(92.dp)
            .fillMaxWidth()
            .clickable { }
    ) {
        Image(
            painterResource(id = User.CurrentUser.avator),
            contentDescription = "用户头像",
            Modifier
                .size(90.dp)
                .padding(all = 15.dp)
                .clip(CircleShape)
                .clickable { }
        )
        Column(Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = User.CurrentUser.username,
                modifier = Modifier.padding(end = 203.dp),
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = W400,
                fontStyle = FontStyle.Normal
            )
        }
        Column(Modifier.align(Alignment.CenterVertically)) {
            Icon(
                painterResource(id = R.drawable.ic_arrow_more), contentDescription = "更多信息",
                Modifier
                    .alpha(0.3f)
                    .size(20.dp)
            )
        }
    }
}