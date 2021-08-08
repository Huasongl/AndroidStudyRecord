package com.example.androidstudyrecord.materialdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidstudyrecord.R
import com.example.androidstudyrecord.databinding.ActivityFruitBinding

class FruitActivity:AppCompatActivity() {
    private lateinit var view:ActivityFruitBinding
    companion object{
        const val FRUIT_NAME = "fruit_name"
        const val FRUIT_IMAGE_ID = "fruit_image_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityFruitBinding.inflate(layoutInflater)
        setContentView(view.root)
        setSupportActionBar(view.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}