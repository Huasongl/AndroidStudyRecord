package com.example.androidstudyrecord.nightmode

import android.content.Context
import android.content.Intent

class NightModeTest {

    companion object{
        fun actionStart(context:Context){
            val intent=Intent(context,NightModeTest::class.java)
            context.startActivity(intent)
        }
    }
}