package com.pietrantuono.shell.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pietrantuono.domain.Mapper
import com.pietrantuono.domain.model.Item
import com.pietrantuono.domain.usecases.ListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ShellViewModel @Inject constructor(
    private val listUseCase: ListUseCase,
    private val mapper: Mapper<Item, ViewState.ItemModel>,
    context: CoroutineContext
) : ViewModel() {

    private val _state: MutableStateFlow<ViewState> = MutableStateFlow(ViewState(emptyList()))

    val state: Flow<ViewState> = _state

    init {
        viewModelScope.launch(context) {
            try {
                val items = listUseCase.execute()
                _state.tryEmit(ViewState(items.map { mapper.map(it) }))
            } catch (e: Exception) {
                // TODO: handle error
            }
        }
    }
}
