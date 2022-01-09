package com.dk.mobiledevicemanagementapp.view.ui.home

import com.dk.mobiledevicemanagementapp.models.MobileListItem
import com.dk.mobiledevicemanagementapp.viewmodels.event.CellClickListener
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertTrue
import java.util.Optional.empty

class MainAdapterTest(): CellClickListener {

    private lateinit var mainAdapter:MainAdapter
    //var device = mutableListOf<MobileListItem>()
    var mobileList:ArrayList<MobileListItem> =  ArrayList()

    @Before
    fun setup(){
        mainAdapter = MainAdapter(this)

    }

    @Test
    fun newObjectCreated() {
        assertTrue( "Object is created",mainAdapter.objectFound());
    }

    @Test
    fun getFilterRecordFound() {
      // val result = mainAdapter.valueFound()
        //assertThat(result).isFalse()
      //  assertThat(result).isTrue()
        assertFalse( "Not found array",mainAdapter.valueFound());
    }

    @Test
    fun getFilterRecordAfterAdd() {
        mobileList.add(0,MobileListItem("ds","ds","ds","",10,"",
            true,"",1.0f,"",""))
        val result = mainAdapter.isValue
        //assertThat(result).isFalse()
        //assertThat(result).isTrue()
        assertFalse( "Record not found need to add list first",mainAdapter.valueFound());
    }



    override fun onCellClickListener(mobileListItem: MobileListItem) {
        TODO("Not yet implemented")
    }
}