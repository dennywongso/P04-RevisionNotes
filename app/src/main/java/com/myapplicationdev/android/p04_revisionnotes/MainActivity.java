package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNote;
    RadioGroup rgStar;
    Button btnInsert, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNote = (EditText)findViewById(R.id.editTextNote);
        rgStar = (RadioGroup)findViewById(R.id.radioGroupStars);
        btnInsert =(Button)findViewById(R.id.buttonInsertNote);
        btnShow = (Button)findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selecteedButtonId = rgStar.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selecteedButtonId);
                int star = Integer.parseInt(rb.getText().toString());
                String note = etNote.getText().toString();
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertNote(note,star);
                db.close();
                Toast.makeText(MainActivity.this,"Added successfully",Toast.LENGTH_SHORT).show();
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
