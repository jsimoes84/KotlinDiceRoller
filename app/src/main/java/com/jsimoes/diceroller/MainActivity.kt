package com.jsimoes.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val incrementValue = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Bind button actions to events
     */
    override fun onStart() {
        super.onStart()

        roll.setOnClickListener { rollDice() }
        count.setOnClickListener { countUp() }
    }

    /**
     * Roll the dice to get a new value
     */
    private fun rollDice() {
        Toast.makeText(this, "Rolling dice!", Toast.LENGTH_SHORT).show()
        val randomValue = (1..6).random()
        diceValue.text = randomValue.toString()
    }

    /**
     * Count up
     */
    private fun countUp() {
        var newValue = 0
        val diceCurrentValueStr = diceValue.text.toString()
        try {

            val currentValueInt = diceCurrentValueStr.toInt()

            if (currentValueInt < 6) {
                newValue = currentValueInt + incrementValue
            } else {
                Toast.makeText(this, "Dice alreay at 6! Can't increment more!", Toast.LENGTH_LONG)
                    .show()
            }

        } catch (e: NumberFormatException) {
            newValue = incrementValue
        }

        diceValue.text = newValue.toString()
    }
}