package com.example.pinakaappdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class GameLobby extends AppCompatActivity{


    ListView listView;
    Button button;
    List<String> roomsList;

    String playerName = "";
    String roomName = "";

    FirebaseDatabase firebaseDatabase;
    DatabaseReference roomRef;
    DatabaseReference roomsRef;

   // String firebaseUrl = "https://appdev-69e51-default-rtdb.asia-southeast1.firebasedatabase.app/";

   // DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl(firebaseUrl);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lobby);

        firebaseDatabase = FirebaseDatabase.getInstance();

        // get playerName and automatically assign it as the room's name.
        SharedPreferences preferences = getSharedPreferences("myPreferences", 0);
        playerName = preferences.getString("playerName", "");
        roomName = playerName;

        listView = findViewById(R.id.ListView);
        button = findViewById(R.id.startBtn);

        roomsList = new ArrayList<>();

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //create room and app self as player 1
                button.setText("Creating Room");
                button.setEnabled(false);
                roomName = playerName;
                roomRef = firebaseDatabase.getReference("rooms/" + roomName + "/player1");
                addRoomEventListener();
                roomRef.setValue(playerName);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                roomName = roomsList.get(position);
                roomRef = firebaseDatabase.getReference("rooms/" + roomName + "/player2");
                addRoomEventListener();
                roomRef.setValue(playerName);
            }
        });
        //show if new rooms are available.
        addRoomsEventListener();
    }
    private void addRoomEventListener(){
        roomRef.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(
                    @NonNull DataSnapshot snapshot){
                //join room
                button.setText("CREATE Room");
                button.setEnabled(true);
                Intent intent = new Intent(getApplicationContext(), gameplay.class);
                intent.putExtra("roomName", roomName);
                startActivity(intent);
            }
            @Override
            public void onCancelled(
                    @NonNull DatabaseError error){
                button.setText("CREATE ROOM");
                button.setEnabled(true);
                Toast.makeText(GameLobby.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void addRoomsEventListener(){
    roomsRef = firebaseDatabase.getReference("rooms");
    roomsRef.addValueEventListener(new ValueEventListener(){
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot){
            roomsList.clear();
            Iterable<DataSnapshot> rooms = dataSnapshot.getChildren();
            for(DataSnapshot snapshot : rooms){
                roomsList.add(snapshot.getKey());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(GameLobby.this, android.R.layout.simple_list_item_1, roomsList);
            listView.setAdapter(adapter);
        }
        @Override
        public void onCancelled(@NonNull DatabaseError error){
            }
        });


       /* ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(true);
        progressDialog.setCancelMessage("Waiting for opponent's turn to finish...");
        progressDialog.show();*/
    }
}