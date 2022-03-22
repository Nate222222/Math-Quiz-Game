package com.example.andriod_coursewrk

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class game : AppCompatActivity() { //All variables
    var m1: Double = 0.0
    var a1: String = ""
    var t1: ArrayList<Int> = ArrayList()
    var h1: ArrayList<String> = ArrayList()



    var m2: Double = 0.0
    var a2: String = ""
    var t2: ArrayList<Int> = ArrayList()
    var h2: ArrayList<String> = ArrayList()
    var counter = 50
    var numberOfCorrectAnswers = 0
    var numberOfIncorrectAnswers = 0



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        numberOperations()
        startTimeCounter()

        var btnNext=findViewById<Button>(R.id.button8) //Moving to the next pair of operations
        btnNext.setOnClickListener(){

            t1.clear()
            h1.clear()
            t2.clear()
            h2.clear()

            numberOperations()

        }

    }

    fun numberOperations(){

        var ex1 = findViewById<TextView>(R.id.textView)
        var ex2 = findViewById<TextView>(R.id.textView2)
        var r = Random()



        var n1: Int = r.nextInt(20) + 1
        m1 = n1.toDouble()
        this.t1.add(n1)



        for (i in 0..3) {
            generate1()

        }



        var numberEmpty1 = 0
        for (i in h1) {
            if (i === "e") {
                numberEmpty1 += 1

            }

        }



        var n2: Int = r.nextInt(20) + 1
        m2 = n2.toDouble()
        this.t2.add(n2)



        for (i in 0..3) {
            generate2()

        }

        var numberEmpty2 = 0
        for (i in  h2) {
            if (i === "e") {
                numberEmpty2 += 1

            }

        }



        h1.removeAll(Collections.singleton("e"));

        if(numberEmpty1 == 0){

            a1="((("+ this.t1.get(0)+h1.get(0)+ this.t1.get(1)+")"+h1.get(1)+ this.t1.get(2)+")"+h1.get(2)+ this.t1.get(3)+")"+h1.get(3)+ this.t1.get(4)

        }else if(numberEmpty1 == 1){

            a1="(("+ this.t1.get(0)+h1.get(0)+ this.t1.get(1)+")"+h1.get(1)+ this.t1.get(2)+")"+h1.get(2)+ this.t1.get(3)

        } else if(numberEmpty1 == 2){

            a1="("+ this.t1.get(0)+h1.get(0)+ this.t1.get(1)+")"+h1.get(1)+ this.t1.get(2)

        } else if(numberEmpty1 == 3){

            a1= "" + this.t1.get(0) + h1.get(0)+ this.t1.get(1)

        }



        h2.removeAll(Collections.singleton("e"))

        if(numberEmpty2 == 0){

            a2="((("+ this.t2.get(0)+h2.get(0)+ this.t2.get(1)+")"+h2.get(1)+ this.t2.get(2)+")"+h2.get(2)+ this.t2.get(3)+")"+h2.get(3)+ this.t2.get(4)

        }else if(numberEmpty2 == 1){

            a2="(("+ this.t2.get(0)+h2.get(0)+ this.t2.get(1)+")"+h2.get(1)+ this.t2.get(2)+")"+h2.get(2)+ this.t2.get(3)

        } else if(numberEmpty2 == 2){

            a2="("+ this.t2.get(0)+h2.get(0)+ this.t2.get(1)+")"+h2.get(1)+ this.t2.get(2)

        } else if(numberEmpty2 == 3){

            a2= "" + this.t2.get(0) + h2.get(0)+ this.t2.get(1)

        }

        ex1.text = a1
        ex2.text = a2



        var buttonGreat = findViewById<Button>(R.id.button3)
        var buttonLess = findViewById<Button>(R.id.button5)
        var buttonEqual = findViewById<Button>(R.id.button4)
        var correctval = findViewById<TextView>(R.id.textView3)

        correctval(buttonGreat, buttonLess, buttonEqual, correctval)

    }



    fun generate1(){

        val r = Random()
        var s = r.nextInt(5)
        var n1 = r.nextInt(20) + 1


        if (s == 0) {  //Generating random numbers for the First operation

            if (!anInteger(m1+n1)|| m1+n1>100){
                generate1()

            }else {

                this.t1.add(n1);
                h1.add("+")
                m1+=n1

            }





        } else if (s == 1) {

            if (!anInteger(m1-n1)|| m1-n1>100){
                generate1()

            }else {

                this.t1.add(n1);
                h1.add("-")
                m1-=n1

            }



        } else if (s == 2) {

            if (!anInteger(m1*n1)|| m1*n1>100){
                generate1()

            }else {

                this.t1.add(n1);
                h1.add("*")
                m1*=n1

            }



        } else if (s == 3) {

            if (!anInteger(m1/n1)|| m1/n1>100){
                generate1()

            }else {

                this.t1.add(n1);
                h1.add("/")
                m1/=n1

            }

        } else {

            h1.add("e")

        }



    }



    fun generate2() {

        var r = Random()
        var s = r.nextInt(5)
        var n2 = r.nextInt(20) + 1



        if (s == 0) { //Generating random numbers for the second operation

            if (!anInteger(m2+n2)|| m2+n2>100){
                generate2()

            }else {

                this.t2.add(n2);
                h2.add("+")
                m2+=n2

            }

        } else if (s == 1) {

            if (!anInteger(m2-n2)|| m2-n2>100){
                generate2()

            }else {

                this.t2.add(n2);
                h2.add("-")
                m2-=n2

            }



        } else if (s == 2) {

            if (!anInteger(m2*n2)|| m2*n2>100){
                generate2()

            }else {

                this.t2.add(n2);
                h2.add("*")
                m2*=n2

            }



        } else if (s == 3) {

            if (!anInteger(m2/n2)|| m2/n2>100){
                generate2()

            }else {

                this.t2.add(n2);
                h2.add("/")
                m2/=n2

            }

        } else {

            h2.add("e")

        }

    }



    fun correctval (buttonGreat:Button, buttonLess:Button, buttonEqual:Button, correctval: TextView){

        var checked: String //Defining the correct and wrong answers
        if(m1 == m2){

            checked = "equal"

        }else if(m1 > m2){

            checked = "greater"

        }else{

            checked = "lesser"

        }

        buttonGreat.setOnClickListener{

            if(checked.equals("greater")){

                correctval.text = "CORRECT!"
                numberOfCorrectAnswers ++

                correctval.setTextColor(Color.GREEN)

                if(numberOfCorrectAnswers%5==0){bonusTime()}



            }else{

                correctval.text = "WRONG!"
                numberOfIncorrectAnswers ++

                correctval.setTextColor(Color.RED)

            }

        }

        buttonLess.setOnClickListener{

            if(checked.equals("lesser")){

                correctval.text = "CORRECT!"
                numberOfCorrectAnswers ++


                correctval.setTextColor(Color.GREEN)

                if(numberOfCorrectAnswers%5==0){bonusTime()}

            }else{

                correctval.text = "WRONG!"
                numberOfIncorrectAnswers ++

                correctval.setTextColor(Color.RED)

            }

        }

        buttonEqual.setOnClickListener{

            if(checked.equals("equal")){

                correctval.text = "CORRECT!"
                numberOfCorrectAnswers ++

                correctval.setTextColor(Color.GREEN)

                if(numberOfCorrectAnswers%5==0){bonusTime()}

            }else{

                correctval.text = "WRONG!"
                numberOfIncorrectAnswers ++

                correctval.setTextColor(Color.RED)

            }

        }



    }

    fun anInteger(value: Double):Boolean {
        return value - value.toInt() == 0.0

    }

    fun startTimeCounter() {

        /**
         * to start the timer.
         */

        var countTime: TextView = findViewById(R.id.textView4)
        var scoreWindow= Intent(this,Results::class.java)
        object : CountDownTimer(1000000, 1000) { //counter counts down in seconds


            override fun onTick(millisUntilFinished: Long) {
                countTime.text = counter.toString()
                if (counter<=0){ //counter values

                    cancel()
                    onFinish()

                }

                counter--

            }

            override fun onFinish() {

                var extras = Bundle()//data bundle
                extras.putInt("correct",numberOfCorrectAnswers)
                extras.putInt("incorrect",numberOfIncorrectAnswers)
                scoreWindow.putExtras(extras)
                startActivity(scoreWindow)//open the scores

            }



        }.start()

    }

    fun bonusTime(){

        /**
         * to add bonus time.
         */

        if(numberOfCorrectAnswers%5==0){

            var alertBonus= Toast.makeText(applicationContext,"10 seconds added",Toast.LENGTH_SHORT)
            alertBonus.show() //add in extra time
            counter+=10

        }

    }
}