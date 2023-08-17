package com.pietrantuono.shell

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pietrantuono.shell.ui.theme.ShellTheme
import com.pietrantuono.shell.viewmodel.ShellViewModel
import com.pietrantuono.shell.viewmodel.ViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShellTheme {
                val viewState by viewModel<ShellViewModel>().state.collectAsState(initial = ViewState(emptyList()))
                Home(viewState)
            }
        }
    }
}
