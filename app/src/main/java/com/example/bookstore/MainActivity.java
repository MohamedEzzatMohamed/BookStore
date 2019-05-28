package com.example.bookstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.example.bookstore.Book;
import com.example.bookstore.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Book> books;
    ListAdapter listAdapter;
    String[] date = new String[]{"07","06","21","12","20","08","15","23","18","24","09","22","01","04","25","17","19","13","05","02","11","16","03","14","10"};

    RecyclerView listview_booklist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        books = new ArrayList<Book>();

        addBook();

        listview_booklist = findViewById(R.id.listview_booklist);
        listview_booklist.setLayoutManager(new LinearLayoutManager(this));

        listAdapter = new ListAdapter(this, books);

        listview_booklist.setAdapter(listAdapter);
        listview_booklist.hasFixedSize();

    }

    public void addBook(){

        for(int i = 0; i< 25; i++){
            Book book = new Book();
            book.setAuthors("Auther "+i);
            book.setCategory("Category "+i);
            book.setDescription("This book is number: "+i);
            book.setImageLink(R.drawable.book_do_not_be_sad);
            book.setTitle("Book "+ i);
            book.setDate(date[i]+"/02/2015");
            books.add(book);
        }
        return;
    }

    public void sortList(View view) {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

        listAdapter.notifyDataSetChanged();
    }
}
