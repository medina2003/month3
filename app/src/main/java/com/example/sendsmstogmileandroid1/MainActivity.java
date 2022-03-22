package com.example.sendsmstogmileandroid1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button = findViewById(R.id.btn_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }

            private void sendMail() {
                String resultList=editText1.getText().toString();
                String[] recipients=resultList.split(",");

                String part=editText2.getText().toString();
                String massage=editText3.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,part);
                intent.putExtra(Intent.EXTRA_TEXT,massage);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose  here email"));
            }
        });

    }
}
