package com.home.currency;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText edNtd;
    private Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

    }

    private void findViews() {
        edNtd = findViewById(R.id.ntd);
        btnGo = findViewById(R.id.button);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ntd = edNtd.getText().toString();
                if (ntd.equals("")) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.problem)
                            .setMessage(R.string.please_enter_ntd)
                            .setPositiveButton(R.string.ok, null)
                            .show();
                } else {
                    String result = String.format(Locale.ENGLISH, "%.4f", Integer.parseInt(ntd) / 30.9);
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.result)
                            .setMessage(getString(R.string.usd_is) + result)
                            .setPositiveButton(R.string.ok, null)
                            .show();
                }
            }
        });
    }
}
