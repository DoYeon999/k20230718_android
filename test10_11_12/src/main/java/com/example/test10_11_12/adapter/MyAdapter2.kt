package com.example.test10_11_12.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test10_11_12.databinding.Item2342Binding
import com.example.test10_11_12.databinding.Item342Binding

//Recycle2Activity -> 연결할 어댑터
//사실 같은 내용이면 기존에 만들었던 어댑터를 재사용 가능
//연습 삼아서 한번 더 같은 코드를 진행 할 예정
//주석은 MyAdapter 를 참고 하고 지금 전체 구현 방식

//뷰홀더 클래스도 같이 정의할 예정
class MyViewHolder2(val binding: Item2342Binding): RecyclerView.ViewHolder(binding.root)

class MyAdapter2(val datas: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    //목록의 요소를 자동으로 갯수를 파악해서 출력해주는 역할
    override fun getItemCount(): Int{
        Log.d("kkang", "init datas size: ${datas.size}")
        return datas.size
    }
    //데이터와 뷰를 연결하는 역할
    //데이터가 변경이 될때마다 여기 함수가 자동으로 호출
    //받아온 데이터를 해당 뷰에 연결해서 보여주는 역할
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
            = MyViewHolder2(Item2342Binding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("kkang","onBindViewHolder : $position")
        val binding=(holder as MyViewHolder2).binding
        //뷰에 데이터 출력
        binding.itemData.text= datas[position]

        //뷰에 이벤트 추가
        binding.itemRoot.setOnClickListener{
            //보통 상세페이지 연결을 많이 함
            Log.d("kkang", "item root click : $position")
        }
        //목록에 데이터를 임의로 받아오는 부분이 아니라, 기존 데이터에 추가, 수정 할 때 반영이 안되는 경우가 있음, 그럴 때 사용하는 함수
        notifyDataSetChanged()
    }
}