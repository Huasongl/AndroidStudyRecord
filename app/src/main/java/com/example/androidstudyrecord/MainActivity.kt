package com.example.androidstudyrecord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidstudyrecord.criminalintent.CriminalIntentActivity
import com.example.androidstudyrecord.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view= ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)
        view.CriminalIntent.setOnClickListener {
            CriminalIntentActivity.actionStart(this)
        }
    }
}