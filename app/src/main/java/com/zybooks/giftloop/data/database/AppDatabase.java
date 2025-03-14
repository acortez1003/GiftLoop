package com.zybooks.giftloop.data.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.zybooks.giftloop.data.model.User;
import com.zybooks.giftloop.data.model.Gift;
import com.zybooks.giftloop.data.model.Group;

@Database(entities = {User.class, Gift.class, Group.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static
}
