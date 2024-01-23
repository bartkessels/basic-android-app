package net.bartkessels.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Main(
    viewModel: MainViewModel
) {
    MainInternal(
        state = viewModel.displayText.collectAsState().value,
        onButtonClick = viewModel::updateText
    )
}

@Composable
private fun MainInternal(
    state: MainState,
    onButtonClick: () -> Unit
) {
    val textToDisplay = when (state) {
        MainState.Uninitialized -> R.string.uninitialized_text
        MainState.Updated -> R.string.updated_text
    }

    Column {
        Text(stringResource(textToDisplay))
        Button(onClick = onButtonClick) {
            Text(stringResource(R.string.update_text_button))
        }
    }
}

@Preview
@Composable
private fun MainInternalPreview() {
    MainInternal(
        state = MainState.Uninitialized,
        onButtonClick = { }
    )
}