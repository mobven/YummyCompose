package com.mobven.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mobven.components.R

val sfProFamily = FontFamily(
    Font(R.font.sf_pro_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.sf_pro_bold, FontWeight.Bold),
    Font(R.font.sf_pro_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.sf_pro_medium, FontWeight.Medium),
    Font(R.font.sf_pro_regular, FontWeight.Normal),
    Font(R.font.sf_pro_regular, FontWeight.SemiBold),
    Font(R.font.sf_pro_semibold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.sf_pro_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.sf_pro_ultra_light_italic, FontWeight.ExtraLight, FontStyle.Italic)
)

val Typography.h1BoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 24.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.Bold,
    )
val Typography.h1SemiBoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 24.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.SemiBold,
    )
val Typography.h1MediumStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 24.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.Medium,
    )
val Typography.h2BoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 20.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.Bold,
    )
val Typography.h2SemiBoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 20.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.SemiBold,
    )
val Typography.h2MediumStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 20.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.Medium,
    )
val Typography.h3BoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Bold,
    )
val Typography.h3SemiBoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.SemiBold,
    )
val Typography.h3MediumStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Medium,
    )

val Typography.h3NormalStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Normal,
    )
val Typography.h4BoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold,
    )
val Typography.h4SemiBoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.SemiBold,
    )
val Typography.h4MediumStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Medium,
    )
val Typography.h5BoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Bold,
    )
val Typography.h5SemiBoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.SemiBold,
    )
val Typography.h5MediumStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Medium,
    )

val Typography.h5NormalStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Normal,
    )

val Typography.smallBoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Bold,
    )
val Typography.smallSemiBoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.SemiBold,
    )
val Typography.smallMediumStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium,
    )
val Typography.xsmallBoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Bold,
    )
val Typography.xsmallSemiBoldStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.SemiBold,
    )
val Typography.xsmallMediumStyle: TextStyle
    get() = TextStyle(
        fontFamily = sfProFamily,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium,
    )