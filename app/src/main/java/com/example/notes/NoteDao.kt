package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)      // suspend - so that this func runs on background thread

    @Delete
    suspend fun delete(note: Note)

    @Query("Select * From Notes_Table Order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}