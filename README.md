# Fetch Android Exercise

## Description
This app retrieves data from the following url https://fetch-hiring.s3.amazonaws.com/hiring.json and displays the data in a easy to read list with the following changes:
* All items grouped by "listId"
* Sorted first by "listId" then by "name"
* Filtered out any items where "name" is blank or null

**⚠️ Important:**
  * The directions indicate to sort by "name", which is a String, the result displays items sorted by the first digit of the name's ID number as shown in the image below.
  * ![](https://github.com/tanveerm176/fetch-android-exercise/blob/main/sort-by-String.png) 
  * The sort was updated to sort the items numerically, as shown in the demo GIF. Depending on how the data is structured and internally used, either case may be correct. I chose to implement the latter based on the assumption that the iterms would be sorted by the name's entire ID number.


## Requirements
The following is required to run the app:
* Android Studio Hedgehog | 2023.1.1
* Android Device or Emulator with API Version 34 or min API Version 24
* Java Version 1.8

## Demo
![](https://github.com/tanveerm176/fetch-android-exercise/blob/main/FetchAndroidExercise-Demo.gif)
