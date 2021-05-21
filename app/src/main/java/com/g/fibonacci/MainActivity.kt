package com.g.fibonacci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numIn = findViewById<EditText>(R.id.numIn)
        val btn = findViewById<Button>(R.id.send)
        val fiboOut = findViewById<TextView>(R.id.fiboOut)

        val fiboSize = numIn.text.toString().toIntOrNull() //Issue here

        btn.setOnClickListener{
            var fiboList = fibonacciGenerator(fiboSize)  //Issue here
            fiboOut.text = fiboList.toString()
        }
    }



    //fibonacciGenerator() returns a List of Fibo numbers
    //n is the number of items in the output
    fun fibonacciGenerator(n : Int?): MutableList<Int> {
        //arr is the array that holds the output that will be returned
        var arr = mutableListOf<Int>()
        if (n != null) {
            if (n == 1) {
                //if number of items = 1 output just 1
                arr.add(1)
            } else if (n > 1) {
                //else if number of items is above 1...
                arr.add(1)
                arr.add(1)
                //the base case for n = 2 is [1,1]
                var i = 0
                //i is for index of array
                //loop until the length of the array is equal to number of items in the output
                //if n is 2 the loop will not even begin
                while (arr.size < n) {
                    // recall arr = [1,1]
                    // add the value of index 0 with valuw the next index to get newValue of Fibonacci sequence
                    // e.g. add 0 + (0 + 1)...
                    var newValue = arr.elementAt(i) + arr.get(i + 1)
                    // add newValue to the end of the array,
                    // arr.length is auto incremented
                    arr.add(newValue)
                    //increment the index so next values can be calculated in the loop
                    i++
                }
            }
        }
        //finally return the array
        return arr
    }
}

