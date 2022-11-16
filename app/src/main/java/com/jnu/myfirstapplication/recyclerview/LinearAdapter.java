package com.jnu.myfirstapplication.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jnu.myfirstapplication.R;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {
    private Context mContext;
    private List<String>list;
    public LinearAdapter(Context context){
        this.mContext=context;
    }
    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("你好");
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(mContext,"click......"+position,Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.tv_title);
        }
    }
}
