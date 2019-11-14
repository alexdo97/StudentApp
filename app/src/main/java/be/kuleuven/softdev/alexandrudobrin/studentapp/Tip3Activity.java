package be.kuleuven.softdev.alexandrudobrin.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tip3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip3);

        Button NextBtn = (Button) findViewById(R.id.NextBtn);
        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tip3Activity.this, Tip4Activity.class);
                startActivity(intent);
            }
        });

        Button BackBtn = (Button) findViewById(R.id.BackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tip3Activity.this, TipsAndTricks.class);
                startActivity(intent);
            }
        });

        Button PreviousBtn = (Button) findViewById(R.id.PreviousBtn);
        PreviousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tip3Activity.this, Tip2Activity.class);
                startActivity(intent);
            }
        });
    }
}
