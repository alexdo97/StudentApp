package be.kuleuven.softdev.alexandrudobrin.studentapp;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class LightSensorActivity extends AppCompatActivity implements SensorEventListener {

    TextView textView;

    SensorManager sensorManager;
    Sensor sensor;
    public String text1;
    private ImageSwitcher imageSwitcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);


        imageSwitcher = (ImageSwitcher) findViewById(R.id.ImageSwitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });

        textView = (TextView) findViewById(R.id.textView);

        sensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);


    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onSensorChanged(final SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_LIGHT)
        {
            if(event.values[0] >= 0 && event.values[0] <= 100) imageSwitcher.setImageResource(R.drawable.sad);
            else if(event.values[0] >= 100 && event.values[0] <= 250 || event.values[0] >= 500) imageSwitcher.setImageResource(R.drawable.neutral);
            else if(event.values[0] >= 250 && event.values[0] <= 500) imageSwitcher.setImageResource(R.drawable.happy);

            textView.setText("" + (int)event.values[0] + "\nLux");

            Button ContinueBtn = (Button) findViewById(R.id.ContinueBtn);
            ContinueBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LightSensorActivity.this, MainChronometerActivity.class);
                    int value = (int)event.values[0];
                    String StringValue = Integer.toString(value);
                    intent.putExtra("LUX_VALUE",StringValue);
                    startActivity(intent);
                }
            });
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
