# MobileProgramming-TermProject

## INDEX

* Goals
- The goal that the app wanted to realize
- Unimplemented function

* Functional description
- Implemented functional description
- Configured system operation description

* Requirement satisfaction.

* Implementation System Demo
- Brief description of implementation code
- Explanation of execution program

## Goals

* The goal of implementing the app "Food Cal"
  - Provide a kind of calendar that allows you to record the food and contents you ate that day on the calendar date.
    <img width="70%" src="https://user-images.githubusercontent.com/67958557/148350531-1ae9bc27-8d75-4b5d-b486-96166f79f956.jpg"/>
  - It is intended to provide a function of dividing the screen of the calendar into monthly, weekly, and daily screens and storing different contents on each screen.

* The function that was planned to be implemented.
  - **First Activity**
    + Click on the desired date of the calendar to write a memo.
    + Use the button at the top right to turn on/off the BGM.
    + Use the button at the top left to move to the weekly screen (second activity).
      <img width="100%" scr="https://user-images.githubusercontent.com/67958557/148351766-0bb7fe3e-afe3-4f44-be00-dbb38c2d289c.jpg"/>

  - **Second Activity**
    + Save/modify/delete function after inserting notes and icons by clicking the button below the desired day of the calendar.
    + Use the button at the top right to move to the daily screen (third activity).
    + Use the button at the top left to move to the monthly screen (first activity).
      <img width="60%" scr="https://user-images.githubusercontent.com/67958557/148352070-354072ed-b035-457c-9a7e-346c9e1b83f1.jpg"/>

  - **Thrid Activity**
    + Select one of daily memo, sticker selection, and image upload from the lower right menu.
    + Give the authority to use the camera and upload the captured image.
    + Save/Modify/Delete function after writing a daily memo (diary)
      <img width="60%" scr="https://user-images.githubusercontent.com/67958557/148352371-a39b6617-5e2e-4f8f-8290-c9d57cd7f4f0.jpg"/>
    
    + Use the button at the top right to move to the monthly screen (first activity).
    + Use the button at the top left to move to the weekly screen (second activity).
      <img width="60%" scr="https://user-images.githubusercontent.com/67958557/148352629-0fbc6343-f874-4980-a98a-b7b0453bb381.jpg"/>
 
* Unimplemented function
  - **Second Activity**
    + The function of storing a memo in a file has been implemented, but storing the positional state of the inserted icon has not been implemented.
    + Wanted to take calendar information and create a weekly record according to the date, but it stopped at a one-time weekly record due to difficulties.
  - **Thrid Activity**
    + It was planned to implement a function of calling images, text, and icons separately using the menu function, but changed by adding a menu at the end.
    + The third activity also wanted to bring calendar information and create a daily record according to the date, but it was only a one-time record due to difficulties.
   
## Functional description

* Composition screen
  <img width="80%" scr="https://user-images.githubusercontent.com/67958557/148354960-af30c4fb-10db-4529-b70f-5725e215b2d9.jpg"/>

* Description of functions
  - On the first screen, a function that allows users to click on a calendar date to take notes on that date and save, modify, and delete them was implemented.
  - Press the music button at the top right to play the built-in BGM.
  - If you press the button with 7 on the top left, the calendar will go to Activity 2.
  <img width="60%" scr="https://user-images.githubusercontent.com/67958557/148355306-f638beb1-a281-4b5e-9713-8357d0722ac9.jpg"/>
  
  - On the first screen, press the music button at the top right to play the built-in BGM, but use Service to continue listening to the BGM at the end of the app.
  <img width="60%" scr="https://user-images.githubusercontent.com/67958557/148355440-2198a1bc-c9c2-4211-87c8-7ae90a45dc1d.jpg"/>
  
  - On the second screen, a function was created to record, modify, and delete articles of the day by pressing the box below the day of the week.
  - Pressing the grid-patterned diary button at the top left leads to Activity 1.
  - Pressing the button with 1 on the top right leads to Activity 3.
  <img width="60%" scr="https://user-images.githubusercontent.com/67958557/148355661-5beb3d13-f7d8-4af6-bd9f-21245a01bb13.jpg"/>
  
  - Additionally, food-shaped stickers listed on the screen may be moved and decorated through drag.
  <img width="60%" scr="https://user-images.githubusercontent.com/67958557/148355773-bce8761d-d364-42f8-9cec-77c890a5f224.jpg"/>
  
  - On the third screen, the ability to record, modify, and delete daily texts was created.
  - If the camera permission is not accepted when the screen first appears, the app will be shut down.
  - When you press Image View, you can insert or change a picture through camera shooting.
  - Pressing the button on the upper right leads to Activity 1, and pressing the button on the upper left leads to 2.
  <img width="60%" scr="https://user-images.githubusercontent.com/67958557/148355926-2d8757c5-bf41-41e6-9661-9fe5d811d59e.jpg"/>
  
  - Additionally, the menu function was implemented.
  - In the menu, you can select a bright background and a dark background, and when selecting a bright background,
    an existing white background and a dark gray background are selected.
  <img width="60%" scr="https://user-images.githubusercontent.com/67958557/148356266-c5d83823-8808-4aa4-a1d7-68da6715e919.jpg"/>
  
## Requirement Satisfaction

* The requirements presented are as follows.
  - 1. Configure the app with three or more different screens. (Implement an app call using intents, use two or more layouts xml)
  - 2. Take and process the user's input.
  - 3. Create more than three new classes. (Includes Activity Class Extension)
  - 4. Provide a menu function.
  - 5. Use one or more additional multimedia functions in addition to showing images.
  - 6. Use one or more elements other than Activity (Element of Android App: Activity, Service, Broadcast Receiver, Contents Provider)
 
* How it can satified?
  - 1. Organized the app on three different screens, month, week, and day, and implement a call button using intent to return to month from month to week, day to week, and day to month.
  - 2. Implemented memo and image addition functions that receive and process user input.
  - 3. Add three or more activity classes to function.
  - 4. It provides a menu function on the third screen.
  - 5. In addition to the image attachment, it provides a function to turn on/off BGM.
  - 6. In addition to Activity among the elements of the Android app, Service elements are used to allow BGM to run in the background.
  
## Implementation System Demo

* Activity 1
  - The ability to click the calendar date to take notes on that date, save, modify, and delete them.
  
  - BGM on/off function.
  
  - The function of moving on to Activity 2.
  
* Activity 2
  - The function of recording, modifying, and deleting articles of the day by pressing the box below the day of the week.
  
  - The function of moving food-shaped stickers on the screen through drag.
  
  - Ability to move on to activities 1 and 3.
  
* Activity 3

  - Recording, revising, and functioning for a day.
  
  - If you don't accept camera permission, it's over.
  
  - If you press Image View, you can take pictures or change them.
  
  - Choose a bright and dark background mode from the menu.

  - Ability to move on to activities 1 and 2.
  
## Program Execution
  <iframe id="video" width="100%" src="https://user-images.githubusercontent.com/67958557/148353225-d67aa54f-fd06-4b3a-9d97-bf1fd37593dd.mp4" frameborder="0"></iframe>

##Conclusion
  - The development app "Food Cal" was satisfied with the requirements of the term project, but overall,
    it seems to be insufficient as a general launch app.
  - It would be nice to study more about how to represent calendars weekly and daily.
  - It was beneficial to be able to contain the contents practiced within class time in the process of the project.
  - I could think about how the functions of the other apps currently using were implemented.
