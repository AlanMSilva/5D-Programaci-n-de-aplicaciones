package com.example.myfirstandroidapp

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goButton = findViewById<Button>(R.id.go_button)
        val nameText = findViewById<EditText>(R.id.name)
        val ageText = findViewById<EditText>(R.id.age)
        goButton.setOnClickListener(){

        }
        goButton.setOnClickListener(View.OnClickListener {
            var ageS=ageText.text.toString().toInt()
            var suma = 0;
            var res=0;
            if(nameText.text.isEmpty() || ageText.text.isEmpty())
                Toast.makeText(this,"Please type something...",Toast.LENGTH_SHORT).show()
            else if(ageS <10 ) {
                res = ageS * 7
                while(res > 0){
                    suma += res%10;
                    res /= 10;
                }
            }else if(ageS >= 10){
                while(ageS >0){
                    suma += ageS%10;
                    ageS /= 10;
                }
                ageS=suma;
                if(ageS >=10){
                    suma = 0;
                    while(ageS >0) {
                        suma +=  ageS%10;
                        ageS /= 10;
                    }
                }
            }
            Toast.makeText(this, "Hey "+ nameText.text + " Your lucky number is: " + suma, Toast.LENGTH_SHORT).show()
        })
    }
}

