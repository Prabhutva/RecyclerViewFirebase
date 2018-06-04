package com.rajath.recyclerviewfirebase;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> implements ValueEventListener {

    private DatabaseReference reference;
    ArrayList<Books> books_ar = new ArrayList<>();


    public Adapter(){
        books_ar = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference().child("Books");
        reference.addValueEventListener(this);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View newView  =layoutInflater.inflate(R.layout.item_format,parent,false);
        return new ViewHolder(newView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

            holder.bookNameTextView.setText(books_ar.get(position).bookName);
            holder.bookAuthorTextView.setText(books_ar.get(position).bookAuthor);

    }

    @Override
    public int getItemCount() {
        return books_ar.size();
    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        books_ar = new ArrayList<>();
        for (DataSnapshot c :
                dataSnapshot.getChildren()) {
            books_ar.add(new Books(c.child("bookName").getValue(String.class), c.child("bookAuthor").getValue(String.class)));
        }
        notifyDataSetChanged();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}