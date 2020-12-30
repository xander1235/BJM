package com.example.banjaravaya;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.banjaravaya.activities.ProfileActivity;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private TextView userText, passText;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        userText = findViewById(R.id.usernameRequired);
        passText = findViewById(R.id.passwordRequired);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((username == null || TextUtils.isEmpty(username.getText())) && (password == null || TextUtils.isEmpty(password.getText()))) {
                    userText.setVisibility(View.VISIBLE);
                    passText.setVisibility(View.VISIBLE);
                    return;
                }
                if (username == null || TextUtils.isEmpty(username.getText())) {
                    userText.setVisibility(View.VISIBLE);
                    return;
                }

                if (password == null || TextUtils.isEmpty(password.getText())) {
                    passText.setVisibility(View.VISIBLE);
                    return;
                }

                userText.setVisibility(View.INVISIBLE);
                passText.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("username", username.getText().toString());
                intent.putExtra("password", password.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}