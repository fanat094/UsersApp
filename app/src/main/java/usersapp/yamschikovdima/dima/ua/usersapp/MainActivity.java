package usersapp.yamschikovdima.dima.ua.usersapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gturedi.views.StatefulLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import usersapp.yamschikovdima.dima.ua.usersapp.adapter.UsersAdpter;
import usersapp.yamschikovdima.dima.ua.usersapp.model.Users;
import usersapp.yamschikovdima.dima.ua.usersapp.presenter.Presenter;
import usersapp.yamschikovdima.dima.ua.usersapp.view.ViewUsers;


public class MainActivity extends AppCompatActivity implements ViewUsers{

    private UsersAdpter nAdapter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.stateful_view)
    StatefulLayout st; //progress view
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new Presenter();
        presenter.attachView(this);
        presenter.getUs();

        st.showLoading();//progress view старт

    }

    @Override
    public void get_json_users(List<Users> usersList) {

        nAdapter = new UsersAdpter(usersList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(nAdapter);
        st.showContent();//відображженя конетенту

    }

    @Override
    public void stfull() {

        st.showEmpty();//якщо запит onFailure
    }
}
