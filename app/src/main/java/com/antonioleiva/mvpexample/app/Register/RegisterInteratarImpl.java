package com.antonioleiva.mvpexample.app.Register;

import android.text.TextUtils;

/**
 * Created by tony on 18/1/17.
 */

public class RegisterInteratarImpl implements RegisterInteractor {

    private RegisterInteractor.OnRegisterFinishedListener registerFinishedListener;

    public RegisterInteratarImpl(OnRegisterFinishedListener registerFinishedListener) {
        this.registerFinishedListener = registerFinishedListener;
    }

    @Override
    public void onRegister(String name, String address, String city) {
        if (TextUtils.isEmpty(name)) {
            registerFinishedListener.onNameError();
            return;
        }
        if (TextUtils.isEmpty(address)) {
            registerFinishedListener.onAddressError();
            return;
        }
        if (TextUtils.isEmpty(city)) {
            registerFinishedListener.onCityError();
            return;
        }

        if (name.contains("9")) {
            registerFinishedListener.onRegisterFail();
            return;
        }

        registerFinishedListener.onRegisterSuccess();
    }
}
