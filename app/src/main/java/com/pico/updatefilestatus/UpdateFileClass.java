package com.pico.updatefilestatus;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class UpdateFileClass {
    private static final String TAG = "UpdateFileClass";

    /**
    * Create a new file for testing the updateFileStatus method
    * @param fileName The name of file to create(eg. "/storage/emulated/0/Download/update.txt").*/
    public void createFile(String fileName) {
        Log.e(TAG, "createFile: " );
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    Log.e(TAG, "createFile: " + "success");
                }
            } catch (IOException e) {
                Log.e(TAG, "createFile: failed. "  + "Error message: "+ e.getMessage());
            }
        }
    }

    /**
     * @param context Context
     * @param fileName The name of file to update(eg. "/storage/emulated/0/Download/update.txt").*/
    public void updateFileStatus(Context context, String fileName) {
        Log.e(TAG, "updateFileStatus: ");
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(new File(fileName)));
        context.sendBroadcast(intent);
    }
}
