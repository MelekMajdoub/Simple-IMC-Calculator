package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    //**********Declaration variables globales  ************
    EditText e1, e2;
    Button b;
    float height,weight, imc;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //**********Declaration des identifiants des views from XML file *************
        e1 = (EditText) findViewById(R.id.taille_saisie);
        e2= (EditText) findViewById(R.id.poids_saisie);
                result = (TextView) findViewById(R.id.result);
        b = (Button)findViewById(R.id.button);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().length()>0 && e2.getText().length()>0){
                    height = Float.parseFloat(e1.getText().toString());
                    weight = Float.parseFloat(e2.getText().toString());

                    imc = CalculatriceIMC(weight, height);

                    if (imc<16){
                        result.setText("Votre IMC est "+(int) imc+"\n Vous etes trop maigre.");
                    }
                    else if (imc<18.5){
                        result.setText("Votre IMC est "+(int) imc+"\n Vous etes maigre.");
                    }
                    else if (imc<25){
                        result.setText("Votre IMC est "+(int) imc+"\n Vous etes normal.");
                    }
                    else if (imc<30){
                        result.setText("Votre IMC est "+ (int) imc+"\n Vous etes gros(se).");
                    }
                    else {
                        result.setText("Votre IMC est "+ (int) imc+"\n Vous etes gros(se).");
                    }
                }
            }
        });
    }

    float CalculatriceIMC(float weight , float height){
        height=(height/1000);
        return (float) (weight / (height*height));
    }
}