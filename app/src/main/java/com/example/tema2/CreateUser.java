package com.example.tema2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class CreateUser extends AppCompatActivity {

    EditText name;
    EditText mark;
    Button buttonAdd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        name = findViewById(R.id.first_and_last_name);
        mark = findViewById(R.id.mark);
        buttonAdd = findViewById(R.id.buttonAdd);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "production").allowMainThreadQueries().build();


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(name.getText().toString(), Integer.parseInt(mark.getText().toString()));
                db.userDao().insertAll(user);

                startActivity(new Intent(CreateUser.this, MainActivity.class));
            }
        });

    }
}
