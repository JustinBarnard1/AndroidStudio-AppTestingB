package com.vgrec.espressoexamples;

import androidx.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;

import com.vgrec.espressoexamples.activities.RecyclerViewActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author vgrec, created on 3/30/15.
 */
public class RecyclerViewTest extends ActivityInstrumentationTestCase2<RecyclerViewActivity> {

    private static final String BOOK_TITLE = "Clean Code";
    private static final String BOOK_AUTHOR = "Robert C. Martin";

    public RecyclerViewTest() {
        super(RecyclerViewActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickAtPosition() {
        // Perform a click on first element in the RecyclerView
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)));
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)));
    }

    public void testClickOnViewInRow() {
        // Perform click on an element with a specific text
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItem(
                hasDescendant(withText(BOOK_TITLE)), click()));

        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)));
    }
}