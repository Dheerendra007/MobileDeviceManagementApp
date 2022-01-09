package com.dk.mobiledevicemanagementapp.view.ui.home

import android.app.Application
import androidx.lifecycle.ViewModel
import com.dk.mobiledevicemanagementapp.models.MobileListItem
import com.google.gson.Gson

class HomeViewModel(val context: Application) : ViewModel() {

  var mobileList:Array<MobileListItem> = emptyArray()

    init {
        mobileList=  loadMobileFromAssests()
    }

    private fun loadMobileFromAssests():Array<MobileListItem>{
        val inputStream = context.assets.open("mobilelist.json")
        val size:Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json,Array<MobileListItem>::class.java)
    }

    fun getDeviceList() = mobileList

}