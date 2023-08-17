package com.pietrantuono.shell.viewmodel

import android.icu.text.CaseMap.Title

data class ViewState(val items: List<ItemModel>) {

    data class ItemModel(val title: String, val subtitle: String)
}
