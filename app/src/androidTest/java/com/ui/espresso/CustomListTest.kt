package com.ui.espresso

import android.util.Log
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.ui.espresso.bases.CustomListActivityBase
import com.ui.espresso.bases.TestBase
import com.ui.espresso.matchers.CustomMatchers
import com.ui.espresso.models.BookData
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Test

/**
 * @author  HDunn, Modified on 5/12/21.
 *
 * TEST - WORK TO TAKE ALL CONSTANTS (integers too)
 * AND MOVE INTO - /androidTest/java/com/ui/espresso/models/BookData.kt
 * ONLY REFACTOR ONE TEST BELOW - testClickOnBookByPosition TO PASS
 * git commit results
 *
 */
class CustomListTest : TestBase() {


    @Before
    fun navigateToBooksList(){
        Log.i("Navigate","runs now")
    }

    @Test
    fun testOpenBookById() {
        Log.i("test","starting test open book")

        Espresso.onView(ViewMatchers.withId(R.id.custom_list_adapter_button)).perform(ViewActions.click())

        // Click on the Book with ID 5
        Espresso.onData(CustomMatchers.withBookId(BookData.openBookId5)).perform(ViewActions.click())

        // Check the correct book title is displayed
        Espresso.onView(ViewMatchers.withId(R.id.book_title)).check(ViewAssertions.matches(ViewMatchers.withText(BookData.bookTitle5)))

        // Check the correct author is displayed
        Espresso.onView(ViewMatchers.withId(R.id.book_author)).check(ViewAssertions.matches(ViewMatchers.withText(BookData.bookAuthor5)))
    }

    @Test
    fun testOpenBookByTitleAndAuthor() {

        Espresso.onView(ViewMatchers.withId(R.id.custom_list_adapter_button)).perform(ViewActions.click())

        // Match a book with a specific title and author name
        Espresso.onData(CoreMatchers.allOf(CustomMatchers.withBookTitle(BookData.bookTitle5), CustomMatchers.withBookAuthor(BookData.bookAuthor5))).perform(ViewActions.click())

        // Check the correct book title is displayed
        Espresso.onView(ViewMatchers.withId(R.id.book_title)).check(ViewAssertions.matches(ViewMatchers.withText(BookData.bookTitle5)))

        // Check the correct author is displayed
        Espresso.onView(ViewMatchers.withId(R.id.book_author)).check(ViewAssertions.matches(ViewMatchers.withText(BookData.bookAuthor5)))
    }

    @Test
    fun testClickOnBookByPosition() {
        Espresso.onView(ViewMatchers.withId(R.id.custom_list_adapter_button)).perform(ViewActions.click())
        Espresso.onData(CoreMatchers.anything()).atPosition(BookData.position5).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.book_title)).check(ViewAssertions.matches(ViewMatchers.withText(BookData.bookTitle5)))
        Espresso.onView(ViewMatchers.withId(R.id.book_author)).check(ViewAssertions.matches(ViewMatchers.withText(BookData.bookAuthor5)))
    }

    //companion object {
        // MOVE and add to STRINGS IN BookData
        //private const val BOOK_TITLE = "Java Concurrency in Practice"
        //private const val BOOK_AUTHOR = "Brian Goetz"
    //}
}
