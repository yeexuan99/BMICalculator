package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener()
        {
            try {


                val height: Double = editTextHeight.text.toString().toDouble();
                val weight: Double = editTextWeight.text.toString().toDouble();
                val status: String
                val heightm: Double = height / 100
                val bmi = weight / (heightm * heightm)

                if (bmi < 18.5) {
                    imageViewProfile.setImageResource(R.drawable.under)
                    status = "Under"
                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    imageViewProfile.setImageResource(R.drawable.normal)
                    status = "Normal"
                } else {
                    imageViewProfile.setImageResource(R.drawable.over)
                    status = "Over"
                }

                textViewBMI.text = "BMI: %.2f(%s)".format(bmi, status)
            }catch (ex:Exception){

                val toast:Toast = Toast.makeText(this,"Weight and Height should not be empty",Toast.LENGTH_SHORT)

                toast.setGravity(Gravity.CENTER, 0, 0)

                toast.show()
            }
        }

        buttonReset.setOnClickListener()
        {
            editTextHeight.text = null;
            editTextWeight.text = null;
            textViewBMI.text = null;
            imageViewProfile.setImageResource(R.drawable.empty);



        }

            }










}
