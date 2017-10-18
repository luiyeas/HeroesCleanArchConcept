package com.lnavarro.heroescleanarchitectureconcept.modules.home.presentation.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lnavarro.heroescleanarchitectureconcept.R;
import com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.model.Heroe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by luis on 17/10/17.
 */

public class HeroesGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<Heroe> mData;

    public HeroesGridAdapter(Context context, ArrayList<Heroe> data) {
        this.mContext = context;
        this.mData = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_grid_heroes, parent, false);
        viewHolder = new HeroesGridAdapter.HeroesViewHolder(v);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Heroe heroe = mData.get(position);

        ((HeroesViewHolder) holder).heroeName.setText(heroe.getName());
        ((HeroesViewHolder) holder).realName.setText(heroe.getRealName());

        Picasso.with(mContext).load(heroe.getPhoto()).into(((HeroesViewHolder) holder).image);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class HeroesViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView heroeName, realName;

        public HeroesViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            heroeName = (TextView) itemView.findViewById(R.id.heroe_name);
            realName = (TextView) itemView.findViewById(R.id.real_name);

        }
    }

}
