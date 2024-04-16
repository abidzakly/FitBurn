package org.d3if3139.assessment1.typography

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import org.d3if3139.assessment1.R

object AppTypography {
    private val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )
    private val fontName = GoogleFont("Poppins")

    private val fontFamily = FontFamily(
        Font(googleFont = fontName, fontProvider = provider)
    )

    val typography = Typography(
        labelMedium = TextStyle(
            fontFamily = fontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp/*...*/
        ),
        labelLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp,
            /*...*/
        ),
        displayMedium = TextStyle(
            fontFamily = fontFamily, fontWeight = FontWeight.SemiBold/*...*/
        ),
        bodyLarge = TextStyle(
            fontFamily = fontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = fontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp
        ),
        bodySmall = TextStyle(
            fontFamily = fontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp
        ),
        /*...*/
    )

}