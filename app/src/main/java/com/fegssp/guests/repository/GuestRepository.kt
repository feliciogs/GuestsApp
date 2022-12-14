package com.fegssp.guests.repository

import android.content.ContentValues
import android.content.Context
import com.fegssp.guests.contants.DataBaseConstants
import com.fegssp.guests.model.GuestModel
import java.lang.Exception

class GuestRepository(context: Context) {

    private val guestDataBase = GuestDataBase.getDataBase(context).guestDAO()

    fun insert(guest: GuestModel):Boolean{
        return guestDataBase.insert(guest) > 0
        /*return try {
            val db = guestDataBase.writableDatabase
            val presence = if(guest.presence) 1 else 0

            val values = ContentValues()
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME,guest.name)
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE,presence)

            db.insert(DataBaseConstants.GUEST.TABLE_NAME,null,values)
            true
        }catch (e: Exception){
            false
        }*/
    }

    fun update(guest: GuestModel):Boolean{
        return guestDataBase.update(guest) > 0
        /*try {
            val db = guestDataBase.writableDatabase
            val presence = if(guest.presence)1 else 0

            val values = ContentValues()

            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(guest.id.toString())

            db.update(DataBaseConstants.GUEST.TABLE_NAME,values,selection,args)
            return true
        }catch (e:Exception){
            return false
        }*/
    }

    fun delete(id: Int){
        val guest = getGuest(id)
        guestDataBase.delete(guest)
        /*return try {
            val db = guestDataBase.writableDatabase

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.GUEST.TABLE_NAME,selection,args)
            true
        }catch (e:Exception){
            false
        }*/
    }

    fun getAll(): List<GuestModel>{
        return guestDataBase.getAll()
        /*var listGuest = mutableListOf<GuestModel>()
        try {
            val db = guestDataBase.readableDatabase

            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )
            val cursor = db.query(DataBaseConstants.GUEST.TABLE_NAME,projection,null,null,null,null,null)

            if(cursor != null && cursor.count > 0){
                while (cursor.moveToNext()){
                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))

                    val guest = GuestModel(id,name,presence == 1)
                    listGuest.add(guest)
                }
            }
            cursor.close()
        }catch (e:Exception){
            return listGuest
        }
        return listGuest*/
    }

    fun getPresent(): List<GuestModel>{
        return guestDataBase.getPresent()
        /*var listGuest = mutableListOf<GuestModel>()
        try {
            val db = guestDataBase.readableDatabase

            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )
            val selection = DataBaseConstants.GUEST.COLUMNS.PRESENCE + " = ?"
            val args = arrayOf("1")

            val cursor = db.query(DataBaseConstants.GUEST.TABLE_NAME,projection,selection,args,null,null,null)

            if(cursor != null && cursor.count > 0){
                while (cursor.moveToNext()){
                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))

                    val guest = GuestModel(id,name,presence == 1)
                    listGuest.add(guest)
                }
            }
            cursor.close()
        }catch (e:Exception){
            return listGuest
        }
        return listGuest*/
    }

    fun getAbsent(): List<GuestModel>{
        return guestDataBase.getAbsent()
        /*var listGuest = mutableListOf<GuestModel>()
        try {
            val db = guestDataBase.readableDatabase

            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )
            val selection = DataBaseConstants.GUEST.COLUMNS.PRESENCE + " = ?"
            val args = arrayOf("0")

            val cursor = db.query(DataBaseConstants.GUEST.TABLE_NAME,projection,selection,args,null,null,null)

            if(cursor != null && cursor.count > 0){
                while (cursor.moveToNext()){
                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))

                    val guest = GuestModel(id,name,presence == 1)
                    listGuest.add(guest)
                }
            }
            cursor.close()
        }catch (e:Exception){
            return listGuest
        }
        return listGuest*/
    }

    fun getGuest(id: Int): GuestModel {
        return guestDataBase.getGuest(id)
        /*var guest : GuestModel? = null
        try {
            val db = guestDataBase.readableDatabase

            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            val cursor = db.query(DataBaseConstants.GUEST.TABLE_NAME,projection,selection,args,null,null,null)

            if(cursor != null && cursor.count > 0){
                while (cursor.moveToNext()){
                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))

                    guest = GuestModel(id,name,presence == 1)

                }
            }

            cursor.close()
        }catch (e:Exception){
            return guest
        }
        return guest*/
    }
}