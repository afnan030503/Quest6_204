package com.example.navigationcompose.Navigation

import android.window.SplashScreenView
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.model.Mahasiswa
import com.example.navigationcompose.ui.theme.view.screen.MahasiswaFormView
import com.example.navigationcompose.ui.theme.view.screen.RencanaStudiView
import com.example.navigationcompose.ui.theme.view.screen.SplashScreenView
import com.example.navigationcompose.ui.theme.view.screen.TampilView
import com.example.navigationcompose.ui.theme.view.viewmodel.MahasiswaViewModel
import com.example.navigationcompose.ui.theme.view.viewmodel.RencanaStudiViewModel

enum class Halaman{
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil

}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudiViewModel = viewModel()

){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    val krsUiState = krsViewModel.krsStateUi.collectAsState().value

    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ) {
        composable(route = Halaman.Splash.name) {
            SplashScreenView(onMulaiButton = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Matakuliah.name) {
            RencanaStudiView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = { krsViewModel.saveDataKRS(it) },
                onBackButtonClicked = {
                    navController.popBackStack()
                },
                navController = navController
            )

        }
        composable(route = Halaman.Tampil.name) {
            TampilView(
                mahasiswa = mahasiswaUiState,
                rencanaStudi = krsUiState,
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

    }
}