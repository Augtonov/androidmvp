package com.antonioleiva.mvpexample.app.Register;

/**
 * Created by tony on 18/1/17.
 */

public interface RegisterInteractor {

    interface OnRegisterFinishedListener {
        void onRegisterSuccess();
        void onRegisterFail();
        void onNameError();
        void onAddressError();
        void onCityError();
    }

    void onRegister(String name, String address, String city);


}
