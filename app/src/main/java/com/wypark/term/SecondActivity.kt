package com.wypark.term


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_layout.*
import java.io.FileInputStream
import java.io.FileOutputStream

class SecondActivity : AppCompatActivity() {

    var fname: String = ""
    var str: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
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

        var btnSun=findViewById<Button>(R.id.btnSun)
        btnSun.setOnClickListener{
            save_Btn2.visibility = View.VISIBLE // 저장 버튼이 Visible
            contextEditText2.visibility = View.VISIBLE // EditText가 Visible
            textView4.visibility = View.INVISIBLE // 저장된 메모 textView가 Invisible
            cha_Btn2.visibility = View.INVISIBLE // 수정 Button이 Invisible
            del_Btn2.visibility = View.INVISIBLE // 삭제 Button이 Invisible
            yoil_view.text = String.format("sunday") // 날짜를 보여주는 텍스트에 해당 날짜를 넣는다.
            contextEditText2.setText("") // EditText에 공백값 넣기
            checkedSunDay() // checkedDay 메소드 호출
        }

        var btnMon=findViewById<Button>(R.id.btnMon)
        btnMon.setOnClickListener{
            save_Btn2.visibility = View.VISIBLE // 저장 버튼이 Visible
            contextEditText2.visibility = View.VISIBLE // EditText가 Visible
            textView4.visibility = View.INVISIBLE // 저장된 메모 textView가 Invisible
            cha_Btn2.visibility = View.INVISIBLE // 수정 Button이 Invisible
            del_Btn2.visibility = View.INVISIBLE // 삭제 Button이 Invisible
            yoil_view.text = String.format("monday") // 날짜를 보여주는 텍스트에 해당 날짜를 넣는다.
            contextEditText2.setText("") // EditText에 공백값 넣기
            checkedMonDay() // checkedDay 메소드 호출
        }

        var btnTue=findViewById<Button>(R.id.btnTue)
        btnTue.setOnClickListener{
            save_Btn2.visibility = View.VISIBLE // 저장 버튼이 Visible
            contextEditText2.visibility = View.VISIBLE // EditText가 Visible
            textView4.visibility = View.INVISIBLE // 저장된 메모 textView가 Invisible
            cha_Btn2.visibility = View.INVISIBLE // 수정 Button이 Invisible
            del_Btn2.visibility = View.INVISIBLE // 삭제 Button이 Invisible
            yoil_view.text = String.format("tuesday") // 날짜를 보여주는 텍스트에 해당 날짜를 넣는다.
            contextEditText2.setText("") // EditText에 공백값 넣기
            checkedTueDay() // checkedDay 메소드 호출
        }

        var btnWed=findViewById<Button>(R.id.btnWed)
        btnWed.setOnClickListener{
            save_Btn2.visibility = View.VISIBLE // 저장 버튼이 Visible
            contextEditText2.visibility = View.VISIBLE // EditText가 Visible
            textView4.visibility = View.INVISIBLE // 저장된 메모 textView가 Invisible
            cha_Btn2.visibility = View.INVISIBLE // 수정 Button이 Invisible
            del_Btn2.visibility = View.INVISIBLE // 삭제 Button이 Invisible
            yoil_view.text = String.format("wednesday") // 날짜를 보여주는 텍스트에 해당 날짜를 넣는다.
            contextEditText2.setText("") // EditText에 공백값 넣기
            checkedWedDay() // checkedDay 메소드 호출
        }

        var btnThu=findViewById<Button>(R.id.btnThu)
        btnThu.setOnClickListener{
            save_Btn2.visibility = View.VISIBLE // 저장 버튼이 Visible
            contextEditText2.visibility = View.VISIBLE // EditText가 Visible
            textView4.visibility = View.INVISIBLE // 저장된 메모 textView가 Invisible
            cha_Btn2.visibility = View.INVISIBLE // 수정 Button이 Invisible
            del_Btn2.visibility = View.INVISIBLE // 삭제 Button이 Invisible
            yoil_view.text = String.format("thursday") // 날짜를 보여주는 텍스트에 해당 날짜를 넣는다.
            contextEditText2.setText("") // EditText에 공백값 넣기
            checkedThuDay() // checkedDay 메소드 호출
        }

