package com.example.androidstudyrecord.materialdesign
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.androidstudyrecord.R
class MaterialDesign : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_design)
        val toolbar:Toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
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