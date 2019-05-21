# UpdateFile Instructions

JAR file, demo apk are in /resource.    
Note: Regarding JAR file creation and usage, please refer to [the Guideline](https://github.com/picoxr/support/blob/master/How%20to%20Use%20JAR%20file%20in%20Unity%20project%20on%20Pico%20device.docx)

## Introduction
This JAR file is used to send broadcast to Android media lib. After that, user can see the newly created files directly on Pico device or PC. Without this JAR file, user needs to reboot the Pico device to newly created files.

## Class Name
```
com.pico.updatefilestatus.UpdateFileClass
```

## Permission
```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```

## Interface
```
void updateFileStatus(String filePath)
```

## Sample Code
```
string filePath = "/storage/emulated/0/Download/update.txt";
AndroidJavaObject updateFileManager = new AndroidJavaObject("com.pico.updatefilestatus.UpdateFileClass");
AndroidJavaObject ActivityContext = new AndroidJavaClass("com.unity3d.player.UnityPlayer").GetStatic<AndroidJavaObject>("currentActivity");

updateFileManager.Call("updateFileStatus", ActivityContext, filePath);
```


