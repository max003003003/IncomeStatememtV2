package com.max.incomestatement.util;

import android.content.Context;

import com.max.incomestatement.AppExecutors;
import com.max.incomestatement.data.IncomeStatementRepository;
import com.max.incomestatement.database.IncomeStatementDatabase;
import com.max.incomestatement.ui.AddWalletActivity.AddWalletActivityFactory;
import com.max.incomestatement.ui.AddWalletActivity.AddWalletActivityViewModel;
import com.max.incomestatement.ui.MainActivity.MainActivityViewModelFactory;
import com.max.incomestatement.ui.WalletTransactionActivity.WalletTransactionViewModelFactory;

/**
 * Created by Max on 3/1/2018.
 */

public class InJectorUtils {
    public static IncomeStatementRepository provideRepository(Context context) {
        IncomeStatementDatabase database = IncomeStatementDatabase.getsInstance(context.getApplicationContext());
        AppExecutors executors = AppExecutors.getInstance();

        return IncomeStatementRepository.getInstance(database.weatherDao(), executors);
    }
    public static MainActivityViewModelFactory provideMainActivityViewModelFactory(Context context) {
        IncomeStatementRepository repository = provideRepository(context.getApplicationContext());
        return new MainActivityViewModelFactory(repository);
    }

    public static AddWalletActivityFactory provideAddActivityViewModelFactory(Context context) {
        IncomeStatementRepository repository = provideRepository(context.getApplicationContext());
        return new AddWalletActivityFactory(repository);
    }

    public static WalletTransactionViewModelFactory provideWalletTransactionViewModelFactory (Context context) {
        IncomeStatementRepository repository = provideRepository(context.getApplicationContext());
        return new WalletTransactionViewModelFactory(repository);
    }

}
