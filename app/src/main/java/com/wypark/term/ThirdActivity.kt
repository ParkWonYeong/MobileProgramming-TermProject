package com.wypark.term

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.style.BackgroundColorSpan
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.third_layout.*
import org.w3c.dom.Text
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.security.cert.CertPath
import java.text.SimpleDateFormat
import java.util.*

class ThirdActivity : AppCompatActivity() {

    var fname: String = ""
    var str: String = ""

    val REQUEST_IMAGE_CAPTURE=1
    lateinit var currentPhotoPath:String

    lateinit var baseLayout:LinearLayout
    lateinit var topbar:TextView
    lateinit var select:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_layout)

        //메뉴
        baseLayout=findViewById<LinearLayout>(R.id.baseLayout)
        topbar=findViewById<TextView>(R.id.topbar)
        select=findViewById<Button>(R.id.select)
        registerForContextMenu(select)

        //화면 이동 버튼
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

        //내용 저장 확인
        checkedDaily()

        save_Btn3.setOnClickListener { // 저장 Button이 클릭되면
            saveDay(fname) // saveDiary 메소드 호출
            Toast.makeText(this.getApplicationContext(), fname + "데이터를 저장했습니다.", Toast.LENGTH_SHORT)
                .show() // 토스트 메세지
            str = contextEditText3.getText().toString() // str 변수에 edittext내용을 toString 형으로 저장
            textView5.text = "${str}" // textView에 str 출력
            save_Btn3.visibility = View.INVISIBLE
            cha_Btn3.visibility = View.VISIBLE
            del_Btn3.visibility = View.VISIBLE
            contextEditText3.visibility = View.INVISIBLE
            textView5.visibility = View.VISIBLE
        }

        //카메라 기능 permission
        settingPermission()

        var imageView = findViewById<ImageView>(R.id.img_picture)

        imageView.setOnClickListener() {
            startCapture()
        }


    }

    //파일 저장 함수
    fun checkedDaily() {
        fname =
            "Daily Note" // 저장할 파일 이름 설정.
        var fis: FileInputStream? = null // FileStream fis 변수 설정

        try {
            fis = openFileInput(fname) // fname 파일 열기

            val fileData = ByteArray(fis.available()) // fileData에 파이트 형식으로 저장
            fis.read(fileData) // fileData를 읽음
            fis.close()

            str = String(fileData) // str 변수에 fileData를 저장

            contextEditText3.visibility = View.INVISIBLE
            textView5.visibility = View.VISIBLE
            textView5.text = "${str}" // textView에 str 출력

            save_Btn3.visibility = View.INVISIBLE
            cha_Btn3.visibility = View.VISIBLE
            del_Btn3.visibility = View.VISIBLE

            cha_Btn3.setOnClickListener { // 수정 버튼을 누를 시
                contextEditText3.visibility = View.VISIBLE
                textView5.visibility = View.INVISIBLE
                contextEditText3.setText(str) // editText에 textView에 저장된 내용을 출력
                save_Btn3.visibility = View.VISIBLE
                cha_Btn3.visibility = View.INVISIBLE
                del_Btn3.visibility = View.INVISIBLE
                textView5.text = "${contextEditText3.getText()}"
            }

            del_Btn3.setOnClickListener {
                textView5.visibility = View.INVISIBLE
                contextEditText3.setText("")
                contextEditText3.visibility = View.VISIBLE
                save_Btn3.visibility = View.VISIBLE
                cha_Btn3.visibility = View.INVISIBLE
                del_Btn3.visibility = View.INVISIBLE
                removeDay(fname)
                Toast.makeText(
                    this.getApplicationContext(),
                    fname + "데이터를 삭제했습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (textView5.getText() == "") {
                save_Btn3.visibility = View.VISIBLE // 저장 버튼이 Visible
                contextEditText3.setText("") // EditText에 공백값 넣기
                contextEditText3.visibility = View.VISIBLE // EditText가 Visible
                textView5.visibility = View.INVISIBLE
                cha_Btn3.visibility = View.INVISIBLE // 수정 Button이 Invisible
                del_Btn3.visibility = View.INVISIBLE // 삭제 Button이 Invisible
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @SuppressLint("WrongConstant")
    fun saveDay(readyDay: String) {
        var fos: FileOutputStream? = null

        try {
            fos = openFileOutput(readyDay, MODE_NO_LOCALIZED_COLLATORS)
            var content: String = contextEditText3.getText().toString()
            fos.write(content.toByteArray())
            fos.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @SuppressLint("WrongConstant")
    fun removeDay(readyDay: String) {
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

    //contextmenu 함수
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

    //카메라 권한 설정 함수
    fun settingPermission(){
        var permis = object : PermissionListener {
            override fun onPermissionGranted() {
                Toast.makeText(this@ThirdActivity, "권한 허가", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(this@ThirdActivity, "권한 거부", Toast.LENGTH_SHORT)
                    .show()
                ActivityCompat.finishAffinity(this@ThirdActivity) //권한 거부시 앱을 종료한다.
            }
        }

        TedPermission.with(this)
            .setPermissionListener(permis)
            .setRationaleMessage("카메라 사진 권한 필요")
            .setDeniedMessage("카메라 권한 요청 거부")
            .setPermissions(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.CAMERA
            )
            .check()
    }

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

    @Throws(IOException::class)
    private fun createImageFile():File{
        val timeStamp:String=SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir:File?=getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_",
            ".jpg",
            storageDir
        ).apply {
            currentPhotoPath=absolutePath
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode== Activity.RESULT_OK){
            val file=File(currentPhotoPath)
            if(Build.VERSION.SDK_INT<28){
                val bitmap=MediaStore.Images.Media
                    .getBitmap(contentResolver,Uri.fromFile(file))
                img_picture.setImageBitmap(bitmap)
            }
            else{
                val decode=ImageDecoder.createSource(this.contentResolver,
                Uri.fromFile(file))
                val bitmap=ImageDecoder.decodeBitmap(decode)
                img_picture.setImageBitmap(bitmap)
            }
        }
    }

}