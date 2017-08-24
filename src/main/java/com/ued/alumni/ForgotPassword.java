package com.ued.alumni;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {
    Button btnForgotSubmit;
    EditText etOld,etNew,etConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        etConfirm=(EditText)findViewById(R.id.et_forgot_confirm);
        etNew=(EditText)findViewById(R.id.et_forgot_new);
        etOld=(EditText)findViewById(R.id.et_forgot_old);
        btnForgotSubmit=(Button)findViewById(R.id.btn_forgot_submit);
        btnForgotSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNew.getText().toString().trim().equals(etConfirm.getText().toString().trim())){
                    Toast.makeText(ForgotPassword.this, "Changed your password", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(ForgotPassword.this, "New password and Confirm password doesnt match", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
