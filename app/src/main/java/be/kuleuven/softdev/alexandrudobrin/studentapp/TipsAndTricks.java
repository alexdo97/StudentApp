package be.kuleuven.softdev.alexandrudobrin.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TipsAndTricks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_and_tricks);

        Button Tip1Btn = (Button) findViewById(R.id.Tip1Btn);
        Tip1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, Tip1Activity.class);
                startActivity(intent);
            }
        });

        Button Tip2Btn = (Button) findViewById(R.id.Tip2Btn);
        Tip2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, Tip2Activity.class);
                startActivity(intent);
            }
        });

        Button Tip3Btn = (Button) findViewById(R.id.Tip3Btn);
        Tip3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, Tip3Activity.class);
                startActivity(intent);
            }
        });

        Button Tip4Btn = (Button) findViewById(R.id.Tip4Btn);
        Tip4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, Tip4Activity.class);
                startActivity(intent);
            }
        });

        Button Tip5Btn = (Button) findViewById(R.id.Tip5Btn);
        Tip5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, Tip5Activity.class);
                startActivity(intent);
            }
        });

        Button Tip6Btn = (Button) findViewById(R.id.Tip6Btn);
        Tip6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, Tip6Activity.class);
                startActivity(intent);
            }
        });

        Button Tip7Btn = (Button) findViewById(R.id.Tip7Btn);
        Tip7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, Tip7Activity.class);
                startActivity(intent);
            }
        });

        Button Tip8Btn = (Button) findViewById(R.id.Tip8Btn);
        Tip8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, Tip8Activity.class);
                startActivity(intent);
            }
        });

        Button Tip9Btn = (Button) findViewById(R.id.Tip9Btn);
        Tip9Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, Tip9Activity.class);
                startActivity(intent);
            }
        });

        Button Tip10Btn = (Button) findViewById(R.id.Tip10Btn);
        Tip10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, Tip10Activity.class);
                startActivity(intent);
            }
        });

        Button Tip11Btn = (Button) findViewById(R.id.Tip11Btn);
        Tip11Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, Tip11Activity.class);
                startActivity(intent);
            }
        });

        Button Tip12Btn = (Button) findViewById(R.id.Tip12Btn);
        Tip12Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, Tip12Activity.class);
                startActivity(intent);
            }
        });

        Button TipContinueBtn = (Button) findViewById(R.id.TipContinueBtn);
        TipContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, MainLightActivity.class);
                startActivity(intent);
            }
        });

        Button BackBtn = (Button) findViewById(R.id.BackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsAndTricks.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
