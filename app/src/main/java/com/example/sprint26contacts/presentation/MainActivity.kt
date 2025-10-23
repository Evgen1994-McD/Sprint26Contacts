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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
                ContactDetails(
                    contact = Contact(
                        name = "Евгений",
                        surname = "Сергеевич",
                        familyName = "Авдейкин",
                        imageRes = R.drawable.orig,
                        isFavorite = true,
                        phone = "+79655631039",
                        address = "г. Пермь, ул. Космонавта Беляева 61В, кв. 4",
                        email = "MrMarwell@Gmail.com"
                    )
                )

            }
        }
    }
}
@Composable
fun ContactDetails(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Avatar(contact)
        Name(contact)
        NumberPhone(contact)
        AdressPrinter(contact.address, stringResource(R.string.address))
        AdressPrinter(contact.email, stringResource(R.string.email))

    }
}
@Composable
fun Avatar(contact: Contact) {
    val img = contact.imageRes
    Box {
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .size(64.dp)
                .clip(shape = CircleShape),
            painter = if (img != null) {
                painterResource(id = img)
            } else {
                painterResource(id = R.drawable.circle)
            },
            contentDescription = null
        )
        if (img == null) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = contact.name.take(1) + contact.familyName.take(1),
                fontWeight = FontWeight.Bold
            )
        }
    }

}
@Composable
fun AdressPrinter(adress: String?, text: String?) {
    if (adress != null) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text.toString(),
                modifier = Modifier,
                fontSize = 18.sp
            )
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = adress.toString(),
                    maxLines = 2
                )
            }
        }
    }
}
@Composable
fun NumberPhone(contact: Contact) {
    var number = stringResource(R.string.no_number)
    if (contact.phone.isNotEmpty()) {
        number = contact.phone
    }
    Row(
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.phone),
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
    Column(
        modifier = Modifier
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            contact.name + " " + contact.surname,
            maxLines = 2,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = contact.familyName,
                modifier = Modifier
                    .padding(top = 8.dp),
                fontSize = 24.sp,
            )
            if (contact.isFavorite) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "favorite",
                    tint = Color.Red,
                    modifier = Modifier
                        .padding(
                            top = 8.dp,
                            start = 5.dp
                        )
                )
            }
        }

    }
}
/**
 * Функции предпросмотра с данными и без данных
 */

@Preview(showSystemUi = true)
@Composable
private fun MainPreviewFullData() {
    ContactDetails(
        contact = Contact(
            name = "Евгений",
            surname = "Сергеевич",
            familyName = "Авдейкин",
            imageRes = R.drawable.orig,
            isFavorite = true,
            phone = "+79655631039",
            address = "г. Пермь, ул. Космонавта Беляева 61В, кв. 4",
            email = "MrMarwell@Gmail.com"
        )
    )
}
@Preview(showSystemUi = true)
@Composable
private fun MainPreviewNoData() {
    ContactDetails(
        contact = Contact(
            name = "Евгений",
            surname = "",
            familyName = "Авдейкин",
            imageRes = null,
            isFavorite = false,
            phone = "",
            address = "г. Пермь, ул. Космонавта Беляева 61В, кв. 4",
            email = null
        )
    )
}
