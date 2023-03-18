package com.example.firstassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultView: FrameLayout = findViewById(R.id.frameLayout)
        var flag : String = ""
        val spinnerVal : Spinner = findViewById(R.id.SPClass)
        var options = arrayOf("", "Economy", "First Class")
        val btnConfirm : Button = findViewById(R.id.BTNConfirm)
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, thirdFragment)
            commit()
        }

        btnConfirm.setOnClickListener {
            if (flag == "Economy") {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayout, firstFragment)
                    commit()
                }
            } else if (flag == "First Class") {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayout, secondFragment)
                    commit()
                }
            } else {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayout, thirdFragment)
                    commit()
                }
            }
        }
    }
}