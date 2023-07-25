package com.example.test10_11_12.test12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test10_11_12.R

//test11 -> MainActivity가 사용중이어서 뷰가 activity_main2

//뷰 경로 : 실제 작업은 여기서
//test12/src/main/res/layout/activity_main.xml
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}