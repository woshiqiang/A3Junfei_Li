package com.example.a3junfei_li;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_take_a_photo;
    private Button button_browse_photos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        button_take_a_photo = (Button) findViewById(R.id.button_take_a_photo);
        button_browse_photos = (Button) findViewById(R.id.button_browse_photos);

        button_take_a_photo.setOnClickListener(this);
        button_browse_photos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_take_a_photo:
                //start the TakePhotoActivity
                startActivity(new Intent(MainActivity.this,TakePhotoActivity.class));
                break;
            case R.id.button_browse_photos:
                //start the BrowsePhotosActivity
                startActivity(new Intent(MainActivity.this,BrowsePhotosActivity.class));
                break;
        }
    }
}
