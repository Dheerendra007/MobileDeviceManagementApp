package com.dk.mobiledevicemanagementapp.view.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.dk.mobiledevicemanagementapp.databinding.AdapterMobileBinding

import com.dk.mobiledevicemanagementapp.models.MobileListItem
import com.dk.mobiledevicemanagementapp.viewmodels.event.CellClickListener

class MainAdapter( val cellClickListener: CellClickListener): RecyclerView.Adapter<MainViewHolder>() {

    var device = mutableListOf<MobileListItem>()
    var deviceListFiltered= mutableListOf<MobileListItem>()
    var isValue = false

    init {
        isValue = true

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterMobileBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val device = deviceListFiltered[position]
        holder.binding.tvname.text = device.name
        holder.binding.tvstatus.text = "Status:"+device.status
    //    Glide.with(holder.itemView.context).load(device.imageUrl).into(holder.binding.ivmobile)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(device)
        }

    }

    /* fun setMovieList(movies: Array<MobileListItem>) {
     this.device = movies.toMutableList()
     notifyDataSetChanged()
 }*/

    fun addData(list: Array<MobileListItem>) {
        device = list.toMutableList()
        deviceListFiltered = device
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return deviceListFiltered.size
    }

     fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""
                if (charString.isEmpty()) deviceListFiltered =
                    device as ArrayList<MobileListItem> else {
                    val filteredList = ArrayList<MobileListItem>()
                    device
                        .filter {
                            (it.Id.contains(constraint!!)) or
                                    (it.name.contains(constraint))

                        }
                        .forEach { filteredList.add(it) }
                    deviceListFiltered = filteredList

                }
                return FilterResults().apply { values = deviceListFiltered }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                deviceListFiltered = if (results?.values == null)
                    ArrayList()
                else
                    results.values as ArrayList<MobileListItem>
                notifyDataSetChanged()
            }
        }
    }

    fun valueFound():Boolean{
        if(device.size>0){
            return true
        }else{
            return false
        }
    }

    fun objectFound():Boolean{
       return isValue
    }
}

class MainViewHolder(val binding: AdapterMobileBinding) : RecyclerView.ViewHolder(binding.root) {

}
