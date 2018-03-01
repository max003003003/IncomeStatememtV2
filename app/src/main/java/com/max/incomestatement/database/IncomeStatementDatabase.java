package com.max.incomestatement.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import com.max.incomestatement.model.Wallet;

/**
 * Created by Max on 3/1/2018.
 */
@Database(entities = {Wallet.class}, version =2)
public abstract class IncomeStatementDatabase extends RoomDatabase {
    private static  final String LOG_TAG =
            IncomeStatementDatabase.class.getSimpleName();
    private static  final String DATABASE_NAME = "weather";

    private static final Object LOCK = new Object();
    private static IncomeStatementDatabase sInstance;

    public static IncomeStatementDatabase
    getsInstance(Context context){
        Log.d(LOG_TAG, "Getting the database");
        if(sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        IncomeStatementDatabase.class, IncomeStatementDatabase.DATABASE_NAME).build();
                Log.d(LOG_TAG, "Made new database");
            }

        }
        return sInstance;
    }
    public abstract WalletDao weatherDao();

}
