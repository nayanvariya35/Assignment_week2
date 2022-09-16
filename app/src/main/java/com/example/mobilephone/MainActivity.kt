package com.example.mobilephone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pmodel=findViewById<Button>(R.id.search)
        pmodel.setOnClickListener{
            val pcompany=findViewById<Spinner>(R.id.company)
            val spinnerValue=pcompany.selectedItem
            val showModels=getModels(spinnerValue.toString())
            val modelList = showModels.reduce{str, item->str + '\n' + item}

            val display=findViewById<TextView>(R.id.models)
            display.text="$spinnerValue"+ " " + "Models" + '\n' + "$modelList"

            val cHistory=getHistory(spinnerValue.toString())
            val displayHistory=findViewById<TextView>(R.id.history)
            displayHistory.text="$spinnerValue"+ " " + "History" + '\n' + "$cHistory"
        }

    }
    fun getModels(phoneModels: String) : List<String> {
        return when (phoneModels) {
            "Samsung" -> listOf("Note 1", "Note 7", "Note 12")
            "Iphone" -> listOf("Iphone 12", "Iphone 13", "Iphone 14")
            "Realme" -> listOf("Nord 1" , "Nord Pro", "Nord 9")
            "Google" -> listOf("Pixel 1", "Pixel 2", "Pixel 3")
            else -> listOf("No Models Available")
        }
    }
    fun getHistory(companyHistory: String) : String {
        return when (companyHistory) {
            "Samsung" ->"Samsung was founded as a grocery trading store on March 1, 1938, by Lee Byung-Chull."
            "Iphone" -> "Apple Computers, Inc. was founded on April 1, 1976, by college dropouts Steve Jobs and Steve Wozniak."
            "Realme" -> "Realme is a Chinese smartphone company established on May 4, 2018 by Sky Li."
            "Google" -> "Google was founded on September 4, 1998, by Larry Page and Sergey Brin."
            else -> "No History Available"
        }
    }
}