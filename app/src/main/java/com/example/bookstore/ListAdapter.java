package com.example.bookstore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    public Context context;
    public ArrayList<Book> books;

    public ListAdapter(Context context, ArrayList<Book> books){
        this.context = context;
        this.books = books;

    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){

        View itemlayout=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itembooklist,null);

        RecyclerView.ViewHolder viewHolder=new ListAdapter.ViewHolder(itemlayout);
        return(ListAdapter.ViewHolder)viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder viewHolder, int i){
        Book in = books.get(i);
        viewHolder.title.setText(in.getTitle());
        viewHolder.authors.setText(in.getAuthors());
        viewHolder.category.setText(in.getCategory());
        viewHolder.date.setText(in.getDate());
        viewHolder.description.setText(in.getDescription());
        viewHolder.imageLink.setImageResource(in.getImageLink());

    }


    @Override
    public int getItemCount(){
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageLink;
        TextView title, description, category, authors, date;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageLink = itemView.findViewById(R.id.iv_book);
            title = itemView.findViewById(R.id.textview_title);
            description = itemView.findViewById(R.id.textview_description);
            category = itemView.findViewById(R.id.textview_category);
            authors = itemView.findViewById(R.id.textview_authors);
            date = itemView.findViewById(R.id.textview_date);

        }
    }




/*
    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.itembooklist,null);
        ImageView imageLink = convertView.findViewById(R.id.iv_book);
        TextView title, description, category, authors, date;
        title = convertView.findViewById(R.id.textview_title);
        description = convertView.findViewById(R.id.textview_description);
        category = convertView.findViewById(R.id.textview_category);
        authors = convertView.findViewById(R.id.textview_authors);
        date = convertView.findViewById(R.id.textview_date);

        imageLink.setImageResource(books.get(position).getImageLink());
        title.setText(books.get(position).getTitle());
        authors.setText(books.get(position).getAuthors());
        category.setText(books.get(position).getCategory());
        date.setText(books.get(position).getDate());
        description.setText(books.get(position).getDescription());

        return convertView;
    }
    */
}
