package arush.assignment3

import android.content.Intent
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import arush.assignment3.ui.theme.SmartInternzAssignment3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartInternzAssignment3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var userName by rememberSaveable { mutableStateOf("") }
    var passwd by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    var visibile by rememberSaveable { mutableStateOf(false) }
    var enableState by rememberSaveable { mutableStateOf(false) }
    var loginText by rememberSaveable { mutableStateOf("Login") }

    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(color = Color(0xFFFC8D1B)),
        horizontalAlignment = Alignment.CenterHorizontally){
        Column(modifier = Modifier
            .fillMaxWidth()
            .clip(RectangleShape)
            .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.loginpic), contentDescription = "Login Picture",
                modifier = Modifier
                    .size(128.dp)
                    .clip(RectangleShape))
            Text(
                text = loginText,
                style = TextStyle(fontSize = 36.sp, fontStyle = FontStyle.Italic, fontFamily = FontFamily.Serif),
                modifier = Modifier.padding(top = 14.dp)
            )
            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 35.dp, top = 50.dp, end = 35.dp, bottom = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally){
                TextField(value = userName, onValueChange = {it-> userName = it},
                    label = { Text(text = "Username")},
                    leadingIcon = { Icon(Icons.Filled.Person, contentDescription = null)},
                    modifier = Modifier.fillMaxWidth())
                TextField(value = passwd, onValueChange = {it-> passwd = it},
                    label = { Text(text = "Password")},
                    leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation()
                )
                if(userName != "" && passwd != ""){enableState = true}
                if(!visibile){
                    Button(
                        onClick = {
                            visibile = true
                            loginText = "Welcome $userName"
                        },
                        contentPadding = PaddingValues(horizontal = 40.dp, vertical = 10.dp),
                        modifier = Modifier.padding(top = 20.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFF528F1E)
                        ),
                        enabled = enableState
                    ) {
                        Text(text = "Login", style = TextStyle(fontSize = 24.sp))
                    }
                }
            }
            if (visibile){
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth()) {
                    Row (modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center){
                        Image(painter = painterResource(id = R.drawable.amazonlogo), contentDescription = "amazon logo",
                            modifier = Modifier
                                .clip(RectangleShape)
                                .size(95.dp))
                        Button(onClick = {
                            val amazon= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/"))
                            startActivity(context, amazon, null)
                        }, contentPadding = PaddingValues(horizontal = 40.dp, vertical = 10.dp),
                            modifier = Modifier.padding(top = 20.dp, start = 10.dp), colors = ButtonDefaults.buttonColors(
                                Color(0xFF510679)
                            )) {
                            Text(text = "Login", style = TextStyle(fontSize = 24.sp))
                        }
                    }
                    Row (modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center){
                        Image(painter = painterResource(id = R.drawable.flipkartlogo), contentDescription = "amazon logo",
                            modifier = Modifier
                                .clip(RectangleShape)
                                .size(100.dp))
                        Button(onClick = {
                            val flipkart = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flipkart.com/"))
                            startActivity(context, flipkart, null)
                        }, contentPadding = PaddingValues(horizontal = 40.dp, vertical = 10.dp),
                            modifier = Modifier.padding(top = 20.dp, start = 10.dp), colors = ButtonDefaults.buttonColors(
                                Color(0xFF510679)
                            )) {
                            Text(text = "Login", style = TextStyle(fontSize = 24.sp))
                        }
                    }
                    Row (modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center){
                        Image(painter = painterResource(id = R.drawable.myntralogo), contentDescription = "amazon logo",
                            modifier = Modifier
                                .clip(RectangleShape)
                                .size(90.dp))
                        Button(onClick = {
                            val myntra = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.myntra.com/"))
                            startActivity(context, myntra, null)
                        }, contentPadding = PaddingValues(horizontal = 40.dp, vertical = 10.dp),
                            modifier = Modifier.padding(top = 20.dp, start = 28.dp), colors = ButtonDefaults.buttonColors(
                                Color(0xFF510679)
                            )) {
                            Text(text = "Login", style = TextStyle(fontSize = 24.sp))
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartInternzAssignment3Theme {
        Greeting()
    }
}