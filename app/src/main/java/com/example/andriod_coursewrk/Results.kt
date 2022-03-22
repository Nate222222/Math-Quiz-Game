package com.example.andriod_coursewrk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Results : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_results)



        var txtCorrectNum =findViewById<TextView>(R.id.textView5)

        var textIncorrectNum =findViewById<TextView>(R.id.textView6)



        var intent=getIntent()

        var extras=intent.getExtras()



        var correctnum= extras!!.getInt("correct").toString()

        var incorrectnum= extras!!.getInt("incorrect").toString()



        txtCorrectNum.text =correctnum

        textIncorrectNum.text =incorrectnum

    }



    override fun onBackPressed() {

        super.onBackPressed()

        var mainWindow= Intent(this,MainActivity::class.java)

        startActivity(mainWindow)

        finish()

    }
}