package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener(){
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        val weight = editTextWeight.text.toString()
        val height = editTextHeight.text.toString()
        if(height.isEmpty()){
            editTextHeight.setError(getString(R.string.input_error))
            return
        }
        if(weight.isEmpty()){
            editTextWeight.setError(getString(R.string.input_error))
            return
        }
        val weightF = weight.toFloat()
        val heightF = height.toFloat()
        val BMI = weightF / (heightF / 100).pow(2)
        var BMIText = String.format("%s : %.2f",R.string.bmi,BMI)

        if(BMI < 18.5){
            BMIText = BMIText + " (UnderWeight)"
            imageView.setImageDrawable()
        }
        else if(BMI < 24.9){
            BMIText = BMIText + " (Normal)"
        }
        else{
            BMIText = BMIText + " (OverWeight)"
        }

    }
}
