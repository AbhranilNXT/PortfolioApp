package com.example.portfolioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.portfolioapp.ui.theme.PortfolioAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateCard()

                }
            }
        }
    }
}

@Composable
fun CreateCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
    , color = Color.White) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(18.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(20.dp)
        ) {


            Column(modifier = Modifier
                .height(700.dp)
                .width(390.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally){

                CreateImageProfile()

                Divider(color = Color.LightGray,
                    thickness = 3.dp)

                CreateInfoTab()
                
                Button(
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                    }) {
                    
                    Text(text = "Portfolio",
                        style = MaterialTheme.typography.labelLarge)
                    
                }
                if (buttonClickedState.value)
                    Projects()
                else Box(){}


            }



        }
    }
}

@Preview
@Composable
fun Projects(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(3.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            border = BorderStroke(width = 4.dp, color = Color.Black)
        ) {

            Portfolio(data = listOf("Project 1","Project 2","Project 3"))

        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data) {item ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(13.dp)
                , elevation = CardDefaults.cardElevation(30.dp),
                shape = RectangleShape) {

                Row(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp)) {

                    CreateImageProfile(modifier = Modifier.size(100.dp))

                    Column(Modifier.padding(8.dp).align(Alignment.CenterVertically)) {

                        Text(item, fontWeight = FontWeight.Bold)
                        Text(text = "A good project",
                            style = MaterialTheme.typography.bodyMedium)
                    }

                }

            }
        }
    }

}


@Composable
private fun CreateInfoTab() {
    Column(
        modifier = Modifier.padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Abhranil ''NXT'' Dasgupta",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Blue
        )
        //color = MaterialTheme.colorScheme.onSurfaceVariant

        Text(
            text = "Android Developer",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "IoT Lab, KIIT", Modifier.padding(5.dp),
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "@abhranil_nxt", Modifier.padding(5.dp),
            style = MaterialTheme.typography.bodyLarge
        )


    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)

    ) {

        Image(
            painter = painterResource(id = R.drawable.prof), contentDescription = "Profile Image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PortfolioAppTheme {
        CreateCard()

    }
}