package com.example.androidstudyrecord.materialdesign

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.appcompat.widget.Toolbar
import com.example.androidstudyrecord.R

class MaterialDesign : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_design)
        val toolbar:Toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }
    companion object{
        fun actionStart(context:Context){
            val intent=Intent(context,MaterialDesign::class.java)
            context.startActivity(intent)
        }
    }
}