package com.example.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public EditText editText;
        public MyViewHolder(EditText editText) {
            super(editText);
            this.editText = editText;
        }
    }

    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        EditText editText = (EditText) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.edit_text, parent, false);
        MyViewHolder vh = new MyViewHolder(editText);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.editText.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
