package com.smile.newsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by smile on 9/7/15.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    protected int resourceID;

    public NewsAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        resourceID = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);
        View view;
        if (convertView != null) {
            view = convertView;
        }else {
            view = LayoutInflater.from(getContext()).inflate(resourceID, null);
            TextView textView = (TextView) view.findViewById(R.id.news_title);
            textView.setText(news.getTitle());
        }
        return view;
    }

}
