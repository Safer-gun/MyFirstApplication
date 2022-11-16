package com.jnu.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jnu.myfirstapplication.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {
    private Button mButtonbtn_1;
    private Button mButtontext;
    private Button mButtonbtn_3;
    private Button mBtnRadioButton;
    private Button mBtnCheckButton;
    private Button mBtnRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonbtn_1=(Button)findViewById(R.id.btn_1);
        mButtontext=(Button) findViewById(R.id.btn_2);
        mButtonbtn_3=(Button)findViewById((R.id.btn_3));
        mBtnRadioButton=(Button)findViewById((R.id.btn_radioButton));
        mBtnCheckButton=(Button)findViewById(R.id.btn_checkbox);
        mBtnRV=(Button)findViewById(R.id.btn_recyclerview);
        setListener();;
    }


    private void setListener(){
        OnClick onClick=new OnClick();
        mButtonbtn_1.setOnClickListener(onClick);
        mButtontext.setOnClickListener(onClick);
        mButtonbtn_3.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckButton.setOnClickListener(onClick);
        mBtnRV.setOnClickListener(onClick);

    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent=null;
            switch(view.getId()){
                case R.id.btn_1:
                    intent =new Intent(MainActivity.this,ButtonActivity.class);
                    break;
                case R.id.btn_2:
                    break;
                case R.id.btn_3:
                    intent =new Intent(MainActivity.this,EditTextActivity.class);
                    break;
                case R.id.btn_radioButton:
                    intent =new Intent(MainActivity.this,RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent=new Intent(MainActivity.this,CheckBoxActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    intent=new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
