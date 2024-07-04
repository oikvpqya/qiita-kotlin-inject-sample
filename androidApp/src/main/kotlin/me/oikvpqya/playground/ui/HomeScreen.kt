package me.oikvpqya.playground.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.serialization.Serializable
import me.oikvpqya.playground.data.DatabaseRepository
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Inject

@Serializable
object Home

@Inject
class HomeViewModel(
    private val repository: DatabaseRepository,
) : ViewModel() {

    fun get(): SharedFlow<ImmutableList<String>> {
        return repository.get().shareIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            replay = 1,
        )
    }

    fun insert(string: String) {
        viewModelScope.launch { repository.insert(string) }
    }

    fun insert(strings: List<String>) {
        viewModelScope.launch { repository.insert(strings) }
    }
}

typealias HomeRoute = @Composable (
    navController: NavController,
    modifier: Modifier,
) -> Unit

@Composable
@Inject
fun HomeRoute(
    homeViewModel: () -> HomeViewModel,
    @Assisted navController: NavController,
    @Assisted modifier: Modifier = Modifier,
) {
    val viewModel = viewModel { homeViewModel() }

    val data: ImmutableList<String> by remember(viewModel) {
        viewModel.get()
    }.collectAsStateWithLifecycle(initialValue = persistentListOf())

    HomeScreen(
        strings = data,
        onInsertItem = { string -> viewModel.insert(string) },
        onInsertItems = { strings -> viewModel.insert(strings) },
        onNavigateToImage = { path -> navController.navigate(Image(path)) },
        modifier = modifier,
    )
}

@Composable
fun HomeScreen(
    strings: ImmutableList<String>,
    onInsertItem: (String) -> Unit,
    onInsertItems: (List<String>) -> Unit,
    onNavigateToImage: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Button(
            onClick = { onNavigateToImage(createRandomImageUrl()) },
        ) {
            Text(text = "See Random Image")
        }
        Button(
            onClick = { onInsertItem(Clock.System.now().toString()) },
        ) {
            Text(text = "+")
        }
        Button(
            onClick = { Clock.System.now().let { now -> onInsertItems(List(5) { index -> "$now : $index" }) } },
        ) {
            Text(text = "+ (5 times)")
        }
        LazyColumn {
            items(strings) { string -> Text(text = string) }
        }
    }
}

private fun createRandomImageUrl(
    seed: Int = (0..100).random(),
    width: Int = 300,
    height: Int = width,
): String {
    return "https://picsum.photos/seed/$seed/$width/$height"
}
