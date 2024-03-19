package net.bartkessels.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.pluralStringResource
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
internal fun MainInternal(
    state: MainState,
    onButtonClick: () -> Unit
) {
    val textToDisplay = when (state) {
        MainState.Uninitialized -> stringResource(R.string.uninitialized_text)
        is MainState.Updated -> pluralStringResource(R.plurals.updated_text, state.clickCount)
    }

    Column {
        Text(textToDisplay)
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