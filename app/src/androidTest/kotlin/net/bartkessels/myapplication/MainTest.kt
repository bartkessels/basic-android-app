package net.bartkessels.myapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

internal class MainTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun shouldDisplayHelloWorldWhenTheMainStateIsUninitialized() {
        // Arrange & Act
        composeTestRule.setContent {
           MainInternal(
               state = MainState.Uninitialized,
               onButtonClick = { }
           )
        }

        // Assert
        composeTestRule
            .onNodeWithText(context.getString(R.string.uninitialized_text))
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisplayYouHaveClickedOnceWhenTheMainStateIsUpdatedWithAClickCountOfOne() {
        // Arrange & Act
        composeTestRule.setContent {
            MainInternal(
                state = MainState.Updated(clickCount = 1),
                onButtonClick = { }
            )
        }

        // Assert
        composeTestRule
            .onNodeWithText("You have clicked 1 time")
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisplayYouHaveClickedXTimesWhenTheMainStateIsUpdatedWithAClickCountOfFive() {
        // Arrange
        val noClicks = 5

        // Act
        composeTestRule.setContent {
            MainInternal(
                state = MainState.Updated(clickCount = noClicks),
                onButtonClick = { }
            )
        }

        // Assert
        composeTestRule
            .onNodeWithText("You have clicked 5 times")
            .assertIsDisplayed()
    }

    @Test
    fun shouldCallOnButtonClickWhenTheButtonIsPressed() {
        // Act
        var isOnButtonClickCalled = false
        composeTestRule.setContent {
            MainInternal(
                state = MainState.Uninitialized,
                onButtonClick = { isOnButtonClickCalled = true }
            )
        }

        // Act
        composeTestRule
            .onNodeWithText(context.getString(R.string.update_text_button))
            .performClick()

        // Assert
        Assert.assertTrue(isOnButtonClickCalled)
    }
}