package com.example.androidstudyrecord.materialdesign

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidstudyrecord.R

class FruitsListViewModel:ViewModel() {
    val fruitsList : LiveData<List<Fruits>>
    get() = _fruitsList
    private val _fruitsList = MutableLiveData<List<Fruits>>()
    init {
        initFruits()
    }
    private fun initFruits(){
        val fruits = mutableListOf<Fruits>()
        repeat(10){
            val fruit=Fruits()
            fruit.name="Apple"
            fruit.imageId=R.drawable.apple
            fruits+=fruit
        }
        _fruitsList.value= fruits
    }

}