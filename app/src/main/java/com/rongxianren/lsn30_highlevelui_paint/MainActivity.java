package com.rongxianren.lsn30_highlevelui_paint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rongxianren.lsn30_highlevelui_paint.custom_progressBar.ProgressActivity;
import com.rongxianren.lsn30_highlevelui_paint.paint_primary_use.PaintPrimaryUseActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void paintPrimaryUse(View view) {
        Intent intent = new Intent(this, PaintPrimaryUseActivity.class);
        startActivity(intent);
    }

    public void customProgressBar(View view) {
        Intent intent = new Intent(this, ProgressActivity.class);
        startActivity(intent);
    }
}
