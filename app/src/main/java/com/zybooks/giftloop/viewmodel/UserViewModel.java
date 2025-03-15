package com.zybooks.giftloop.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.zybooks.giftloop.data.model.User;
import com.zybooks.giftloop.data.repository.UserRepository;
import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private final UserRepository userRepository;
    private final LiveData<List<User>> allUsers;

    public UserViewModel(Application application) {
        super(application);
        userRepository = new UserRepository(application);
        allUsers = userRepository.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public LiveData<User> getUserById(int userId) {
        return userRepository.getUsersById(userId);
    }

    public void insert(User user) {
        userRepository.insert(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
