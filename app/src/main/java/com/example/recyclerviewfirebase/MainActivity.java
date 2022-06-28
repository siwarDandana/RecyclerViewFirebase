package com.example.recyclerviewfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {

    TextView tvMsg, tvObj, tvColl;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseStorage storage = FirebaseStorage.getInstance();
    DatabaseReference myRef = database.getReference("msg");
    DatabaseReference myRefObj = database.getReference("Epi/contact");
    DatabaseReference myRefColl = database.getReference("tabContacts");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMsg = findViewById(R.id.textViewMessage);
        tvObj = findViewById(R.id.textViewObject);
        tvColl = findViewById(R.id.textViewCollection);
        myRef.addValueEventListener(valMessage);
        myRefObj.addValueEventListener(valObj);
        myRefColl.addValueEventListener(valColl);
    }

    public void msgClick(View view) {
        //myRef.setValue("Hello, World!");
        myRef.setValue(null); //suppression noeud
    }

    public void objectClick(View view) {
        Contact c = new Contact (  "ali", "ali" ,"9685855");

        DatabaseReference myRefo = database.getReference("Epi/contact");
        myRefo.setValue(c);
    }

    public void collectionClick(View view) {
        Contact c = new Contact (  "ali", "ali" ,"9685855");
        Contact c1 = new Contact ("salh","salh", "99999");
        DatabaseReference myRefc = database.getReference( "tabContacts");
        //myRef.child("c1").setValue(c);
        //myRef.child("c2/").setValue(c);

        myRefc.push().setValue(c1);

    }

    ValueEventListener valMessage = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            String ch = snapshot.getValue(String.class);
            tvMsg.setText(ch);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    ValueEventListener valObj = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            Contact c = snapshot.getValue(Contact.class);
            tvObj.setText(c.getId()+"  "+c.getNom()+"  "+c.getTel());
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    ValueEventListener valColl = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            Contact c;
            String ch="";
            for (DataSnapshot ds: snapshot.getChildren()) {
                c = ds.getValue(Contact.class);
                ch += c.getId()+"  "+c.getNom()+"  "+c.getTel()+"\n";
            }

            tvColl.setText(ch);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    public void storageClick(View view) {
        StorageReference storageReference = storage.getReference();
        StorageReference ref = storageReference.child("imagesEpi/imgs");

        //ref.putFile();



    }

    public void galleryClick(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

    }
}