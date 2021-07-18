package com.example.androidstudyrecord.materialdesign
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.androidstudyrecord.R
import com.example.androidstudyrecord.databinding.ActivityMaterialDesignBinding
import com.google.android.material.snackbar.Snackbar

class MaterialDesign : AppCompatActivity() {
    private lateinit var view : ActivityMaterialDesignBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        view = ActivityMaterialDesignBinding.inflate(layoutInflater)
        setContentView(view.root)
        setSupportActionBar(view.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }
        view.fab.setOnClickListener{view->
         Snackbar.make(view,"Data deleted", Snackbar.LENGTH_SHORT)
             .setAction("Undo"){
                 Toast.makeText(this,"Data restored",Toast.LENGTH_LONG).show()
             }
             .show()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->view.drawerLayout.openDrawer(GravityCompat.START)
            R.id.backup->Toast.makeText(this,"You clicked Backup",Toast.LENGTH_SHORT).show()
            R.id.delete->Toast.makeText(this,"You clicked Delete",Toast.LENGTH_SHORT).show()
            R.id.settings->Toast.makeText(this,"You clicked Settings",Toast.LENGTH_SHORT).show()
        }
        return true
    }
    companion object{
        fun actionStart(context:Context){
            val intent=Intent(context,MaterialDesign::class.java)
            context.startActivity(intent)
        }
    }
}