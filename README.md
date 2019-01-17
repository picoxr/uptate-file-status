# UpdateFile Instructions

Note: Regarding java package creation and usage, please refer to [the Guideline](https://github.com/picoxr/support/blob/master/How_to_use_JAR_file_in_Unity_project_on_Pico_device.docx)

## Introduction

This JAR file is used to send broadcast to Android media lib. After that, user can see the newly created files directly on Pico device or PC. Without this JAR file, user needs to reboot the Pico device to newly created files.

## Class Name

```
com.picovr.updatefilestatus.MainActivity
```

## Interfaces

```
void updateFileStatus(String fullFileName)
```
