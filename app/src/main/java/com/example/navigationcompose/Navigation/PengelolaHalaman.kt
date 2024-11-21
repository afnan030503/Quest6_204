package com.example.navigationcompose.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.ui.theme.view.screen.MahasiswaFormView
import com.example.navigationcompose.ui.theme.view.screen.RencanaStudiView
import com.example.navigationcompose.ui.theme.view.viewmodel.MahasiswaViewModel
import com.example.navigationcompose.ui.theme.view.viewmodel.RencanaStudiViewModel

enum class Halaman{
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil,

}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudiViewModel = viewModel(),
    navController: NavController = rememberNavController()

){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ) {
        composable(route = Halaman.Splash.name) {
            SplashView(onMulaiButoon = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButoonClicked = {
                    MahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

    }
}