package com.example.chunithm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import java.io.FileNotFoundException

class Memolist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memolist)
        setMemoText()
    }

    private fun setMemoText(){
        val filename = "SaveData.txt"
        var text = ""
        val memoText = findViewById<TextView>(R.id.textView11)

        val input = try {
            openFileInput(filename)
        }
        catch (e: FileNotFoundException){
            memoText.text="No File"
            return
        }

        val br = input.bufferedReader()

        while(true){
            var a: String? = br.readLine() ?: break
            text += a + "\n"
        }
        br.close()

        memoText.text = text
    }

    fun deleteMemo(view: View){
        val filename = "SaveData.txt"
        deleteFile(filename)
    }

    fun ButtonVisible(view: View){
        var deleteButton = findViewById<Button>(R.id.button5)
        deleteButton.visibility=VISIBLE
    }
}