package com.example.ganeshtikone.kotlincalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatEditText
import android.support.v7.widget.AppCompatTextView
import android.view.View
import android.widget.Toast
import java.lang.ref.WeakReference

class CalculatorActivity : AppCompatActivity(), CalculatorMVPInterface.CalculatorRequiredViewOperation,
        View.OnClickListener {


    private lateinit var buttonAdd: AppCompatButton
    private lateinit var buttonSubtract: AppCompatButton
    private lateinit var buttonMultiply: AppCompatButton
    private lateinit var buttonDivision: AppCompatButton
    private lateinit var buttonClear: AppCompatButton

    private lateinit var editTextOperand1: AppCompatEditText
    private lateinit var editTextOperand2: AppCompatEditText

    private lateinit var textViewTotal: AppCompatTextView

    private val presenter: CalculatorMVPInterface.CalculatorPresenterOperation = CalculatorPresenter(WeakReference(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        initUserInterface()
        setOnClickListenersOnButton()
    }

    private fun setOnClickListenersOnButton() {
        buttonAdd.setOnClickListener(this)
        buttonSubtract.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonDivision.setOnClickListener(this)
        buttonClear.setOnClickListener(this)

    }

    private fun initUserInterface() {

        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDivision = findViewById(R.id.buttonDivision)
        buttonClear = findViewById(R.id.buttonClear)

        editTextOperand1 = findViewById(R.id.editTextOperand1)
        editTextOperand2 = findViewById(R.id.editTextOperand2)

        textViewTotal = findViewById(R.id.textViewTotal)
    }


    override fun onCalculate(total: Double) {
        textViewTotal.text = total.toString()
    }

    override fun onError(error: String) {
        showToast(error)
    }

    override fun onClick(view: View?) {

        when {
            R.id.buttonAdd == view?.id -> presenter.addition(
                    presenter.getValueFromEditText(editTextOperand1),
                    presenter.getValueFromEditText(editTextOperand2)
            )
            R.id.buttonSubtract == view?.id -> presenter.subtraction(
                    presenter.getValueFromEditText(editTextOperand1),
                    presenter.getValueFromEditText(editTextOperand2)
            )
            R.id.buttonMultiply == view?.id -> presenter.multiplication(
                    presenter.getValueFromEditText(editTextOperand1),
                    presenter.getValueFromEditText(editTextOperand2)
            )
            R.id.buttonDivision == view?.id -> presenter.division(
                    presenter.getValueFromEditText(editTextOperand1),
                    presenter.getValueFromEditText(editTextOperand2)
            )
            R.id.buttonClear == view?.id -> {
                val clearText = "0"
                editTextOperand1.setText(clearText)
                editTextOperand2.setText(clearText)
                textViewTotal.text = clearText
            }
        }
    }


    private fun showToast(message: String) {
        Toast.makeText(this,
                message,
                Toast.LENGTH_SHORT).show()
    }
}
