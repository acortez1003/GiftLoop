package com.zybooks.giftloop.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.zybooks.giftloop.data.model.Group;
import java.util.List;

@Dao
public interface GroupDao {
    @Insert
    void insert(Group group);

    @Delete
    void delete(Group group);

    @Query("SELECT * FROM group_table")
    LiveData<List<Group>> getAllGroups();

    @Query("SELECT * FROM group_table WHERE id = :groupId")
    LiveData<Group> getGroupById(int groupId);
}
