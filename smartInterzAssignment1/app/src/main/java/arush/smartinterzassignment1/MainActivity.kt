package arush.smartinterzassignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import arush.smartinterzassignment1.ui.theme.SmartInterzAssignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartInterzAssignment1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
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
    var text by remember { mutableStateOf("") }
    var paswrd by remember { mutableStateOf("") }
    Column (modifier = Modifier.fillMaxSize()){
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp), horizontalArrangement = Arrangement.Center){
            Text(text = "Login", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color(0xFFE49B0F))
        }

        Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center){
            Row(
                modifier = Modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(value = text, onValueChange = { newText -> text = newText },
                    textStyle = TextStyle(color = Color.Black),
                    label = { Text(text = "Username") })
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp), horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(value = paswrd, onValueChange = { newText -> paswrd = newText },
                    textStyle = TextStyle(color = Color.Black),
                    label = { Text(text = "Password") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation(),
                )
            }
            Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                Button(
                    onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color.Magenta),
                    shape = RectangleShape
                ) {
                    Text(text = "Sign in", fontSize = 20.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartInterzAssignment1Theme {
        Greeting()
    }
}