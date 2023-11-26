package id.utdi.asepsuherman.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.utdi.asepsuherman.Destination
import id.utdi.asepsuherman.R // Gantilah ini dengan nama file resource Anda

data class DestinationWisata(
    val id: Int,
    val nama: String,
    val deskripsi: String,
    val imageResId: Int
)

val destinasiWisataList = listOf(
    DestinationWisata(
        id = 1,
        nama = "Bali",
        deskripsi = "Pulau Dewata dengan keindahan alam dan budayanya.",
        imageResId = R.drawable.traveloka
    ),
    DestinationWisata(
        id = 2,
        nama = "Yogyakarta",
        deskripsi = "Kota pelajar dengan sejarah dan budaya yang kaya.",
        imageResId = R.drawable.traveloka
    ),
    DestinationWisata(
        id = 3,
        nama = "Borobudur",
        deskripsi = "Candi Budha terbesar di dunia yang sangat megah.",
        imageResId = R.drawable.traveloka
    ),
    DestinationWisata(
        id = 4,
        nama = "Komodo Island",
        deskripsi = "Pulau tempat habitat Komodo, reptil terbesar di dunia.",
        imageResId = R.drawable.traveloka
    )
)

@Composable
fun ListScreen(navController: NavController) {
    LazyColumn(modifier = Modifier.background(Color.LightGray)) {
        items(destinasiWisataList) { destinasi ->
            DestinationItem(destinasi = destinasi, navController = navController)
        }
    }
}

@Composable
fun DestinationItem(destinasi: DestinationWisata, navController: NavController) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(Color.White)
            .clickable { navController.navigate(Destination.Detail.createRoute(destinasi.id)) }
    ) {
        Column {
            // Gambar destinasi
            Image(
                painter = painterResource(id = destinasi.imageResId),
                contentDescription = null, // Content description bisa ditambahkan sesuai kebutuhan
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            // Nama destinasi
            Text(
                text = destinasi.nama,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(8.dp)
            )

            // Deskripsi destinasi
            Text(
                text = destinasi.deskripsi,
                modifier = Modifier
                    .padding(8.dp)
            )
            // Tombol untuk navigasi ke layar detail
            Button(
                onClick = { navController.navigate(Destination.Detail.createRoute(destinasi.id)) },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Lihat Detail")
            }
        }
    }
}
