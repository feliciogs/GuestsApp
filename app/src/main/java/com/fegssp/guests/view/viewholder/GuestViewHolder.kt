package com.fegssp.guests.view.viewholder

import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.fegssp.guests.databinding.RowGuestsBinding
import com.fegssp.guests.model.GuestModel
import com.fegssp.guests.view.listener.OnGuestListener

class GuestViewHolder(private val bind: RowGuestsBinding,private val listener: OnGuestListener) : RecyclerView.ViewHolder(bind.root) {

    fun bind(guest:GuestModel){
        bind.textName.text = guest.name

        bind.textName.setOnClickListener {
            listener.onClick(guest.id)
        }
        bind.textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de Convidado")
                .setMessage("Tem certeza que deseja remover?")
                .setPositiveButton("Sim") {
                        dialog, p1 ->  listener.onDelete(guest.id)
                }
                .setNegativeButton("Não",null)
                .create()
                .show()
            true
        }
    }
}