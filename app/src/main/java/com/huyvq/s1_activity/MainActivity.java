package com.huyvq.s1_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.Contacts.SettingsColumns.KEY;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String KEY_MESSAGE = "KEY";
    public static final int KEY_REPLY = 1;

    private Button btSend;
    private EditText editText;
    private TextView textViewReply, textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btSend = findViewById(R.id.bt_send);
        btSend.setOnClickListener(this);

        textView = findViewById(R.id.text_header_reply);
        editText = findViewById(R.id.edt_text_main);

        textViewReply = findViewById(R.id.text_reply);
    }


    @Override
    public void onClick(View v) {
        if (editText.getText().toString().isEmpty()){
            Toast.makeText(this,"Bạn chưa nhập", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d(LOG_TAG, "Click Button Send");

        Intent intent = new Intent(this, SeconActivity.class);
        String message = editText.getText().toString();
        intent.putExtra(KEY_MESSAGE, message);

        startActivityForResult(intent, KEY_REPLY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == KEY_REPLY){
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra(SeconActivity.KEY_2);

                textView.setVisibility(View.VISIBLE);

                textViewReply.setText(reply);
                textViewReply.setVisibility(View.VISIBLE);

                editText.setText("");
            }
        }
    }
}