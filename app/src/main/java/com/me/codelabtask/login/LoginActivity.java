package com.me.codelabtask.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.me.codelabtask.R;
import com.me.codelabtask.userlist.UserListActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        Button btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                mLoginViewModel.login(email, password);
            }
        });

        mLoginViewModel.mToken.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                if (s == null || s.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Invalid User Name or Password", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(LoginActivity.this, UserListActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
