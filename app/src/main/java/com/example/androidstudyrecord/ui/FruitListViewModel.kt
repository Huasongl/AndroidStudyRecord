package com.example.androidstudyrecord.ui

import androidx.lifecycle.ViewModel
import com.example.androidstudyrecord.R

class FruitListViewModel:ViewModel() {
    val fruits= mutableListOf<Fruit>()
    init {
        for(i in 0 until 100){
            val fruit = Fruit()
            fruit.name="fruit #$i"
            fruit.imageId=R.drawable.test
            fruits+=fruit
        }
    }
}