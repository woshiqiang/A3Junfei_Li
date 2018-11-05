package com.example.a3junfei_li;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;

public class BrowsePhotosActivity extends AppCompatActivity {

    private GridView gridView;
    private File[] files;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_photos);
        initView();

        readFiles();
    }

    /**
     * read the photos from SD card
     */
    private void readFiles() {
        File dir = this.getExternalFilesDir(null);
        if (dir == null) {
            Toast.makeText(this, "no photos", Toast.LENGTH_SHORT).show();
            return;
        }
        files = dir.listFiles();

        gridView.setAdapter(new MyPhotoAdapter(this, files));

    }

    private void initView() {
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //delete the photo
                try {
                    boolean delete = files[i].delete();
                    if (delete) {
                        Toast.makeText(BrowsePhotosActivity.this, "delete success！", Toast.LENGTH_SHORT).show();
                        readFiles();
                    } else {
                        Toast.makeText(BrowsePhotosActivity.this, "delete failed！", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(BrowsePhotosActivity.this, "delete failed！", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
    }
}
