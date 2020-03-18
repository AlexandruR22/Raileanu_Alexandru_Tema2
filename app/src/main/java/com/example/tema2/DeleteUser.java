package com.example.tema2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class DeleteUser extends AppCompatActivity {

    EditText name;
    Button buttonDelete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_user);

        name = findViewById(R.id.delUser);
        buttonDelete = findViewById(R.id.buttonDelete);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "production").allowMainThreadQueries().build();


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aux = name.getText().toString();
                User user = new User();
                user.setName(aux);
                db.userDao().deleteUser(user);

                startActivity(new Intent(DeleteUser.this, MainActivity.class));
            }
        });

    }
}
