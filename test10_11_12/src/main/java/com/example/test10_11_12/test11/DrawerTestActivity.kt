package com.example.test10_11_12.test11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.test10_11_12.R
import com.example.test10_11_12.databinding.ActivityDrawerTestBinding

class DrawerTestActivity : AppCompatActivity() {

    //기존경로
    lateinit var binding : ActivityDrawerTestBinding
    //toggle 선언 추가
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDrawerTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //test11/src/main/java/com/example/test11/MainActivity357.kt

        //드로워 태그 하위에 뷰 2개가 있고, 첫번째 뷰 = 메인화면 뷰, 두번째 뷰 = 서랍 뷰(사이드)
        //test11/src/main/res/layout/activity_main357.xml

        //ActionBarDrawerToggle 버튼 적용
        //test11/src/main/res/values/strings.xml
        toggle = ActionBarDrawerToggle(this, binding.drawer,
            R.string.drawer_opened,
            R.string.drawer_closed
        )
        //액션바애 토글부분 연결시켜서 버튼을 클릭하면 서랍 화면이 보인다
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //이벤트가 toggle 버튼에서 제공된거라면..
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
