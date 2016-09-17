package com.example.jrmartinez.josemae;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText email,passw;
    static final String EMAIL_KEY ="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email=(EditText)findViewById(R.id.email);
        passw=(EditText)findViewById(R.id.password);
    }

    public void Crear(View view) {
        String em=email.getText().toString();
        String pass=passw.getText().toString();

        if(saveClienteOnPreferences(em,pass)){
            Intent inte = getIntent();
            inte.putExtra(EMAIL_KEY,pass);
            setResult(RESULT_OK,inte);

            finish();
        }
        else{
            Toast.makeText(SignUpActivity.this,"email ya esta usado",Toast.LENGTH_LONG).show();
        }
    }

    public void Cancelar(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    private boolean saveClienteOnPreferences(String e,String p){
        SharedPreferences sp = getSharedPreferences(MainActivity.APP_SAVED_PREFERENCES,MODE_PRIVATE);

        String result = sp.getString(e,"");
        if(result.equals("")){
            SharedPreferences.Editor spedit = sp.edit();
            spedit.putString(e,p);
            spedit.commit();
            return true;
        }
        return false;
    }
}
