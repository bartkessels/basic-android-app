import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import net.bartkessels.myapplication.MainViewModel

@Composable
fun Main(
    viewModel: MainViewModel
) {
    Column {
        Text(viewModel.displayText.collectAsState().value, color = Color.White)
        Button(onClick = viewModel::updateText) {
            Text("Click me")
        }
    }
}