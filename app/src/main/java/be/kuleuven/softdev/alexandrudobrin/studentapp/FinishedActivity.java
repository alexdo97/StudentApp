package be.kuleuven.softdev.alexandrudobrin.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FinishedActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);

        myDb = new DatabaseHelper(this);

        Intent PrevIntent = getIntent();
        final String Date = PrevIntent.getStringExtra("DATE");
        final String LightValue = PrevIntent.getStringExtra("LUX_VALUE");
        final String Subject = PrevIntent.getStringExtra("SUBJECT");
        final String Time = PrevIntent.getStringExtra("TIME");

        TextView TextViewDate = (TextView) findViewById(R.id.TextViewDate);
        TextView TextViewLightValue = (TextView) findViewById(R.id.TextViewLightValue);
        TextView TextViewSubject = (TextView) findViewById(R.id.TextViewSubject);
        TextView TextViewTime = (TextView) findViewById(R.id.TextViewTime);

        TextViewDate.setText(Date);
        TextViewLightValue.setText(LightValue);
        TextViewSubject.setText(Subject);
        TextViewTime.setText(Time);

        Button FinishBtn = (Button) findViewById(R.id.FinishBtn);
        FinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddData(Date,LightValue,Subject,Time);

                Intent intent = new Intent(FinishedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void AddData(String Date, String LightValue, String Subject, String Time)
    {
        boolean isInserted = myDb.addData(Date,LightValue,Subject,Time);

        if(isInserted == true)
        {
            Toast.makeText(FinishedActivity.this,"Activity Finished",Toast.LENGTH_LONG).show();

        }
        else
            Toast.makeText(FinishedActivity.this,"Saving Data Failed",Toast.LENGTH_LONG).show();


    }

    private void toastMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
