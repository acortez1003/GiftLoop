package com.zybooks.giftloop.data.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.zybooks.giftloop.data.database.AppDatabase;
import com.zybooks.giftloop.data.database.UserDao;
import com.zybooks.giftloop.data.model.User;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRepository {
    private final UserDao userDao;
    private final LiveData<List<User>> allUsers;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public UserRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        userDao = database.userDao();
        allUsers = userDao.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public LiveData<User> getUsersById(int userId) {
        return userDao.getUserById(userId);
    }

    public void insert(User user) {
        executorService.execute(() -> userDao.insert(user));
    }

    public void delete(User user) {
        executorService.execute(() -> userDao.delete(user));
    }
}
