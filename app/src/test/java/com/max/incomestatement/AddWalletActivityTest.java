package com.max.incomestatement;

import android.app.Activity;

import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.MenuItem;
import android.widget.EditText;

import com.max.incomestatement.data.IncomeStatementRepository;
import com.max.incomestatement.model.Wallet;
import com.max.incomestatement.ui.AddWalletActivity.AddWalletActivityViewModel;
import com.max.incomestatement.ui.AddWalletActivity.EditWalletActivity;
import com.max.incomestatement.util.InJectorUtils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.eq;


/**
 * Created by Max on 3/4/2018.
 */
@RunWith(RobolectricTestRunner.class)

public class AddWalletActivityTest {


    @Before
    public void setup(){

    }

    @SmallTest
    @Test public void shouldSaveWalletToRepository(){

     
       Activity activity = Robolectric.setupActivity(EditWalletActivity.class);
       EditText nameInput = (EditText) activity.findViewById(R.id.nameIn);
       EditText balanceInput = (EditText) activity.findViewById(R.id.balanceIn);
       nameInput.setText("SCB");
       balanceInput.setText("500");
      // Shadows.shadowOf( ).clickMenuItem(R.id.action_save);
       AddWalletActivityViewModel viewModel = InJectorUtils.provideAddActivityViewModelFactory(activity.getApplicationContext()).create(AddWalletActivityViewModel.class);

        IncomeStatementRepository repository = InJectorUtils.provideRepository(activity.getApplicationContext());
        repository.getCurrentWallet().getValue();
        assert(repository.getCurrentWallet().getValue().get(0).getName().equals("SCB"));
    }



}
