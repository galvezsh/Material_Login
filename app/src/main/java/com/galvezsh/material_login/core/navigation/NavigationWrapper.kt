package com.galvezsh.material_login.core.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.galvezsh.material_login.ui.view.LoginView
import com.galvezsh.material_login.ui.view.RecoverView
import com.galvezsh.material_login.ui.view.RegisterView
import com.galvezsh.material_login.ui.view.StartView

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
            RecoverView( it.toRoute<RecoverScreen>().email )
        }
    }
}