package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun SignupScreen(
    onNavigateBack: () -> Unit
) {
    var userName by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }
    var userPhone by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }


    val isNameValid = userName.isNotBlank() && userName.all { it.isLetter() || it.isWhitespace() }


    val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()

    val isPhoneValid = userPhone.length == 10 && userPhone.all { it.isDigit() }

    val isPasswordValid = userPassword.isNotBlank() && userPassword == confirmPassword


    val isFormValid = isNameValid && isEmailValid && isPhoneValid && isPasswordValid

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4A47A3)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .width(320.dp)
                    .padding(22.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.img1),
                        contentDescription = "Logo",
                        modifier = Modifier.size(120.dp)
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    Text(
                        text = "Sign Up",
                        color = Color.Black,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(24.dp))


                    OutlinedTextField(
                        value = userName,
                        shape = RoundedCornerShape(12.dp),
                        onValueChange = { userName = it },
                        label = { Text("Full Name") },
                        modifier = Modifier.fillMaxWidth(),
                        isError = userName.isNotEmpty() && !isNameValid,
                        supportingText = { if (userName.isNotEmpty() && !isNameValid) Text("Solo letras permitidas") }
                    )
                    Spacer(modifier = Modifier.height(8.dp))


                    OutlinedTextField(
                        value = userEmail,
                        shape = RoundedCornerShape(12.dp),
                        onValueChange = { userEmail = it },
                        label = { Text("Email") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth(),
                        isError = userEmail.isNotEmpty() && !isEmailValid,
                        supportingText = { if (userEmail.isNotEmpty() && !isEmailValid) Text("Formato de correo inválido") }
                    )
                    Spacer(modifier = Modifier.height(8.dp))


                    OutlinedTextField(
                        value = userPhone,
                        shape = RoundedCornerShape(12.dp),
                        onValueChange = {

                            if (it.length <= 10) userPhone = it
                        },
                        label = { Text("Phone Number") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                        isError = userPhone.isNotEmpty() && !isPhoneValid,
                        supportingText = { if (userPhone.isNotEmpty() && !isPhoneValid) Text("Debe tener exactamente 10 dígitos") }
                    )
                    Spacer(modifier = Modifier.height(8.dp))


                    OutlinedTextField(
                        value = userPassword,
                        shape = RoundedCornerShape(12.dp),
                        onValueChange = { userPassword = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))


                    OutlinedTextField(
                        value = confirmPassword,
                        shape = RoundedCornerShape(12.dp),
                        onValueChange = { confirmPassword = it },
                        label = { Text("Confirm Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        isError = confirmPassword.isNotEmpty() && userPassword != confirmPassword,
                        supportingText = { if (confirmPassword.isNotEmpty() && userPassword != confirmPassword) Text("Las contraseñas no coinciden") }
                    )

                    Spacer(modifier = Modifier.height(24.dp))


                    Button(
                        onClick = { onNavigateBack() },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = isFormValid,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A47A3)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Create Account", color = Color.White, fontSize = 18.sp, modifier = Modifier.padding(vertical = 4.dp))
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    TextButton(onClick = { onNavigateBack() }) {
                        Text("Already have an account? Login", color = Color.Gray)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignupScreenPreview() {
    MaterialTheme {
        SignupScreen(
            onNavigateBack = {}
        )
    }
}