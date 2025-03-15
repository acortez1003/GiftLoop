package com.zybooks.giftloop.data.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.zybooks.giftloop.data.database.AppDatabase;
import com.zybooks.giftloop.data.database.GroupDao;
import com.zybooks.giftloop.data.model.Group;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GroupRepository {
    private final GroupDao groupDao;
    private final LiveData<List<Group>> allGroups;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public GroupRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        groupDao = database.groupDao();
        allGroups = groupDao.getAllGroups();
    }

    public LiveData<List<Group>> getAllGroups() {
        return allGroups;
    }

    public LiveData<Group> getGroupById(int groupId) {
        return groupDao.getGroupById(groupId);
    }

    public void insert(Group group) {
        executorService.execute(() -> groupDao.insert(group));
    }

    public void delete(Group group) {
        executorService.execute(() -> groupDao.delete(group));
    }
}
