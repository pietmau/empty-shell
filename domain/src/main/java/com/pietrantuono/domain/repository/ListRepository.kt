package com.pietrantuono.domain.repository

import com.pietrantuono.domain.model.Item

interface ListRepository {

    suspend fun getList(): List<Item>
}