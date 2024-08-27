package com.nyekilajos.composeappiumtest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun MainContent() {
    Scaffold(
        modifier = modifierWith("MainScreen"),
        topBar = {
            Text(
                fontSize = 24.sp,
                modifier = modifierWith("ComposeText").padding(vertical = 32.dp, horizontal = 24.dp),
                text = "This is a text from compose."
            )
        },
        content = { padding ->
            val context = LocalContext.current
            AndroidView(
                modifier = modifierWith("AndroidViewContainer")
                    .fillMaxSize()
                    .padding(padding),
                factory = {
                    LayoutInflater.from(it).inflate(R.layout.main_layout, null, false)
                },
                update = {
                    it.findViewById<Button>(R.id.xml_based_button).setOnClickListener {
                        Toast.makeText(context, "XML based button clicked.", Toast.LENGTH_LONG).show()
                    }
                })
        },
        bottomBar = {
            val context = LocalContext.current
            Button(
                modifier = modifierWith("ComposeButton").padding(24.dp),
                onClick = { Toast.makeText(context, "A compose based button is clicked.", Toast.LENGTH_LONG).show() }
            ) {
                Text(modifier = modifierWith("ComposeButtonText"), text = "Compose Button")
            }
        }
    )
}

@Preview
@Composable
fun MainContentPreview() {
    MainContent()
}

@OptIn(ExperimentalComposeUiApi::class)
@SuppressLint("ModifierFactoryExtensionFunction")
fun modifierWith(testTag: String) = Modifier
    .semantics {
        this.testTag = testTag
        this.testTagsAsResourceId = true
    }
