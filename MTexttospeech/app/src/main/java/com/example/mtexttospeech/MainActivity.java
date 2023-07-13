package com.example.mtexttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    Button btn;
    EditText editText;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(this);
        editText=findViewById(R.id.editTextText);
        textToSpeech=new TextToSpeech(getBaseContext(),this);
        textToSpeech.setLanguage(Locale.ENGLISH);

    }

    @Override
    public void onClick(View v) {
        String text=editText.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);



    }

    @Override
    public void onInit(int status) {
        if(status!=TextToSpeech.ERROR){
            Toast.makeText(getBaseContext(),"sucess",Toast.LENGTH_LONG).show();
        }

    }
}