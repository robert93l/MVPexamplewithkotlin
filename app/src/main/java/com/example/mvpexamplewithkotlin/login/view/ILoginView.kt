package com.example.mvpexamplewithkotlin.login.view

interface ILoginView {

    fun onClear()
    fun onShowProgress()
    fun onHideProgress()
    fun onUpdateLoginResultUserInfo(nickname: String, age: Int)
}