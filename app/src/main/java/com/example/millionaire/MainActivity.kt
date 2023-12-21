package com.example.millionaire

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.button2
import kotlinx.android.synthetic.main.activity_main.button3
import kotlinx.android.synthetic.main.activity_main.button4
import kotlinx.android.synthetic.main.activity_main.tvQuestion
import kotlinx.android.synthetic.main.activity_main.tvValue

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvQuestion.text = "Тут будет первый вопрос"

    }

    private val rounds = mutableListOf<Round>()
    private var currentRound = 0
    private fun fillRounds() {
        rounds.run {
            add(Round("Что такое Луна?", "Звезда", "Планета", "Спутник", "Круг сыра", 3, 100))
            add(
                Round(
                    "В каком году запущен первый спутник?",
                    "1957",
                    "1961",
                    "1965",
                    "1969",
                    1,
                    1_000
                )
            )
            add(Round("Сколько спутников у Maрса?", "0", "1", "2", "4", 3, 10_000))
            add(
                Round(
                    "Как называется спутник Плутона?",
                    "Нет спутников",
                    "Харон",
                    "Энцелад",
                    "Ио",
                    2,
                    100_000
                )
            )
            add(
                Round(
                    "Какой крупнейший спутник у Юпитера?",
                    "Европа",
                    "Каллисто",
                    "Титан",
                    "Ганимед",
                    4,
                    1_000_000
                )
            )
        }

    }

    private fun updateUI() {
        tvQuestion.text = rounds[currentRound].question
        tvValue.text = rounds[currentRound].value.toString()
        button.text = rounds[currentRound].answer1
        button2.text = rounds[currentRound].answer2
        button3.text = rounds[currentRound].answer3
        button4.text = rounds[currentRound].answer4
    }

    private fun checkAnswer(givenId: Int) =
        (givenId == rounds[currentRound].rightId)
    private fun goNextRound(): Boolean {
        if (currentRound >= rounds.size - 1) return false
        currentRound++
        updateUI()
        return true
    }
    private fun processRound(givenId: Int) {
        if (checkAnswer(givenId)) {
            if (!goNextRound()) {
                Toast.makeText(this, "YOU WIN! :)", Toast.LENGTH_SHORT).show()
                finish()
            }
        } else {
            Toast.makeText(this, "YOU LOOSE : (", Toast.LENGTH_SHORT).show()
            finish()
        }
    }


}