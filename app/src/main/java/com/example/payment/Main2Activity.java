package com.example.payment;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    EditText edittextTo, edittextSubject, edittextMessage;
    Button ButtonSend, ButtonAttachment, b1, b2;
    String email, message, subject, attechmentfile;
    Uri URI = null;
    Uri imageuri;
    ArrayList<Uri> uris = new ArrayList<Uri>();
    private static final int PICK_FROM_GALLERY = 101;
    int CollumnIndex;
    String[] hi = new String[10];


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {

            imageuri = data.getData();


//            ClipData clipData=data.getClipData();
//            if(clipData!=null){
//
//                for(int i=0;i<clipData.getItemCount();i++){
//                    Uri imageuri=clipData.getItemAt(i).getUri();
//               uris.add(imageuri);
//                }
//
//            }else {
//
//            }


        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edittextTo = findViewById(R.id.edittextTo);

        edittextSubject = findViewById(R.id.edittextSubject);
        edittextMessage = findViewById(R.id.edittextMessage);
        b1 = findViewById(R.id.whatsapp);
        b2 = findViewById(R.id.call);
        ButtonSend = findViewById(R.id.ButtonSend);
        ButtonAttachment = findViewById(R.id.ButtonAttachment);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri hii = Uri.parse("smsto:" + "+919904278734");
                Intent i = new Intent(Intent.ACTION_SENDTO, hii);
                i.setPackage("com.whatsapp");
                startActivity(i);


//                startActivity(new Intent(Intent.ACTION_VIEW));

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri hii = Uri.parse("tel::" + "+9199*****34");
                Intent i = new Intent(Intent.ACTION_DIAL,hii);
                startActivity(i);


            }
        });
        ButtonSend.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View view) {
                Intent pickintent = new Intent();

                pickintent.setType("image/*");
                pickintent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(pickintent, "select picture"), PICK_FROM_GALLERY);
                Intent emailintent = new Intent(Intent.ACTION_SEND);
                emailintent.setType("vnd.android.cursor.dir/email");
                String to[] = {"mit202220@gmail.com"};
                emailintent.putExtra(Intent.EXTRA_EMAIL, to);
                emailintent.putExtra(Intent.EXTRA_STREAM, imageuri);
                emailintent.putExtra(Intent.EXTRA_SUBJECT, "subject");

                startActivity(Intent.createChooser(emailintent, "send email...."));


//
//                 Intent pickintent = new Intent(Intent.ACTION_GET_CONTENT);
//                pickintent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
//                pickintent.setType("image/*");
//
//
//               startActivityForResult(Intent.createChooser(pickintent,"select picture"),PICK_FROM_GALLERY);
//                Intent emailintent=new Intent(Intent.ACTION_SEND);
//                emailintent.setType("vnd.android.cursor.dir/email");
//                String to[]={"mit202220@gmail.com"};
//                emailintent.putExtra(Intent.EXTRA_EMAIL,to);
//                emailintent.putParcelableArrayListExtra(Intent.EXTRA_STREAM,uris  );
//                emailintent.putExtra(Intent.EXTRA_SUBJECT,"subject");
//
//                startActivity(Intent.createChooser(emailintent,"send email...."));


            }
        });


    }

    @Override
    public void onClick(View view) {

    }
}
