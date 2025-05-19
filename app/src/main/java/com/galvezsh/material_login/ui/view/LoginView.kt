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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.material_login.R

//@Preview( showBackground = true, showSystemUi = true, backgroundColor = 0xFF3C2E28 )
@Composable
fun LoginView( navigateToRecoverView: (String) -> Unit ) {
    var email: String by remember { mutableStateOf( "" ) }
    var password: String by remember { mutableStateOf( "" ) }

    val isValidEmail = false
    val isValidPassword = false

    Box( modifier = Modifier.fillMaxSize().background( color = MaterialTheme.colorScheme.background ) ) {
        Column(
            modifier = Modifier.align( Alignment.TopCenter ).padding( horizontal = 24.dp ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SquareImage(
                id = R.drawable.ic_app,
                size = 96.dp,
                Modifier.padding( top = 64.dp )
            )
            Spacer( 24.dp )
            Text(
                text = "Correo electrónico:",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.align( Alignment.Start ).padding( bottom = 8.dp )
            )
            EmailField(
                email = email,
                placeholder = "example@email.com",
                onTextFieldChanged = { email = it }
            )
            Spacer( 16.dp )
            Text(
                text = "Contraseña:",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.align( Alignment.Start ).padding( bottom = 8.dp )
            )
            PasswordField(
                password = password,
                placeholder = "example@1234",
                onTextFieldChanged = { password = it }
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
            if ( isValidPassword ) {
                Text(
                    text = "La contraseña tiene al menos 8 caracteres",
                    textAlign = TextAlign.Left,
                    color = Color.Green,
                    modifier = Modifier.align( Alignment.Start ).padding( top = 12.dp ),
                )
            } else {
                Text(
                    text = "La contraseña debe tener al menos 8 caracteres",
                    textAlign = TextAlign.Left,
                    color = Color.Red,
                    modifier = Modifier.align( Alignment.Start ).padding( top = 12.dp ),
                )
            }
        }

        Column( modifier = Modifier.align( Alignment.BottomCenter ).padding( horizontal = 24.dp ) ) {
            TextLink (
                text = "¿Olvidaste la contraseña?",
                modifier = Modifier.align( Alignment.CenterHorizontally ).padding( bottom = 24.dp ),
                onPressedLink = { navigateToRecoverView( email ) }
            )
            PrimaryButton(
                text = "Iniciar sesión",
                enabled = ( isValidEmail && isValidPassword ),
                modifier = Modifier.padding( bottom = 48.dp ),
                onPressedButton = {  }
            )
        }
    }
}