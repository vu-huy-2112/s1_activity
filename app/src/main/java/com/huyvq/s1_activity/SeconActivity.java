package com.huyvq.s1_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SeconActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_2 = "KEY_2";
    private TextView textView;
    private EditText editText;
    private Button btReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon);

        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        String massage = intent.getStringExtra(MainActivity.KEY_MESSAGE);

        editText = findViewById(R.id.edt_text_sencond);
        btReply = findViewById(R.id.bt_reply);
        btReply.setOnClickListener(this);

        textView = findViewById(R.id.text_message);
        textView.setText(massage);
    }

    @Override
    public void onClick(View v) {
        if (editText.getText().toString().isEmpty()){
            Toast.makeText(this,"Bạn chưa nhập", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent();
        String reply = editText.getText().toString();
        intent.putExtra(KEY_2, reply);
        setResult(RESULT_OK, intent);
        finish();
    }
}