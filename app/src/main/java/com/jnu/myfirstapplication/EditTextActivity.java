package com.jnu.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {
    private Button mBtnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        mBtnLogin=(Button)findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditTextActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_1:
                    break;
                case R.id.btn_2:
                    break;
                case R.id.btn_3:
                    break;
                case R.id.btn_4:
                    break;
                case R.id.btn_login:
                    break;
            }
        }
    }
}
