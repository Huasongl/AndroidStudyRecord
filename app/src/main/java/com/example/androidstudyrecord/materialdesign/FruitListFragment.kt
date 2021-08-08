package com.example.androidstudyrecord.materialdesign

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidstudyrecord.R
import com.example.androidstudyrecord.criminalintent.CrimeListFragment
import com.example.androidstudyrecord.databinding.FragmentCrimeListBinding

class FruitListFragment:Fragment() {
    private var _view: FragmentCrimeListBinding?=null
    private val view :FragmentCrimeListBinding get() = _view!!
    private var adapter:FruitAdapter?=null
    private val fruitViewHolder:FruitsListViewModel by lazy {
        ViewModelProvider(this).get(FruitsListViewModel::class.java)
    }
    private inner class FruitViewHolder(view: View) : RecyclerView.ViewHolder(view),View.OnClickListener{
        private lateinit var fruit : Fruits
        init {
            itemView.setOnClickListener(this)
        }
        private val fruitImage : ImageView = itemView.findViewById(R.id.fruit_image)
        private val fruitContent : TextView = itemView.findViewById(R.id.fruit_message)
        override fun onClick(v: View?) {

        }
        fun bind(fruit : Fruits){
            this.fruit=fruit
            fruitImage.setImageResource(this.fruit.imageId)
            fruitContent.text=this.fruit.name
        }
    }
    private inner class FruitAdapter(val fruit: List<Fruits>):RecyclerView.Adapter<FruitViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
            val view = layoutInflater.inflate(R.layout.list_item_fruit, parent, false)
            val holder = FruitViewHolder(view)
            holder.itemView.setOnClickListener {
                val position = holder.absoluteAdapterPosition
                val fruits = fruit[position]
                val intent = Intent(context,FruitActivity::class.java)
                startActivity(intent)
            }
            return holder

        }
        override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
            val fruit = fruit[position]
            holder.bind(fruit)
        }

        override fun getItemCount(): Int {
            return fruit.size
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _view = FragmentCrimeListBinding.inflate(inflater,container,false)
        val fruitsListRecyclerView :RecyclerView = view.crimeRecyclerView
        fruitsListRecyclerView.layoutManager=LinearLayoutManager(context)
        upDateUI()
        fruitsListRecyclerView.adapter=adapter
        view.swipeRefreshLayout.setOnRefreshListener {
            upDateUI()
            adapter?.notifyDataSetChanged()
            view.swipeRefreshLayout.isRefreshing=false
        }
        return view.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _view=null
    }
    private fun upDateUI() {
        val fruits = fruitViewHolder.fruitsList.value
        adapter= fruits?.let { FruitAdapter(it) }
    }
    companion object{
        fun newInstance(): FruitListFragment {
            return FruitListFragment()
        }
    }
}