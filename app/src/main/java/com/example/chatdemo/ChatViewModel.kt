package com.example.chatdemo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.chatdemo.data.Chat
import com.example.chatdemo.data.Discovery
import com.example.chatdemo.data.Message
import com.example.chatdemo.data.User
import com.example.work_home.R


class ChatViewModel : ViewModel() {

    var selectedIndex by mutableStateOf(0)

    fun setSelected(index : Int) {
        selectedIndex = index
    }

    val friends : List<List<List<User>>> by mutableStateOf(
        listOf(
//            根据分组分类
            listOf(
//                根据在线状态分类
                listOf(
                    User.CurrentUser,  //伍仁桥
                    User("klaygoatno11", "克莱.汤普森", R.drawable.klay, 0, true),
                ),
                listOf(
                    User("currysc30", "库里Stephen", R.drawable.stephen, 0, false),
                )
            ),
            listOf(
                listOf(
                    User("tomandjerry", "Tomcat", R.drawable.tom, 1, true),
                    User("pujing", "PJ_", R.drawable.pj, 1, true),
                    User("paidaxing", "派大星", R.drawable.pai, 1, true),
                    User("hmbbfkcz", "Bob", R.drawable.bob, 1, true),
                    User("zrnbdwdfxp", "Z_RN", R.drawable.zrn, 1, true),
                    User("hermino", "赫敏格兰杰", R.drawable.hermino, 1, true),
                    ),
                listOf(
                    User("jerryandtom", "jerry", R.drawable.jerry, 1, false),
                    User("kd1zhaojinmai", "zhaojinmai", R.drawable.kd1, 1, false),
                    User("kd2jinmailang", "baijingting", R.drawable.kd2, 1, false),
                )
            ),
            listOf(
                listOf(
                    User("imadog", "siu狗", R.drawable.dog, 2, true)
                ),
                listOf(

                )
            )
        )
    )

    val chats : List<Chat> by mutableStateOf(
        listOf(
            Chat(User("klaygoatno11", "克莱.汤普森", R.drawable.klay, 0, true), listOf(Message("klaygoatno11", "你好中国的球迷朋友， 我是克莱汤普森"))),
            Chat(User("zrnbdwdfxp", "Z_RN", R.drawable.zrn, 1, true), listOf(Message("zrnbdwdfxp", "你好，我是张若楠"),Message("wurenqiao", "你好，我是伍仁桥"))),
            Chat(User("tomandjerry", "Tomcat", R.drawable.tom, 1, true), listOf(Message("tomandjerry", "我是一只猫，快乐的星猫"))),
            Chat(User("currysc30", "库里Stephen", R.drawable.stephen, 0, false), listOf(Message("currysc30", "你好中国的球迷朋友， 我是克莱斯呆芬"))),
            Chat(User("pujing", "PJ_", R.drawable.pj, 1, true), listOf(Message("pujing", "我是你的俄罗斯友人"))),
            Chat(User("paidaxing", "派大星", R.drawable.pai, 1, true), listOf(Message("paidaxing", "我们一起抓水母吧"))),
            Chat(User("kd1zhaojinmai", "zhaojinmai", R.drawable.kd1, 1, false), listOf(Message("kd1zhaojinmai", "这是第十次循环"))),
            Chat(User("kd2jinmailang", "baijingting", R.drawable.kd2, 1, false), listOf(Message("kd2jinmailang", "这是第十次循环"))),
            Chat(User("jerryandtom", "jerry", R.drawable.jerry, 1, false), listOf(Message("jerryandtom", "&**…………%……￥%…………###￥"))),
            Chat(User("hermino", "赫敏格兰杰", R.drawable.hermino, 1, true), listOf(Message("hermino", "I'm Hermione Granger"))),
            Chat(User("imadog", "siu狗", R.drawable.dog, 2, true), listOf(Message("imadog", "汪汪汪"))),
            Chat(User("hmbbfkcz", "Bob", R.drawable.bob, 1, true), listOf(Message("hmbbfkcz", "海棉宝宝方裤衩子"))),
            Chat(User.CurrentUser, listOf(Message("wurenqiao", ""))),
        )
    )

//    输入框输入内容
    var searchInput : String by mutableStateOf("")

    fun setsearchInput (content : String) {
        searchInput = content
    }

    val groupsList : List<Any> by mutableStateOf(
        listOf(
        "  特别关心","  我的好友", "  修勾"
        )
    )

    var isWhichGroupMessageShow by mutableStateOf(
        -1
    )

    fun setIsWhichGroupMessageShow (index : Int) {
        isWhichGroupMessageShow = index
    }


//    动态列表
    val discoveryList : List<Discovery> by mutableStateOf(
        listOf(
            Discovery(friends.get(0).get(0).get(1), "今天和Stephen & Rocco去钓鱼", 0, "2023-03-29-14:59"),
            Discovery(friends.get(0).get(1).get(0), "今天和KT & Rocco去钓鱼", 0,  "2023-03-29-14:00"),
            Discovery(friends.get(1).get(0).get(2), "你知道吗?海绵宝宝，这就像一个游戏一样没什么大不了的，咱们去抓水母，我们就什么都不用干了，生活就像一大碗糖豆一样，各种各样的梦想。", 0,  "2023-03-28-09:00"),
            Discovery(friends.get(1).get(0).get(5), "自己只有一茶匙的感情,并不代表人人都是这样。", 0,  "2023-03-27-18:05"),
            Discovery(friends.get(1).get(1).get(1), "没有天生的信心,只有不断培养的信心。", 0, "2023-03-27-09:00"),
            Discovery(friends.get(1).get(0).get(0), "汤姆其实是一只聪明的猫,所以杰瑞每一次都会被抓到,而汤姆总会放了他,因为汤姆知道,杰瑞是一只骄傲的小老鼠。最好的感觉就是你在闹,我在笑", R.drawable.tomandjerry, "2023-03-27-00:00"),
        )
    )
}