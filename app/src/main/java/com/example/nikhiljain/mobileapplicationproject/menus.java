package com.example.nikhiljain.mobileapplicationproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class menus extends AppCompatActivity {

    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myRef= database.getReference();

    TextView breakfast, lunch, snacks, dinner, output;
    Button res;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("MESS MENU");

        breakfast= (TextView) findViewById(R.id.textView9);
        lunch= (TextView) findViewById(R.id.textView10);
        snacks= (TextView) findViewById(R.id.textView11);
        dinner= (TextView) findViewById(R.id.textView12);
        res= (Button) findViewById(R.id.btn);
        sp= (Spinner) findViewById(R.id.spinner);

        String[] DAYS={"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        List<String> list= new ArrayList<String>();
        for(int i=0;i<DAYS.length;i++){
            list.add(DAYS[i]);
        }

        ArrayAdapter<String> dataAdapter= new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str;
                str= sp.getSelectedItem().toString();

                output= (TextView) findViewById(R.id.textView13);
                output.setText("For " + str);

                DatabaseReference ref1= myRef.child("days").child(str).child("Breakfast");
                ref1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        String val= dataSnapshot.getValue(String.class);

                        breakfast.setText(val);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                DatabaseReference ref2= myRef.child("days").child(str).child("Lunch");
                ref2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        String val= dataSnapshot.getValue(String.class);

                        lunch.setText(val);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                DatabaseReference ref3= myRef.child("days").child(str).child("Snacks");
                ref3.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        String val= dataSnapshot.getValue(String.class);

                        snacks.setText(val);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                DatabaseReference ref4= myRef.child("days").child(str).child("Dinner");
                ref4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        String val= dataSnapshot.getValue(String.class);

                        dinner.setText(val);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}