        var btnFri=findViewById<Button>(R.id.btnFri)
        btnFri.setOnClickListener{
            save_Btn2.visibility = View.VISIBLE // 저장 버튼이 Visible
            contextEditText2.visibility = View.VISIBLE // EditText가 Visible
            textView4.visibility = View.INVISIBLE // 저장된 메모 textView가 Invisible
            cha_Btn2.visibility = View.INVISIBLE // 수정 Button이 Invisible
            del_Btn2.visibility = View.INVISIBLE // 삭제 Button이 Invisible
            yoil_view.text = String.format("friday") // 날짜를 보여주는 텍스트에 해당 날짜를 넣는다.
            contextEditText2.setText("") // EditText에 공백값 넣기
            checkedFriDay() // checkedDay 메소드 호출
        }

        var btnSat=findViewById<Button>(R.id.btnSat)
        btnSat.setOnClickListener{
            save_Btn2.visibility = View.VISIBLE // 저장 버튼이 Visible
            contextEditText2.visibility = View.VISIBLE // EditText가 Visible
            textView4.visibility = View.INVISIBLE // 저장된 메모 textView가 Invisible
            cha_Btn2.visibility = View.INVISIBLE // 수정 Button이 Invisible
            del_Btn2.visibility = View.INVISIBLE // 삭제 Button이 Invisible
            yoil_view.text = String.format("saturday") // 날짜를 보여주는 텍스트에 해당 날짜를 넣는다.
            contextEditText2.setText("") // EditText에 공백값 넣기
            checkedSatDay() // checkedDay 메소드 호출
        }

        save_Btn2.setOnClickListener { // 저장 Button이 클릭되면
            saveWeek(fname) // saveDiary 메소드 호출
            Toast.makeText(this.getApplicationContext(), fname + "데이터를 저장했습니다.", Toast.LENGTH_SHORT)
                .show() // 토스트 메세지
            str = contextEditText2.getText().toString() // str 변수에 edittext내용을 toString 형으로 저장
            textView4.text = "${str}" // textView에 str 출력
            save_Btn2.visibility = View.INVISIBLE
            cha_Btn2.visibility = View.VISIBLE
            del_Btn2.visibility = View.VISIBLE
            contextEditText2.visibility = View.INVISIBLE
            textView4.visibility = View.VISIBLE
        }

        //음식 아이콘 drag&drop
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

