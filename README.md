# UpdateFile Instructions

- If you have any questions/comments, please visit [**Pico Developer Answers**](https://devanswers.pico-interactive.com/) and raise your question there.

JAR file, demo apk are in /resource.    
Note: Regarding JAR file creation and usage, please refer to [the Guideline](http://static.appstore.picovr.com/docs/JarUnity/index.html)

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


