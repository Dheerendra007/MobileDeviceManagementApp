package com.dk.mobiledevicemanagementapp.viewmodels.home

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dk.mobiledevicemanagementapp.view.ui.home.HomeViewModel

class HomeViewModelFactory(val context: Application):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(context) as T
    }
}