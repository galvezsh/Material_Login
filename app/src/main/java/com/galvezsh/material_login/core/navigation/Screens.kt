package com.galvezsh.material_login.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object StartScreen

@Serializable
object LoginScreen

@Serializable
object RegisterScreen

@Serializable
data class RecoverScreen( val email: String )