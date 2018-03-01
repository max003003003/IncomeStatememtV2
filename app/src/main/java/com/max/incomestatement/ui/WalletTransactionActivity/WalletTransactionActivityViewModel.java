package com.max.incomestatement.ui.WalletTransactionActivity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.max.incomestatement.data.IncomeStatementRepository;
import com.max.incomestatement.model.Wallet;

import java.util.List;

/**
 * Created by Max on 3/1/2018.
 */



public class WalletTransactionActivityViewModel extends ViewModel{
    private final LiveData<List<Wallet>> mWallet;
    private final IncomeStatementRepository mRepository;

    public WalletTransactionActivityViewModel(IncomeStatementRepository repository) {
        mRepository = repository;
        mWallet = mRepository.getCurrentWallet();
    }

    public LiveData<List<Wallet>> getWallet(){ return mWallet;}
 }
