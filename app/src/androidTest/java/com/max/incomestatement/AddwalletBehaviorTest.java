package com.max.incomestatement;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.TypeTextAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.max.incomestatement.ui.MainActivity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;
import android.support.test.espresso.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddwalletBehaviorTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(
            MainActivity.class
    );

    @Test
    public void shouldOpenAddWalletActivity(){

        Espresso.onView(withId(R.id.fab)).perform(click());
        Espresso.onView(withId(R.id.nameIn)).perform(typeText("SCB"));
        Espresso.onView(withId(R.id.balanceIn)).perform(typeText("5000"));
        Espresso.onView(withId(R.id.spinner)).perform(click());
        Espresso.onData(anything()).atPosition(1).perform(click());
        try {
            openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        } catch (Exception e) {
            //This is normal. Maybe we dont have overflow menu.
        }
        Espresso.onView(anyOf(   withId(R.id.action_save))).perform(click());


    }

}
