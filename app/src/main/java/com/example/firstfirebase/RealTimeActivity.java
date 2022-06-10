package com.example.firstfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RealTimeActivity extends AppCompatActivity {

    // Var globales
    FirebaseDatabase db;
    DatabaseReference myRef;

    private Button btnSend;
    private EditText etMessage;

    //Initialisation des composants
    private void initUI() {
        db = FirebaseDatabase.getInstance();
        myRef = db.getReference("message");

        btnSend = findViewById(R.id.btnSend);
        etMessage = findViewById(R.id.etMessage);

    }


    public void sendMessage(View view) {
        String message = etMessage.getText().toString();
        myRef.setValue(message);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime);

        initUI();
        //sendMessage(this);
    }
}