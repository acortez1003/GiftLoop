package com.zybooks.giftloop.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.zybooks.giftloop.data.model.Group;
import com.zybooks.giftloop.data.repository.GroupRepository;
import java.util.List;

public class GroupViewModel extends AndroidViewModel {
    private final GroupRepository groupRepository;
    private final LiveData<List<Group>> allGroups;

    public GroupViewModel(Application application) {
        super(application);
        groupRepository = new GroupRepository(application);
        allGroups = groupRepository.getAllGroups();
    }

    public LiveData<List<Group>> getAllGroups() {
        return allGroups;
    }

    public LiveData<Group> getGroupById(int groupId) {
        return groupRepository.getGroupById(groupId);
    }

    public void insert(Group group) {
        groupRepository.insert(group);
    }

    public void delete(Group group) {
        groupRepository.delete(group);
    }
}
