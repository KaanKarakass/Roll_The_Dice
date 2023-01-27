package com.kaankarakas.rollthedice

// Kaan karakaş 18070001042 lab2

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<Button>(R.id.rollButton)
        buttonClick.setOnClickListener {
            // Two friends roll dice separately
            val randomValues = List(2){ Random.nextInt(1,7)}
            val randomValues2 = List(2){ Random.nextInt(1,7)}

            //Getting random numbers (dice) to variables
            var player1Dice1 = randomValues.first()
            val player1Dice2 = randomValues.last()
            var player2Dice1 = randomValues2.first()
            val player2Dice2 = randomValues2.last()


            val first = findViewById<TextView>(R.id.resultText)
            val second = findViewById<TextView>(R.id.resultText2)

            first.text= "$player1Dice1-$player1Dice2"
            second.text = "$player2Dice1-$player2Dice2"

            val mainTitle = findViewById<TextView>(R.id.title)

            player1Dice1 += player1Dice2
            player2Dice1 += player2Dice2

            //the sums of the dice are compared and according to that, it is written on the screen who wins.
            if (player1Dice1 > player2Dice1){
                mainTitle.text = getString(R.string.leftWon)
                first.setTextColor(Color.GREEN)
                second.setTextColor(Color.BLUE)
            }else if (player1Dice1 < player2Dice1){
                mainTitle.text = getString(R.string.rightWon)
                second.setTextColor(Color.GREEN)
                first.setTextColor(Color.BLUE)
            }else{
                mainTitle.text = getString(R.string.dramStation)
                first.setTextColor(Color.BLUE)
                second.setTextColor(Color.BLUE)
            }

        }
        //When pressed the reset button, the page returns to its original state.
        val resetClick = findViewById<Button>(R.id.resetButton)
        resetClick.setOnClickListener {
            finish()
            startActivity(intent)
        }
    }

}