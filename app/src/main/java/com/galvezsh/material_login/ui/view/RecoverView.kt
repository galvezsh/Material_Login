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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.material_login.R

@Composable
fun RecoverView( newEmail: String ) {
    var email: String by remember { mutableStateOf( newEmail ) }

    val isValidEmail = false

    Box( modifier = Modifier
        .fillMaxSize()
        .background( color = MaterialTheme.colorScheme.background )
        .padding( horizontal = 24.dp )
    ) {
        Column {
            SquareImage(
                id = R.drawable.ic_app,
                size = 96.dp,
                Modifier.padding( top = 96.dp ).align( Alignment.CenterHorizontally )
            )
            Spacer( 32.dp )
            Text(
                text = "Correo electrónico:",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding( bottom = 8.dp )
            )
            EmailField(
                email = email,
                placeholder = "example@gmail.com",
                onTextFieldChanged = { email = it }
            )
            Spacer( 8.dp )
            TextFieldErrorLabel(
                isValid = isValidEmail,
                validText = "El correo electrónico es válido",
                invalidText = "El correo electrónico no es válido",
                modifier = Modifier
            )
        }

        PrimaryButton(
            text = "Recuperar contraseña",
            enabled = isValidEmail,
            modifier = Modifier.padding( bottom = 48.dp ).align( Alignment.BottomCenter ),
            onPressedButton = {  }
        )
    }
}