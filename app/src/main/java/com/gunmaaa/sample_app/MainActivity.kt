package com.gunmaaa.sample_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var value = 0
        var isClear = false
        var isCalc  = false
        var operator: String? = null

        fun numButtonAction(num: String) {
            display.text =
                    if (display.text.toString() != "0" && isClear) {
                        display.text.toString() + num
                    } else {
                        isClear = false
                        num
                    }
            isCalc = true
        }

        fun calculation(op: String?) :Int {
            return when (op) {
                "+"  -> value + display.text.toString().toInt()
                "-"  -> value - display.text.toString().toInt()
                "*"  -> value * display.text.toString().toInt()
                "/"  -> value / display.text.toString().toInt()
                else -> display.text.toString().toInt()
            }
        }

        fun calcButtonAction(op: String?) {
            if (isCalc) {
                value = calculation(operator)
                isClear = true
                isCalc = false
                display.text = value.toString()
            }
            operator = op
        }

        clear.setOnClickListener {
            display.text = "0"
            value = 0
            operator = null
            isClear = false
            isCalc = false
        }
        zero.setOnClickListener {
            numButtonAction("0")
        }
        one.setOnClickListener {
            numButtonAction("1")
        }
        two.setOnClickListener {
            numButtonAction("2")
        }
        three.setOnClickListener {
            numButtonAction("3")
        }
        four.setOnClickListener {
            numButtonAction("4")
        }
        five.setOnClickListener {
            numButtonAction("5")
        }
        six.setOnClickListener {
            numButtonAction("6")
        }
        seven.setOnClickListener {
            numButtonAction("7")
        }
        eight.setOnClickListener {
            numButtonAction("8")
        }
        nine.setOnClickListener {
            numButtonAction("9")
        }
        add.setOnClickListener {
            calcButtonAction("+")
        }
        sub.setOnClickListener {
            calcButtonAction("-")
        }
        mul.setOnClickListener {
            calcButtonAction("*")
        }
        div.setOnClickListener {
            calcButtonAction("/")
        }
        equal.setOnClickListener {
            if (isCalc) {
                value = calculation(operator)
                isCalc = false
                isClear = true
                display.text = value.toString()
                operator = null
            }
        }
    }
}
