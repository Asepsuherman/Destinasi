// Program ini merupakan bagian dari package id.utdi.asepsuherman.screen
package id.utdi.asepsuherman.screen

// Mengimpor library untuk animasi dan komponen UI pada Compose
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

// Fungsi Composable untuk menampilkan detail berdasarkan elementId yang diterima sebagai parameter
@Composable
fun Detail(elementId: Int) {
    // Mendefinisikan Column sebagai komponen utama dengan properti-modifier, horizontalAlignment, dan verticalArrangement
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Menampilkan teks "Detail Screen" menggunakan komponen Text
        Text(text = "Detail Screen")

        // Menampilkan teks yang mengandung informasi elementId yang telah diklik
        Text(text = "You have clicked on element $elementId")
    }
}
