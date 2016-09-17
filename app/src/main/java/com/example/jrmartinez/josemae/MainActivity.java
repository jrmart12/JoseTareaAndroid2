package com.example.jrmartinez.josemae;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText pass, email;
    SharedPreferences prefs;
    static final String APP_SAVED_PREFERENCES="Cuenta";
    static final int CREAR_REQUEST = 0;
    static final String request="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pass=(EditText)findViewById(R.id.password);
        email=(EditText)findViewById(R.id.email);

        if(!SignUpActivity.EMAIL_KEY.equals("email")) {
            Intent inte2 = new Intent(getBaseContext(), AutoLoginActivity.class);
            startActivityForResult(inte2, CREAR_REQUEST);
        }
    }

    public void SignUp(View view) {
        Intent inte = new Intent(getBaseContext(),SignUpActivity.class);
        startActivityForResult(inte,CREAR_REQUEST);
    }

    public void Login(View view) {
        SharedPreferences sp = getSharedPreferences(APP_SAVED_PREFERENCES,MODE_PRIVATE);
        String result = sp.getString(email.getText().toString(),"");

        if(result.equals("")){
            Toast.makeText(MainActivity.this, "usuario no exite", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "bienvenido", Toast.LENGTH_SHORT).show();
            Intent inte3 = new Intent(getBaseContext(), ProfileActivity.class);
            startActivityForResult(inte3, CREAR_REQUEST);
        }
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==CREAR_REQUEST){
            if(resultCode==RESULT_OK){
                String nombre = data.getStringExtra(SignUpActivity.EMAIL_KEY);
                Toast.makeText(MainActivity.this,"USUARIO "+nombre+" CREADO.",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(MainActivity.this,"Cancelado",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onCheckboxClicked(View view) {
        prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        prefs.edit().putString("user",email.getText().toString()).commit();
    }
}
