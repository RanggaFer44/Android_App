package com.example.apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetailActivity extends AppCompatActivity {

    TextView detailDesc, detailTitle, detailStep, detailIngredients, detailAdditional;
    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailDesc = findViewById(R.id.detailDesc);
        detailTitle = findViewById(R.id.detailTitle);
        detailStep = findViewById(R.id.detailStep);
        detailIngredients = findViewById(R.id.detailIngredients);
        detailAdditional = findViewById(R.id.detailAdditional);
        detailImage = findViewById(R.id.detailImage);
        deleteButton = findViewById(R.id.deleteButton);
        editButton = findViewById(R.id.editButton);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailDesc.setText(bundle.getString("Description"));
            detailIngredients.setText(bundle.getString("Ingredients"));
            detailTitle.setText(bundle.getString("Title"));
            detailStep.setText(bundle.getString("Step"));
            detailAdditional.setText(bundle.getString("Additional"));
            key = bundle.getString("key");
            imageUrl = bundle.getString("Image");
            Glide.with(DetailActivity.this).load(bundle.getString("Image")).into(detailImage);
        }

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Recipe");
                FirebaseStorage storage = FirebaseStorage.getInstance();

                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        reference.child(key).removeValue();
                        Toast.makeText(DetailActivity.this, "Data delete successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                });
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class)
                        .putExtra("Title", detailTitle.getText().toString())
                        .putExtra("Description", detailDesc.getText().toString())
                        .putExtra("Ingredients", detailIngredients.getText().toString())
                        .putExtra("Additional", detailAdditional.getText().toString())
                        .putExtra("Step", detailStep.getText().toString())
                        .putExtra("Image", imageUrl)
                        .putExtra("key", key);
                startActivity(intent);
            }
        });

    }

}