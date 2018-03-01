package com.max.incomestatement.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.max.incomestatement.model.Wallet;

import java.util.List;

/**
 * Created by Max on 3/1/2018.
 */
@Dao
public interface WalletDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(Wallet... wallets);

    @Query("SELECT * FROM wallet")
    LiveData<List<Wallet>> getWallet();

}
