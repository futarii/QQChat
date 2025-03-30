package com.example.chatdemo.data

import com.example.work_home.R

class User (val id : String, val username : String, val avator : Int, val group : Int, val isOnline : Boolean) {
//    当前用户 伴生对象
    companion object {
        val CurrentUser : User = User("wurenqiao", "-futari", R.drawable.futari, 0, true)
    }
}