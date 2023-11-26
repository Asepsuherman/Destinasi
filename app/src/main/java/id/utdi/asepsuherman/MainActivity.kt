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
import androidx.compose.runtime.internal.composableLambda
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

sealed class Destination(val route:String){
    object Home: Destination("home")
    object List: Destination("list")
    object Detail: Destination("detail/{elementId"){
        fun createRoute(elementId: Int) = "detail/$elementId"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DestinasiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)
                }
            }
        }
    }
}

@Composable
fun NavigationAppHost(navController: NavHostController){
    val ctx = LocalContext.current
 NavHost(navController = navController, startDestination = "home"){
     composable(Destination.Home.route) { HomeScreen(navController)}
     composable(Destination.List.route) { ListScreen(navController)}
     composable(Destination.Detail.route) {navBackStackEntry ->
         val elementId = navBackStackEntry.arguments?.getInt("elementId")
         if (elementId == null){
             Toast.makeText(ctx,"ElementId is required", Toast.LENGTH_SHORT).show()
         } else {
             Detail(elementId = elementId)
         }
     }
 }
}
