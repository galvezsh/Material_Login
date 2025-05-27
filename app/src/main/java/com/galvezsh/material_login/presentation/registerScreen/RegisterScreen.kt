package com.galvezsh.material_login.presentation.registerScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.galvezsh.material_login.presentation.CommonField
import com.galvezsh.material_login.presentation.EmailField
import com.galvezsh.material_login.presentation.PasswordField
import com.galvezsh.material_login.presentation.PrimaryButton
import com.galvezsh.material_login.presentation.Spacer
import com.galvezsh.material_login.presentation.TextFieldErrorLabel

@Preview( showSystemUi = true, showBackground = true )
@Composable
fun RegisterView( registerViewModel: RegisterViewModel = hiltViewModel()) {

    val firstName by registerViewModel.firstName.collectAsState()
    val lastName by registerViewModel.lastName.collectAsState()
    val email by registerViewModel.email.collectAsState()
    val pass by registerViewModel.pass.collectAsState()
    val passCheck by registerViewModel.passCheck.collectAsState()

    val isValidFirstName by registerViewModel.isValidFirstName.collectAsState()
    val isValidLastName by registerViewModel.isValidLastName.collectAsState()
    val isValidEmail by registerViewModel.isValidEmail.collectAsState()
    val isValidPass by registerViewModel.isValidPass.collectAsState()
    val isValidPassCheck by registerViewModel.isValidPassCheck.collectAsState()

    Box( modifier = Modifier
        .fillMaxSize()
        .background( color = MaterialTheme.colorScheme.background )
        .padding( horizontal = 24.dp )
    ) {
        Column( modifier = Modifier.verticalScroll( rememberScrollState() ) ) {
            Spacer(32.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy( 8.dp )
            ) {
                Column( modifier = Modifier.weight( 1f ) ) {
                    Text(
                        text = "Nombre:",
                        fontSize = 18.sp,
                        color = Color.White,
                    )
                    CommonField(
                        text = firstName,
                        placeholder = "Amanda",
                        onTextFieldChanged = { registerViewModel.onChangedFirstName( it ) }
                    )
                }
                Column( modifier = Modifier.weight( 1f ) ) {
                    Text(
                        text = "Apellidos:",
                        fontSize = 18.sp,
                        color = Color.White,
                    )
                    CommonField(
                        text = lastName,
                        placeholder = "Díaz Palomo",
                        onTextFieldChanged = { registerViewModel.onChangedLastName( it ) }
                    )
                }
            }
            Spacer(12.dp)
            Text(
                text = "Correo electrónico:",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding( bottom = 8.dp )
            )
            EmailField(
                email = email,
                placeholder = "example@gmail.com",
                onTextFieldChanged = { registerViewModel.onChangedEmail( it ) }
            )
            Spacer(12.dp)
            Text(
                text = "Contraseña:",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding( bottom = 8.dp )
            )
            PasswordField(
                password = pass,
                placeholder = "example@1234",
                onTextFieldChanged = { registerViewModel.onChangedPassword( it ) }
            )
            Spacer(12.dp)
            Text(
                text = "Confirmar contraseña:",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding( bottom = 8.dp )
            )
            PasswordField(
                password = passCheck,
                placeholder = "example@1234",
                onTextFieldChanged = { registerViewModel.onChangedPasswordCheck( it ) }
            )
            Spacer(8.dp)
            TextFieldErrorLabel(
                isValid = isValidFirstName && isValidLastName,
                validText = "El nombre y los apellidos están completos",
                invalidText = "El nombre y los apellidos están incompletos",
                modifier = Modifier
            )
            TextFieldErrorLabel(
                isValid = isValidEmail,
                validText = "El correo electrónico es válido",
                invalidText = "El correo electrónico no es válido",
                modifier = Modifier
            )
            TextFieldErrorLabel(
                isValid = isValidPass,
                validText = "La contraseña tiene al menos 8 caracteres",
                invalidText = "La contraseña debe tener al menos 8 caracteres",
                modifier = Modifier
            )
            TextFieldErrorLabel(
                isValid = isValidPassCheck,
                validText = "Las contraseñas coinciden",
                invalidText = "Las contraseñas no coinciden",
                modifier = Modifier
            )
            Spacer(64.dp)

        }

        PrimaryButton(
            text = "Registrarse",
            enabled = ( isValidFirstName && isValidLastName && isValidEmail && isValidPass && isValidPassCheck ),
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 48.dp),
            onPressedButton = { registerViewModel.onPressedRegisterButton() }
        )
    }
}