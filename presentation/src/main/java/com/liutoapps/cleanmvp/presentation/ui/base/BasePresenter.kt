package com.liutoapps.cleanmvp.presentation.ui.base

interface BasePresenter<V> {

    fun onAttach(view: V)

    fun onDetatch()

}