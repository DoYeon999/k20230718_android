package com.example.test6_kdy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.test6_kdy.databinding.ActivityLoginBinding
import com.example.test6_kdy.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityLoginBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //아이디, 패스워드를 입력 받고, 콘솔에 출력, 토스트(알림창) 출력
        binding.loginbutton.setOnClickListener{
            val id : String = binding.idInput.text.toString()
            val pw : String = binding.pwInput.text.toString()
            Log.d("kdy", "id의 값 : $id, pw의 값 : $pw")
            Toast.makeText(this@LoginActivity, "id의 값 : $id, pw의 값 : $pw", Toast.LENGTH_SHORT).show()
        }
    }
}