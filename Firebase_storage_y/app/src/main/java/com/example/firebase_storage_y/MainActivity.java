package com.example.firebase_storage_y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView end;
    ImageView imageView,imageView2;
    Intent intent;
    int PICK_CONTACT_REQUEST=1;
    Uri uri;
    String data_list;
    EditText fileName;
    StorageReference storageReference,pic_storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);

        end=(TextView) findViewById(R.id.textView2);

        fileName=(EditText) findViewById(R.id.filename);

        imageView=(ImageView)  findViewById(R.id.imageView);
        imageView2=(ImageView)  findViewById(R.id.imageView2);

        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);

        storageReference = FirebaseStorage.getInstance().getReference();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 intent=new Intent();
                 intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                 intent.setType("image/*");
                 intent.setAction(Intent.ACTION_GET_CONTENT);
                 startActivityForResult(intent,1);
                 b2.setEnabled(true);
                 b3.setEnabled(true);
                 b4.setEnabled(true);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = fileName.getText().toString();
                pic_storage =  storageReference.child(s+data_list);
                pic_storage.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        end.setText("上傳成功");
                    }
                });
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = fileName.getText().toString();
                pic_storage = storageReference.child(s+data_list);
                File file;
                try{
                    file = File.createTempFile("image","png");
                    pic_storage.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            imageView2.setImageURI(Uri.fromFile(file));
                            end.setText("讀取成功");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            end.setText("讀取失敗");
                        }
                    });
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = fileName.getText().toString();
                pic_storage=storageReference.child(s+data_list);
                pic_storage.delete();
                end.setText("刪除成功");
                imageView.setImageURI(null);
                imageView2.setImageURI(null);
            }
        });
        Button btn = (Button) findViewById(R.id.button9);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
                startActivity(intent);
            }});
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==PICK_CONTACT_REQUEST){
            uri = data.getData();
            imageView.setImageURI(uri);

            ContentResolver contentResolver=getContentResolver();
            MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
            data_list = mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
        }


        super.onActivityResult(requestCode,resultCode,data);
    }
    public void jumpfirebase(View view){
        Uri uri = Uri.parse("https://console.firebase.google.com/u/0/");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}