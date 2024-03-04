package ru.rsue.android.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private EditText eText;

    private RadioButton lBtn;
    private RadioButton mBtn;

    private Button saveBtn;

    private NoteDb data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        data = NoteDb.getInstance();
        initView( );

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });

    }

    private  void initView( ) {
        eText = findViewById(R.id.et_note_text);
        lBtn = findViewById(R.id.rb_low);
        mBtn = findViewById(R.id.rb_med);
       saveBtn = findViewById(R.id.btn_save_note);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, SecondActivity.class);
    }

    private void saveNote() {
        String text = eText.getText().toString();
        int priority = getPriority();
        int id = data.getNotes().size();
        data.add(new Note(id, text, priority));
        finish();
    }

    private int getPriority() {
        if (lBtn.isChecked()) {
            return 0;
        } else if (mBtn.isChecked()) {
            return 1;
        } else {
            return 2;
        }
    }
}