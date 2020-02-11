package com.example.todo;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.todo.R.id.bt_remove;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView mRecyclerview;
    TaskAdapter taskAdapter;
    List<Task> taskList;
    DatabaseHelper databaseHelper;
   // Button btRemove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mRecyclerview=findViewById(R.id.recycler_view);
      //  btRemove=findViewById(bt_remove);
        databaseHelper=new DatabaseHelper(this);
        taskList=new ArrayList<>();
        taskList=databaseHelper.getAllTask();
       // btRemove.setOnClickListener(this);
        recyclerviewSetUp();
        
    }

    private void recyclerviewSetUp() {
       mRecyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        taskAdapter = new TaskAdapter(getApplicationContext(),taskList);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(taskAdapter);

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id) {
            //case bt_remove:databaseHelper.deleteTask();
        }

    }
}
