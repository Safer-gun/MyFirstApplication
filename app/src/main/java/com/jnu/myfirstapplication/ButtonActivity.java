package com.jnu.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {
    private Button mBtn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        mBtn3=(Button)findViewById(R.id.btn_3);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this,"你顶着我的肺了",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showToast(View view){
        Toast.makeText(this,"你击中我的心了",Toast.LENGTH_LONG).show();
    }
}
