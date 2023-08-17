package com.pietrantuono.shell.di

import com.pietrantuono.data.ListRepositoryImpl
import com.pietrantuono.domain.Mapper
import com.pietrantuono.domain.model.Item
import com.pietrantuono.domain.repository.ListRepository
import com.pietrantuono.shell.viewmodel.ItemsMapper
import com.pietrantuono.shell.viewmodel.ViewState
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
interface ShellModule {

    @Binds
    fun bindRep(repo: ListRepositoryImpl): ListRepository

    @Binds
    fun bindMapper(mapper: ItemsMapper): Mapper<Item, ViewState.ItemModel>

    companion object {
        @Provides
        fun provideCoroutineContext(): CoroutineContext = Dispatchers.IO
    }
}