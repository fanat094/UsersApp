package usersapp.yamschikovdima.dima.ua.usersapp.presenter;


import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import usersapp.yamschikovdima.dima.ua.usersapp.api.App;
import usersapp.yamschikovdima.dima.ua.usersapp.model.Users;
import usersapp.yamschikovdima.dima.ua.usersapp.view.ViewUsers;

public class Presenter {

    ViewUsers view;

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

                        view.get_json_users(usersList);

                    }

                    @Override
                    public void onError(Throwable e) {

                        view.stfull();

                    }
                });

    }

}

