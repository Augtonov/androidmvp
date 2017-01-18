package com.antonioleiva.mvpexample.app.Register;

import android.text.TextUtils;

/**
 * Created by tony on 18/1/17.
 */

public class RegisterPresenterImpl implements RegisterPresenter, RegisterInteractor.OnRegisterFinishedListener {

    private RegisterView registerView;
    private RegisterInteractor registerInteractor;

    public RegisterPresenterImpl(RegisterView registerView) {
        this.registerView = registerView;
        this.registerInteractor = new RegisterInteratarImpl(this);
    }

    @Override
    public void validateCredentials(String name, String address, String city) {

        registerInteractor.onRegister(name, address, city);
    }

    @Override
    public void onDestroy() {
        registerView = null;
    }

    @Override
    public void onRegisterSuccess() {

        registerView.registerSuccess();
    }

    @Override
    public void onRegisterFail() {
        registerView.registerError();
    }

    @Override
    public void onNameError() {
        registerView.nameError();
    }

    @Override
    public void onAddressError() {
        registerView.addressError();
    }

    @Override
    public void onCityError() {
        registerView.cityError();
    }
}
