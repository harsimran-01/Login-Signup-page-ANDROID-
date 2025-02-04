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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    NavigationToSignUp:()->Unit={}
){
    var User_name by remember{ mutableStateOf("") }
    var Password by remember{ mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = "Login",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif
            )

        Spacer(modifier = modifier.height(19.dp))

        OutlinedTextField(value = User_name,
            onValueChange = {User_name = it},
            label = { Text(text = "Username")},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person,
                    contentDescription = "username")
            })

        Spacer(modifier = modifier.height(10.dp))

        OutlinedTextField(value = Password,
            onValueChange = {Password = it},
            label = { Text(text = "Password")},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock,
                    contentDescription = "Password")
            }, visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = modifier.height(10.dp))

        Button(onClick = {
            Log.i("Credentials","Username : ${User_name} Password : ${Password}")
        }) {
            Text(text = "Login")

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(10.dp)
        ){
            Text(text = "Forgot Password ?",
                Modifier.clickable { })

        }

        Spacer(modifier = modifier.padding(10.dp))

        Text(text = "Don't have an Account? Sign Up",
            modifier=modifier.clickable {NavigationToSignUp()})

    }

}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview(){
    LoginPage()
}
