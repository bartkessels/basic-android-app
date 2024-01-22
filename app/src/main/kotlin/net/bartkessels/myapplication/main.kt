import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import net.bartkessels.myapplication.MainViewModel

@Composable
fun Main(
    viewModel: MainViewModel
) {
    BasicText(
        text = viewModel.displayText.collectAsState().value,
        modifier = Modifier.clickable(
            onClick = viewModel::updateText
        )
    )
}