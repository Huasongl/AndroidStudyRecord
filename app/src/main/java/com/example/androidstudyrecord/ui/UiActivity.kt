package com.example.androidstudyrecord.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidstudyrecord.R
import com.example.androidstudyrecord.criminalintent.CriminalIntentActivity

class UiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui2)
        supportActionBar?.hide()
    }
    companion object{
        fun actionStart(context: Context){
            val intent= Intent(context, UiActivity::class.java)
            context.startActivity(intent)
        }
    }
}