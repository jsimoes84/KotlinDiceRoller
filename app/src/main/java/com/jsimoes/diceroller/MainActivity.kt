package com.jsimoes.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        roll.setOnClickListener { v ->
            rollDice()
        }
    }

    private fun rollDice(){
        Toast.makeText(this, "Rolling dice!", Toast.LENGTH_SHORT).show()
        val randomValue = (1..6).random()
        diceValue.text = randomValue.toString()
    }
}