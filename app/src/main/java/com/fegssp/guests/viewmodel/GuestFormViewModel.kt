package com.fegssp.guests.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fegssp.guests.model.GuestModel
import com.fegssp.guests.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    private val guestModel = MutableLiveData<GuestModel>()
    var guest : LiveData<GuestModel> = guestModel

    private val _saveGuest = MutableLiveData<String>()
    var saveGuest : LiveData<String> = _saveGuest

    fun save(guest: GuestModel){
        if (guest.id == 0){
            if(repository.insert(guest)){
                _saveGuest.value = "Inserção com sucesso"
            }else{
                _saveGuest.value = "Falha"
            }
        }else{
            if(repository.update(guest)){
                _saveGuest.value = "Atualizado com sucesso"
            }else{
                _saveGuest.value = "Falha"
            }
        }
    }

    fun getGuest(guestID: Int){
        guestModel.value = repository.getGuest(guestID)
    }
}