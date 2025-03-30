package com.example.chatdemo.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatdemo.ChatViewModel
import com.example.chatdemo.ui.theme.ContactsPageBackgroundColor
import com.example.chatdemo.ui.theme.ContactsPageColor

//联系人页
@Composable
fun ContactsPage(title : String, viewModel: ChatViewModel) {
    Column() {
        TopBar(title, viewModel)
        Box(modifier = Modifier
            .background(ContactsPageBackgroundColor)
            .fillMaxSize()
        ) {
            Column {
//                搜索框Box
                Box(modifier = Modifier
                    .background(color = ContactsPageColor)
                    .fillMaxWidth()
                )
                {
                    SearchBar(index = 1, viewModel)
                }
                Spacer(modifier = Modifier.height(15.dp))
//                通知信息Box
                Box(modifier = Modifier
                    .background(ContactsPageColor)
                    .fillMaxWidth()
                ) {
                    Notification()
                }
                Spacer(modifier = Modifier.height(15.dp))
                Box(modifier = Modifier
                    .background(ContactsPageColor)
                    .fillMaxWidth()
                ) {
                    Groups(viewModel)
                }
            }
        }
    }
}





