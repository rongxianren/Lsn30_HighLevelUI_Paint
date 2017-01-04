package com.rongxianren.lsn30_highlevelui_paint.custom_progressBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rongxianren.lsn30_highlevelui_paint.R;

public class ProgressActivity extends AppCompatActivity {


    CustomProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        progressBar = (CustomProgressBar) findViewById(R.id.progress_bar);
        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        float max = progressBar.getmMax();
                        float progress = progressBar.getProgress();
                        while (progress < max) {
                            progress++;
                            progressBar.setProgress(progress);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

            }
        });
    }
}
