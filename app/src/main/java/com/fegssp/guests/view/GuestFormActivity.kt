package com.fegssp.guests.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.fegssp.guests.model.GuestModel
import com.fegssp.guests.viewmodel.GuestFormViewModel
import com.fegssp.guests.R
import com.fegssp.guests.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var binding: ActivityGuestFormBinding
    lateinit var viewModel: GuestFormViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)
        binding.btnSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true

    }

    override fun onClick(v: View) {
        if(v.id == R.id.btn_save){
            val name = binding.edtName.text.toString()
            val presence = binding.radioPresent.isChecked

            viewModel.insert(GuestModel(0,name,presence))
        }
    }
}