package com.example.sprint26contacts.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Avatar(contact)
        Name(contact)
        NumberPhone(contact)
        Address(contact)

    }

}


@Composable
fun Avatar(contact: Contact) {
    Box {
        Image(
            modifier = Modifier
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.circle), contentDescription = "icon"
        )
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = contact.name.take(1) + contact.familyName.take(1)
        )
    }

}


@Composable
fun Address(contact: Contact){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
Text(
    text = "Адрес:",
    modifier = Modifier,
    fontSize = 18.sp
)
        Box(
            modifier = Modifier
                .width(150.dp)
        ){
            Text(
                text = contact.address,
                maxLines = 2
            )
        }


    }
}




@Composable
fun NumberPhone(contact: Contact){
    var number = "---"
    if (contact.phone.isNotEmpty()){
        number = contact.phone
    }
Row(
    modifier = Modifier
        .padding(top = 40.dp)
        .fillMaxWidth(),
    horizontalArrangement = Arrangement.Center
) {
    Text(
        text = "Телефон:",
        modifier = Modifier
            .padding(end = 3.dp),
        fontSize = 18.sp
    )
    Text(
        text = number,
        fontSize = 18.sp
    )
}

}



@Composable
fun Name(contact: Contact) {
    Box(
        modifier = Modifier
            .padding(top = 10.dp)
    ) {
        Text(
            contact.name + " " + contact.surname,
            maxLines = 2,
            modifier = Modifier,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = contact.familyName,
            modifier = Modifier
                .padding(top = 25.dp)
                .align(Alignment.Center),
            fontSize = 24.sp,

            )
    }
}


@Preview(showSystemUi = true)
@Composable
private fun MainPreview() {
    MainScreen(
        contact = Contact(
            name = "Евгений",
            surname = "Сергеевич",
            familyName = "Авдейкин",
            imageRes = null,
            isFavorite = true,
            phone = "+79655631039",
            address = "Perm GGGGGGGGGGGG ddsa sdsdsd",
            email = "MrMarwell@Gmail.com"
        )
    )
}
