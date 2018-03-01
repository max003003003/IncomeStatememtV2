package com.max.incomestatement.ui.MainActivity;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.max.incomestatement.data.IncomeStatementRepository;
import com.max.incomestatement.ui.MainActivity.MainActivityViewModel;

/**
 * Created by Max on 3/1/2018.
 */

public class MainActivityViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final IncomeStatementRepository mRepository;


    public MainActivityViewModelFactory(IncomeStatementRepository mRepository) {
        this.mRepository = mRepository;
    }

    @Override
    public <T extends ViewModel> T create (Class<T> modelClass){
        return (T) new MainActivityViewModel(mRepository);
    }
}
