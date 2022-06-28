package com.example.recyclerviewfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextView tvMsg, tvObj, tvColl;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMsg = findViewById(R.id.textViewMessage);
        tvObj = findViewById(R.id.textViewObject);
        tvColl = findViewById(R.id.textViewCollection);
    }

    public void msgClick(View view) {
        DatabaseReference myRef = database.getReference("msg");
        myRef.setValue("Hello, World!");
    }

    public void objectClick(View view) {
        Contact c = new Contact (  "ali", "ali" ,"9685855");
    }

    public void collectionClick(View view) {
        Contact c = new Contact (  "ali", "ali" ,"9685855");
        Contact c1 = new Contact ("salh","salh", "99999");
        DatabaseReference myRef = database.getReference( "tabContacts");
        //myRef.child("c1").setValue(c);
        //myRef.child("c2/").setValue(c);

        myRef.push().setValue(c1);

    }
}