import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import net.bartkessels.myapplication.MainState
import net.bartkessels.myapplication.MainViewModel
import net.bartkessels.myapplication.R

@Composable
fun Main(
    viewModel: MainViewModel
) {
    val textToDisplay = when (viewModel.displayText.collectAsState().value) {
        MainState.Uninitialized -> R.string.uninitialized_text
        MainState.Updated -> R.string.updated_text
    }

    Column {
        Text(stringResource(textToDisplay))
        Button(onClick = viewModel::updateText) {
            Text(stringResource(R.string.update_text_button))
        }
    }
}