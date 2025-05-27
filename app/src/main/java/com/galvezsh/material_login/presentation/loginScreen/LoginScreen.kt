package com.galvezsh.material_login.presentation.loginScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.galvezsh.material_login.R
import com.galvezsh.material_login.presentation.EmailField
import com.galvezsh.material_login.presentation.PasswordField
import com.galvezsh.material_login.presentation.PrimaryButton
import com.galvezsh.material_login.presentation.Spacer
import com.galvezsh.material_login.presentation.SquareImage
import com.galvezsh.material_login.presentation.TextFieldErrorLabel
import com.galvezsh.material_login.presentation.TextLink

@Composable
fun LoginView( navigateToRecoverView: (String) -> Unit, loginViewModel: LoginViewModel = hiltViewModel() ) {

    val email by loginViewModel.email.collectAsState()
    val pass by loginViewModel.pass.collectAsState()
    val isValidEmail by loginViewModel.isValidEmail.collectAsState()
    val isValidPass by loginViewModel.isValidPass.collectAsState()

    Box( modifier = Modifier
        .fillMaxSize()
        .background( color = MaterialTheme.colorScheme.background )
        .padding( horizontal = 24.dp )
    ) {
        Column( modifier = Modifier.verticalScroll( rememberScrollState() ) ) {
            SquareImage(
                id = R.drawable.ic_app,
                size = 96.dp,
                Modifier.padding(top = 64.dp).align(Alignment.CenterHorizontally)
            )
            Spacer(24.dp)
            Text(
                text = "Correo electrónico:",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding( bottom = 8.dp )
            )
            EmailField(
                email = email,
                placeholder = "example@email.com",
                onTextFieldChanged = { loginViewModel.onChangedEmail( it ) }
            )
            Spacer(16.dp)
            Text(
                text = "Contraseña:",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding( bottom = 8.dp )
            )
            PasswordField(
                password = pass,
                placeholder = "example@1234",
                onTextFieldChanged = { loginViewModel.onChangedPassword( it ) }
            )
            Spacer(8.dp)
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
            Spacer(64.dp)
        }

        Column( modifier = Modifier.align( Alignment.BottomCenter ) ) {
            TextLink(
                text = "¿Olvidaste la contraseña?",
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 16.dp),
                onPressedLink = { navigateToRecoverView(email) }
            )
            PrimaryButton(
                text = "Iniciar sesión",
                enabled = (isValidEmail && isValidPass),
                modifier = Modifier.padding(bottom = 48.dp),
                onPressedButton = { loginViewModel.onPressedLoginButton() }
            )
        }
    }
}