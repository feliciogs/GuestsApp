package com.fegssp.guests.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fegssp.guests.model.GuestModel
import com.fegssp.guests.repository.GuestRepository

class GuestsViewlModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application.applicationContext)
    private val listAllGuest = MutableLiveData<List<GuestModel>>()
    val guests: LiveData<List<GuestModel>> = listAllGuest

    fun getAll(){
        listAllGuest.value = repository.getAll()
    }

    fun getAbsent(){
        listAllGuest.value = repository.getAbsent()
    }
    fun getPresent(){
        listAllGuest.value = repository.getPresent()
    }

    fun delete(id:Int){
        repository.delete(id)
    }
}