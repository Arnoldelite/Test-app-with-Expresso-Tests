package com.vogella.android.testapp;


import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/*import android.app.Application;
import android.test.ApplicationTestCase;
*/
/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
/*public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
}*/


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ApplicationTest {

    private String mStringToBetyped;
    private String compare;
    private UiDevice mDevice;
    private String mStringToBetyped2;
    private String mStringToBetyped3;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initParam() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
        mStringToBetyped2 = "Flick";
        mStringToBetyped3 = "Testing a longer text in the text field just to see how long it takes";
        compare = " "+"is Extremely Awesome" ;
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        try {
            mDevice.setOrientationNatural();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }




        @Test
        public void changeText_Activity() {

            try {
                mDevice.setOrientationLeft();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            // Type text and then press the button.
            onView(withId(R.id.edit_message))
                    .perform(typeText(mStringToBetyped), closeSoftKeyboard());
            //onView(withId(R.id.page_1)).perform(click());
            onView(withText("Send")).perform(click());
            // Check that the text was changed.
            onView(withId(R.id.display))
                    .check(matches(withText(mStringToBetyped + compare)));
        }

        @Test
        public void changeOrientation_Activity() {

            try {
                mDevice.setOrientationNatural();
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            // Type text and then press the button.
            onView(withId(R.id.edit_message))
                    .perform(typeText(mStringToBetyped2), closeSoftKeyboard());
            //onView(withId(R.id.page_1)).perform(click());
            onView(withText("Send")).perform(click());
            // Check that the text was changed.
            onView(withId(R.id.display))
                    .check(matches(withText(mStringToBetyped2 + compare)));
        }


    @Test
    public void changeTextSize_Activity() {

        try {
            mDevice.setOrientationNatural();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        // Type text and then press the button.
        onView(withId(R.id.edit_message))
                .perform(typeText(mStringToBetyped3), closeSoftKeyboard());
        //onView(withId(R.id.page_1)).perform(click());
        onView(withText("Send")).perform(click());
        // Check that the text was changed.
        onView(withId(R.id.display))
                .check(matches(withText(mStringToBetyped3 + compare)));
    }


    @Test
    public void changeOrientation2_Activity() {

        try {
            mDevice.setOrientationRight();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        // Type text and then press the button.
        onView(withId(R.id.edit_message))
                .perform(typeText(mStringToBetyped3), closeSoftKeyboard());
        //onView(withId(R.id.page_1)).perform(click());
        onView(withText("Send")).perform(click());
        // Check that the text was changed.
        onView(withId(R.id.display))
                .check(matches(withText(mStringToBetyped3 + compare)));
    }

}