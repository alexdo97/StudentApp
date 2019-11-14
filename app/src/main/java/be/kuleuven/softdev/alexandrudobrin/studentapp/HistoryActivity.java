package be.kuleuven.softdev.alexandrudobrin.studentapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class HistoryActivity extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mListView = (ListView) findViewById(R.id.ListView);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();

        Button ClearAllBtn = (Button) findViewById(R.id.ClearAllBtn);
        ClearAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabaseHelper.deleteAll();
                toastMessage("History cleared");
                populateListView();


            }
        });
        Button BackBtn = (Button) findViewById(R.id.BackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HistoryActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

    private void populateListView()
    {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get data and append to a list
        final Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();

        int counter = 0;
        while(data.moveToNext())
        {
            //get the value from database in column 1
            //then add it to the ArrayList
            counter++;
            listData.add("   Date: " + data.getString(1) +"\n   Activity: " + data.getString(3));
        }
        //create the list adapter and set adapter
        final ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);

        Collections.sort(listData, Collections.reverseOrder());
        mListView.setAdapter(adapter);

        final int finalCounter = counter;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int FinalPosition = finalCounter - position - 1;
                Intent intent = new Intent(HistoryActivity.this, SelectedItemActivity.class);
                data.moveToPosition(FinalPosition);
               // int ix = data.getInt(0);
                intent.putExtra("ID",data.getString(0));
                intent.putExtra("DATE",data.getString(1));
                intent.putExtra("LUX_VALUE",data.getString(2));
                intent.putExtra("SUBJECT",data.getString(3));
                intent.putExtra("TIME",data.getString(4));

                startActivity(intent);

            }
        });

    }

    private void toastMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


}
