package be.kuleuven.softdev.alexandrudobrin.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SelectedItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_item);

        final DatabaseHelper mDataBaseHelper = new DatabaseHelper(this);

        Intent PrevIntent = getIntent();
        final int Id = Integer.parseInt(PrevIntent.getStringExtra("ID"));
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

        Button DeleteBtn = (Button) findViewById(R.id.DeleteBtn);
        DeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDataBaseHelper.deleteItem(Id, Date, LightValue, Subject, Time);
                toastMessage("Activity Deleted");
                Intent intent = new Intent(SelectedItemActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });


    }
    private void toastMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
