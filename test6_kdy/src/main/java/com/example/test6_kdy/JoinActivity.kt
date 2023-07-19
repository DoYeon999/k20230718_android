package com.example.test6_kdy

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.test6_kdy.databinding.ActivityJoinBinding
import com.example.test6_kdy.databinding.ActivityLoginBinding

class JoinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityJoinBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_join)
        setContentView(binding.root)

        binding.joinbutton.setOnClickListener{

            val pwInput : String = binding.pwInput.text.toString()
            val pw2Input : String = binding.pw2Input.text.toString()

            if(pwInput == pw2Input){
                Toast.makeText(this@JoinActivity, "회원가입 완료", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@JoinActivity, "회원가입 실패", Toast.LENGTH_SHORT).show()
            }

        }

    }

}