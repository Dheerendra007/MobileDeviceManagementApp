package com.dk.mobiledevicemanagementapp.viewmodels.event

import com.dk.mobiledevicemanagementapp.models.MobileListItem

interface CellClickListener {
    fun onCellClickListener(mobileListItem: MobileListItem)
}