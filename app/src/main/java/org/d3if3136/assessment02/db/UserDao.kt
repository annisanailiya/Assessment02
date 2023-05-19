package org.d3if3136.assessment02.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insert(user: UserEntity)

    @Query("SELECT * FROM user ORDER BY id DESC")
    fun getLastUser(): LiveData<List<UserEntity>>
}