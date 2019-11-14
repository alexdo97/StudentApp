package be.kuleuven.softdev.alexandrudobrin.studentapp;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import java.util.Timer;

public class ChronometerActivity extends AppCompatActivity {

    private Button mStartButton;
    private Button mPauseButton;
    private Button mResetButton;
    Button mFinishButton;
    private Chronometer mChronometer;

    private long lastPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);




        mStartButton = (Button) findViewById(R.id.StartBtn);
        mPauseButton = (Button) findViewById(R.id.PauseBtn);
        mResetButton = (Button) findViewById(R.id.ResetBtn);
        mChronometer = (Chronometer) findViewById(R.id.Chronometer);
        mFinishButton = (Button) findViewById(R.id.FinishBtn);
        mFinishButton.setEnabled(false);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastPause != 0)
                {
                    mChronometer.setBase(mChronometer.getBase() + SystemClock.elapsedRealtime() - lastPause);
                }
                else
                {
                    mChronometer.setBase(SystemClock.elapsedRealtime());
                }

                mChronometer.start();
                mStartButton.setEnabled(false);
                mPauseButton.setEnabled(true);
                mFinishButton.setEnabled(false);

            }
        });

        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastPause = SystemClock.elapsedRealtime();
                mChronometer.stop();
                mPauseButton.setEnabled(false);
                mStartButton.setEnabled(true);
                mFinishButton.setEnabled(true);
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometer.stop();
                mChronometer.setBase(SystemClock.elapsedRealtime());
                lastPause = 0;
                mStartButton.setEnabled(true);
                mPauseButton.setEnabled(false);
                mFinishButton.setEnabled(false);
            }
        });

        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mPauseButton.isEnabled())
                {
                    mFinishButton.setEnabled(true);
                }
                Intent PrevIntent = getIntent();
                String LightValue = PrevIntent.getStringExtra("LUX_VALUE");
                String Subject = PrevIntent.getStringExtra("SUBJECT");
                String Date = PrevIntent.getStringExtra("DATE");

                mChronometer.stop();
                long time =SystemClock.elapsedRealtime() - mChronometer.getBase();

                String Time = getTime(time);

                Intent intent = new Intent(ChronometerActivity.this, FinishedActivity.class);

                intent.putExtra("DATE",Date);
                intent.putExtra("LUX_VALUE",LightValue);
                intent.putExtra("SUBJECT",Subject);
                intent.putExtra("TIME",Time);

                startActivity(intent);

            }
        });

    }

    public String getTime(long time)
    {
        int h = (int) (time / 3600000);
        int m = (int) (time - h * 3600000) / 60000;
        int s = (int) (time - h * 3600000 - m * 60000) / 1000;
        String hh = h < 10 ? "0" + h : h + "";
        String mm = m < 10 ? "0" + m : m + "";
        String ss = s < 10 ? "0" + s : s + "";
        String Time = hh + ":" + mm + ":" + ss;
        return Time;
    }



}
