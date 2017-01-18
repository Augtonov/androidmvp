package com.antonioleiva.mvpexample.app.Register;

/**
 * Created by tony on 18/1/17.
 */

public interface RegisterView {

    void registerSuccess();
    void registerError();
    void addressError();
    void nameError();
    void cityError();
}
