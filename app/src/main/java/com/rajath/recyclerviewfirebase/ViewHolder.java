package com.rajath.recyclerviewfirebase;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView bookNameTextView;
    TextView bookAuthorTextView;

    public ViewHolder(View itemView) {
        super(itemView);
        bookNameTextView = itemView.findViewById(R.id.bookName);
        bookAuthorTextView = itemView.findViewById(R.id.bookAuthor);

    }
}
