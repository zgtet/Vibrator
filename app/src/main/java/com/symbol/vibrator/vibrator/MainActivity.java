package com.symbol.vibrator.vibrator;

import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btnVibrate);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                vibrate();
            }
        });
    }

    public void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            long[] wave_time = {0, 100, 0, 100, 0, 100, 0, 100, 0, 100};
            int[] wave_ampl = {0, 50, 0, 100, 0, 150, 0, 200, 0, 255};

            VibrationEffect vibrationEffect = null;
            vibrationEffect = VibrationEffect.createWaveform(wave_time, wave_ampl, -1);
            vibrator.vibrate(vibrationEffect);
        }
        else
        {
            //deprecated in API 26
            vibrator.vibrate(500);
        }

    }
}
