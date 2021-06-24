package com.example.a2d_recycler_view;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.CustomViewHolder> {

    private Context context;
    private ArrayList<Chapter> chapters;
    private implementonclick implement;

    public ChapterAdapter(Context context, ArrayList<Chapter> chapters,implementonclick implement) {
        this.context = context;
        this.chapters = chapters;
        this.implement = implement;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.single_chapter, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.tvChapterName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implement.onclicklis(position);
            }
        });
        Chapter chapter = chapters.get(position);
        holder.tvChapterName.setText(chapter.chapterName);

    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {


        public TextView tvChapterName;

        public CustomViewHolder(View itemView) {
            super(itemView);

            tvChapterName = (TextView) itemView.findViewById(R.id.tvChapterName);

        }
    }
}

