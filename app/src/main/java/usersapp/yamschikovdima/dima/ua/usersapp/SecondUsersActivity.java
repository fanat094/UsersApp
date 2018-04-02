package usersapp.yamschikovdima.dima.ua.usersapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondUsersActivity extends AppCompatActivity {

    @BindView(R.id.userId_tv) TextView userId_tv;
    @BindView(R.id.id_tv) TextView id_tv;
    @BindView(R.id.title_tv) TextView title_tv;
    @BindView(R.id.body_tv) TextView body_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_users);
        ButterKnife.bind(this);

        Intent fromintent = getIntent();
        userId_tv.setText(Integer.toString(fromintent.getIntExtra("put_userId", 0)));
        id_tv.setText(Integer.toString(fromintent.getIntExtra("put_id", 0)));
        title_tv.setText(fromintent.getStringExtra("put_title"));
        body_tv.setText(fromintent.getStringExtra("put_body"));
    }
}
