package com.example.mvpexamplewithkotlin.login.presenter

import android.util.Log
import com.example.mvpexamplewithkotlin.framework.util.thread.ThreadUtil
import com.example.mvpexamplewithkotlin.login.model.UserInfoModel
import com.example.mvpexamplewithkotlin.login.presenter.controller.LoginController
import com.example.mvpexamplewithkotlin.login.view.ILoginView

class LoginPresenter(var iLoginView: ILoginView): ILoginPresenter {
    override fun clear() {
        iLoginView.onClear()
    }

    override fun showProgress() {
        iLoginView.onShowProgress()
    }

    override fun hideProgress() {
       iLoginView.onHideProgress()
    }

    override fun login(id: String, password: String) {

        clear()
        showProgress()

        LoginController.requestLogin(id = id, password = password, object: LoginController.LoginControllerDelegate{
            override fun OnSuccess(response: String) {
                Log.d("??", "onSuccess $response")

                val userInfoModel = UserInfoModel()
                userInfoModel.nickname ="coding"
                userInfoModel.age = 1

                ThreadUtil.startUIThread(0){
                    hideProgress()

                    iLoginView.onUpdateLoginResultUserInfo(nickname = userInfoModel.nickname, age = userInfoModel.age)
                }
            }

            override fun onFailed() {
                Log.d("??", "onFailed")
                hideProgress()

            }

        })
    }

}