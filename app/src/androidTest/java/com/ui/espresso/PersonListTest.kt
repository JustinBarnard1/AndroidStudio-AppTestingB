package com.ui.espresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.ui.espresso.bases.TestBase
import com.ui.espresso.matchers.CustomMatchers
import org.hamcrest.CoreMatchers
import org.junit.Test

/**
 *   WORK HERE AND CODE AS MUCH TESTING AS YOU WANT
 *   - verify like "Code Master" is displayed
 *   - verify like flaticon is in view.
 *   - verify age or message for "tester"
 */
class PersonListTest : TestBase() {
    // WORK HERE test-c
    @Test
    fun testIsFlaticonDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.person_list_adapter_button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.person_list_footer)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun testClickOnPersonAtPosition() {
        Espresso.onView(ViewMatchers.withId(R.id.person_list_adapter_button)).perform(ViewActions.click())
        Espresso.onData(CoreMatchers.anything()).atPosition(1).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.person_name)).check(ViewAssertions.matches(ViewMatchers.withText(PERSON_NAME)))
        Espresso.onView(ViewMatchers.withId(R.id.person_messages)).check(ViewAssertions.matches(ViewMatchers.withText(PERSON_MESSAGE)))
    }

    @Test
    fun testClickOnPersonByName(){
        Espresso.onView(ViewMatchers.withId(R.id.person_list_adapter_button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText(PERSON_NAME)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.person_name)).check(ViewAssertions.matches(ViewMatchers.withText(PERSON_NAME)))
    }

    companion object {
        private const val PERSON_NAME = "Code Master"
        private const val PERSON_MESSAGE = "[I am Kotlin Master, still learning Kotlin]"
        private const val PERSON_AGE = 30
    }

}
