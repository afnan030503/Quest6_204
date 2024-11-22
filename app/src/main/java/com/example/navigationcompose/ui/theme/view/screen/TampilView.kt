package com.example.navigationcompose.ui.theme.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationcompose.model.Mahasiswa
import com.example.navigationcompose.model.RencanaStudi

@Composable
fun TampilView(
    mahasiswa: Mahasiswa,
    rencanaStudi: RencanaStudi,
    onBackButtonClicked: () -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        // Tampilkan data mahasiswa
        Text(text = "Nama: ${mahasiswa.nama}", fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "NIM: ${mahasiswa.nim}", fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Email: ${mahasiswa.email}", fontSize = 20.sp)

        Spacer(modifier = Modifier.padding(16.dp))

        // Tampilkan data rencana studi
        Text(text = "Mata Kuliah: ${rencanaStudi.namaMK}", fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Kelas: ${rencanaStudi.kelas}", fontSize = 20.sp)

        Spacer(modifier = Modifier.padding(16.dp))

        // Tombol kembal
        Button (onClick = {  onBackButtonClicked()}) {
            Text(text = "Kembali")
    }



    }
}