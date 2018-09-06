package com.example.okcomputers.authfirebase;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {


    private DatabaseReference databaseReference;
    private FirebaseDatabase mFirebaseDatabase;
    private FoodItemAdapter mFoodAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
      databaseReference = mFirebaseDatabase.getReference().child("Users");

        List<FoodItemclass> foodItemclasses = new ArrayList<>();

      mFoodAdapter = new FoodItemAdapter(this,foodItemclasses);

      mListView = (ListView)findViewById(R.id.Listview);

        mListView.setAdapter(mFoodAdapter);
      databaseReference.addChildEventListener(new ChildEventListener() {
          @Override
          public void onChildAdded( DataSnapshot dataSnapshot,  String s) {
                FoodItemclass foodItemsclass = dataSnapshot.getValue(FoodItemclass.class);
                mFoodAdapter.add(foodItemsclass);
          }

          @Override
          public void onChildChanged( DataSnapshot dataSnapshot,  String s) {

          }

          @Override
          public void onChildRemoved( DataSnapshot dataSnapshot) {

          }

          @Override
          public void onChildMoved( DataSnapshot dataSnapshot,  String s) {

          }

          @Override
          public void onCancelled( DatabaseError databaseError) {

          }
      });
    }

}

