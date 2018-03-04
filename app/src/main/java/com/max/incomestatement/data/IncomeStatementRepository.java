package com.max.incomestatement.data;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.max.incomestatement.AppExecutors;
import com.max.incomestatement.database.WalletDao;
import com.max.incomestatement.model.Wallet;

import java.util.List;

/**
 * Created by Max on 3/1/2018.
 */

public class IncomeStatementRepository {

        private static final String LOG_TAG = IncomeStatementRepository.class.getSimpleName();

        // For Singleton instantiation
        private static final Object LOCK = new Object();
        private static IncomeStatementRepository sInstance;
        private final WalletDao mWalletDao;

        private final AppExecutors mExecutors;
        private boolean mInitialized = false;

        private IncomeStatementRepository(WalletDao walletDao,
                                   AppExecutors executors) {
            mWalletDao = walletDao;
            mExecutors = executors;
        }


        public synchronized static IncomeStatementRepository getInstance(
                WalletDao walletDao,  AppExecutors executors) {
            Log.d(LOG_TAG, "Getting the repository");
            if (sInstance == null) {
                synchronized (LOCK) {
                    sInstance = new IncomeStatementRepository(walletDao, executors);
                    Log.d(LOG_TAG, "Made new repository");
                }
            }
            return sInstance;
        }

        public  LiveData<List<com.max.incomestatement.model.Wallet>> getCurrentWallet() {

            return mWalletDao.getWallet();
        }

        public synchronized void addNewWallet(Wallet wallet){
            synchronized (LOCK) {
                mExecutors.diskIO().execute(() -> {
                    mWalletDao.bulkInsert(wallet);

                });
            }
            notify();

        }
}
