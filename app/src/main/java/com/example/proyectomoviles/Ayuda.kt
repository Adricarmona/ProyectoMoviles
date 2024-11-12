package com.example.proyectomoviles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Ayuda() {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = "Ayuda"
        )
        Spacer(
            Modifier.size(20.dp)
        )
        Image(
            painter = painterResource(R.drawable.png_clipart_rim_et_keskin_tuning_europe_gmbh_car_tuning_alloy_wheel_kt_miscellaneous_auto_part) ,
            contentDescription = "es una foto de una llanta to guapa"
        )
        Text(
            text = "Bienvenido a la sección de Ayuda. Aquí encontrarás respuestas a las preguntas frecuentes y guías para hacer tu experiencia de compra de llantas más fácil y rápida.\n" +
                    "\n" +
                    "Preguntas Frecuentes (FAQ)\n" +
                    "¿Cómo busco llantas para mi vehículo?\n" +
                    "Ingresa la marca, modelo y año de tu vehículo en el buscador para obtener llantas compatibles. También puedes buscar por medidas específicas o por tipo de llanta si ya tienes esos datos.\n" +
                    "\n" +
                    "¿Cómo realizo una compra?\n" +
                    "Una vez seleccionada la llanta, agrégala al carrito y sigue los pasos en pantalla para completar tu compra. Puedes pagar con tarjeta de crédito, débito o métodos de pago alternativos.\n" +
                    "\n" +
                    "¿Qué métodos de envío ofrecen?\n" +
                    "Ofrecemos envío a domicilio y también puedes optar por recoger tus llantas en una tienda cercana. Los tiempos de envío y costos varían según la ubicación.\n" +
                    "\n" +
                    "¿Puedo devolver o cambiar mis llantas?\n" +
                    "Las devoluciones o cambios están permitidos dentro de los primeros 30 días después de la compra. Las llantas deben estar sin usar y en su empaque original. Consulta nuestra política de devoluciones para más detalles.\n" +
                    "\n" +
                    "Contacto\n" +
                    "Si necesitas más ayuda o tienes una consulta específica, puedes contactarnos:\n" +
                    "\n" +
                    "Correo electrónico: soporte@llantas.com\n" +
                    "Teléfono: +34 123 456 789\n" +
                    "Horario de atención: Lunes a viernes de 9:00 a 18:00\n" +
                    "Consejos para tu compra\n" +
                    "Revisa bien las especificaciones de tus llantas antes de comprarlas para asegurar la compatibilidad con tu vehículo.\n" +
                    "Aprovecha las promociones y descuentos especiales que encontrarás en la sección de Ofertas."
        )
    }


}
