package arush.smartinternzassignment4

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import arush.smartinternzassignment4.ui.theme.SmartInternzAssignment4Theme
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartInternzAssignment4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen { logOut() }
                }
            }
        }
    }

    private fun logOut(){
        firebaseAuth.signOut()
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
        Toast.makeText(applicationContext, "Logged out Successfully", Toast.LENGTH_SHORT).show()
        finish()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(logOut : () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()){
        CenterAlignedTopAppBar(title = {
            Row(modifier = Modifier.height(56.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.tomato_logo), contentDescription = "Logo",
                    modifier = Modifier.size(50.dp))
                Text(text = "Tomato", style = TextStyle(fontFamily = FontFamily(Font((R.font.armageda_wide),
                    weight = FontWeight(1))), fontSize = 44.sp, color = Color.Red),
                    modifier = Modifier.padding(start = 5.dp))
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(end = 5.dp)
                ) {
                    Icon(painter = painterResource(id = R.drawable.baseline_logout_24), contentDescription = "Log out",
                        modifier = Modifier
                            .size(30.dp)
                            .align(alignment = Alignment.CenterVertically)
                            .clickable { logOut() })
                }
            }
        })
        var imageList = arrayListOf<Int>(R.drawable.coffee_bg, R.drawable.dominos_bg,R.drawable.kfc_bg,
            R.drawable.burgerking_bg, R.drawable.biryani_bg, R.drawable.paneer_bg)

        var restList = arrayListOf<String>("Cafe coffee day","Domino's pizza","KFC","Burger king","Biryani house"
            ,"Royal cuisine")

        var descList = arrayListOf<String>("ccd","dominos","kfc","burger king","biryani","royal restaurant")

        hotelCard(bgImage = imageList, bgDesc = descList, restName = restList)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartInternzAssignment4Theme {
        HomeScreen({})
    }
}

@Composable
fun hotelCard(bgImage: ArrayList<Int>, bgDesc: ArrayList<String>, restName: ArrayList<String>){
    var i = 0
    while(i<bgImage.size){
        Card(modifier = Modifier.) {

        }
        i++
    }
}