package com.me.codelabtask.login;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.me.codelabtask.models.Token;
import com.me.codelabtask.models.UserCredentials;
import com.me.codelabtask.network.ApiEndpointClient;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends ViewModel {

    MutableLiveData<String> mToken;

    public LoginViewModel() {
        mToken = new MutableLiveData<>();
    }

    public void login(String email, String password) {
        UserCredentials credentials = new UserCredentials(email, password);
        ApiEndpointClient.newInstance().login(credentials)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Token>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Token token) {
                        if (token != null) {
                            mToken.setValue(token.strToken);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mToken.setValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
