package com.tips.guidejded_jded;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button  btn1 , btn2 , btn3, btn4, btn5, btn6, btn7;
    private TextView text1, text2, text3, text4, text5, text6 , text7;
    private DatabaseReference mrefarence;

     // data from database fairebase
    private String   rbtn1 , rbtn2 ,rbtn3 ,rbtn4 ,rbtn5 , rbtn6 ,rbtn7;
    private String   rtext1, rtext2, rtext3, rtext4, rtext5, rtext6, rtext7  ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);
        btn7 = (Button)findViewById(R.id.button7);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
        text3 = (TextView)findViewById(R.id.textView3);
        text4 = (TextView)findViewById(R.id.textView4);
        text5 = (TextView)findViewById(R.id.textView5);
        text6 = (TextView)findViewById(R.id.textView6);
        text7 = (TextView)findViewById(R.id.textView7);

        mrefarence = FirebaseDatabase.getInstance().getReference().child( "guide_jded");

        mrefarence.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                rbtn1 = dataSnapshot.child("btn1").getValue().toString();
                rbtn2 = dataSnapshot.child("btn2").getValue().toString();
                /*
                rbtn3 = dataSnapshot.child("btn3").getValue().toString();
                rbtn4 = dataSnapshot.child("btn4").getValue().toString();
                rbtn5 = dataSnapshot.child("btn5").getValue().toString();
                rbtn6 = dataSnapshot.child("btn6").getValue().toString();
                rbtn7 = dataSnapshot.child("btn7").getValue().toString();
                */

                rtext1 = dataSnapshot.child("text1").getValue().toString();
                rtext2 = dataSnapshot.child("text2").getValue().toString();
                /*
                rtext3 = dataSnapshot.child("text3").getValue().toString();
                rtext4 = dataSnapshot.child("text4").getValue().toString();
                rtext5 = dataSnapshot.child("text5").getValue().toString();
                rtext6 = dataSnapshot.child("text6").getValue().toString();
                rtext7 = dataSnapshot.child("text7").getValue().toString();

                */

                btn1.setText(rbtn1);
                btn2.setText(rbtn2);

                text1.setText(rtext1);
                text2.setText(rtext2);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
