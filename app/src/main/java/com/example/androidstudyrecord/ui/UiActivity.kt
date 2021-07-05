package com.example.androidstudyrecord.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudyrecord.R
import com.example.androidstudyrecord.criminalintent.CriminalIntentActivity

class UiActivity : AppCompatActivity() {
    private lateinit var listView:ListView
    private var fruitAdapter: FruitAdapter?=null
    private val fruitListViewModel:FruitListViewModel by lazy {
        ViewModelProviders.of(this).get(FruitListViewModel::class.java)
    }
    private inner class ViewHolder(view:View){
        private lateinit var fruit: Fruit
        private val fruitImage:ImageView=view.findViewById(R.id.fruit_image)
        private val fruitText:TextView=view.findViewById(R.id.fruit_message)
        fun bind(fruit: Fruit){
            this.fruit=fruit
            fruitImage.setImageResource(this.fruit.imageId)
            fruitText.text=this.fruit.name
        }
    }

    private inner class FruitAdapter(activity: Activity,val resourceId:Int,data:List<Fruit>):ArrayAdapter<Fruit>(activity,resourceId,data){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view:View
            val viewHolder:ViewHolder
            if(convertView==null) {
                view = LayoutInflater.from(context).inflate(resourceId, parent, false)
                viewHolder=ViewHolder(view)
                view.tag=viewHolder
            }
            else{
                view=convertView
                viewHolder= view.tag as ViewHolder
            }
            val fruit=getItem(position)
            if (fruit != null) {
               viewHolder.bind(fruit)
            }
            return view
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui2)
        supportActionBar?.hide()
        listView=findViewById(R.id.listView)
        val fruits=fruitListViewModel.fruits
        fruitAdapter=FruitAdapter(this,R.layout.list_item_fruit,fruits)
        listView.adapter=fruitAdapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val fruit=fruits[position]
            Toast.makeText(this,fruit.name,Toast.LENGTH_SHORT).show()
        }

    }
    companion object{
        fun actionStart(context: Context){
            val intent= Intent(context, UiActivity::class.java)
            context.startActivity(intent)
        }
    }
}