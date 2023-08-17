package com.pietrantuono.shell.viewmodel

import com.pietrantuono.domain.Mapper
import com.pietrantuono.domain.model.Item
import com.pietrantuono.shell.viewmodel.ViewState.ItemModel
import javax.inject.Inject

class ItemsMapper @Inject constructor() : Mapper<Item, ItemModel> {

    override fun map(input: Item) = ItemModel(input.title, input.subtitle)
}
