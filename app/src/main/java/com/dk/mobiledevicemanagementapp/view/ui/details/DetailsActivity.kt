package com.dk.mobiledevicemanagementapp.view.ui.details

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.dk.mobiledevicemanagementapp.R
import com.dk.mobiledevicemanagementapp.databinding.ActivityDetailsBinding
import com.dk.mobiledevicemanagementapp.databinding.ActivityMainBinding
import com.dk.mobiledevicemanagementapp.models.MobileListItem

class DetailsActivity : AppCompatActivity() {

    lateinit var mobileListItem: MobileListItem
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // This line gives us the product
        // Make sure to use the same key as in HomeFragment
        mobileListItem = intent.getParcelableExtra<MobileListItem>("mobileItem")!!

        // calling the action bar
        // calling the action bar
        var actionBar = getSupportActionBar()

        if (actionBar != null) {

            // Customize the back button
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24);

            // showing the back button in action bar
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.title = "Details: "+mobileListItem.name
        }



        setValue(mobileListItem,binding)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun setValue(mobileListItem: MobileListItem,binding: ActivityDetailsBinding){
        binding.tvName.text = "Name - "+mobileListItem.name
        binding.tvOS.text = "OS - "+mobileListItem.OS
        binding.tvStatus.text = "Status - "+mobileListItem.status
        binding.tvSize.text = "Size - "+mobileListItem.size
        binding.rating.rating = mobileListItem.review
    }


}