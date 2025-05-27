package com.galvezsh.material_login.presentation.recoverScreen

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RecoverViewModel @Inject constructor(): ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _isValidEmail = MutableStateFlow( false )
    val isValidEmail: StateFlow<Boolean> = _isValidEmail

    private var oneTimeExecution = false

    fun onChangedEmail( newEmail: String ) {
        _email.value = newEmail
        _isValidEmail.value = Patterns.EMAIL_ADDRESS.matcher( newEmail ).matches()
    }

    fun onPressedRecoverButton() {
        // Do here what recover is suppose to do
    }

    fun getOneTimeExecution(): Boolean {
        return oneTimeExecution
    }

    fun setOneTimeExecution() {
        oneTimeExecution = true
    }

}