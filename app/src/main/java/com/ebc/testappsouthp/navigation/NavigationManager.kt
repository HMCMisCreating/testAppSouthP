package com.ebc.testappsouthp.navigation


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import com.ebc.testappsouthp.enumerators.ViewIDs
import com.ebc.testappsouthp.view.components.cupcakewizard.SelectFlavorScreen
import com.ebc.testappsouthp.view.components.cupcakewizard.StartOrderScreen
import com.ebc.testappsouthp.viewmodel.CupcakeMakerViewModel

// Crear función para el topbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeAppBar() {
    CenterAlignedTopAppBar(
        title = {"Título"},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )

    )

}


// Crear el nav manager
@Composable
fun NavigationManager(cupcakeMakerViewModel: CupcakeMakerViewModel) {
    val navController = rememberNavController();

    Scaffold(
        topBar = {CupcakeAppBar()},
        bottomBar = {Text(text = "I'm the bottom container")}

    ) {
        NavHost(
            navController = navController,
            startDestination = ViewIDs.Start.id,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            composable("Home") {
                Text(text = "Placeholder Home")
            }
            composable (ViewIDs.Start.id) {
                StartOrderScreen(navController, cupcakeMakerViewModel)
            }
            composable (ViewIDs.Flavors.id) {
                SelectFlavorScreen(navController, cupcakeMakerViewModel)
            }
        }
    }
}




