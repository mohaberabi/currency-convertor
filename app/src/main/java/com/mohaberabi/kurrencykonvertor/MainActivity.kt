package com.mohaberabi.kurrencykonvertor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import dagger.hilt.android.AndroidEntryPoint
import presentation.screen.CurrencyConvertorRoot
import theme.AppTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                CurrencyConvertorRoot()
            }
        }
    }
}

