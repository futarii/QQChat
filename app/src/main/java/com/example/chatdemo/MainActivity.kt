package com.example.chatdemo

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.chatdemo.ui.BottomBar
import com.example.chatdemo.ui.ContactsPage
import com.example.chatdemo.ui.MessagePage
import com.example.chatdemo.ui.theme.ChatDemoTheme
import com.example.chatdemo.ui.theme.DiscoveryPage
import com.example.work_home.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

class MainActivity : ComponentActivity() {
    val viewModel : ChatViewModel by viewModels()
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatDemoTheme {
                Column() {
//                    水平三页
                    HorizontalPager(count = 3, modifier = Modifier.weight(1f)) {
                        when(viewModel.selectedIndex) {
                            0 -> MessagePage("", viewModel)  //消息
                            1 -> ContactsPage("联系人", viewModel) //联系人
                            2 -> DiscoveryPage("动 态", viewModel) //动态
                        }
                    }
//                底边栏
                    BottomBar(viewModel = viewModel)
                }

            }
        }
    }


}
