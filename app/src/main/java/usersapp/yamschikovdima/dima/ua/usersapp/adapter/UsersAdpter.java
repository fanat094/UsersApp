package usersapp.yamschikovdima.dima.ua.usersapp.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import usersapp.yamschikovdima.dima.ua.usersapp.R;
import usersapp.yamschikovdima.dima.ua.usersapp.SecondUsersActivity;
import usersapp.yamschikovdima.dima.ua.usersapp.model.Users;


/**
 * Created by user on 07.04.2017.
 */

public class UsersAdpter extends RecyclerView.Adapter<UsersAdpter.MyViewHolder> {

    List<Users> usersList;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.userId_tv) TextView userId;
        @BindView(R.id.id_tv) TextView id;
        @BindView(R.id.title_tv) TextView title;
        @BindView(R.id.body_tv) TextView body;

        public MyViewHolder(View view) {
            super(view);

            ButterKnife.bind(this,view);
            view.setOnClickListener(this);
            view.setClickable(true);

        }

        @Override
        public void onClick(View view) {

            Intent putintent = new Intent (view.getContext(), SecondUsersActivity.class);
            putintent.putExtra("put_userId", usersList.get(getPosition()).getUserId());
            putintent.putExtra("put_id", usersList.get(getPosition()).getId());
            putintent.putExtra("put_title", usersList.get(getPosition()).getTitle());
            putintent.putExtra("put_body", usersList.get(getPosition()).getBody());
            view.getContext().startActivity(putintent);
        }
    }


    public UsersAdpter(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.usersreating_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Users users = usersList.get(position);

        holder.userId.setText(Integer.toString(users.getUserId()));
        holder.id.setText(Integer.toString(users.getId()));
        holder.title.setText(users.getTitle());
        holder.body.setText(SrringFiftyDots(position, usersList));


    }

    private String SrringFiftyDots (int pos, List<Users> usersList){

        String startStr = "";

        for (int i=0; i<usersList.size(); i++){

            if (usersList.get(pos).getBody().length()>50) {

                startStr = usersList.get(pos).getBody();
                startStr = startStr.substring(0, 51)+"...";
            }
            else {
                startStr = usersList.get(pos).getBody();
                startStr = startStr + "...";
            }
        }
        return startStr;
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

}