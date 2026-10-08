package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TitleCard(fullName: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_business_card_img)
    Box(
        modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = "Android-image",
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            )
            Text(
                text = fullName,
                color = Color(0xFF082e41),
                fontSize = 40.sp,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF346b40)
            )
        }
    }
}

@Composable
fun ContactDetails(phone: String, socialsLink: String, email: String, modifier: Modifier = Modifier) {
    val textColor = Color(0xFF082e41)
    Box(
        modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(Modifier.padding(bottom = 8.dp)) {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Phone",
                    tint = Color(0xFF346b40)
                )
                Text(
                    text = phone,
                    color = textColor,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            Row(Modifier.padding(bottom = 8.dp)) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Share",
                    tint = Color(0xFF346b40)
                )
                Text(
                    text = socialsLink,
                    color = textColor,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            Row {
                Icon(
                    imageVector = Icons.Filled.Email, //346b40
                    contentDescription = "Email",
                    tint = Color(0xFF346b40)
                )
                Text(
                    text = email, //082e41
                    color = textColor,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    // 60% to 40% space d7e7d5, 'cheated' by using spacers
    Surface(
        modifier,
        color = Color(0xFFd7e7d5)) {
        Column(
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(Modifier.weight(1.25F))
            TitleCard(
                "Peter Cypers",
                title = "Android Developer Extraordinaire",
                modifier = Modifier.weight(1F)
            )
            Spacer(Modifier.weight(.15F))
            ContactDetails(
                "(+32) 1234 56 78",
                "@Dev_Peter_Socials",
                "peter@email.com",
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TitleCardPreview() {
    BusinessCardTheme {
        TitleCard("Peter Cypers", title = "Android Developer Extraordinaire")
    }
}

@Preview(showBackground = true)
@Composable
fun ContactDetailsPreview() {
    BusinessCardTheme {
        ContactDetails(
            "(+32) 1234 56 78",
            "@Dev_Peter_Socials",
            "peter@email.com"
        )
    }
}