package com.zybooks.giftloop.data.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.zybooks.giftloop.data.database.AppDatabase;
import com.zybooks.giftloop.data.database.GiftDao;
import com.zybooks.giftloop.data.model.Gift;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GiftRepository {
    private final GiftDao giftDao;
    private final LiveData<List<Gift>> allGifts;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public GiftRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        giftDao = database.giftDao();
        allGifts = giftDao.getAllGifts();
    }

    public LiveData<List<Gift>> getAllGifts() {
        return allGifts;
    }

    public LiveData<Gift> getGiftById(int giftId) {
        return giftDao.getGiftById(giftId);
    }

    public LiveData<List<Gift>> getGiftsByStatus(String status) {
        return giftDao.getGiftsByStatus(status);
    }

    public void insert(Gift gift) {
        executorService.execute(() -> giftDao.insert(gift));
    }

    public void delete(Gift gift) {
        executorService.execute(() -> giftDao.delete(gift));
    }
}
