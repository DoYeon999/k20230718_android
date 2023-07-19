package com.example.test6_kdy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.test6_kdy.databinding.ActivityMainBinding

//액티비티 : 화면을 그려주는 역할
class MainActivity : AppCompatActivity() {

    //스위치 효과를 주기위해 상태 패턴의 변수를 이용해서 이미지 보여주고 안보여주기
    var status: Int = 0

    //최초에 한 번 화면에 출력을 하는 역할
    override fun onCreate(savedInstanceState: Bundle?) {

        //뷰 바인딩 적용1
        //시스템에서 자동으로 생성 ActivityMainBinding
        //여기 코드, 설정 코드이기때문에 디비 연결하는 Connection 객체 용도가 비슷
        //bindind 작업 하는
        val binding = ActivityMainBinding.inflate(layoutInflater)

        //savedInstanceState: Bundle? -> 임시 데이터 저장 객체
        super.onCreate(savedInstanceState)
        //레이아웃 샘플로 리니어 사용하는 중  why? 제약 조건 설정이 간단해서 뷰만 선택해서 배치만 하면 기본 세로, 가로 방향으로 배치가 간단

        //뷰 바인딩 적용2
        setContentView(binding.root)

        //버튼 클릭 -> 이미지 -> show / hide
        //버튼에 이벤트 클릭 리스너 설정 후 -> 결과로 이미지의 속성 중에 visibility 속성으로 show / hide 테스트
        //binding 객체 안에 사용하는 뷰의 모든 객체가 가 담아져 있음
//        binding.btn1.setOnClickListener {
//
//            if (status == 0) {
//                binding.img1.visibility = View.GONE
//                status = 1
//            } else if(status == 1){
//                binding.img1.visibility = View.VISIBLE
//                status = 0
//            }
//
//            //버튼2개로 하는 경우
//            binding.btn2.setOnClickListener {
//                binding.img1.visibility = View.VISIBLE
//            }
//
//        }
        //회원 가입 버튼 클릭시 간단히 해당 액티비티 화면 이동
        binding.joinBtn.setOnClickListener{
            //인텐트라는 개념에 가장 기초인 화면 전환
            //화면 전환시, 데이터를 가지고 이동도 할 예정
            val intent = Intent(this@MainActivity, JoinActivity::class.java)
            startActivity(intent)
        }

        //아이디, 패스워드를 입력 받고, 콘솔에 출력, 토스트(알림창) 출력
        binding.loginBtn.setOnClickListener{
           val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}