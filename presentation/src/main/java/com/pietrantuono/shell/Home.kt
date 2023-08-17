package com.pietrantuono.shell

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pietrantuono.shell.viewmodel.ViewState

@Composable
fun Home(viewState: ViewState) {
    LazyColumn(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        items(viewState.items.size) { index ->
            ItemView(viewState.items[index])
        }
    }
}

@Composable
fun ItemView(itemModel: ViewState.ItemModel) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = itemModel.title)
        Text(text = itemModel.subtitle)
    }
}
