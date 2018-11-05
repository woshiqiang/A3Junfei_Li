package com.example.a3junfei_li;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;

/**
 * take photo
 *
 * @Date 2018-11-05.
 */
public class TakePhotoActivity extends AppCompatActivity {
    CameraPreview cameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);
        cameraView = (CameraPreview) findViewById(R.id.cameraView);

        SensorManagerHelper sensorHelper = new SensorManagerHelper(this);
        sensorHelper.setOnShakeListener(new SensorManagerHelper.OnShakeListener() {

            @Override
            public void onShake() {
                System.out.println("shake");
                Log.d("TakePhotoActivity", "shake........");
                File file = new File(getExternalFilesDir(null), "pic_" + System.currentTimeMillis() + ".jpg");
                cameraView.setOutPutDir(file);
                cameraView.takePicture();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.onResume(this);
    }

    @Override
    protected void onPause() {
        cameraView.onPause();
        super.onPause();
    }

    public void takePic(View view) {
        File file = new File(getExternalFilesDir(null), "pic_" + System.currentTimeMillis() + ".jpg");
        cameraView.setOutPutDir(file);
        cameraView.takePicture();
    }
}
