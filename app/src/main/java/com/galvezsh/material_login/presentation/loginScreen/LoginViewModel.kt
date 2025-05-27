package com.galvezsh.material_login.presentation.loginScreen

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _pass = MutableStateFlow("")
    val pass: StateFlow<String> = _pass

    private val _isValidEmail = MutableStateFlow( false )
    val isValidEmail: StateFlow<Boolean> = _isValidEmail

    private val _isValidPass = MutableStateFlow( false )
    val isValidPass: StateFlow<Boolean> = _isValidPass

    fun onChangedEmail( newEmail: String ) {
        _email.value = newEmail
        _isValidEmail.value = Patterns.EMAIL_ADDRESS.matcher( newEmail ).matches()
    }

    fun onChangedPassword( newPass: String ) {
        _pass.value = newPass
        _isValidPass.value = newPass.length >= 8
    }

    fun onPressedLoginButton() {

    }
}