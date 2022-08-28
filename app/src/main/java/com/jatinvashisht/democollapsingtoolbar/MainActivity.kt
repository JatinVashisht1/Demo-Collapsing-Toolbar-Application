package com.jatinvashisht.democollapsingtoolbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jatinvashisht.democollapsingtoolbar.ui.theme.DemoCollapsingToolbarTheme
import me.onebone.toolbar.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoCollapsingToolbarTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    val collapsingToolbarScaffoldState = rememberCollapsingToolbarScaffoldState()
                    val offsetY = collapsingToolbarScaffoldState.offsetY
                    val progress = collapsingToolbarScaffoldState.toolbarState.progress
                    MyUi(collapsingToolbarScaffoldState = collapsingToolbarScaffoldState,
                        progress = progress,
                        modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun MyUi(
    modifier: Modifier = Modifier,
    collapsingToolbarScaffoldState: CollapsingToolbarScaffoldState,
    progress: Float,
) {
    CollapsingToolbarScaffold(
        modifier = modifier,
        state = collapsingToolbarScaffoldState,
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {
            val textSize = (16 + 30 * progress).sp
            Box(modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .height(134.dp)
                .fillMaxWidth()
                .pin()
            )
            Text(
                text = "Title",
                modifier = Modifier
                    .road(Alignment.CenterStart, Alignment.BottomEnd)
                    .padding(60.dp, 16.dp, 16.dp, 16.dp),
                color = Color.White,
                fontSize = textSize
            )
            Image(
                imageVector = Icons.Default.Home,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(10.dp),
            )
        }
    ) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(100) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "This is item number $it")
                }
            }
        }
    }
}
