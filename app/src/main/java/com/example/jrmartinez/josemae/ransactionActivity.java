package com.example.jrmartinez.josemae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ransactionActivity extends AppCompatActivity {
    Spinner planes;
    String opcion="";
    EditText num;
    double numero=0;
    static double n = 0;
    static String o="opcion";
    private String[] lista = {"Ingresos", "Egresos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ransaction);
        planes = (Spinner) findViewById(R.id.lista);
        num = (EditText) findViewById(R.id.numero);
    }

    public void Aplicar(View view) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, lista);
        planes.setAdapter(adapter);

        planes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        Toast t1 = Toast.makeText(getApplicationContext(), lista[position], Toast.LENGTH_LONG);
                        t1.show();
                        opcion = "Ingresos";
                        calculo();
                        break;
                    case 2:
                        Toast t2 = Toast.makeText(getApplicationContext(), lista[position], Toast.LENGTH_LONG);
                        t2.show();
                        opcion = "Egresos";
                        calculo();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void Cancelar(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void calculo() {
        String x = num.getText().toString();
        numero = Double.parseDouble(x);
        if(numero>=0){
            n=numero;
            o=opcion;
            Intent inte7 = new Intent(getBaseContext(), ProfileActivity.class);
            startActivityForResult(inte7, 0);
        }
        else{
            Toast.makeText(ransactionActivity.this,"numero positivo",Toast.LENGTH_LONG).show();
        }
    }
}
