package com.pietrantuono.shell

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pietrantuono.shell.ui.theme.ShellTheme
import com.pietrantuono.shell.viewmodel.ViewState
import com.pietrantuono.shell.viewmodel.ViewState.ItemModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

class MyComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            ShellTheme {
                Home(viewState = ViewState(listOf(ItemModel(TITLE, SUBTITLE))))
            }
        }

        composeTestRule.onNodeWithText(TITLE).assertIsDisplayed()
        composeTestRule.onNodeWithText(SUBTITLE).assertIsDisplayed()
    }

    private companion object {
        private const val TITLE = "title"
        private const val SUBTITLE = "subtitle"
    }
}