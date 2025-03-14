package com.zybooks.giftloop.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.zybooks.giftloop.data.model.Gift;
import java.util.List;

@Dao
public interface GiftDao {
    @Insert
    void insert(Gift gift);

    @Delete
    void delete(Gift gift);

    @Query("SELECT * FROM gift_table")
    LiveData<List<Gift>> getAllGifts();

    @Query("SELECT * FROM gift_table WHERE id = :giftId")
    LiveData<Gift> getGiftById(int giftId);

    @Query("SELECT * FROM gift_table WHERE status = :status")
    LiveData<List<Gift>> getGiftsByStatus(String status);
}
