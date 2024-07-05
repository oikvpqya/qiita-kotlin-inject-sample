import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import me.oikvpqya.playground.di.create
import me.oikvpqya.playground.di.DesktopApplicationComponent
import me.oikvpqya.playground.di.WindowComponent

fun main() = application {

    val applicationComponent = remember {
        DesktopApplicationComponent::class.create()
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Playground",
    ) {
        val component = remember(applicationComponent) {
            WindowComponent::class.create(applicationComponent)
        }

        component.appContent.Content(
            modifier = Modifier,
        )
    }
}
