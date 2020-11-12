package com.yunjaena.project;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.phone_book_list_view);
        personList = new ArrayList<>();
        personList.add(new Person("홍길동", "010-1234-5678"));
        personList.add(new Person("길동", "010-1234-5678"));
        personList.add(new Person("홍동", "010-1234-5678"));
        personList.add(new Person("홍", "010-1234-5678"));
        personList.add(new Person("홍길동", "010-1234-5678"));
        personList.add(new Person("길동", "010-1234-5678"));
        personList.add(new Person("홍동", "010-1234-5678"));
        personList.add(new Person("홍", "010-1234-5678"));
        personList.add(new Person("홍길동", "010-1234-5678"));
        personList.add(new Person("길동", "010-1234-5678"));
        personList.add(new Person("홍동", "010-1234-5678"));
        personList.add(new Person("홍", "010-1234-5678"));
        personList.add(new Person("홍길동", "010-1234-5678"));
        personList.add(new Person("길동", "010-1234-5678"));
        personList.add(new Person("홍동", "010-1234-5678"));
        personList.add(new Person("홍", "010-1234-5678"));
        personList.add(new Person("홍길동", "010-1234-5678"));
        personList.add(new Person("길동", "010-1234-5678"));
        personList.add(new Person("홍동", "010-1234-5678"));
        personList.add(new Person("홍", "010-1234-5678"));
        personList.add(new Person("홍길동", "010-1234-5678"));
        personList.add(new Person("길동", "010-1234-5678"));
        personList.add(new Person("홍동", "010-1234-5678"));
        personList.add(new Person("홍", "010-1234-5678"));
        personList.add(new Person("홍길동", "010-1234-5678"));
        personList.add(new Person("길동", "010-1234-5678"));
        personList.add(new Person("홍동", "010-1234-5678"));
        personList.add(new Person("홍", "010-1234-5678"));
        listViewAdapter = new ListViewAdapter(personList, this);
        listView.setAdapter(listViewAdapter);
    }
}

class ListViewAdapter extends BaseAdapter {
    public static final String TAG = "ListViewAdapter";
    private List<Person> personList;
    private Context context;

    public ListViewAdapter(List<Person> personList, Context context) {
        this.personList = personList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int i) {
        return personList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view;
        ViewHolder viewHolder;

        if (convertView == null) {
            Log.d(TAG, "new view : " + position);
            view = LayoutInflater.from(context).inflate(R.layout.item_phone_book, null);
            viewHolder = new ViewHolder();
            viewHolder.nameTextView = view.findViewById(R.id.name_text_view);
            viewHolder.phoneNumberTextView = view.findViewById(R.id.phone_number_text_view);
            view.setTag(viewHolder);
        } else {
            Log.d(TAG, "convert view : " + position);
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }

        viewHolder.nameTextView.setText(personList.get(position).getName());
        viewHolder.phoneNumberTextView.setText(personList.get(position).getPhoneNumber());
        return view;
    }
}

class Person {
    private String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

class ViewHolder {
    public TextView nameTextView;
    public TextView phoneNumberTextView;
}
