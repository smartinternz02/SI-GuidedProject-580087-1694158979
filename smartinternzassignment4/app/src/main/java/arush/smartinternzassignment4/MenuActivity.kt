package arush.smartinternzassignment4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import arush.smartinternzassignment4.ui.theme.SmartInternzAssignment4Theme
import kotlin.random.Random
import kotlin.random.nextInt

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val num = intent.getIntExtra("menuNum", 0)
        Log.d("qwerty", num.toString())

        setContent {
            SmartInternzAssignment4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    menuScreen(num)
                }
            }
        }
    }
}

@Composable
fun menuScreen(num: Int) {

    var itemCount by remember { mutableStateOf(0) }

    var imageList = arrayListOf<Int>(R.drawable.coffee_bg, R.drawable.dominos_bg,R.drawable.kfc_bg,
        R.drawable.burgerking_bg, R.drawable.biryani_bg, R.drawable.paneer_bg)
    var restList = arrayListOf<String>("Cafe coffee day","Domino's pizza","KFC","Burger king","Biryani house"
        ,"Royal cuisine")
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = imageList[num]), contentDescription = "Hotel Pic",
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.3f),
            contentScale = ContentScale.Crop)
        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
            .padding(top = 6.dp)){
            Text(text = restList[num], style = TextStyle(fontSize = 30.sp, fontFamily = FontFamily(
                Font((R.font.poppins_regular), weight = FontWeight(1))), fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(start = 10.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .padding(end = 10.dp)){
                    Image(painter = painterResource(id = R.drawable.baseline_shopping_cart_24), contentDescription = "Cart",
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(80.dp, 40.dp))
                    Box(modifier = Modifier.align(Alignment.BottomEnd)){
                        Row (modifier = Modifier.padding(end = 12.dp, bottom = 5.dp)){
                            Text(text = itemCount.toString(), style = TextStyle(fontSize = 22.sp),
                                color = Color(0xFFE93545), fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally){
            cardMaker(num) { itemCount++ }
        }
    }
}

@Composable
fun cardMaker(menuNum : Int, itemCounter: () -> Unit ){
    val menuId = R.array.Menu0 + menuNum
    val menuArray = stringArrayResource(id = menuId)
    for(menuItem in menuArray){
        Card(modifier = Modifier
            .fillMaxWidth(0.95f)
            .wrapContentHeight()
            .padding(top = 12.dp,),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(modifier = Modifier.fillMaxSize().padding(top = 8.dp, bottom = 8.dp),
                verticalArrangement = Arrangement.Center) {
                Row (modifier = Modifier){
                    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                        Text(text = menuItem, style = TextStyle(fontFamily = FontFamily(Font((R.font.roboto_regular),
                            weight = FontWeight(1))), fontSize = 22.sp),
                            modifier = Modifier.padding(start = 10.dp))
                        Text(text = "₹ "+ makePrice().toString(), style = TextStyle(fontSize = 18.sp),
                            modifier = Modifier.padding(start = 10.dp, top = 8.dp))
                    }
                    Box(modifier = Modifier.fillMaxSize()
                        .align(Alignment.CenterVertically),) {
                        Button(onClick = { itemCounter() }, modifier = Modifier
                            .size(110.dp, 38.dp)
                            .padding(end = 10.dp)
                            .align(Alignment.CenterEnd)
                            , colors = ButtonDefaults.buttonColors(Color(0xFFFFB3B9)),
                            contentPadding = PaddingValues(),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color(0xFFE93545))
                        ) {
                            Text(text = "Add to Cart", color = Color(0xFFE93545), style = TextStyle(fontSize = 17.sp,
                                fontWeight = FontWeight.Bold))
                        }
                    }
                }
            }
        }
    }
}

private fun makePrice() : Int{
    var num = Random.nextInt(200..600)
    return num
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SmartInternzAssignment4Theme {
        menuScreen(0)
    }
}