package com.max.incomestatement.ui.WalletTransactionActivity;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.max.incomestatement.R;

import com.max.incomestatement.ui.AddWalletActivity.EditWalletActivity;
import com.max.incomestatement.util.InJectorUtils;

public class WalletTransactionActivity extends AppCompatActivity {

    public static final String WALLET_TRANSACTION_EXTRA = "WALLET_TRANSACTION_EXTRA";
    private AppCompatImageView iconimage;
    private TextView balancetv;
    private String balanceString;
    private Context contex;
    private ListView transactionListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        iconimage =(AppCompatImageView) findViewById(R.id.iconwallet);
        transactionListView=(ListView) findViewById(R.id.transaction_listview);
        balancetv=(TextView) findViewById(R.id.balancewallet);

//        transactionCursorAdapter = new TransactionCursorAdapter(this,null);
//        transactionListView.setAdapter(transactionCursorAdapter);
//
//        transactionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
//
//                Intent intent = new Intent(WalletActivity.this, EditTransaction.class);
//                TextView transid=(TextView) view.findViewById(R.id.transaction_row_transaction_id);
//                intent.setData(mCurrentWalletUri);
//                intent.putExtra("transactionID",transid.getText());
//                intent.putExtra("balance", balanceString);
//                intent.putExtra("walletid",walletid);
//                intent.putExtra("mode",3);
//                startActivity(intent);
//            }
//        });
//
//        getContentResolver().query( TransactionContract.TransactionEntry.CONTENT_URI ,
//                TransactionContract.TransactionEntry.projection,
//                TransactionContract.TransactionEntry.COLUMN_TRANSACTION_WALLET_ID+" =  "+walletid ,
//                null,null);
//
//
//
//
//        getLoaderManager().initLoader(EXISTING_WALLET_LOADER,null,new WalletLoader());
//        getLoaderManager().initLoader(EXISTING_TRANSACTION_LOADER,null,new TransactionLoader());
//
//
//

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("test","createOptionMenu");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_wallet,menu );
        return true;
    }

}
