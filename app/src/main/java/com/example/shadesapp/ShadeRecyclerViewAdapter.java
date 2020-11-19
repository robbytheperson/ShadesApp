package com.example.shadesapp;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Shade}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ShadeRecyclerViewAdapter extends RecyclerView.Adapter<ShadeRecyclerViewAdapter.ViewHolder> {

    private final List<Shade> mValues;
    private Context context;

    public ShadeRecyclerViewAdapter(List<Shade> mValues, Context context) {
        this.mValues = mValues;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_shade_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mShade = mValues.get(position);
        holder.mShadeTextView.setText(holder.mShade.getName());
        holder.mShadeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                    Intent intent = new Intent(context, InformationActivity.class);
                    intent.putExtra("shade_detail", holder.mShade.getDescription());
                    context.startActivity(intent);
                }
                else {
                    TextView shadeDetailTV = ((MainActivity)context).findViewById(R.id.shade_detail_TV);
                    shadeDetailTV.setText(holder.mShade.getDescription());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mShadeTextView;
        public Shade mShade;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mShadeTextView = (TextView) view.findViewById(R.id.shade_name_itemTV);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mShadeTextView.getText() + "'";
        }
    }
}