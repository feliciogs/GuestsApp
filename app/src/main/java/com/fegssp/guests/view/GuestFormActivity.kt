package com.fegssp.guests.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fegssp.guests.model.GuestModel
import com.fegssp.guests.viewmodel.GuestFormViewModel
import com.fegssp.guests.R
import com.fegssp.guests.contants.DataBaseConstants
import com.fegssp.guests.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var binding: ActivityGuestFormBinding
    lateinit var viewModel: GuestFormViewModel
    private var guestID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)
        binding.btnSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true

        observe()
        loadData()

    }

    override fun onClick(v: View) {
        if(v.id == R.id.btn_save){
            val name = binding.edtName.text.toString()
            val presence = binding.radioPresent.isChecked

            val model = GuestModel(guestID,name,presence)
            viewModel.save(model)
        }
    }

    private fun observe(){
        viewModel.guest.observe(this, Observer {
            binding.edtName.setText(it.name)

            if(it.presence){
                binding.radioPresent.isChecked = true
            }else{
                binding.radioAbsent.isChecked = true
            }
        })

        viewModel.saveGuest.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            finish()
        })
    }

    private fun loadData(){
        val bundle = intent.extras

        if(bundle != null){
            guestID = bundle.getInt(DataBaseConstants.GUEST.ID)
            viewModel.getGuest(guestID)
        }
    }
}