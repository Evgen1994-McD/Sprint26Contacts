package com.example.sprint26contacts.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sprint26contacts.R
import com.example.sprint26contacts.domain.models.Contact
import com.example.sprint26contacts.ui.theme.Sprint26ContactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sprint26ContactsTheme {

            }
        }
    }
}


@Composable
fun MainScreen(contact: Contact) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ){
Avatar(contact)
    }
}


@Composable
fun Avatar(contact: Contact){
    Box{
        Image(modifier = Modifier
            .align(Alignment.Center),
            painter = painterResource(id = R.drawable.circle), contentDescription = "icon")
        Text(modifier = Modifier
            .align(Alignment.Center),
            text = contact.name.take(1)+contact.familyName.take(1))
    }
}



@Preview(showSystemUi = true)
@Composable
private fun MainPreview(){
    MainScreen(contact = Contact(
        name = "Женя",
        surname = "Сергеевич",
        familyName = "Авдейкин",
        imageRes = null,
        isFavorite = true,
        phone = "+79655631039",
        address = "Perm",
        email = "MrMarwell@Gmail.com"
    ))
}
