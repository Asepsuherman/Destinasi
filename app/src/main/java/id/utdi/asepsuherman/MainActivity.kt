package id.utdi.asepsuherman

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import id.utdi.asepsuherman.screen.Detail
import id.utdi.asepsuherman.screen.HomeScreen
import id.utdi.asepsuherman.screen.ListScreen
import id.utdi.asepsuherman.ui.theme.DestinasiTheme

// Sealed class untuk representasi destinasi (halaman) dalam aplikasi
sealed class Destination(val route:String){
    object Home: Destination("home")
    object List: Destination("list")
    object Detail: Destination("detail/{elementId"){
        // Fungsi untuk membuat route detail dengan menyertakan elementId
        fun createRoute(elementId: Int) = "detail/$elementId"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DestinasiTheme {
                // Container surface menggunakan warna 'background' dari tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Mendeklarasikan NavController dan menggunakan NavigationAppHost
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)
                }
            }
        }
    }
}

@Composable
fun NavigationAppHost(navController: NavHostController){
    // Mengambil konteks lokal
    val ctx = LocalContext.current

    // Mendefinisikan NavHost dengan start destination pada halaman home
    NavHost(navController = navController, startDestination = Destination.Home.route){
        // Menentukan komposisi untuk halaman home
        composable(Destination.Home.route) { HomeScreen(navController)}

        // Menentukan komposisi untuk halaman list
        composable(Destination.List.route) { ListScreen(navController)}

        // Menentukan komposisi untuk halaman detail dengan memanfaatkan argumen
        composable(Destination.Detail.route) {navBackStackEntry ->
            // Mendapatkan elementId dari argumen
            val elementId = navBackStackEntry.arguments?.getInt("elementId")

            // Memeriksa apakah elementId ada
            if (elementId == null){
                // Menampilkan pesan Toast jika elementId tidak ada
                Toast.makeText(ctx,"ElementId is required", Toast.LENGTH_SHORT).show()
            } else {
                // Menampilkan halaman detail jika elementId ada
                Detail(elementId = elementId)
            }
        }
    }
}
