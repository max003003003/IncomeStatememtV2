package com.max.incomestatement.ui.AddWalletActivity;

import android.arch.lifecycle.ViewModel;

import com.max.incomestatement.data.IncomeStatementRepository;
import com.max.incomestatement.model.Wallet;

/**
 * Created by Max on 3/1/2018.
 */

public class AddWalletActivityViewModel extends ViewModel {

    private IncomeStatementRepository mRepository;
    public AddWalletActivityViewModel(IncomeStatementRepository repo)
    {
        mRepository=repo;
    }

    public void AddNewWallet(Wallet newWallet)
    {
        mRepository.addNewWallet(newWallet);


    }
}
