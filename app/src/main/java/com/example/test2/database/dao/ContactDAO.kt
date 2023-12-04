package com.example.test2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(contacts: Contacts):Long

    @Query("SELECT * FROM CONTACTS")
    suspend fun getAllContacts():List<Contacts>

    @Query("SELECT * FROM CONTACTS WHERE ID=:id")

    suspend fun getContactByID(id:Int):Contacts

    //@Update
    //suspend fun update(contacts: Contacts)

    @Delete
    suspend fun delete(contacts: Contacts)
}