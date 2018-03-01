package com.max.incomestatement.ui.MainActivity;

import com.max.incomestatement.ui.AddWalletActivity.EditWalletActivity;
import com.max.incomestatement.R;




import android.arch.lifecycle.LifecycleActivity;

import android.arch.lifecycle.ViewModelProviders;


import android.content.Intent;


import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ProgressBar;
import android.widget.Toolbar;
import android.view.View;

import com.max.incomestatement.ui.WalletTransactionActivity.WalletTransactionActivity;
import com.max.incomestatement.util.InJectorUtils;

public class MainActivity extends AppCompatActivity implements WalletAdapter.WalletAdapterOnItemClickHandler {
     private WalletAdapter mWalletAdapter;
     private RecyclerView mRecycleview;
     private int mPosition = RecyclerView.NO_POSITION;
     private MainActivityViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mRecycleview  =findViewById(R.id.walletListView);
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecycleview.setLayoutManager(layoutManager);
        mRecycleview.setHasFixedSize(true);
        mWalletAdapter = new WalletAdapter(this,this);
        mRecycleview.setAdapter(mWalletAdapter);
        MainActivityViewModelFactory factory = InJectorUtils.provideMainActivityViewModelFactory(this);
        mViewModel = ViewModelProviders.of(this,factory).get(MainActivityViewModel.class);
        mViewModel.getWallet().observe(this,wallets -> {
            mWalletAdapter.setWallet(wallets);
            if(mPosition == RecyclerView.NO_POSITION) mPosition=0;
            mRecycleview.smoothScrollToPosition(mPosition);

            if(wallets != null) showWalletDataView();
            else{
                showLoading();
            }
        });



        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,EditWalletActivity.class);
                startActivity(intent);
            }
        });


    }

    private void showWalletDataView(){

        mRecycleview.setVisibility(View.VISIBLE);
    }
    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("test","createOptionMenu");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_wallet,menu );
        return true;
    }

    @Override
    public void OnItemClick(int id) {
        Intent detail = new Intent(MainActivity.this, WalletTransactionActivity.class);
        detail.putExtra(WalletTransactionActivity.WALLET_TRANSACTION_EXTRA,id);
        startActivity(detail);
    }

    public void showLoading(){
        mRecycleview.setVisibility(View.INVISIBLE);

    }
}
