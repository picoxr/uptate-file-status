package com.pico.uptatefilestatus;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.unity3d.player.UnityPlayerNativeActivityPico;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String TAG = "----main---";

    Button btCreate;
    Button btUpdate;

    String fullFileName;

    public static Activity unityActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unityActivity = this;

        btCreate = findViewById(R.id.bt_create);
        btUpdate = findViewById(R.id.bt_update);

        fullFileName = Environment.getExternalStoragePublicDirectory(DOWNLOAD_SERVICE)+ File.separator + "update.txt";

        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: " + fullFileName);
                createFile(fullFileName);
            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateFileStatus(fullFileName);
            }
        });

    }

    public void createFile(String fullFileName) {
        File file = new File(fullFileName);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    Log.e(TAG, "createFile: " + "success");
                }
            } catch (IOException e) {
                Log.e(TAG, "createFile: " + e.getMessage());
            }
        }
    }

    public void updateFileStatus(String fullFileName) {
        Log.e(TAG, "updateFile: ");
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(new File(fullFileName)));
        sendBroadcast(intent);
    }
}
