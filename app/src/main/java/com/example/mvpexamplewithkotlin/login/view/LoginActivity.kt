package com.example.mvpexamplewithkotlin.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import com.example.mvpexamplewithkotlin.R
import com.example.mvpexamplewithkotlin.login.presenter.ILoginPresenter
import com.example.mvpexamplewithkotlin.login.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), ILoginView {

    private lateinit var textViewLoginResultInfo: TextView
    private lateinit var buttonLogin: Button
    private lateinit var edittextID: EditText
    private lateinit var edittextPW: EditText
    private lateinit var frameLayoutProgress: FrameLayout

    lateinit var iLoginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initPresenter()
        findView()
        setListener()
    }

    private fun initPresenter() {
        iLoginPresenter = LoginPresenter(iLoginView = this)
    }

    private fun findView() {
        textViewLoginResultInfo = findViewById(R.id.textViewLoginResultInfo)
        buttonLogin = findViewById(R.id.buttonLogin)
        edittextID = findViewById(R.id.editTextId)
        edittextPW = findViewById(R.id.editTextPW)
        frameLayoutProgress = findViewById(R.id.frameLayoutProgress)
    }

    private fun setListener() {
        buttonLogin.setOnClickListener {

            iLoginPresenter.login(
                id = edittextID.text.toString().trim(),
                password = edittextPW.text.toString().trim()
            )

        }
    }

    override fun onClear() {
        edittextID.setText("")
        edittextPW.setText("")
    }

    override fun onShowProgress() {
        frameLayoutProgress.visibility = View.VISIBLE
    }

    override fun onHideProgress() {
        frameLayoutProgress.visibility = View.GONE
    }

    override fun onUpdateLoginResultUserInfo(nickname: String, age: Int) {
        textViewLoginResultInfo.text = "nickname is $nickname, age is $age"
    }


}