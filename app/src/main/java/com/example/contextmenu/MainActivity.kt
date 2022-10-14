package com.example.contextmenu

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    lateinit var constraintLayout : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        constraintLayout = findViewById(R.id.constraintLayout)
        // register context menu for constraint layout
        // long press the constraint layout to show context menu
        registerForContextMenu(constraintLayout)
    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        // inflate the context menu
        menuInflater.inflate(R.menu.contextmenu,menu)

        // set a header for context menu
        menu?.setHeaderTitle("Context Menu")

        super.onCreateContextMenu(menu, v, menuInfo)
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.red->{
                constraintLayout.background = ColorDrawable(Color.RED)
            }R.id.green->{
                constraintLayout.background = ColorDrawable(Color.GREEN)
            }R.id.yellow->{
                constraintLayout.background = ColorDrawable(Color.YELLOW)
            }R.id.gray-> {
                constraintLayout.background = ColorDrawable(Color.GRAY)
            }
        }
        return super.onContextItemSelected(item)
    }


    override fun onContextMenuClosed(menu: Menu) {
        Toast.makeText(
            this,
            "Context Menu Closed",
            Toast.LENGTH_SHORT
        ).show()
        super.onContextMenuClosed(menu)
    }
}