package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnlogin,btnworld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin=findViewById(R.id.btnlogin);
        btnworld=findViewById(R.id.btnworld);
        AlertDialog dialog=new AlertDialog.Builder(MainActivity.this)
                .setTitle("Deletion")
                .setMessage("Do you want to delete")
                .setIcon(R.drawable.ic_launcher_background)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "File is deleted sucessfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "File is not deleted", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "deletion Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false).create();
        btnworld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog customDialog=new Dialog(MainActivity.this);
                customDialog.setContentView(R.layout.dlg_login);
                EditText etusername=customDialog.findViewById(R.id.etusername);
                EditText etpassword=customDialog.findViewById(R.id.etpassword);
                Button btnLogin=customDialog.findViewById(R.id.btnLogin);
                Button btncancel=customDialog.findViewById(R.id.btncancel);
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, etusername.getText().toString()+"has been login sucessfully", Toast.LENGTH_SHORT).show();
                   customDialog.dismiss();
                    }
                });
                btncancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "login cancelled", Toast.LENGTH_SHORT).show();
                        customDialog.dismiss();
                    }
                });
                customDialog.show();
            }
        });

    }
}