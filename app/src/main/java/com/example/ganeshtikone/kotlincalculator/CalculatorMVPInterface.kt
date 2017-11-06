package com.example.ganeshtikone.kotlincalculator

import android.support.v7.widget.AppCompatEditText

/**
 * Created by ganeshtikone on 6/11/17.
 * Calculator MVP Interface
 */

interface CalculatorMVPInterface {

    interface CalculatorRequiredViewOperation {
        fun onCalculate(total: Double)
        fun onError(error: String)
    }


    interface CalculatorPresenterOperation {
        fun addition(operand1: Double, operand2: Double)
        fun subtraction(operand1: Double, operand2: Double)
        fun multiplication(operand1: Double, operand2: Double)
        fun division(operand1: Double, operand2: Double)
        fun getValueFromEditText(inputEditText: AppCompatEditText): Double
    }
}