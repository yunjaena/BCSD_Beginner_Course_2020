package com.yunjaena.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView phoneBookRecyclerView;
    private List<Person> personList;
    private RecyclerAdapter recyclerAdapter;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        phoneBookRecyclerView = findViewById(R.id.phone_book_recycler_view);
        addButton = findViewById(R.id.add_button);
        personList = new ArrayList<>();

        // 2. Adapter
        recyclerAdapter = new RecyclerAdapter(personList);
        phoneBookRecyclerView.setAdapter(recyclerAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personList.add(new Person("홍길동", "010-1234-5678"));
                recyclerAdapter.notifyDataSetChanged();
            }
        });
    }
}

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public List<Person> personList;

    public RecyclerAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone_book, null);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTextView.setText(personList.get(position).getName());
        holder.phoneNumberTextView.setText(personList.get(position).getPhoneNumber());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView phoneNumberTextView;
        public TextView nameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            phoneNumberTextView = itemView.findViewById(R.id.phone_number_text_view);
            nameTextView = itemView.findViewById(R.id.name_text_view);
        }
    }
}
