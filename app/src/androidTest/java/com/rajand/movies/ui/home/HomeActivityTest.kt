package com.rajand.movies.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.rajand.movies.R
import com.rajand.movies.utils.DataDummy
import com.rajand.movies.utils.EspressoIdlingResource
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummySeries = DataDummy.generateDummySeries()
    private val dummyEpisodes = DataDummy.generateDummyEpisodes(dummySeries[0].id)

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_title_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_movie)).check(matches(withText(dummyMovies[0].title)))

        onView(withId(R.id.tv_description_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_movie)).check(matches(withText(dummyMovies[0].description)))

        onView(withId(R.id.tv_genres_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genres_movie)).check(matches(withText(dummyMovies[0].genres)))

        onView(withId(R.id.tv_realese_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_realese_movie)).check(matches(withText(dummyMovies[0].realese)))

        onView(withId(R.id.tv_rating_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating_movie)).check(matches(withText(dummyMovies[0].rating.toString())))
    }

    @Test
    fun loadSeries() {
        onView(withId(R.id.navigation_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_tvshow)).perform(click())

        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummySeries.size))
    }

    @Test
    fun loadDetailSeries() {
        onView(withId(R.id.navigation_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_tvshow)).perform(click())

        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withIndex(withId(R.id.btn_item_read_tvshow), 0)).perform(click())

        onView(withId(R.id.tv_title_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_series)).check(matches(withText(dummySeries[0].title)))

        onView(withId(R.id.tv_description_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_series)).check(matches(withText(dummySeries[0].description)))

        onView(withId(R.id.tv_genres_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genres_series)).check(matches(withText(dummySeries[0].genres)))

        onView(withId(R.id.tv_realese_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_realese_series)).check(matches(withText(dummySeries[0].realese)))

        onView(withId(R.id.tv_rating_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating_series)).check(matches(withText(dummySeries[0].rating.toString())))
    }

    @Test
    fun loadEpisodes() {
        onView(withId(R.id.navigation_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_tvshow)).perform(click())

        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withIndex(withId(R.id.btn_item_read_tvshow), 0)).perform(click())

        onView(withId(R.id.btn_start_series)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_start_series)).perform(click())

        onView(withId(R.id.rv_episode)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_episode)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyEpisodes.size))
    }

    @Test
    fun loadDetailEpisode() {
        onView(withId(R.id.navigation_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_tvshow)).perform(click())

        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withIndex(withId(R.id.btn_item_read_tvshow), 0)).perform(click())

        onView(withId(R.id.btn_start_series)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_start_series)).perform(click())

        onView(withId(R.id.rv_episode)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_episode)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.web_view)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavorites() {
        onView(withId(R.id.navigation_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_tvshow)).perform(click())

        onView(withIndex(withId(R.id.btn_item_read_tvshow), 0)).perform(click())
        onView(withId(R.id.action_favorite)).perform(click())

        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.navigation_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_favorite)).perform(click())

        onView(withIndex(withId(R.id.btn_item_read_favorite), 0)).perform(click())

        onView(withId(R.id.tv_title_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_series)).check(matches(withText(dummySeries[0].title)))

        onView(withId(R.id.tv_description_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_series)).check(matches(withText(dummySeries[0].description)))

        onView(withId(R.id.tv_genres_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genres_series)).check(matches(withText(dummySeries[0].genres)))

        onView(withId(R.id.tv_realese_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_realese_series)).check(matches(withText(dummySeries[0].realese)))

        onView(withId(R.id.tv_rating_series)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating_series)).check(matches(withText(dummySeries[0].rating.toString())))

        onView(withId(R.id.action_favorite)).perform(click())

        onView(isRoot()).perform(ViewActions.pressBack())
    }

    // Mencari button dengan index di dalam RecyclerView
    private fun withIndex(matcher: Matcher<View?>, index: Int): Matcher<View?> {
        return object : TypeSafeMatcher<View?>() {
            var currentIndex = 0
            override fun describeTo(description: Description) {
                description.appendText("with index: ")
                description.appendValue(index)
                matcher.describeTo(description)
            }

            override fun matchesSafely(view: View?): Boolean {
                return matcher.matches(view) && currentIndex++ == index
            }
        }
    }

}