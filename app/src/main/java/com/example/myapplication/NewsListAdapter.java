package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyViewHolder> {
    private List<NewsItem> list;
    private Context context;

    NewsItemClickListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.textview1);
            imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }


    public NewsListAdapter(List<NewsItem> list, Context ctx, NewsItemClickListener listener) {
        this.list = list;
        context = ctx;
        this.listener = listener;
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        final NewsItem itm = list.get(position);
        viewHolder.title.setText(itm.getTitle());
        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(itm);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface NewsItemClickListener {
        void onItemClick(NewsItem item);
    }
}
