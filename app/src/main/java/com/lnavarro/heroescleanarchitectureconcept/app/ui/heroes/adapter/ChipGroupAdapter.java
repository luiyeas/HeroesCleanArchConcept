package com.lnavarro.heroescleanarchitectureconcept.app.ui.heroes.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lnavarro.heroescleanarchitectureconcept.R;

/**
 * Created by luis on 19/10/17.
 */

public class ChipGroupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String[] mData;

    public ChipGroupAdapter(String[] data) {
        this.mData = data;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_chip_layout, parent, false);
        viewHolder = new ChipViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChipViewHolder) holder).groupTextView.setText(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    class ChipViewHolder extends RecyclerView.ViewHolder {

        TextView groupTextView;

        public ChipViewHolder(View itemView) {
            super(itemView);

            groupTextView = itemView.findViewById(R.id.group_textview);

        }
    }
}
