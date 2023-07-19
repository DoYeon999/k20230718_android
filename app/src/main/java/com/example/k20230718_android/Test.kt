package com.example.k20230718_android

//고차함수
fun hofFun(arg: (Int) -> Boolean): () -> String {
    val result = if(arg(10)) {
        "valid"
    } else {
        "invalid"
    }
    return {"hofFun result : $result"}
}

//매개변수 arg 의 타입이 함수.
//(Int) -> Boolean)
//따라서, 함수를 호출하려면 인자로 함수를 전달.
//인자 : {no -> no>0}


val data5 : Int = 1

val data4 : Int by lazy {
    println("in lazy....순서2...")
    10
}

lateinit var name2: String
//lateinit var num : Int
//기본 문법에 대한 설명은 참고 및, 한 번 정도 직접 코드로 작성해서 오류 부분정도 확인하고, 실제 작업은 ide에서 문법체크 해주니 도움 받기

val name: String = "kdy"


fun main(){

    val result = hofFun({no -> no > 0})
    println(result())

    //Array 선언, Getter, Setter
    //선언
    val data1 : Array<Int> = Array(3, {0})

    //Setter
    data1[0] = 10
    data1[1] = 20

    //Getter
    println("""
        data1의 size : ${data1.size}
        data1의 요소 : ${data1[0]}, ${data1.get(1)}, ${data1[2]}
    """.trimIndent())


    //null을 허용할 수 있는 연산자가 있을 때만 사용 가능(중요)
    var data6 : Int? =2
    data6 = null

    //data5. : 모든 타입이 객체이기 때문에 닷(.) 연산자 통해서 멤버에 다 접근 가능함

    println("in main 순서1")
    println("data4 사용 : $data4")
//    println("data4 사용하자 순서3 : (" + {data4} + 10)


//    val name: String (빨간줄 안 뜨지만 오류 발생)
    val name: String = "main 안의 name 변수"
    println("이름은 : $name")  //jsp EL 표기법, ${} 해당 변수 사용
    //$변수, 사용하면 됨
    println("hello world")
}

class Test {

}