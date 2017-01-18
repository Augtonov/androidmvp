package com.antonioleiva.mvpexample.app.Register;

/**
 * Created by tony on 18/1/17.
 */

public interface RegisterPresenter {

    void validateCredentials(String name, String address, String city);
    void onDestroy();
}
