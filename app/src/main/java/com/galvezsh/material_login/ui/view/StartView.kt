package com.galvezsh.material_login.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.material_login.R

//@Preview( showBackground = true, showSystemUi = true )
@Composable
fun StartView( navigateToLoginView: () -> Unit, navigateToRegisterView: () -> Unit ) {
    val appName = LocalContext.current.getString( R.string.app_name )

    Box( modifier = Modifier.fillMaxSize().background( color = MaterialTheme.colorScheme.background ) ) {
        Column( modifier = Modifier.align( Alignment.TopCenter ), horizontalAlignment = Alignment.CenterHorizontally ) {
            CircleImage(
                id = R.drawable.ic_app,
                size = 160.dp,
                modifier = Modifier.padding( top = 160.dp )
            )
            Spacer( 8.dp )
            Text(
                text = "¡Unete a $appName!",
                fontSize = 22.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding( horizontal = 24.dp )
            )
            Spacer( 8.dp )
            Text(
                text = "¡Unete a la comundidad Android más grande de toda habla hispana!",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding( horizontal = 24.dp )
            )
        }

        Column( modifier = Modifier.align( Alignment.BottomCenter ) ) {
            PrimaryButton(
                text = "Iniciar Sesión",
                enabled = true,
                modifier = Modifier.padding( horizontal = 24.dp ),
                onPressedButton = { navigateToLoginView() }
            )
            Spacer( 8.dp )
            SecondaryButton(
                text = "Crear Cuenta",
                enabled = true,
                modifier = Modifier.padding( horizontal = 24.dp ),
                onPressedButton = {  navigateToRegisterView() }
            )
            Spacer( 24.dp )
        }
    }
}