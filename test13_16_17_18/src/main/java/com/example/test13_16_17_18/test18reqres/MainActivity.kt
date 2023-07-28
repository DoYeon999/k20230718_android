package com.example.test13_16_17_18.test18reqres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.test13_16_17_18.databinding.ActivityMain9Binding
import com.example.test13_16_17_18.test18reqres.Model.UserListModel
import com.example.test13_16_17_18.test18reqres.Model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//https://github.com/lsy3709/K230201AndroidLab/tree/master/test18
//test18/src/main/java/com/example/test18/MainActivity.kt
//구성 retrofit(2) ,
// 1) 리사이클러 뷰 구성(어댑터, 뷰 홀더)
// 2) 레트로핏 관련 설정
// 3) 받아오는 데이터 모델링 작업

//순서 1
//MainActivity 코드 파일 복사 진행
//변경사항
// 1) ActivityMain9Binding 수정
//추가작업 1
// Call 을 retrofit2 로 임포트  -> import retrofit2.Call
//추가작업 2
//import retrofit2.Callback
//추가작업 3
//import retrofit2.Response


//순서 2
// MainActivity 뷰 코드 복사 진행
//변경사항
// 1) tools:context=".test18reqres.MainActivity"     -> 변경

//순서 3 MyApplication 일반 클래스 작업, 코드 복사 진행
//추가작업 1
//매니페스트 파일 <application android:name=".test18reqres.MyApplication"    -> 추가
//추가작업 2
//<uses-permission android:name="android.permission.INTERNET" />     -> 추가

//순서 4 인터페이스 작업(레트로핏에 필요한 인터페이스, 여기에 서버와 통신 할 떄 필요한 함수들 정의했음)
//INetworkService -> Call 을 retrofit2 로 임포트
//test18/src/main/java/com/example/test18/retrofit/INetworkService.kt
//일반 인터페이스 작업, 코드 복사 진행

//순서 5 모델, 모델리스트 (서버에서 넘어온 데이터를 임시 객체에 담아서 작업의 편의성 위해 사용)
//경로 1 UserModel
//test18/src/main/java/com/example/test18/Model/UserModel.kt
//경로 2 UserListModel
//test18/src/main/java/com/example/test18/Model/UserListModel.kt

//순서 6 불러온 데이터를 리사이클러 뷰에 출력하기 위한 사전 작업
//일반 클래스 작업, 코드 복사 진행
//test18/src/main/java/com/example/test18/adpater/MyAdapter.kt

//추가작업 1.
//목록 아이템 요소 뷰 작업
//test18/src/main/res/layout/item_retrofit.xml
//추가작업 2. 임포트
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMain9Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //test , MyApplication에서 만든 형으로 다운캐스팅해서, 해당 객체 생성.
        val networkService = (applicationContext as MyApplication).networkService

        // INetworkService에 정의된 추상 함수이고, MyApplication 클래스에 붙였다.
        // 예  doGetUserList(2)
        // 여기에 함수의 형식이 계속 변경이 됩니다.
        val userListCall = networkService.doGetUserList("2")



        // 버튼1을 누르면 해당 test1()의 결과값 받아오기.
        binding.btn1test1.setOnClickListener {
            // 해당 애너테이션 정의 부분 사용해보기 예제2) @GET("users/list?sort=desc")

            //val test1 = networkService.test1()
            //테스트 중
            val test1 = networkService.doGetUserList(2)
            //fun doGetUserList(@Query("page") page: String): Call<UserListModel>


            test1.enqueue(object: Callback<UserListModel> {
                override fun onResponse(call: Call<UserListModel>, response: Response<UserListModel>) {
                    val userModelSample = response.body()
                    Log.d("lsy","test1()호출예제2이고 값조회: ${userModelSample}")
                }

                override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }


        // 실제 통신을 해서 사용하기. 서버와 통신해서, 데이터를 받는다.
        userListCall.enqueue(
            //Callback : import 함.
            object: Callback<UserListModel> {
                // Callback 인터페이스를 구현한 특정 표현식을 쓸때,
                // 의무적으로 재정의를 해야하는 함수2개.
                // onResponse : 서버로 부터 응답 성공 했을 때, 수행하는 함수.
                // onFailure : 실패 했을 때, 수행하는 함수.
                override fun onResponse(
                    call: Call<UserListModel>,
                    response: Response<UserListModel>
                ) {
                    // 정상적으로 서버로부터 데이터를 받아왔다.
                    // 실제로 데이터를 받고나서, response.body 곳에 data가 있음.
                    val userList = response.body()

                    // 받아온 데이터를 콘솔에 출력.
                    // 실제 작업은 뷰에 바인딩.
                    // 리사이클러 뷰를 작업.
                    Log.d("lsy","userList(response.body)의 값: ${userList} ")
                }

                override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })



    }
}