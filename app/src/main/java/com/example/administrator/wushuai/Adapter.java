package com.example.administrator.wushuai;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/27/027.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>
{


    private Status status;
    private Context context;
    private LayoutInflater inflater;

    public Adapter(Status status, Context context) {
        this.status = status;
        this.context = context;

        inflater=LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v=inflater.inflate(R.layout.recycler_item,null);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.title.setText(status.getData().get(position).getEfficacy());
        holder.content.setText(status.getData().get(position).getGoods_name());

    }

    @Override
    public int getItemCount() {
        return status.getData().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title,content;
        public MyViewHolder(View itemView) {
            super(itemView);

            title= (TextView) itemView.findViewById(R.id.tv_title);
            content= (TextView) itemView.findViewById(R.id.tv_content);
        }
    }

}
