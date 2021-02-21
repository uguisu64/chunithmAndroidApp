package com.example.chunithm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.annotation.IntegerRes
import androidx.annotation.NonNull
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(view:View){
        val beforeText = findViewById<EditText>(R.id.editTextNumberDecimal)
        val afterText = findViewById<EditText>(R.id.editTextNumberDecimal2)
        val scoreText = findViewById<EditText>(R.id.editTextNumberDecimal3)

        var t: String = scoreText.text.toString()
        val score = t.toIntOrNull()
        if(score==null || score !in 0..1010000){
            failed()
            return
        }

        t = beforeText.text.toString()
        val beforeScore = t.toDoubleOrNull()
        if(beforeScore==null || beforeScore<0){
            failed()
            return
        }

        t = afterText.text.toString()
        val afterScore = t.toDoubleOrNull()
        if(afterScore==null || afterScore<0){
            failed()
            return
        }


        var changeNum = afterScore - beforeScore
        var teisu = 0.0

        val stateButton = findViewById<RadioGroup>(R.id.radioGroup)
        val checkedID = stateButton.checkedRadioButtonId
        when(findViewById<RadioButton>(checkedID).text){
            "AJ" ->{
                changeNum-=1
            }
            "FC" ->{
                changeNum-=0.5
            }
        }

        when(score){
            1010000 ->{
                teisu = (changeNum - 14)/5.0
            }
            in 1007500..1010000 ->{
                val a = (score-1007500)*0.0015
                teisu = (changeNum-10-a)/5.0
            }
            in 1005000..1007500 ->{
                val a = (score-1005000)*0.001
                teisu = (changeNum-7.5-a)/5.0
            }
            in 1000000..1005000 ->{
                val a = (score-1000000)*0.0005
                teisu = (changeNum-5-a)/5.0
            }
            in 975000..1000000 ->{
                val a = (score-975000)*0.0002
                teisu = (changeNum-a)/5.0
            }
            in 925000..975000 ->{
                val a = (score-925000)*0.00006
                teisu = (changeNum+a)/5.0
            }
            in 900000..925000 ->{
                val a = (score-900000)*0.00008
                teisu = (changeNum+a)/5.0
            }
        }

        val resultText = findViewById<TextView>(R.id.textView5)
        resultText.text=teisu.toString()
    }

    private fun failed(){
        val resultText = findViewById<TextView>(R.id.textView5)
        resultText.text=getString(R.string.prog1)
    }
}
