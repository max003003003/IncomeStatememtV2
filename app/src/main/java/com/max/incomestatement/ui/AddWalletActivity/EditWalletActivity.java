package com.max.incomestatement.ui.AddWalletActivity;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.max.incomestatement.R;
import com.max.incomestatement.model.Wallet;
import com.max.incomestatement.ui.MainActivity.MainActivityViewModelFactory;
import com.max.incomestatement.util.InJectorUtils;

public class EditWalletActivity extends AppCompatActivity {
    private  Spinner spinner;
    private  EditText name;
    private  EditText balance;
    private  ArrayAdapter<CharSequence> adapter;
    private  String itemvalue;
    private AddWalletActivityViewModel mViewModel;
    private  int mode=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_wallet);
        spinner = findViewById(R.id.spinner);
        name =  findViewById(R.id.nameIn);
        balance= findViewById(R.id.balanceIn);
        Button deleteButtom = findViewById(R.id.delete_wallet);
        AddWalletActivityFactory factory = InJectorUtils.provideAddActivityViewModelFactory(this.getApplicationContext());
        mViewModel = ViewModelProviders.of(this,factory).get(AddWalletActivityViewModel.class);

        setSpinner();
        if(mode == 1)
        {
            deleteButtom.setVisibility(View.GONE);
        }

    }


    private void setSpinner()
    {
        adapter = ArrayAdapter.createFromResource(this,R.array.array_wallter_option,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemvalue= adapterView.getItemAtPosition(i).toString() ;

                switch ((int) adapterView.getItemIdAtPosition(i))
                {
                    case 0: itemvalue = "ic_account_balance_wallet_white_24dp"; break;
                    case 1: itemvalue = "ic_account_balance_white_24dp"; break;
                    case 2: itemvalue = "local_atm_white_48x48"; break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void insertWallet(){

        if(mode==1) {
            String n = name.getText().toString().trim();
            Double b = Double.parseDouble(balance.getText().toString().trim());
            Wallet wallet = new Wallet(n,b,itemvalue,"th");
            mViewModel.AddNewWallet(wallet);

        }
        else{
            String n = name.getText().toString().trim();
            ContentValues values = new ContentValues();

        }
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("test","createOptionMenu");
        getMenuInflater().inflate(R.menu.edit_wallet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_save:
                 insertWallet();
                 finish();
                return true;

            case android.R.id.home:
                finish();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }




}
