package com.example.test10_11_12

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.test10_11_12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //binding 사용하려면  1)build.gradle(설정, Sync Now 클릭)
    lateinit var binding : ActivityMainBinding

    //생명주기 13장, 액티비티 조금 더 상세히 설명
    //최초1회에 한 번 실행이 되는 함수, 특징 : 매개변수로 번들 타입의 객체를 가짐
    //번들 타입 객체 : 메모리상에 임시 저장하는 파일
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        //inflate -> 인스턴스화를 한다 -> 객체 생성한다
        binding = ActivityMainBinding.inflate(layoutInflater)
        //화면에 출력하는 역할
        setContentView(binding.root)

        //테스트1, 권한 관련
        //https://github.com/lsy3709/AndroidLab/blob/master/test10/src/main/java/com/example/test10/MainActivity.kt
        //인텐트 기본 기능
        // 1) 액티비티 간의 전환(화면이동)
        // 2) 화면 간의 이동 시 데이터 전달
        // 3) 화면 이동하고 이동된 화면에서 작업 후 데이터를 원래 화면에 가져오는 역할
        // ex) A앱, 갤러리(외부 앱) 접근해서 사진을 선택 후 다시 A앱 가져오는 경우
        // ex) A앱, 외부앱 접근해서 권한을 획득하고 다시 A앱으로 돌아오는 경우
        // 4) 외부(시스템 해당 앱에 접근시) intenet-filter -> 명시적으로 설정
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->

            if (isGranted) {
                Log.d("kkang", "callback, granted..")
            } else {
                Log.d("kkang", "callback, denied..")
            }
        }

        val status= ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION")
        if(status == PackageManager.PERMISSION_GRANTED){
            Log.d("kkang", "granted..")
        }else {
            requestPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")
        }
    }
    
    //onCreate 마지막
}