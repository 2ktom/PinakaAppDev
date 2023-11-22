package com.example.pinakaappdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class GameLobby extends AppCompatActivity{

	TextView p1, p2, pCount;
    private String playerUID = "0"; //Player unique ID
    private String opponentUID = "0";
	private boolean OpponentFound = false;

    private String status = "waiting";

    private String playerTurn = "";

    String firebaseUrl = "https://appdev-69e51-default-rtdb.asia-southeast1.firebasedatabase.app/";

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl(firebaseUrl);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lobby);

        p1 = findViewById(R.id.player1);
        p2 = findViewById(R.id.player2);
        pCount = findViewById(R.id.playerCount);

        // Get edittext input from SetAlias class
        final String playerAlias = getIntent().getStringExtra("playername");


        //Generate unique player id. The player will be identified by this id.
        playerUID = String.valueOf(System.currentTimeMillis());

        p1.setText(playerAlias);

        mDatabase.child("connections").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(
                    @NonNull DataSnapshot snapshot){
                //check if opponent is found
                if(OpponentFound){

                   //check if there are users in the firebase realtime db
                    if(snapshot.hasChildren()){

                        //check all connections if users are also waiting
                        for(DataSnapshot connections : snapshot.getChildren()){
                            long conId = Long.parseLong(connections.getKey());

                            int getPlayerCount = (int)connections.getChildrenCount();

                            if(status.equals("waiting")){
                            }
                        }
                    }
                }
                //If no lobby active, create a new one.
                else {

                    //Generate ID for new lobby.
                    String connUID = String.valueOf(System.currentTimeMillis());

                    snapshot.child(connUID).child(playerUID).child("player_name").getRef().setValue(playerUID);
                }
            }

            @Override
            public void onCancelled(
                    @NonNull DatabaseError error){

            }
        });
    }
}