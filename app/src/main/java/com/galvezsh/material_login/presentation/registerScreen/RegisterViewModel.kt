package com.galvezsh.material_login.presentation.registerScreen

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    private val _firstName = MutableStateFlow("")
    val firstName: StateFlow<String> = _firstName

    private val _lastName = MutableStateFlow("")
    val lastName: StateFlow<String> = _lastName

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _pass = MutableStateFlow("")
    val pass: StateFlow<String> = _pass

    private val _passCheck = MutableStateFlow("")
    val passCheck: StateFlow<String> = _passCheck


    private val _isValidFirstName = MutableStateFlow( false )
    val isValidFirstName: StateFlow<Boolean> = _isValidFirstName

    private val _isValidLastName = MutableStateFlow( false )
    val isValidLastName: StateFlow<Boolean> = _isValidLastName

    private val _isValidEmail = MutableStateFlow( false )
    val isValidEmail: StateFlow<Boolean> = _isValidEmail

    private val _isValidPass = MutableStateFlow( false )
    val isValidPass: StateFlow<Boolean> = _isValidPass

    private val _isValidPassCheck = MutableStateFlow( false )
    val isValidPassCheck: StateFlow<Boolean> = _isValidPassCheck


    fun onChangedFirstName( newName: String ) {
        _firstName.value = newName
        _isValidFirstName.value = _firstName.value != ""
    }

    fun onChangedLastName( newName: String ) {
        _lastName.value = newName
        _isValidLastName.value = _lastName.value != ""
    }

    fun onChangedEmail( newEmail: String ) {
        _email.value = newEmail
        _isValidEmail.value = Patterns.EMAIL_ADDRESS.matcher( newEmail ).matches()
    }

    fun onChangedPassword( newPass: String ) {
        _pass.value = newPass
        _isValidPass.value = newPass.length >= 8
    }

    fun onChangedPasswordCheck( newPass: String ) {
        _passCheck.value = newPass
        _isValidPassCheck.value = _pass.value == _passCheck.value
    }

    fun onPressedRegisterButton() {
        // Do here what register is suppose to do
    }
}