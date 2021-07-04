package com.example.androidstudyrecord.ui

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.example.androidstudyrecord.R

class TitleLayout(context: Context,attrs:AttributeSet):LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.title,this)
        val titleBack:Button = findViewById(R.id.titleBack)
        val titleEdit:Button=findViewById(R.id.titleEdit)
        titleBack.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
        titleEdit.setOnClickListener {
            Toast.makeText(context,"You clocked Edit button",Toast.LENGTH_SHORT).show()
        }
    }

}