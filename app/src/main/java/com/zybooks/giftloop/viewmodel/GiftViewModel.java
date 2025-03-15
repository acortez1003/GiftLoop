package com.zybooks.giftloop.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.zybooks.giftloop.data.model.Gift;
import com.zybooks.giftloop.data.repository.GiftRepository;
import java.util.List;

public class GiftViewModel extends AndroidViewModel {
    private final GiftRepository giftRepository;
    private final LiveData<List<Gift>> allGifts;

    public GiftViewModel(Application application) {
        super(application);
        giftRepository =  new GiftRepository(application);
        allGifts = giftRepository.getAllGifts();
    }

    public LiveData<List<Gift>> getAllGifts() {
        return allGifts;
    }

    public LiveData<Gift> getGiftById(int giftId) {
        return giftRepository.getGiftById(giftId);
    }

    public LiveData<List<Gift>> getGiftsByStatus(String status) {
        return giftRepository.getGiftsByStatus(status);
    }

    public void insert(Gift gift) {
        giftRepository.insert(gift);
    }

     public void delete(Gift gift) {
        giftRepository.delete(gift);
     }
}
