package com.example.payment;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.e1);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.next);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(in);


            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String transactionNote = "Unknown Gamer";
                String currencyUnit = "INR";
                Uri uri = Uri.parse("upi://pay?pa=" + "jbbram681@okicici" + "&pn=" + "Meet " + "&tn=" + transactionNote +
                        "&am=" + s1 + "&cu=" + currencyUnit);
                Intent intent = new Intent();
                intent.setData(uri);
                Intent chooser = Intent.createChooser(intent, "Pay with...");
                startActivityForResult(chooser, 1, null);
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String res = data.getStringExtra("response");
            String search = "SUCCESS";
            if (Objects.requireNonNull(res).toLowerCase().contains(search.toLowerCase())) {


                Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
