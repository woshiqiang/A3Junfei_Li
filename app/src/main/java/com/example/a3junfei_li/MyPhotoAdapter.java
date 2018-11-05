package com.example.a3junfei_li;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * The adapter of Browse Photos
 *
 * @Date 2018-11-05.
 */
public class MyPhotoAdapter extends BaseAdapter {
    private Context context;
    private File[] files;

    public MyPhotoAdapter(Context context, File[] files) {
        this.context = context;
        this.files = files;
    }

    @Override
    public int getCount() {
        return files.length;
    }

    @Override
    public Object getItem(int i) {
        return files[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.item_gridview, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        FileInputStream f = null;
        try {
            f = new FileInputStream(files[i].getAbsolutePath());
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;//图片的长宽都是原来的1/8
            BufferedInputStream bis = new BufferedInputStream(f);
            Bitmap bm = BitmapFactory.decodeStream(bis, null, options);
            holder.imageView.setImageBitmap(bm);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        return view;
    }

    private static class ViewHolder {
        private ImageView imageView;

        public ViewHolder(View view) {
            this.imageView = view.findViewById(R.id.imageView);
        }

    }
}
