package com.akshat.myflashlightapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch;
    TextView tv_result;
    CameraManager cameraManager;
    String camerid, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    aSwitch = findViewById(R.id.myswitchid);
    tv_result = findViewById(R.id.mytextviewid);

    aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            // flashlight code

            torch(b);
        }
    });
    }

    private void torch(boolean b) {
        
        try {
            cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
            String cameraid = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraid,b);
            result = b?"ON":"OFF";
            tv_result.setText(result);
        } catch (CameraAccessException e) {
            throw new RuntimeException(e);
        }
    }
}