package be.kuleuven.softdev.alexandrudobrin.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainChronometerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chronometer);

         final EditText SubjectText = (EditText) findViewById(R.id.SubjectText);
        Button ContinueBtn = (Button) findViewById(R.id.ContinueBtn);
        ContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent PrevIntent = getIntent();
                String LightValue = PrevIntent.getStringExtra("LUX_VALUE");

                Intent intent = new Intent(MainChronometerActivity.this, ChronometerActivity.class);

                Calendar c = Calendar.getInstance();
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

                String subject = SubjectText.getText().toString();
                intent.putExtra("DATE",date);
                intent.putExtra("LUX_VALUE",LightValue);
                intent.putExtra("SUBJECT",subject);




                startActivity(intent);
            }
        });




            }


}
