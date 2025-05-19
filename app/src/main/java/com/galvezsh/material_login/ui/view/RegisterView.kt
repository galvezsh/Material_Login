package com.galvezsh.material_login.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview( showSystemUi = true, showBackground = true )
@Composable
fun RegisterView() {
    var firstName: String by remember { mutableStateOf( "" ) }
    var lastName: String by remember { mutableStateOf( "" ) }
    var email: String by remember { mutableStateOf( "" ) }
    var password: String by remember { mutableStateOf( "" ) }
    var secondPassword: String by remember { mutableStateOf( "" ) }

    val isValidFullName = false
    val isValidEmail = false
    val isValidPassword = false
    val isValidPasswordCheck = false

    Box( modifier = Modifier.fillMaxSize().background( color = MaterialTheme.colorScheme.background ) ) {
        Column(
            modifier = Modifier.align( Alignment.TopCenter ).padding( horizontal = 24.dp ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer( 32.dp )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy( 8.dp )
            ) {
                Column( modifier = Modifier.weight( 1f ) ) {
                    Text(
                        text = "Nombre:",
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier
                    )
                    CommonField(
                        text = firstName,
                        placeholder = "Amanda",
                        onTextFieldChanged = { firstName = it }
                    )
                }
                Column( modifier = Modifier.weight( 1f ) ) {
                    Text(
                        text = "Apellidos:",
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier
                    )
                    CommonField(
                        text = lastName,
                        placeholder = "Díaz Palomo",
                        onTextFieldChanged = { lastName = it }
                    )
                }
            }
            Spacer( 12.dp )
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
            Spacer( 12.dp )
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
            Spacer( 12.dp )
            Text(
                text = "Confirmar contraseña:",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.align( Alignment.Start ).padding( bottom = 8.dp )
            )
            PasswordField(
                password = secondPassword,
                placeholder = "example@1234",
                onTextFieldChanged = { secondPassword = it }
            )
            Spacer( 8.dp )
            TextFieldErrorLabel(
                isValid = isValidFullName,
                validText = "El nombre y los apellidos están completos",
                invalidText = "El nombre y los apellidos están incompletos",
                modifier = Modifier.align( Alignment.Start )
            )
            TextFieldErrorLabel(
                isValid = isValidEmail,
                validText = "El correo electrónico es válido",
                invalidText = "El correo electrónico no es válido",
                modifier = Modifier.align( Alignment.Start )
            )
            TextFieldErrorLabel(
                isValid = isValidPassword,
                validText = "La contraseña tiene al menos 8 caracteres",
                invalidText = "La contraseña debe tener al menos 8 caracteres",
                modifier = Modifier.align( Alignment.Start )
            )
            TextFieldErrorLabel(
                isValid = isValidPasswordCheck,
                validText = "Las contraseñas coinciden",
                invalidText = "Las contraseñas no coinciden",
                modifier = Modifier.align( Alignment.Start )
            )
        }

        Column( modifier = Modifier.align( Alignment.BottomCenter ).padding( horizontal = 24.dp ) ) {
            PrimaryButton(
                text = "Registrarse",
                enabled = ( isValidFullName && isValidEmail && isValidPassword && isValidPasswordCheck ),
                modifier = Modifier.padding( bottom = 48.dp ),
                onPressedButton = {  }
            )
        }
    }
}