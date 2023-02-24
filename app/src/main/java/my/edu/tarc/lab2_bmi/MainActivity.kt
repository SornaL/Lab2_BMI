package my.edu.tarc.lab2_bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Link between the UI and the code
        val imageviewBMI : ImageView = findViewById(R.id.imageViewBMI);
        val textViewBMI : TextView = findViewById(R.id.textViewBMI);
        val status : TextView = findViewById(R.id.textViewStatus);
        val editTextWeight : EditText = findViewById(R.id.editTextWeight);
        val editTextHeight : EditText = findViewById(R.id.editTextHeight);
        val btnCalculate : Button = findViewById(R.id.buttonCalculate);
        val btnReset : Button = findViewById(R.id.buttonReset);

        btnCalculate.setOnClickListener{
            if(editTextHeight.text.isEmpty()){
                editTextHeight.setError(getString(R.string.value_required))
                return@setOnClickListener //terminate program execution
            }

            if(editTextWeight.text.isEmpty()) {
                editTextWeight.setError(getString(R.string.value_required))
                return@setOnClickListener //terminate program execution)
            }

            //All the user input through Edit Text = text(to String)
            var weight = editTextWeight.text.toString().toFloat()
            var height = editTextHeight.text.toString().toFloat()
            var bmi = weight / (height/100).pow(2)

            if(bmi < 18.5){ //Underweight
                imageviewBMI.setImageResource(R.drawable.under)
                //Show the BMI value like ===> Body Mass Index : 18.4
                textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi), bmi)
                status.text = String.format("%s : %s", getString(R.string.status), getString(R.string.under))
            }

            else if(bmi in 18.5..24.9){ //Underweight
                imageviewBMI.setImageResource(R.drawable.normal)
                textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi), bmi)
                status.text = String.format("%s : %s", getString(R.string.status), getString(R.string.normal))
            }

            else if(bmi > 25){ //Underweight
                imageviewBMI.setImageResource(R.drawable.over)
                textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi), bmi)
                status.text = String.format("%s : %s", getString(R.string.status), getString(R.string.over))
            }

        }

        btnReset.setOnClickListener{
            imageviewBMI.setImageResource(R.drawable.empty)
            editTextHeight.text.clear()
            editTextWeight.text.clear()
        }

    }
}