package com.sajjad.horizontalrecyclerviewdemo;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class  PersonViewHolder extends RecyclerView.ViewHolder {
    Button moreInfo;
    TextView personId, personFullName;

    PersonViewHolder(@NonNull final View itemView) {
        super(itemView);
        moreInfo = itemView.findViewById(R.id.moreInfo);
        personId = itemView.findViewById(R.id.personId);
        personFullName = itemView.findViewById(R.id.personName);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(itemView.getContext(), "Position: " + getAdapterPosition(), Toast.LENGTH_LONG).show();
            }
        });
    }
}