package com.example.androidstudyrecord.criminalintent

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidstudyrecord.R
import com.example.androidstudyrecord.databinding.ActivityCriminalIntentBinding

class CriminalIntentActivity : AppCompatActivity() {
    private lateinit var view:ActivityCriminalIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view= ActivityCriminalIntentBinding.inflate(layoutInflater)
        setContentView(view.root)

        val currentFragment=supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFragment==null){
            val fragment=CrimeListFragment.newInstance()
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit()
        }
    }

    companion object{
        fun actionStart(context:Context){
            val intent=Intent(context,CriminalIntentActivity::class.java)
            context.startActivity(intent)
        }
    }
}