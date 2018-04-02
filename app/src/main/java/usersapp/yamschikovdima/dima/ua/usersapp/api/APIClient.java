package usersapp.yamschikovdima.dima.ua.usersapp.api;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import usersapp.yamschikovdima.dima.ua.usersapp.model.Users;

public interface APIClient {

    @GET("posts") ////метод запиту
    Single<List<Users>> getUsersModel();
}