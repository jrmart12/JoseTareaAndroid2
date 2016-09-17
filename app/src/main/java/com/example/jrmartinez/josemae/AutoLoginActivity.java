package com.example.jrmartinez.josemae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AutoLoginActivity extends AppCompatActivity {
    TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_login);
        email = (TextView) findViewById(R.id.email);

        String u = getIntent().getStringExtra(SignUpActivity.EMAIL_KEY);
        email.setText("Logged in as: " + u);
    }

    public void aceptar(View view) {
        Intent inte2 = new Intent(getBaseContext(), ProfileActivity.class);
        startActivityForResult(inte2, 0);
    }

    public void otraCuenta(View view) {
        Intent inte = new Intent(getBaseContext(),MainActivity.class);
        startActivityForResult(inte,0);
    }
}