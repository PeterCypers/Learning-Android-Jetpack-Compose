package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AllQuadrants(
                        modifier = Modifier
                            .padding(innerPadding)
                            //.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun AllQuadrants(modifier: Modifier = Modifier) {
    /*
    * by claude.ai code-review:
    * The rule of thumb: the modifier parameter goes on the outermost layout only,
    * and every inner element gets its own fresh Modifier.
    *
    * weights work like grid template columns fractions in JavaScript:
    * (grid-template-columns: 100px 1fr 2fr;)
    * */
    Column(
        modifier = modifier, // .fillMaxSize()
        verticalArrangement = Arrangement.Center
    ) {
        Row(Modifier.weight(1F)) {
            Quadrant(
                title = stringResource(R.string.text_composable),
                body = stringResource(R.string.text_composable_details),
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1F)
            )
            Quadrant(
                title = stringResource(R.string.image_composable),
                body = stringResource(R.string.image_composable_details),
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1F)
            )
        }
        Row(Modifier.weight(1F)) {
            Quadrant(
                title = stringResource(R.string.row_composable),
                body = stringResource(R.string.row_composable_details),
                color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1F)
            )
            Quadrant(
                title = stringResource(R.string.column_composable),
                body = stringResource(R.string.column_composable_details),
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Composable
fun Quadrant(title: String, body: String, modifier: Modifier = Modifier, color: Color = Color.Cyan) {
    Surface(
        modifier,
        color = color
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = body,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AllQuadrantsPreview() {
    ComposeQuadrantTheme {
        AllQuadrants()
    }
}