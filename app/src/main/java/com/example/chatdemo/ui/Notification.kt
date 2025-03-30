package com.example.chatdemo.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.work_home.R

@Composable
fun Notification() {
    Column {
        Row(
            Modifier
                .height(45.dp)
                .clickable { }
                .fillMaxWidth()) {
            Text(
                text = "  新朋友",
                fontSize = 17.sp,
                fontWeight = FontWeight.W400,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 300.dp)
            )
            Icon(
                painterResource(id = R.drawable.ic_arrow_more), "新朋友", modifier = Modifier
                    .size(20.dp)
                    .alpha(0.3f)
                    .align(Alignment.CenterVertically)
            )
        }
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .alpha(0.1f)
                .width(390.dp)
                .align(Alignment.End)
        )
        Row(
            Modifier
                .height(45.dp)
                .clickable { }
                .fillMaxWidth()) {
            Text(
                text = "  群通知",
                fontSize = 17.sp,
                fontWeight = FontWeight.W400,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 300.dp)
            )
            Icon(
                painterResource(id = R.drawable.ic_arrow_more), "群通知", modifier = Modifier
                    .size(20.dp)
                    .alpha(0.3f)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}