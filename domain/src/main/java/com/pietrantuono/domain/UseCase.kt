package com.pietrantuono.domain

interface UseCase<Output> {

    suspend fun execute(): Output
}