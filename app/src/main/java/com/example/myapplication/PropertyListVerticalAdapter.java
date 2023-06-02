package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class PropertyListVerticalAdapter extends RecyclerView.Adapter<PropertyListVerticalAdapter.MyViewHolder> {
    private List<PropertyItem> list;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, location, price, bathroom, bedroom, parking;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.textview1);
            location = (TextView) view.findViewById(R.id.textview2);
            price = (TextView) view.findViewById(R.id.textview3);
            bathroom = (TextView) view.findViewById(R.id.textview4);
            bedroom = (TextView) view.findViewById(R.id.textview5);
            parking = (TextView) view.findViewById(R.id.textview6);

            imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }


    public PropertyListVerticalAdapter(List<PropertyItem> list, Context ctx) {
        this.list = list;
        context = ctx;
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.property_item_vertical, parent,
                false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        final PropertyItem itm = list.get(position);
        viewHolder.title.setText("Property " + position + 1);
        viewHolder.location.setText("Location: " + itm.getLocation());
        viewHolder.price.setText("Price: " + itm.getPrice());
        viewHolder.bedroom.setText("Bedroom: " + itm.getBedrooms());
        viewHolder.bathroom.setText("Bathroom: " + itm.getBathrooms());
        viewHolder.parking.setText("Parking: " + itm.getParking_space());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
