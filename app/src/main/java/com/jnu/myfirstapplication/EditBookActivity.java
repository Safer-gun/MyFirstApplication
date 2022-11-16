package com.jnu.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditBookActivity extends AppCompatActivity {

    public static final int RESULT_CODE_SUCCESS = 666;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);
        EditText editTextTitle=findViewById(R.id.editTextbooktitle);

        position=this.getIntent().getIntExtra("position",0);
        String title=this.getIntent().getStringExtra("titile");

        if(null!=title)
        {
            editTextTitle.setText(title);
        }


        Button buttonyes=findViewById(R.id.edit_btn_yes);
        Button buttonno=findViewById((R.id.edit_btn_no));
        buttonyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putString("title",editTextTitle.getText().toString());
                bundle.putInt("position",position);
                intent.putExtras(bundle);
                setResult(RESULT_CODE_SUCCESS,intent);
                EditBookActivity.this.finish();
            }
        });
        buttonno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditBookActivity.this.finish();
            }
        });

    }
}