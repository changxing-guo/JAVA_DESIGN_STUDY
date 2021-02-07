package com.example.design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JniTestStatic a = new JniTestStatic();
        a.hello();
        int c = -1;
        c = a.getA(1,3);
        Log.d("gcx", "c = " + c);
    }
}