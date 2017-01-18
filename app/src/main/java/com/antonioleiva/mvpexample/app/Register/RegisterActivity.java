package com.antonioleiva.mvpexample.app.Register;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.antonioleiva.mvpexample.app.Login.LoginActivity;
import com.antonioleiva.mvpexample.app.R;

public class RegisterActivity extends Activity implements View.OnClickListener, RegisterView {

    private EditText editTextName;
    private EditText editTextAddress;
    private EditText editTextCity;
    private Button btnSubmit;

    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initUi();

        registerPresenter = new RegisterPresenterImpl(this);
    }

    private void initUi() {
        editTextName = (EditText) findViewById(R.id.editText);
        editTextAddress = (EditText) findViewById(R.id.editText2);
        editTextCity = (EditText) findViewById(R.id.editText3);
        btnSubmit = (Button) findViewById(R.id.button2);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                registerPresenter.validateCredentials(editTextName.getText().toString(),
                        editTextAddress.getText().toString(), editTextCity.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        registerPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void registerSuccess() {
        Log.d("hai", "success");
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void registerError() {
        Log.d("hai", "fail");
    }

    @Override
    public void addressError() {
        Log.d("hai", "addressError");
    }

    @Override
    public void nameError() {
        Log.d("hai", "nameError");
    }

    @Override
    public void cityError() {
        Log.d("hai", "cityError");
    }


}
