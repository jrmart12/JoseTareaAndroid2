package com.example.jrmartinez.josemae;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    EditText email,ingresos,egresos;
    static long numero=0;
    String opcion="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        email = (EditText) findViewById(R.id.editText3);
        ingresos = (EditText) findViewById(R.id.editText4);
        egresos = (EditText) findViewById(R.id.editText5);

        String u = getIntent().getStringExtra(SignUpActivity.EMAIL_KEY);
        email.setText(u);

        if(opcion.equals("Ingresos")){
            ingresos.setText(""+numero);
        }
        else{
            egresos.setText(""+numero);
        }

    }

    public void Transaccion(View view) {
        Intent inte = new Intent(getBaseContext(), ransactionActivity.class);
        startActivityForResult(inte, 0);
        numero += ransactionActivity.n;
        opcion = ransactionActivity.o;
    }

    public void Grafica(View view) {
        Intent inte2 = new Intent(getBaseContext(), GraphActivity.class);
        startActivityForResult(inte2, 0);
    }

    public void Salvar(View view) {
        SharedPreferences sp = getSharedPreferences(MainActivity.APP_SAVED_PREFERENCES,MODE_PRIVATE);
        SharedPreferences.Editor spedit = sp.edit();
        spedit.putString("opcion",opcion);
        spedit.putLong("numero",numero);
        spedit.commit();
        Toast.makeText(ProfileActivity.this,"Datos guardados",Toast.LENGTH_LONG).show();
    }
}
