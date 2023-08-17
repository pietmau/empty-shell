package com.pietrantuono.shell

import com.pietrantuono.domain.Mapper
import com.pietrantuono.domain.model.Item
import com.pietrantuono.domain.usecases.ListUseCase
import com.pietrantuono.shell.viewmodel.ShellViewModel
import com.pietrantuono.shell.viewmodel.ViewState
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ShellViewModelTest {
    private val listUseCase: ListUseCase = mockk {
        coEvery { execute() } returns listOf(Item(TITLE, SUBTITLE))
    }
    private val mapper: Mapper<Item, ViewState.ItemModel> = mockk {
        every { map(any()) } returns ViewState.ItemModel(TITLE, SUBTITLE)
    }
    private val context: CoroutineContext = UnconfinedTestDispatcher()
    private val cut = ShellViewModel(listUseCase, mapper, context)

    @Test
    fun `when subscribes emits values`() = runTest {
        // Given
        val expected = ViewState(listOf(ViewState.ItemModel(TITLE, SUBTITLE)))
        // When
        val actual = cut.state.first()
        // Then
        assertThat(actual).isEqualTo(expected)
    }

    private companion object {
        private const val TITLE = "title"
        private const val SUBTITLE = "subtitle"
    }
}