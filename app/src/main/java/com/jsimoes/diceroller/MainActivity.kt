package com.jsimoes.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val incrementValue = 1
    private var currentValue = 1

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
        currentValue = randomValue
        updateDiceUI(currentValue)
    }

    private fun updateDiceUI(newValue: Int) {
        when (newValue) {
            1 -> diceImage.setImageDrawable(getDrawable(R.drawable.dice_1))
            2 -> diceImage.setImageDrawable(getDrawable(R.drawable.dice_2))
            3 -> diceImage.setImageDrawable(getDrawable(R.drawable.dice_3))
            4 -> diceImage.setImageDrawable(getDrawable(R.drawable.dice_4))
            5 -> diceImage.setImageDrawable(getDrawable(R.drawable.dice_5))
            6 -> diceImage.setImageDrawable(getDrawable(R.drawable.dice_6))
        }
    }

    /**
     * Count up
     */
    private fun countUp() {
        try {
            if (currentValue < 6) {
                currentValue += incrementValue
            } else {
                Toast.makeText(this, "Dice alreay at 6! Can't increment more!", Toast.LENGTH_LONG)
                    .show()
            }

        } catch (e: NumberFormatException) {
            currentValue = 1
        }

        updateDiceUI(currentValue)
    }
}