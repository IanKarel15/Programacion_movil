package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(innerPadding)
                }
            }
        }
    }
}

@Composable
fun MainScreen(padding: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFF4A47A3))
                .fillMaxSize(),
            contentAlignment =
                Alignment.Center
        ){
            Box(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .width(320.dp)
                    .height(700.dp)
                    .padding(22.dp)
            ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(34.dp))
                    Image(
                        painter = painterResource(id = R.drawable.img1),
                        contentDescription = "Logo",
                        modifier = Modifier.size(210.dp)
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Hello",
                        color = (Color(0xFF4A47A3)),
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "Welcome to my first test of an application in Android Studio.",
                        fontSize = 16.sp,
                        color = (Color(0xFF4A47A3)),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4A47A3)
                        )
                    ) {
                        Text("Login",color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(14.dp))
                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        border = BorderStroke(2.dp, Color(0xFF4A47A3))
                    ) {
                        Text("Sign Up", color = Color(0xFF4A47A3))
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Sign up using",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {},
                            modifier = Modifier.size(45.dp),
                            shape = CircleShape,
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0077B5))

                        ) {
                            Text("in",color = Color.White, fontSize = 30.sp,fontWeight  = FontWeight.Bold)
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier.size(45.dp),
                            shape = CircleShape,
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B5998))
                        ) {
                            Text("f",color = Color.White, fontSize = 25.sp,fontWeight  = FontWeight.Bold)
                        }
                        Button(
                            onClick = {},
                            modifier = Modifier.size(45.dp),
                            shape = CircleShape,
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDB4437))

                        ) {
                            Text("G+",color = Color.White, fontSize = 20.sp,fontWeight  = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyApplicationTheme {
        MainScreen(padding = PaddingValues(0.dp))
    }
}



