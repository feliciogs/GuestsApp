package com.fegssp.guests.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fegssp.guests.databinding.RowGuestsBinding
import com.fegssp.guests.model.GuestModel
import com.fegssp.guests.view.listener.OnGuestListener
import com.fegssp.guests.view.viewholder.GuestViewHolder

class GuestsAdapter: RecyclerView.Adapter<GuestViewHolder>() {
    private var guestList: List<GuestModel> = listOf()
    private lateinit var listener: OnGuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = RowGuestsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GuestViewHolder(item,listener)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(guestList[position])
    }

    override fun getItemCount(): Int {
        return guestList.count()
    }

    fun updateGuests(list: List<GuestModel>){
        guestList = list
        notifyDataSetChanged()
    }

    fun attachListener(guestListener:OnGuestListener){
        listener = guestListener
    }
}