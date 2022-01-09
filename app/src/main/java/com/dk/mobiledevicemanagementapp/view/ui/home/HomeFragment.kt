package com.dk.mobiledevicemanagementapp.view.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dk.mobiledevicemanagementapp.databinding.FragmentHomeBinding
import com.dk.mobiledevicemanagementapp.models.MobileListItem
import com.dk.mobiledevicemanagementapp.view.ui.details.DetailsActivity
import com.dk.mobiledevicemanagementapp.viewmodels.event.CellClickListener
import com.dk.mobiledevicemanagementapp.viewmodels.home.HomeViewModelFactory
import com.dk.mobiledevicemanagementapp.models.SearchQueryEvent

import org.greenrobot.eventbus.ThreadMode

import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.EventBus








class HomeFragment : Fragment(), CellClickListener {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val adapter = MainAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
            ViewModelProvider(this,HomeViewModelFactory(requireActivity().application))
                .get(HomeViewModel::class.java)


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.recyclerview.adapter = adapter
        setMobileList(homeViewModel.getDeviceList())
        return root
    }

    fun setMobileList(mobileList:Array<MobileListItem>){
        adapter.addData(mobileList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCellClickListener(mobileListItem: MobileListItem) {
        startActivity(Intent(context, DetailsActivity::class.java).putExtra("mobileItem", mobileListItem))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSearchQuery(event: SearchQueryEvent) {
        val query = event.query
        adapter.getFilter().filter(query)
     //   adapter.filter.filter(newText)
        //adapter.getFilter().filter(query)
    }

    override fun onResume() {
        super.onResume()
        EventBus.getDefault().register(this)
    }

    override fun onPause() {
        EventBus.getDefault().unregister(this)
        super.onPause()
    }
}