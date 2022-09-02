package com.fegssp.guests.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.fegssp.guests.model.GuestModel
import com.fegssp.guests.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    fun insert(guest: GuestModel){
        repository.insert(guest)
    }
}