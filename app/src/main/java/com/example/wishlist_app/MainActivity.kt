package com.example.wishlist_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items: MutableList<Items>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val url = findViewById<EditText>(R.id.URLInput)
        val item = findViewById<EditText>(R.id.ItemInput)
        val cost = findViewById<EditText>(R.id.CostInput)
        val itemsDetails = findViewById<RecyclerView>(R.id.ItemDetails)
        items = ArrayList()
        val adapter = ItemAdapter(items)
        itemsDetails.adapter = adapter
        itemsDetails.layoutManager = LinearLayoutManager(this)


        button.setOnClickListener {
            //closeKeyBoard(button)

            val newItem = Items(item.text.toString(), cost.text.toString().toFloat(), url.text.toString())
            items.add(newItem)
            item.text.clear()
            cost.text.clear()
            url.text.clear()


            // Notify the adapter there's new emails so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()
        }




    }

    private fun closeKeyBoard(view: View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}