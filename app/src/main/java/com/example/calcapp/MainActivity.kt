package com.example.calcapp

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plusButton.setOnClickListener(this)
        minusButton.setOnClickListener(this)
        multiplyButton.setOnClickListener(this)
        divideButton.setOnClickListener(this)
    }

        override fun onClick(v: View) {
            val intent = Intent(this, SecondActivity::class.java)
            val text1: String = editText1.text.toString()
            val text2: String = editText2.text.toString()
            if(text1.isEmpty() || text2.isEmpty() ){
                alertText.text = "何か数値を入力してください"
            } else {
                val number1: Double = text1.toDouble()
                val number2: Double = text2.toDouble()

                if (v.id == R.id.plusButton) {
                    val result = number1 + number2
                    intent.putExtra("VALUE1", result)
                } else if (v.id == R.id.minusButton){
                    val result = number1 - number2
                    intent.putExtra("VALUE1", result)
                } else if (v.id == R.id.multiplyButton){
                    val result = number1 * number2
                    intent.putExtra("VALUE1", result)
                } else{
                    val result = number1 / number2
                    intent.putExtra("VALUE1", result)
                }


            }

            startActivity(intent)
    }
}
