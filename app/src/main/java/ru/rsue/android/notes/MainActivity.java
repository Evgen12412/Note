package ru.rsue.android.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvContainer;

    private FloatingActionButton fBtn;
    private NoteDb data;

    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView( );

        data = NoteDb.getInstance();



        adapter = new NotesAdapter();
        rvContainer.setAdapter(adapter);

        fBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = SecondActivity.newIntent(MainActivity.this );
                startActivity(i);
            }
        });
    }

    private  void initView( ) {
        fBtn = findViewById(R.id.fbtn_add_note);
        rvContainer = findViewById(R.id.rv_container);
    }
}