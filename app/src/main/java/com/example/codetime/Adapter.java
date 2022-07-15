package com.example.codetime;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {

         private List<Pojo> dataList;
         private Context context;

         public Adapter(Context context , List<Pojo> dataList){
             this.context=context;
             this.dataList=dataList;
         }

    @Override
    public CustomViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.contests,parent,false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder( CustomViewHolder holder, int position) {

             holder.cnames.setText(dataList.get(position).getName());
             holder.curls.setText(dataList.get(position).getUrl());
             holder.stimes.setText(dataList.get(position).getStart_time());
             holder.etimes.setText(dataList.get(position).getEnd_time());
            // holder.cdurations.setText(dataList.get(position).getDuration());
             holder.csites.setText(dataList.get(position).getSite());
            // holder.cin24s.setText(dataList.get(position).getIn_24_hours());
            // holder.cstatuses.setText(dataList.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

             TextView cnames, stimes,etimes,cdurations,csites,cin24s,cstatuses ,curls;
           //  String curls ;
             public CustomViewHolder(View itemView){
                 super(itemView);
                 cnames = itemView.findViewById(R.id.cname);
                 curls = itemView.findViewById(R.id.curl);
                 curls.setMovementMethod(LinkMovementMethod.getInstance()); // make text to hyperlink
                 curls.setLinkTextColor(Color.RED);
                 stimes = itemView.findViewById(R.id.stime);
                 etimes = itemView.findViewById(R.id.etime);
                // cdurations = itemView.findViewById(R.id.cduration);
                 csites = itemView.findViewById(R.id.csite);
                // cin24s = itemView.findViewById(R.id.cin24);
                // cstatuses = itemView.findViewById(R.id.cstatus);
             }

         }
}
