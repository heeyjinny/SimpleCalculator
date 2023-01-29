package com.heeyjinny.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

/**  간단한 계산기  **/
//1
//레이아웃 설정, ()와 소숫점은 사용하지 않는 계산기
//activity_main.xml

class MainActivity : AppCompatActivity() {

    //6
    //텍스트뷰 연결
    val expressionTV: TextView by lazy {
        findViewById(R.id.expressionTV)
    }
    val resultTV: TextView by lazy {
        findViewById(R.id.resultTV)
    }

    //4-6
    //연산자가 작성이 되었을 때를 알리는 변수 생성
    //연산자는 한 번만 들어갈 수 있으며,
    //연산자가 들어갔다면(true) 텍스트뷰에 공백을 추가해줘야 함
    var isOperator = false
    var hasOperator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }//onCreate

    //2
    //계산기의 각 메서드 생성
    fun btnClicked(v: View) {
        //3
        //when함수를 사용하여 각 버튼의 아이디 가져오기
        //각 버튼의 아이디가 눌러졌을 때 반환하는 문자열 설정
        when (v.id) {
            //3-1
            //숫자버튼 함수에 반환
            R.id.btn0 -> numberBtnClicked("0")
            R.id.btn1 -> numberBtnClicked("1")
            R.id.btn2 -> numberBtnClicked("2")
            R.id.btn3 -> numberBtnClicked("3")
            R.id.btn4 -> numberBtnClicked("4")
            R.id.btn5 -> numberBtnClicked("5")
            R.id.btn6 -> numberBtnClicked("6")
            R.id.btn7 -> numberBtnClicked("7")
            R.id.btn8 -> numberBtnClicked("8")
            R.id.btn9 -> numberBtnClicked("9")

            //3-2
            //연산자 버튼 함수에 반환
            R.id.btnDivider -> operatorBtnClicked("/")
            R.id.btnPlus -> operatorBtnClicked("+")
            R.id.btnMinus -> operatorBtnClicked("-")
            R.id.btnMulti -> operatorBtnClicked("*")
            R.id.btnModulo -> operatorBtnClicked("%")

        }

    }//btnClicked

    //4
    //숫자 버튼들이 눌렸을 때 숫자를 받아와
    //반응하는 함수 생성
    fun numberBtnClicked(number: String) {

        //4-6-1
        //연산자가 들어갔다면(true) 텍스트뷰에 공백을 추가해줘야 함
        if (isOperator){
            expressionTV.append(" ")
        }
        isOperator = false

        //4-1
        //split()함수 사용하여 띄어쓰기 공백 구분
        //숫자와 연산자를 공백으로 구분하여 읽어 변수에 저장
        val expressionText = expressionTV.text.split(" ")

        //4-2
        //예외 설정
        //만약 텍스트가 비어있지 않았을 때 텍스트의 길이가 15자리 이상이라면
        //숫자의 마지막을 비교
        //last().length를 비교하여 첫번째 숫자, 두번째 숫자의 길이를 알 수 있음
        //토스트 메시지 띄우기
        if (expressionText.isNotEmpty() && expressionText.last().length >= 15){
            Toast.makeText(this, "15자리 까지만 사용할 수 있습니다.", Toast.LENGTH_SHORT).show()
            //4-2-1
            //더이상 로직이 진행되지 않도록 막아주기
            return

        //4-3
        //마지막 값이 비어있고 숫자가 0일 때(0)
        //예외처리
        } else if (expressionText.last().isEmpty() && number == "0"){
            Toast.makeText(this, "0은 제일 앞에 올 수 없습니다", Toast.LENGTH_SHORT).show()
            return
        }

        //4-4
        //예외 없이 정상적으로 동작할 때
        //텍스트뷰에 작성된 숫자들을 붙여주어 보여지게 하기
        expressionTV.append(number)

        //4-5
        //todo resultTv에 실시간으로 계산 결과를 넣어야 하는 기능 구현...

    }

    //5
    //연산자 버튼들이 눌렸을 때
    //반응하는 함수
    fun operatorBtnClicked(operator: String) {
        //5-1
        //만약 연산자를 먼저 눌렀을 때 무시해야함

    }

    fun clearBtnClicked(v: View) {

    }//clearBtnClicked

    fun resultBtnClicked(v: View) {

    }//resultBtnClicked

    fun historyBtnClicked(v: View) {

    }//historyBtnClicked

}//MainActivity