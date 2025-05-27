package com.galvezsh.material_login.core.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.galvezsh.material_login.presentation.loginScreen.LoginView
import com.galvezsh.material_login.presentation.recoverScreen.RecoverView
import com.galvezsh.material_login.presentation.registerScreen.RegisterView
import com.galvezsh.material_login.presentation.startScreen.StartView

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost( navController = navController, startDestination = StartScreen ) {

        composable<StartScreen> {
            StartView(
                navigateToLoginView = { navController.navigate( LoginScreen ) },
                navigateToRegisterView = { navController.navigate( RegisterScreen ) }
            )
        }

        composable<LoginScreen> {
            LoginView(
                navigateToRecoverView = { email -> navController.navigate( RecoverScreen( email ) ) }
            )
        }

        composable<RegisterScreen> {
            RegisterView()
        }

        composable<RecoverScreen> {
            RecoverView( newEmail = it.toRoute<RecoverScreen>().email )
        }
    }
}