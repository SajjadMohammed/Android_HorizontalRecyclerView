package com.sajjad.horizontalrecyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private Context context;
    private List<PersonItemModel> personItemModels;

    PersonRecyclerAdapter(Context context, List<PersonItemModel> personItemModels) {
        this.context = context;
        this.personItemModels = personItemModels;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View personItem = LayoutInflater.from(context).inflate(R.layout.person_item, parent, false);
        return new PersonViewHolder(personItem);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, final int position) {

        holder.personId.setText(String.valueOf(personItemModels.get(position).getId()));
        holder.personFullName.setText(personItemModels.get(position).getFullName());

        holder.moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hi I am a message from button click at position: " + position, Toast.LENGTH_LONG).show();
                // remove item from recycler view
                removeItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personItemModels.size();
    }

    private void removeItem(int position) {
        personItemModels.remove(position);
        notifyDataSetChanged();
    }

    // swipe to remove item
    ItemTouchHelper.SimpleCallback swipeToDelete = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            personItemModels.remove(viewHolder.getAdapterPosition());
            notifyDataSetChanged();
        }
    };
}