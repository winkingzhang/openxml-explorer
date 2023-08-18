package org.zhangwenqing.openxmlexplorer.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val typography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    ),

    h2 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        color = Color.White
    ),

    h3 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 12.sp,
        color = Color.White
    ),

    h4 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 10.sp,
        color = Color.White
    )
)

val primaryColor = Color(0xFF1e88e5)
val primaryLightColor = Color(0xFF6ab7ff)
val primaryDarkColor = Color(0xFF005cb2)
val secondaryColor = Color(0xFF26a69a)
val secondaryLightColor = Color(0xFF64d8cb)
val secondaryDarkColor = Color(0xFF00766c)
val primaryTextColor = Color(0xFF000000)
val secondaryTextColor = Color(0xFF000000)
val lightGrey = Color(0xFFA2B4B5)
val backgroundDark = Color(0xFF2B2B2B)
val backgroundVariant = Color(0xFF3C3F41)
val backgroundLight = Color(0xFF4E5254)


private val DarkColorPalette = darkColors(
    primary = primaryDarkColor,
    primaryVariant = primaryLightColor,
    secondary = secondaryDarkColor,
    secondaryVariant = secondaryLightColor,
    onPrimary = Color.White,
    background = backgroundDark,
    surface = backgroundVariant,
    onSurface = lightGrey
)

private val LightColorPalette = lightColors(
    primary = primaryColor,
    primaryVariant = primaryLightColor,
    secondary = secondaryColor,
    secondaryVariant = secondaryLightColor,
    onPrimary = Color.Black,
    background = Color.White,
    surface = backgroundVariant,
)

@Composable
fun AppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = typography,
        content = content
    )
}