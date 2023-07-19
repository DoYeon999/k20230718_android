package com.example.test6_kdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.postDelayed

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        //매니스트 파일, 앱의 설정 파일인데 시스템 클래스 등 기본메인 액티비티 화면이 시작시 항상 보여줌
        //그래서 우리가 만든 인트로 화면을 메인 대신 보여주고, 핸들러 특정시간 3000ms(3초) 후 원래 메인화면으로 이동
        //Handler handler = new Handler();
        val handler: Handler = Handler();

        handler.postDelayed({
            val intent = Intent(this@IntroActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}