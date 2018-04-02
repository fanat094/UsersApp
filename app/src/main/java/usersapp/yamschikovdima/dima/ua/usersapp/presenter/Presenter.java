package usersapp.yamschikovdima.dima.ua.usersapp.presenter;


import android.util.Log;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import usersapp.yamschikovdima.dima.ua.usersapp.api.App;
import usersapp.yamschikovdima.dima.ua.usersapp.model.Users;
import usersapp.yamschikovdima.dima.ua.usersapp.view.ViewUsers;

public class Presenter {

    ViewUsers view;
    List<Users> usersList;

    public void attachView(ViewUsers view) {
        this.view = view;
    }

    public void getUs() {

        App.getApi().getUsersModel()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Users>>() {
                    @Override
                    public void onSuccess(List<Users> usersList) {

                        //usersList = response.body();

                        view.get_json_users(usersList);
                        Log.d("onSuc", usersList.size()+"");

                    }

                    @Override
                    public void onError(Throwable e) {

                        view.stfull();

                    }
                });

        /*App.getApi().getUsersModel().enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                usersList = response.body();

                view.get_json_users(usersList);

            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Log.d("RES", t.getMessage());
                view.stfull();
            }
        });*/
    }

}

