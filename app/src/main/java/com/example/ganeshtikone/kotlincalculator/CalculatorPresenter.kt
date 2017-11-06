package com.example.ganeshtikone.kotlincalculator

import android.support.v7.widget.AppCompatEditText
import java.lang.ref.WeakReference

/**
 * Created by ganeshtikone on 6/11/17.
 * Calculator Presenter Operation
 */
class CalculatorPresenter(view: WeakReference<CalculatorMVPInterface.CalculatorRequiredViewOperation>) : CalculatorMVPInterface.CalculatorPresenterOperation {

    private var mView: WeakReference<CalculatorMVPInterface.CalculatorRequiredViewOperation> = view


    override fun addition(operand1: Double, operand2: Double) {
        val total = operand1 + operand2
        this.mView.get()?.onCalculate(total)
    }

    override fun subtraction(operand1: Double, operand2: Double) {
        val total = operand1 - operand2
        this.mView.get()?.onCalculate(total)
    }

    override fun multiplication(operand1: Double, operand2: Double) {
        val total = operand1 * operand2
        this.mView.get()?.onCalculate(total)
    }

    override fun division(operand1: Double, operand2: Double) {

        if (operand2 == 0.0) {
            this.mView.get()?.onError("Divide by zero operation")
            return
        }
        val total = operand1 / operand2
        this.mView.get()?.onCalculate(total)
    }


    override fun getValueFromEditText(inputEditText: AppCompatEditText): Double{
        return inputEditText.text.toString().toDouble()
    }


}