/*
 * Ini adalah file Kotlin untuk layar utama (HomeScreen) dalam aplikasi.
 * Berisi definisi fungsi @Composable HomeScreen yang menampilkan tata letak antarmuka pengguna.
 * Program menggunakan framework Compose untuk membangun antarmuka pengguna secara deklaratif.
 */

// Package yang berisi kode terkait tampilan
package id.utdi.asepsuherman.screen

// Import beberapa komponen dari framework Compose dan AndroidX
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import id.utdi.asepsuherman.Destination

// Fungsi utama yang mendefinisikan tampilan layar utama (HomeScreen)
@Composable
fun HomeScreen(navController: NavController) {
    // Column digunakan untuk menyusun elemen tata letak secara vertikal
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Menampilkan teks "Home" di tengah layar
        Text(text = "Home")

        // Tombol dengan teks "to List", dan akan menavigasi ke layar List saat ditekan
        Button(onClick = { navController.navigate(Destination.List.route) }) {
            Text(text = "to List")
        }
    }
}
