package com.me.codelabtask.userlist;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.me.codelabtask.models.UsersData;
import com.me.codelabtask.network.ApiEndpointClient;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserListViewModel extends ViewModel {
    MutableLiveData<UsersData> userData;

    public UserListViewModel() {
        userData = new MutableLiveData<>();
    }

    public void loadUserList() {
        ApiEndpointClient.newInstance().getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UsersData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UsersData usersData) {
                        if (usersData != null) {
                            userData.setValue(usersData);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        userData.setValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
