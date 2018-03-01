package com.max.incomestatement.ui.AddWalletActivity;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.max.incomestatement.data.IncomeStatementRepository;

/**
 * Created by Max on 3/1/2018.
 */

public class AddWalletActivityFactory extends ViewModelProvider.NewInstanceFactory {
    private final IncomeStatementRepository mRepository;


    public AddWalletActivityFactory(IncomeStatementRepository mRepository) {
        this.mRepository = mRepository;
    }

    @Override
    public <T extends ViewModel> T create (Class<T> modelClass){
        return (T) new AddWalletActivityViewModel(mRepository);

    }
}