        var food2=findViewById<ImageView>(R.id.imageView2)
        food2.setOnTouchListener{ v,e ->
            val pWidth=(v.parent as ViewGroup).width
            val pHeight=(v.parent as ViewGroup).height

            if (e.action == MotionEvent.ACTION_MOVE) {
                v.x = v.x + e.x - v.width / 2
                v.y = v.y + e.y - v.height / 2
            } else if (e.action == MotionEvent.ACTION_UP) {
                Log.d("bsjbsj", "detached...")
                Log.d("bsjbsj", "v.x : ${v.x} + v.y : ${v.y} , v.x + v.width : ${v.x + v.width}, v.y + y.width : ${v.y + v.width}")
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

        var food3=findViewById<ImageView>(R.id.imageView3)
        food3.setOnTouchListener{ v,e ->
            val pWidth=(v.parent as ViewGroup).width
            val pHeight=(v.parent as ViewGroup).height

            if (e.action == MotionEvent.ACTION_MOVE) {
                v.x = v.x + e.x - v.width / 2
                v.y = v.y + e.y - v.height / 2
            } else if (e.action == MotionEvent.ACTION_UP) {
                Log.d("bsjbsj", "detached...")
                Log.d("bsjbsj", "v.x : ${v.x} + v.y : ${v.y} , v.x + v.width : ${v.x + v.width}, v.y + y.width : ${v.y + v.width}")
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

        var food4=findViewById<ImageView>(R.id.imageView4)
        food4.setOnTouchListener{ v,e ->
            val pWidth=(v.parent as ViewGroup).width
            val pHeight=(v.parent as ViewGroup).height

            if (e.action == MotionEvent.ACTION_MOVE) {
                v.x = v.x + e.x - v.width / 2
                v.y = v.y + e.y - v.height / 2
            } else if (e.action == MotionEvent.ACTION_UP) {
                Log.d("bsjbsj", "detached...")
                Log.d("bsjbsj", "v.x : ${v.x} + v.y : ${v.y} , v.x + v.width : ${v.x + v.width}, v.y + y.width : ${v.y + v.width}")
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

        var food5=findViewById<ImageView>(R.id.imageView5)
        food5.setOnTouchListener{ v,e ->
            val pWidth=(v.parent as ViewGroup).width
            val pHeight=(v.parent as ViewGroup).height

            if (e.action == MotionEvent.ACTION_MOVE) {
                v.x = v.x + e.x - v.width / 2
                v.y = v.y + e.y - v.height / 2
            } else if (e.action == MotionEvent.ACTION_UP) {
                Log.d("bsjbsj", "detached...")
                Log.d("bsjbsj", "v.x : ${v.x} + v.y : ${v.y} , v.x + v.width : ${v.x + v.width}, v.y + y.width : ${v.y + v.width}")
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

        var food6=findViewById<ImageView>(R.id.imageView6)
        food6.setOnTouchListener{ v,e ->
            val pWidth=(v.parent as ViewGroup).width
            val pHeight=(v.parent as ViewGroup).height

            if (e.action == MotionEvent.ACTION_MOVE) {
                v.x = v.x + e.x - v.width / 2
                v.y = v.y + e.y - v.height / 2
            } else if (e.action == MotionEvent.ACTION_UP) {
                Log.d("bsjbsj", "detached...")
                Log.d("bsjbsj", "v.x : ${v.x} + v.y : ${v.y} , v.x + v.width : ${v.x + v.width}, v.y + y.width : ${v.y + v.width}")
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

        var food7=findViewById<ImageView>(R.id.imageView7)
        food7.setOnTouchListener{ v,e ->
            val pWidth=(v.parent as ViewGroup).width
            val pHeight=(v.parent as ViewGroup).height

            if (e.action == MotionEvent.ACTION_MOVE) {
                v.x = v.x + e.x - v.width / 2
                v.y = v.y + e.y - v.height / 2
            } else if (e.action == MotionEvent.ACTION_UP) {
                Log.d("bsjbsj", "detached...")
                Log.d("bsjbsj", "v.x : ${v.x} + v.y : ${v.y} , v.x + v.width : ${v.x + v.width}, v.y + y.width : ${v.y + v.width}")
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

        var food8=findViewById<ImageView>(R.id.imageView8)
        food8.setOnTouchListener{ v,e ->
            val pWidth=(v.parent as ViewGroup).width
            val pHeight=(v.parent as ViewGroup).height

            if (e.action == MotionEvent.ACTION_MOVE) {
                v.x = v.x + e.x - v.width / 2
                v.y = v.y + e.y - v.height / 2
            } else if (e.action == MotionEvent.ACTION_UP) {
                Log.d("bsjbsj", "detached...")
                Log.d("bsjbsj", "v.x : ${v.x} + v.y : ${v.y} , v.x + v.width : ${v.x + v.width}, v.y + y.width : ${v.y + v.width}")
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

        var food9=findViewById<ImageView>(R.id.imageView9)
        food9.setOnTouchListener{ v,e ->
            val pWidth=(v.parent as ViewGroup).width
            val pHeight=(v.parent as ViewGroup).height

            if (e.action == MotionEvent.ACTION_MOVE) {
                v.x = v.x + e.x - v.width / 2
                v.y = v.y + e.y - v.height / 2
            } else if (e.action == MotionEvent.ACTION_UP) {
                Log.d("bsjbsj", "detached...")
                Log.d("bsjbsj", "v.x : ${v.x} + v.y : ${v.y} , v.x + v.width : ${v.x + v.width}, v.y + y.width : ${v.y + v.width}")
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

        var food10=findViewById<ImageView>(R.id.imageView10)
        food10.setOnTouchListener{ v,e ->
            val pWidth=(v.parent as ViewGroup).width
            val pHeight=(v.parent as ViewGroup).height

            if (e.action == MotionEvent.ACTION_MOVE) {
                v.x = v.x + e.x - v.width / 2
                v.y = v.y + e.y - v.height / 2
            } else if (e.action == MotionEvent.ACTION_UP) {
                Log.d("bsjbsj", "detached...")
                Log.d("bsjbsj", "v.x : ${v.x} + v.y : ${v.y} , v.x + v.width : ${v.x + v.width}, v.y + y.width : ${v.y + v.width}")
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

    }


    fun checkedSunDay() {
        fname =
            "SundayMemo" // 저장할 파일 이름 설정.
        var fis: FileInputStream? = null // FileStream fis 변수 설정

        try {
            fis = openFileInput(fname) // fname 파일 열기

            val fileData = ByteArray(fis.available()) // fileData에 파이트 형식으로 저장
            fis.read(fileData) // fileData를 읽음
            fis.close()

            str = String(fileData) // str 변수에 fileData를 저장

            contextEditText2.visibility = View.INVISIBLE
            textView4.visibility = View.VISIBLE
            textView4.text = "${str}" // textView에 str 출력

            save_Btn2.visibility = View.INVISIBLE
            cha_Btn2.visibility = View.VISIBLE
            del_Btn2.visibility = View.VISIBLE

            cha_Btn2.setOnClickListener { // 수정 버튼을 누를 시
                contextEditText2.visibility = View.VISIBLE
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText(str) // editText에 textView에 저장된 내용을 출력
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                textView4.text = "${contextEditText2.getText()}"
            }

            del_Btn2.setOnClickListener {
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText("")
                contextEditText2.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                removeWeek(fname)
                Toast.makeText(
                    this.getApplicationContext(),
                    fname + "데이터를 삭제했습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (textView4.getText() == "") {
                textView4.visibility = View.INVISIBLE
                yoil_view.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                contextEditText2.visibility = View.VISIBLE
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkedMonDay() {
        fname =
            "MondayMemo" // 저장할 파일 이름 설정.
        var fis: FileInputStream? = null // FileStream fis 변수 설정

        try {
            fis = openFileInput(fname) // fname 파일 열기

            val fileData = ByteArray(fis.available()) // fileData에 파이트 형식으로 저장
            fis.read(fileData) // fileData를 읽음
            fis.close()

            str = String(fileData) // str 변수에 fileData를 저장

            contextEditText2.visibility = View.INVISIBLE
            textView4.visibility = View.VISIBLE
            textView4.text = "${str}" // textView에 str 출력

            save_Btn2.visibility = View.INVISIBLE
            cha_Btn2.visibility = View.VISIBLE
            del_Btn2.visibility = View.VISIBLE

            cha_Btn2.setOnClickListener { // 수정 버튼을 누를 시
                contextEditText2.visibility = View.VISIBLE
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText(str) // editText에 textView에 저장된 내용을 출력
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                textView4.text = "${contextEditText2.getText()}"
            }

            del_Btn2.setOnClickListener {
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText("")
                contextEditText2.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                removeWeek(fname)
                Toast.makeText(
                    this.getApplicationContext(),
                    fname + "데이터를 삭제했습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (textView4.getText() == "") {
                textView4.visibility = View.INVISIBLE
                yoil_view.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                contextEditText2.visibility = View.VISIBLE
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkedTueDay() {
        fname =
            "TuesdayMemo" // 저장할 파일 이름 설정.
        var fis: FileInputStream? = null // FileStream fis 변수 설정

        try {
            fis = openFileInput(fname) // fname 파일 열기

            val fileData = ByteArray(fis.available()) // fileData에 파이트 형식으로 저장
            fis.read(fileData) // fileData를 읽음
            fis.close()

            str = String(fileData) // str 변수에 fileData를 저장

            contextEditText2.visibility = View.INVISIBLE
            textView4.visibility = View.VISIBLE
            textView4.text = "${str}" // textView에 str 출력

            save_Btn2.visibility = View.INVISIBLE
            cha_Btn2.visibility = View.VISIBLE
            del_Btn2.visibility = View.VISIBLE

            cha_Btn2.setOnClickListener { // 수정 버튼을 누를 시
                contextEditText2.visibility = View.VISIBLE
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText(str) // editText에 textView에 저장된 내용을 출력
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                textView4.text = "${contextEditText2.getText()}"
            }

            del_Btn2.setOnClickListener {
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText("")
                contextEditText2.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                removeWeek(fname)
                Toast.makeText(
                    this.getApplicationContext(),
                    fname + "데이터를 삭제했습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (textView4.getText() == "") {
                textView4.visibility = View.INVISIBLE
                yoil_view.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                contextEditText2.visibility = View.VISIBLE
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkedWedDay() {
        fname =
            "WednesdayMemo" // 저장할 파일 이름 설정.
        var fis: FileInputStream? = null // FileStream fis 변수 설정

        try {
            fis = openFileInput(fname) // fname 파일 열기

            val fileData = ByteArray(fis.available()) // fileData에 파이트 형식으로 저장
            fis.read(fileData) // fileData를 읽음
            fis.close()

            str = String(fileData) // str 변수에 fileData를 저장

            contextEditText2.visibility = View.INVISIBLE
            textView4.visibility = View.VISIBLE
            textView4.text = "${str}" // textView에 str 출력

            save_Btn2.visibility = View.INVISIBLE
            cha_Btn2.visibility = View.VISIBLE
            del_Btn2.visibility = View.VISIBLE

            cha_Btn2.setOnClickListener { // 수정 버튼을 누를 시
                contextEditText2.visibility = View.VISIBLE
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText(str) // editText에 textView에 저장된 내용을 출력
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                textView4.text = "${contextEditText2.getText()}"
            }

            del_Btn2.setOnClickListener {
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText("")
                contextEditText2.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                removeWeek(fname)
                Toast.makeText(
                    this.getApplicationContext(),
                    fname + "데이터를 삭제했습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (textView4.getText() == "") {
                textView4.visibility = View.INVISIBLE
                yoil_view.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                contextEditText2.visibility = View.VISIBLE
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkedThuDay() {
        fname =
            "ThursdayMemo" // 저장할 파일 이름 설정.
        var fis: FileInputStream? = null // FileStream fis 변수 설정

        try {
            fis = openFileInput(fname) // fname 파일 열기

            val fileData = ByteArray(fis.available()) // fileData에 파이트 형식으로 저장
            fis.read(fileData) // fileData를 읽음
            fis.close()

            str = String(fileData) // str 변수에 fileData를 저장

            contextEditText2.visibility = View.INVISIBLE
            textView4.visibility = View.VISIBLE
            textView4.text = "${str}" // textView에 str 출력

            save_Btn2.visibility = View.INVISIBLE
            cha_Btn2.visibility = View.VISIBLE
            del_Btn2.visibility = View.VISIBLE

            cha_Btn2.setOnClickListener { // 수정 버튼을 누를 시
                contextEditText2.visibility = View.VISIBLE
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText(str) // editText에 textView에 저장된 내용을 출력
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                textView4.text = "${contextEditText2.getText()}"
            }

            del_Btn2.setOnClickListener {
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText("")
                contextEditText2.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                removeWeek(fname)
                Toast.makeText(
                    this.getApplicationContext(),
                    fname + "데이터를 삭제했습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (textView4.getText() == "") {
                textView4.visibility = View.INVISIBLE
                yoil_view.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                contextEditText2.visibility = View.VISIBLE
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkedFriDay() {
        fname =
            "FridayMemo" // 저장할 파일 이름 설정.
        var fis: FileInputStream? = null // FileStream fis 변수 설정

        try {
            fis = openFileInput(fname) // fname 파일 열기

            val fileData = ByteArray(fis.available()) // fileData에 파이트 형식으로 저장
            fis.read(fileData) // fileData를 읽음
            fis.close()

            str = String(fileData) // str 변수에 fileData를 저장

            contextEditText2.visibility = View.INVISIBLE
            textView4.visibility = View.VISIBLE
            textView4.text = "${str}" // textView에 str 출력

            save_Btn2.visibility = View.INVISIBLE
            cha_Btn2.visibility = View.VISIBLE
            del_Btn2.visibility = View.VISIBLE

            cha_Btn2.setOnClickListener { // 수정 버튼을 누를 시
                contextEditText2.visibility = View.VISIBLE
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText(str) // editText에 textView에 저장된 내용을 출력
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                textView4.text = "${contextEditText2.getText()}"
            }

            del_Btn2.setOnClickListener {
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText("")
                contextEditText2.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                removeWeek(fname)
                Toast.makeText(
                    this.getApplicationContext(),
                    fname + "데이터를 삭제했습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (textView4.getText() == "") {
                textView4.visibility = View.INVISIBLE
                yoil_view.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                contextEditText2.visibility = View.VISIBLE
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkedSatDay() {
        fname =
            "SaturdayMemo" // 저장할 파일 이름 설정.
        var fis: FileInputStream? = null // FileStream fis 변수 설정

        try {
            fis = openFileInput(fname) // fname 파일 열기

            val fileData = ByteArray(fis.available()) // fileData에 파이트 형식으로 저장
            fis.read(fileData) // fileData를 읽음
            fis.close()

            str = String(fileData) // str 변수에 fileData를 저장

            contextEditText2.visibility = View.INVISIBLE
            textView4.visibility = View.VISIBLE
            textView4.text = "${str}" // textView에 str 출력

            save_Btn2.visibility = View.INVISIBLE
            cha_Btn2.visibility = View.VISIBLE
            del_Btn2.visibility = View.VISIBLE

            cha_Btn2.setOnClickListener { // 수정 버튼을 누를 시
                contextEditText2.visibility = View.VISIBLE
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText(str) // editText에 textView에 저장된 내용을 출력
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                textView4.text = "${contextEditText2.getText()}"
            }

            del_Btn2.setOnClickListener {
                textView4.visibility = View.INVISIBLE
                contextEditText2.setText("")
                contextEditText2.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                removeWeek(fname)
                Toast.makeText(
                    this.getApplicationContext(),
                    fname + "데이터를 삭제했습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (textView4.getText() == "") {
                textView4.visibility = View.INVISIBLE
                yoil_view.visibility = View.VISIBLE
                save_Btn2.visibility = View.VISIBLE
                cha_Btn2.visibility = View.INVISIBLE
                del_Btn2.visibility = View.INVISIBLE
                contextEditText2.visibility = View.VISIBLE
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @SuppressLint("WrongConstant")
    fun saveWeek(readyDay: String) {
        var fos: FileOutputStream? = null

        try {
            fos = openFileOutput(readyDay, MODE_NO_LOCALIZED_COLLATORS)
            var content: String = contextEditText2.getText().toString()
            fos.write(content.toByteArray())
            fos.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @SuppressLint("WrongConstant")
    fun removeWeek(readyDay: String) {
        var fos: FileOutputStream? = null

        try {
            fos = openFileOutput(readyDay, MODE_NO_LOCALIZED_COLLATORS)
            var content: String = ""
            fos.write(content.toByteArray())
            fos.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}