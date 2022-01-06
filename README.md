# MobileProgramming-TermProject

This project is a small mobile app development project created by taking classes based on Kotlin in 2020.
Please understand that there are many shortcomings.

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
  
    ![1](https://user-images.githubusercontent.com/67958557/148358735-a3c0d096-3f75-4c8c-a5c4-55a1179352b0.jpg)
    
  - It is intended to provide a function of dividing the screen of the calendar into monthly, weekly, and daily screens and storing different contents on each screen.

* The function that was planned to be implemented.
  - **First Activity**
    + Click on the desired date of the calendar to write a memo.
    + Use the button at the top right to turn on/off the BGM.
    + Use the button at the top left to move to the weekly screen (second activity).
    
    ![2](https://user-images.githubusercontent.com/67958557/148358737-89ae0fda-4eed-4b07-8ace-52eb4da21786.jpg)

  - **Second Activity**
    + Save/modify/delete function after inserting notes and icons by clicking the button below the desired day of the calendar.
    + Use the button at the top right to move to the daily screen (third activity).
    + Use the button at the top left to move to the monthly screen (first activity).
    
     ![3](https://user-images.githubusercontent.com/67958557/148358740-5b91e436-f321-4547-af52-7fa920247c5f.jpg)

  - **Thrid Activity**
    + Select one of daily memo, sticker selection, and image upload from the lower right menu.
    + Give the authority to use the camera and upload the captured image.
    + Save/Modify/Delete function after writing a daily memo (diary)
    
     ![4](https://user-images.githubusercontent.com/67958557/148358741-e5661f23-3959-4973-bf25-2363e6e04374.jpg)
    
    + Use the button at the top right to move to the monthly screen (first activity).
    + Use the button at the top left to move to the weekly screen (second activity).
    
     ![5](https://user-images.githubusercontent.com/67958557/148358694-38c8ebbc-908d-4ece-ab48-5a5637eeb270.jpg)
 
* Unimplemented function
  - **Second Activity**
    + The function of storing a memo in a file has been implemented, but storing the positional state of the inserted icon has not been implemented.
    + Wanted to take calendar information and create a weekly record according to the date, but it stopped at a one-time weekly record due to difficulties.
  - **Thrid Activity**
    + It was planned to implement a function of calling images, text, and icons separately using the menu function, but changed by adding a menu at the end.
    + The third activity also wanted to bring calendar information and create a daily record according to the date, but it was only a one-time record due to difficulties.
   
## Functional description

* Composition screen

  ![8](https://user-images.githubusercontent.com/67958557/148358713-d14f0f8b-dc1d-408d-80b3-369503f90ef7.jpg)
  
* Description of functions

  - **First Screen**

    ![9](https://user-images.githubusercontent.com/67958557/148358717-e6a04e2c-e87b-47f5-9a4f-0c514fd56c39.jpg)
    + On the first screen, a function that allows users to click on a calendar date to take notes on that date and save, modify, and delete them was implemented.
    + Press the music button at the top right to play the built-in BGM.
    + If you press the button with 7 on the top left, the calendar will go to Activity 2.
    + Press the music button at the top right to play the built-in BGM, but use Service to continue listening to the BGM at the end of the app.
  
  
  - **Second Screen**
    
    ![11](https://user-images.githubusercontent.com/67958557/148358724-cc7ca769-d1b0-4109-a9e5-187ca09b602e.jpg)
    + On the second screen, a function was created to record, modify, and delete articles of the day by pressing the box below the day of the week.
    + Pressing the grid-patterned diary button at the top left leads to Activity 1.
    + Pressing the button with 1 on the top right leads to Activity 3.
    + Additionally, food-shaped stickers listed on the screen may be moved and decorated through drag.
  
  - **Third Screen**

    ![13](https://user-images.githubusercontent.com/67958557/148358729-4822e9a1-6ae6-48a3-80b7-eb9ea32304d5.jpg) ![14](https://user-images.githubusercontent.com/67958557/148358731-20fd4315-648d-40a2-b756-3010fcf288a1.jpg)
    + On the third screen, the ability to record, modify, and delete daily texts was created.
    + If the camera permission is not accepted when the screen first appears, the app will be shut down.
    + When you press Image View, you can insert or change a picture through camera shooting.
    + Pressing the button on the upper right leads to Activity 1, and pressing the button on the upper left leads to 2.
    + Additionally, the menu function was implemented.
    + In the menu, you can select a bright background and a dark background, and when selecting a bright background, an existing white background and a dark gray background are selected.
  
## Requirement Satisfaction

* The requirements presented are as follows.
  - 1. Configure the app with three or more different screens. (Implement an app call using intents, use two or more layouts xml)
  - 2. Take and process the user's input.
  - 3. Create more than three new classes. (Includes Activity Class Extension)
  - 4. Provide a menu function.
  - 5. Use one or more additional multimedia functions in addition to showing images.
  - 6. Use one or more elements other than Activity (Element of Android App: Activity, Service, Broadcast Receiver, Contents Provider)
 
* How Can I satified?
  - 1. Organized the app on three different screens, month, week, and day, and implement a call button using intent to return to month from month to week, day to week, and day to month.
  - 2. Implemented memo and image addition functions that receive and process user input.
  - 3. Add three or more activity classes to function.
  - 4. It provides a menu function on the third screen.
  - 5. In addition to the image attachment, it provides a function to turn on/off BGM.
  - 6. In addition to Activity among the elements of the Android app, Service elements are used to allow BGM to run in the background.
  
## Implementation System Demo

* Activity 1
  - The ability to click the calendar date to take notes on that date, save, modify, and delete them.
  ```
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
    
            diaryTextView.visibility = View.VISIBLE 
            save_Btn.visibility = View.VISIBLE 
            contextEditText.visibility = View.VISIBLE 
            
            textView2.visibility = View.INVISIBLE 
            cha_Btn.visibility = View.INVISIBLE
            del_Btn.visibility = View.INVISIBLE

            diaryTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
            contextEditText.setText("") 

            checkedDay(year, month, dayOfMonth)
        }
    
        save_Btn.setOnClickListener {
            saveDiary(fname)
            Toast.makeText(this.getApplicationContext(), fname + "데이터를 저장했습니다.", Toast.LENGTH_SHORT)
                .show()
            str = contextEditText.getText().toString()
            textView2.text = "${str}"
            save_Btn.visibility = View.INVISIBLE
            cha_Btn.visibility = View.VISIBLE
            del_Btn.visibility = View.VISIBLE
            contextEditText.visibility = View.INVISIBLE
            textView2.visibility = View.VISIBLE
        }
        
  ```
  
  - BGM on/off function.
```
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent=Intent(this,MusicService::class.java)
```

```
        play_Btn.setOnClickListener{
            if(play_Btn.isChecked == true){
                play_Btn.setBackgroundResource(R.drawable.music)
                startService(intent)
            } else{
                play_Btn.setBackgroundResource(R.drawable.pause)
                stopService(intent)
            }
        }
```
  
  - The function of moving on to Activity 2.
```
        var btnNewActivity = findViewById<ImageButton>(R.id.btnNewActivity)
        btnNewActivity.setOnClickListener{
            var intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(intent)
        }
```
  
* Activity 2
  - The function of recording, modifying, and deleting articles of the day by pressing the box below the day of the week.
```
        var btnSun=findViewById<Button>(R.id.btnSun)
        btnSun.setOnClickListener{
            save_Btn2.visibility = View.VISIBLE 
            contextEditText2.visibility = View.VISIBLE 
            textView4.visibility = View.INVISIBLE 
            cha_Btn2.visibility = View.INVISIBLE 
            del_Btn2.visibility = View.INVISIBLE 
            yoil_view.text = String.format("sunday") 
            contextEditText2.setText("") 
            checkedSunDay() 
        }
```
  
  - The function of moving food-shaped stickers on the screen through drag.
```
        var food1=findViewById<ImageView>(R.id.imageView)
        food1.setOnTouchListener{ v,e ->
            val pWidth=(v.parent as ViewGroup).width
            val pHeight=(v.parent as ViewGroup).height

            if (e.action == MotionEvent.ACTION_MOVE) {
                v.x = v.x + e.x - v.width / 2
                v.y = v.y + e.y - v.height / 2
            } else if (e.action == MotionEvent.ACTION_UP) {
                Log.d("bsjbsj", "detached...")
                Log.d("bsjbsj", "v.x : ${v.x} + v.y : ${v.y} , " +
                        "v.x + v.width : ${v.x + v.width}, v.y + y.width : ${v.y + v.width}")
                if (v.x < 0) {
                    v.x = 0F
                } else if (v.x + v.width > pWidth) {
                    v.x = (pWidth - v.width).toFloat()
                }
                if (v.y < 0) {
                    v.y = 0F
                } else if (v.y + v.height > pHeight) {
                    v.y = (pHeight - v.height).toFloat()
                }
            }
            true
        }
```        

  - Ability to move on to activities 1 and 3.
```
        var btnFirst = findViewById<ImageButton>(R.id.btnFirst)
        btnFirst.setOnClickListener{
            var intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        var btnThird = findViewById<ImageButton>(R.id.btnThird)
        btnThird.setOnClickListener{
            var intent = Intent(applicationContext, ThirdActivity::class.java)
            startActivity(intent)
        }
```

* Activity 3

  - Recording, revising, and functioning for a day.
```
        checkedDaily()

        save_Btn3.setOnClickListener {
            saveDay(fname)
            Toast.makeText(this.getApplicationContext(), fname + "데이터를 저장했습니다.", Toast.LENGTH_SHORT)
                .show()
            str = contextEditText3.getText().toString()
            textView5.text = "${str}" // textView에 str 출력
            save_Btn3.visibility = View.INVISIBLE
            cha_Btn3.visibility = View.VISIBLE
            del_Btn3.visibility = View.VISIBLE
            contextEditText3.visibility = View.INVISIBLE
            textView5.visibility = View.VISIBLE
        }
```

  - If you don't accept camera permission, it's over.
```
        fun settingPermission(){
        var permis = object : PermissionListener {
            override fun onPermissionGranted() {
                Toast.makeText(this@ThirdActivity, "권한 허가", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(this@ThirdActivity, "권한 거부", Toast.LENGTH_SHORT)
                    .show()
                ActivityCompat.finishAffinity(this@ThirdActivity)
            }
        }
```

  - If you press Image View, you can take pictures or change them.
```
        settingPermission()

        var imageView = findViewById<ImageView>(R.id.img_picture)

        imageView.setOnClickListener() {
            startCapture()
        }
```

```
    fun startCapture(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE) .also{takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also{
                val photoFile: File?=try {
                    createImageFile()
                } catch(ex: IOException){
                    null
                }
                photoFile?.also{
                    val photoURI: Uri =FileProvider.getUriForFile(
                        this,
                        "com.wypark.term.fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI)
                    startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE)

                }
            }
        }
    }
```    
  
  - Choose a bright and dark background mode from the menu.
```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/afternoon"
        android:title="밝은 배경" />
    <item
        android:id="@+id/evening"
        android:title="어두운 배경" />

</menu>
```

```
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        var mInflater = this.menuInflater

        if(v==select){
            menu!!.setHeaderTitle("화면 모드")
            mInflater.inflate(R.menu.option_menu, menu)
        }
    }
```

```
    override fun onContextItemSelected(item: MenuItem): Boolean {
        super.onContextItemSelected(item)

        when(item.itemId){
            R.id.afternoon -> {
                baseLayout.setBackgroundColor(Color.WHITE)
                topbar.setBackgroundColor(Color.TRANSPARENT)
                return true
            }
            R.id.evening -> {
                baseLayout.setBackgroundColor(Color.DKGRAY)
                topbar.setBackgroundColor(Color.GRAY)
                return true
            }
        }
        return false
    }
```

  - Ability to move on to activities 1 and 2.
```
        var btnWeek = findViewById<ImageButton>(R.id.btnWeek)
        btnWeek.setOnClickListener{
            var intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(intent)
        }
        var btnReturn = findViewById<ImageButton>(R.id.btnReturn)
        btnReturn.setOnClickListener{
            var intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
```

## Program Execution
  
https://user-images.githubusercontent.com/67958557/148358733-3ea054d2-a8b9-4183-92a3-13aab9ec09b1.mp4

## Conclusion
  - The development app "Food Cal" was satisfied with the requirements of the term project, but overall,
    it seems to be insufficient as a general launch app.
  - It would be nice to study more about how to represent calendars weekly and daily.
  - It was beneficial to be able to contain the contents practiced within class time in the process of the project.
  - I could think about how the functions of the other apps currently using were implemented.
