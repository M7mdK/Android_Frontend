# Android_Frontend
This repository contains the Android Frontend part of our project.

In this part of the project many extra features could be added. But due to the time limit only few simple features were added such as:

1- Button added in home page takes us to the list of windows page (We can also still reach the same page from the toolbar using "Building windows" item)

2- Fixed/Added back buttons as:

        <activity android:name=".WindowsActivity" android:parentActivityName=".MainActivity" />

        <activity android:name=".WindowActivity" android:parentActivityName=".WindowsActivity" />

3- Sometimes used different features that could make things simpler, for instance: Used Linear Layout (Virtical) in Activity_window where which contains all the 10 textViews (5 titles , 5 values)
