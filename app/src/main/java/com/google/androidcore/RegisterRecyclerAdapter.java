package com.google.androidcore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.androidcore.models.Register;

import java.util.List;

public class RegisterRecyclerAdapter extends RecyclerView.Adapter<RegisterRecyclerAdapter.ViewHolder>{

    private final Context context;
    private List<Register> registerList;

    private final LayoutInflater mLayoutInflater;

    public RegisterRecyclerAdapter(Context context) {
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public RegisterRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = null;
//        inflating the layout the was added to the recycler list then passing its value to the constructor of the view Holder class
        itemView = mLayoutInflater.inflate(R.layout.recycler_list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RegisterRecyclerAdapter.ViewHolder holder, int position) {
        if(registerList != null){
            holder.email.setText(registerList.get(position).getEmailAddress());
            holder.password.setText(registerList.get(position).getPassword());
        }else{
            holder.email.setText("register.getEmailAddress()");
            holder.password.setText("register.getPassword()");
        }


    }

    void setRegister(List<Register> registerList) {
        this.registerList = registerList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (registerList != null)
            return registerList.size();
        else return 0;
    }

    //class used to control all the components of the layout that is being inflated
    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView email;
        public final TextView password;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.txtEmail);
            password = itemView.findViewById(R.id.txtPassword);

        }
    }
}
