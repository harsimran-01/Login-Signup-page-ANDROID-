package eu.tutorials.practice

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpPage(
    modifier: Modifier = Modifier,
    NavigationToLogin:()->Unit={}

){
    var User_name by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var confirm_password by remember{ mutableStateOf("") }
    var emailError by remember{ mutableStateOf("") }

    fun validateEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    Column(
        modifier = Modifier.fillMaxSize().background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Sign Up",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = Color.Black
        )

        Spacer(modifier = modifier.height(10.dp))

        Text(text = "Create an Account")

        Spacer(modifier = modifier.height(10.dp))

        OutlinedTextField(
            value = User_name,
            onValueChange ={User_name = it},
            label = {Text(text = "Username",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray)},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person,
                    contentDescription = "username icon")
            }

        )
        
        Spacer(modifier = Modifier.height(7.dp))

        OutlinedTextField(
            value = Email,
            onValueChange ={Email = it
                emailError = if (validateEmail(it)) "" else "Invalid Email"},
            label = {Text(text = "Email"
                ,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold)
                    },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email,
                    contentDescription = "Email icon")
            },
            isError = emailError.isNotEmpty(), // Highlight error
            colors = TextFieldDefaults.colors( // Use the new function if available
//    errorContainerColor = Color.Red,
//    focusedContainerColor = Color.Blue,
//    unfocusedContainerColor = Color.Gray
)
        )
        if (emailError.isNotEmpty()) {
            Text(
                text = emailError,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }



        Spacer(modifier = Modifier.height(7.dp))

        OutlinedTextField(
            value = password,
            onValueChange ={password = it},
            label = {Text(text = "Password",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold) },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Edit,
                    contentDescription = "Password icon")
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(7.dp))
        OutlinedTextField(
            value = confirm_password,
            onValueChange ={confirm_password = it},
            label = {Text(text = "Confirm Password",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold) },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Edit,
                    contentDescription = "Password icon")
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = modifier.padding(10.dp))

        Button(onClick = {
            Log.i("Credentials","Username: ${User_name} Email: ${Email} Password: ${password}")
        }){
            Text(text = "Sign Up")
        }

        Spacer(modifier = modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)
        ){
            Text(text = "already have an Account ? Login",
                modifier = Modifier.clickable {NavigationToLogin()})

        }


    }

}

@Preview(showBackground = true)
@Composable
fun SignUpPagePreview(){
    SignUpPage()
}
