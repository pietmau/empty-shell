package com.pietrantuono.domain.usecases

import com.pietrantuono.domain.UseCase
import com.pietrantuono.domain.model.Item
import com.pietrantuono.domain.repository.ListRepository
import javax.inject.Inject

class ListUseCase @Inject constructor(private val repository: ListRepository) : UseCase<List<Item>> {

    override suspend fun execute() = repository.getList()
}
