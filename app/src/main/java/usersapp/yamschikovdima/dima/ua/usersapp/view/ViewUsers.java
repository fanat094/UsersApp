package usersapp.yamschikovdima.dima.ua.usersapp.view;

import java.util.List;

import usersapp.yamschikovdima.dima.ua.usersapp.model.Users;

/**
 * Created by 1 on 01.04.2018.
 */

public interface ViewUsers {

    void get_json_users (List<Users> usersList);
    void stfull();
}
