package com.galvezsh.material_login.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.material_login.R

@Composable
fun RecoverView( newEmail: String ) {
    var email: String by remember { mutableStateOf( newEmail ) }

    val isValidEmail = false

    Box( modifier = Modifier.fillMaxSize().background( color = MaterialTheme.colorScheme.background ) ) {
        Column(
            modifier = Modifier.align( Alignment.TopCenter ).padding( horizontal = 24.dp ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SquareImage(
                id = R.drawable.ic_app,
                size = 96.dp,
                Modifier.padding( top = 96.dp )
            )
            Spacer( 32.dp )
            Text(
                text = "Correo electrónico:",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.align( Alignment.Start ).padding( bottom = 8.dp )
            )
            EmailField(
                email = email,
                placeholder = "example@gmail.com",
                onTextFieldChanged = { email = it }
            )
            Spacer( 8.dp )
            if ( isValidEmail ) {
                Text(
                    text = "Correo electrónico válido",
                    textAlign = TextAlign.Left,
                    color = Color.Green,
                    modifier = Modifier.align( Alignment.Start ).padding( top = 12.dp ),
                )
            } else {
                Text(
                    text = "Correo electrónico inválido",
                    textAlign = TextAlign.Left,
                    color = Color.Red,
                    modifier = Modifier.align( Alignment.Start ).padding( top = 12.dp ),
                )
            }
        }

        Column( modifier = Modifier.align( Alignment.BottomCenter ).padding( horizontal = 24.dp ) ) {
            PrimaryButton(
                text = "Recuperar contraseña",
                enabled = isValidEmail,
                modifier = Modifier.padding( bottom = 48.dp ),
                onPressedButton = {  }
            )
        }
    }
}