package com.exem.evo12;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnActTwo;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<RecyclerItem> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActTwo = (ImageButton) findViewById(R.id.btnActTwo);
        btnActTwo.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        //Generate sample data

        for (int i = 0; i<10; i++) {
            listItems.add(new RecyclerItem("Item " + (i + 1), "Welcome to Torisan channel, this is description of item " + (i+1)));
        }
        final EditText editText = (EditText) findViewById(R.id.etWidth1);

        //Set adapter
        adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        listItems.add(0, editText.getText().toString());
                        adapter.notifyDataSetChanged();
                        editText.setText("");
                        return true;
                    }
                return false;
            }
        });


    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, NoteDetailsActivity.class);
        startActivity(intent);
        switch (v.getId()) {
            case R.id.btnActTwo:
                // TODO Call second activity
                break;
            default:
                break;
        }
    }
}