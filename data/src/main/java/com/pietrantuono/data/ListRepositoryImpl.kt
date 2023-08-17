package com.pietrantuono.data

import com.pietrantuono.domain.model.Item
import com.pietrantuono.domain.repository.ListRepository
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor() : ListRepository {

    override suspend fun getList() = listOf(Item("a", "b"), Item("c", "d"), Item("f", "g"))
}
