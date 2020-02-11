package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btSave,btShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btShow.setOnClickListener(this);
        btSave.setOnClickListener(this);
    }

    private void initViews() {
        btSave=findViewById(R.id.bt_save);
        btShow=findViewById(R.id.bt_show);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.bt_save:saveDialoge();
            case R.id.bt_show:Intent  i=new Intent(getApplicationContext(),SecondActivity.class);
            startActivity(i);
        }
    }

    private void saveDialoge() {
        CustomDialogClass cdd=new CustomDialogClass(this);
        cdd.show();

    }
}
