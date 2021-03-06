package com.example.pavel.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by pavel on 05.07.18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> itemText = new ArrayList<>();
    private ArrayList<String> itemImages = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> itemText, ArrayList<String> itemImages, Context mContext) {
        this.itemText = itemText;
        this.itemImages = itemImages;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);


        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d (TAG, "On bind view holder - > called");

        Glide.with(mContext)
                .asBitmap()
                .load(itemImages.get(position))
                .into(holder.itemImage);

        holder.itemText.setText(itemText.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Clicked on: "+itemText.get(position), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Item : clicked");

                Log.d(TAG, "Change activity: called");
                Intent intent = new Intent(mContext, ProfileActivity.class);
                Log.d(TAG, "Intent: created ");

                Log.d(TAG, "Intent: starting putting data ");

                Log.d(TAG, "Intent: starting putting username  "+itemText.get(position));
                intent.putExtra("username", itemText.get(position));

                Log.d(TAG, "Intent: starting putting user photo  "+itemText.get(position));
                intent.putExtra("photo", itemImages.get(position));

                Log.d(TAG, "Starting activity with intent:   " + intent);
                mContext.startActivity(intent);
                Log.d(TAG, "Activity: changed");
            }
        });

    }



    @Override
    public int getItemCount() {
        return itemImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView itemImage;
        TextView itemText;
        RelativeLayout parentLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemText = itemView.findViewById(R.id.item_text);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
