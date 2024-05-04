package com.example.idcmps_listing.core.presentation.uimodel

data class BaseUIModel<T>(val loading: Boolean = false, val error: Throwable?= null,val data: T)
data class BaseListUIModel<T>(val loading: Boolean = false, val error: Throwable?= null, val data: List<T>)