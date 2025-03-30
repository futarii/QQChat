package com.example.chatdemo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatdemo.ChatViewModel
import com.example.chatdemo.ui.theme.BottomBarColor
import com.example.chatdemo.ui.theme.BottomComponentColorSelected
import com.example.work_home.R

@Composable
fun BottomBar(viewModel: ChatViewModel) {
    Box(Modifier.background(color = BottomBarColor)) {
        Row {
            BottomItem(
                Modifier.weight(1f),
                text = "消息",
                img = if (viewModel.selectedIndex == 0) R.drawable.ic_chat_filled
                else R.drawable.ic_chat_outlined,
                textColor = if(viewModel.selectedIndex == 0) BottomComponentColorSelected else Color.Black,
                iconColor = BottomComponentColorSelected
            ) {
                viewModel.setSelected(0)
            }
            BottomItem(
                Modifier.weight(1f),
                text = "联系人",
                img = if (viewModel.selectedIndex == 1) R.drawable.ic_contacts_filled
                else R.drawable.ic_contacts_outlined,
                textColor = if(viewModel.selectedIndex == 1) BottomComponentColorSelected else Color.Black,
                iconColor = BottomComponentColorSelected
            ) {
                viewModel.setSelected(1)
            }
            BottomItem(
                Modifier.weight(1f),
                text = "动态",
                img = if (viewModel.selectedIndex == 2) R.drawable.ic_discovery_filled
                else R.drawable.ic_discovery_outlined,
                textColor = if(viewModel.selectedIndex == 2) BottomComponentColorSelected else Color.Black,
                iconColor = BottomComponentColorSelected
            ) {
                viewModel.setSelected(2)
            }
        }
    }
}

@Composable
private fun BottomItem(modifier: Modifier = Modifier, text : String, img : Int, textColor : Color, iconColor : Color, setIsClicked : () -> Unit) {
    Column(
        modifier
            .padding(vertical = 8.dp)
            .clickable {
                setIsClicked()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painterResource(id = img),
            modifier = Modifier.size(25.dp),
            contentDescription = text,
            tint = iconColor  //图标颜色填充
        )
        Text(text = text, fontSize = 15.sp, color = textColor)
    }
}