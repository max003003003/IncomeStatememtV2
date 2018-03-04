package com.max.incomestatement;

import android.app.Activity;

import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.max.incomestatement.ui.AddWalletActivity.EditWalletActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

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

        activity.findViewById(R.id.action_save).performClick();


    }



}
