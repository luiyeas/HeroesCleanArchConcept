package com.lnavarro.heroescleanarchitectureconcept.modules.home.presentation.ui.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lnavarro.heroescleanarchitectureconcept.R;
import com.lnavarro.heroescleanarchitectureconcept.common.widget.CircleTransformation;
import com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.model.Heroe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by luis on 17/10/17.
 */

public class HeroesGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<Heroe> mData;
    private HeroesListener mClickListener;

    public interface HeroesListener {
        void onHeroeSelected(Heroe heroe);
    }

    public HeroesGridAdapter(Context context, ArrayList<Heroe> data) {
        this.mContext = context;
        this.mData = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_grid_heroes, parent, false);
        viewHolder = new HeroesGridAdapter.HeroesViewHolder(v);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Heroe heroe = mData.get(position);

        Picasso.with(mContext)
                .load(heroe.getPhoto())
                .transform(new CircleTransformation())
                .placeholder(ContextCompat.getDrawable(mContext, R.drawable.placeholder_heroes_adapter))
                .into(((HeroesViewHolder) holder).image);

        ((HeroesViewHolder) holder).heroeNameTextView.setText(heroe.getName());
        ((HeroesViewHolder) holder).heroeRealNameTextView.setText(heroe.getRealName());

        ((HeroesViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.onHeroeSelected(heroe);
                }
            }
        });

    }

    public void setOnItemClickListener(HeroesListener listener) {
        this.mClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class HeroesViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView heroeNameTextView, heroeRealNameTextView;

        public HeroesViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            heroeNameTextView = itemView.findViewById(R.id.heroe_name);
            heroeRealNameTextView = itemView.findViewById(R.id.heroe_real_name);

        }
    }
}
