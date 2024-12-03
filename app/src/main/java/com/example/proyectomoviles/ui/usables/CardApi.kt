package com.example.proyectomoviles.ui.usables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.proyectomoviles.ProyectoMovilesTheme
import com.example.proyectomoviles.R

@Composable
fun CardDatosLLantas (
    brand: String,
    model: String,
    size: String,
    material: String,
    color: String,
    price: Int,
    image_url: String
){
    val context = LocalContext.current

    Card(
        modifier = Modifier.padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp,8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image_url.replace("http://", "https://"))
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.rueda_cargando_sin_fondo),
                error = painterResource(R.drawable.rueda_error_sin_fondo),
                contentDescription = brand,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .weight(0.3f)
            )
            Column(
                modifier = Modifier
                    .padding(20.dp, 0.dp)
                    .weight(0.7f)
            ) {
                Text(
                    text = "$brand - $model",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )


                Text(
                    text = context.getString(R.string.tamanio)+" "+size,
                    fontSize = 13.sp
                )
                Text(
                    text = context.getString(R.string.tipo)+" "+material,
                    fontSize = 13.sp
                )
                Text(
                    text = context.getString(R.string.precio)+" "+price/100+"€",
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "es")
@Composable
fun previewCardDatos() {
    ProyectoMovilesTheme{
        CardDatosLLantas(
            brand = "TODOT",
            model = "TODOT",
            size = "TODO",
            material = "TODO",
            color = "TODO",
            price = 100,
            image_url = "s"
        )
    }
}