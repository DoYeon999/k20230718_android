package com.example.test13_16_17_18.test17sharedpreference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test13_16_17_18.databinding.ActivityMain7Binding

//코드 재사용 test13/MainActivity,  DetailActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //버튼 클릭해서 정방향 메인 -> 디테일 화면으로 이동 + 데이터 전달
        binding.button1.setOnClickListener {
            //SharedPreference 작업, 전역으로
            //여기서 데이터 세터하고 디테일 화면 게터
            //앱 전체의 데이터 저장
            val sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
            //프리퍼런스에 데이터 저장.
            //공유파일 my_prefs 저장위치
            //data / data / 패키지명 / shared_prefs / my_prefs.xml 저장
            sharedPref.edit().run {
                putString("data1", "kdy")
                putInt("data2", 10)
                commit()
            }

//            //::class.java 클래스 래퍼런스 타입으로 전달은 보통 , 내부앱에서 전달하는 방식
//            val intent: Intent = Intent(this, DetailActivity::class.java)
//            //Map 처럼 키와 value 의 형태로 데이터를 설정 및 가져오기 작업을 할 에정
//            intent.putExtra("data1", "hello")
//            intent.putExtra("data2", 10)
//            //시스템에게 설정한 인텐트를 전달함
//            startActivity(intent)
        }

    }
}