package com.example.mvpexamplewithkotlin.login.presenter.controller

import com.example.mvpexamplewithkotlin.framework.util.thread.ThreadUtil

object LoginController {

    interface LoginControllerDelegate {
        fun OnSuccess(response: String)
        fun onFailed()
    }

    fun requestLogin(id: String, password: String, delegate: LoginControllerDelegate) {
        //send id and password to server and waiting response

        ThreadUtil.startThread() {
            Thread.sleep(3000)
            delegate.OnSuccess("response from server")
        }
    }
}