package com.example.proyectomoviles

import android.content.Context
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectomoviles.ui.theme.CheckboxYTexto
import com.example.proyectomoviles.ui.theme.EsteticaTitulo
import com.example.proyectomoviles.ui.theme.TipografiaTitulo
import com.example.proyectomoviles.ui.theme.SwitchYTexto

@Composable
fun configuracion() {
    val context = LocalContext.current

    var subscribirseCorreosPromocionales = remember { mutableStateOf(false) }
    var subscribirseCorreosNoticias = remember { mutableStateOf(false) }


    var privacidad = remember { mutableStateOf(false) }
    var terminosCondiciones = remember { mutableStateOf(false) }

    var expandidoDropdownMenu = remember { mutableStateOf(false) }

    var ayuda = remember { mutableStateOf(false) }
    var sobreNosotros = remember { mutableStateOf(false) }
    var configuracion = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        )
    {
        /*
            Titulo
         */
        EsteticaTitulo(
            context.getString(R.string.Configuracion),
            TipografiaTitulo.bodyLarge,
            Modifier.width(350.dp)
        )


        /*
            El dropdown menu de idioma
         */
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "─── Idioma ───",
            color = MaterialTheme.colorScheme.secondary,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Text(
                text = "Idioma aplicacion",
                color = MaterialTheme.colorScheme.primary)
            IconButton(
                onClick = {
                    expandidoDropdownMenu.value = !expandidoDropdownMenu.value
                }
            ) {
                Icon(
                    Icons.Rounded.List,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = "Icono lista de idiomas"
                )
            }
            DropdownMenu(
                expanded = expandidoDropdownMenu.value,
                onDismissRequest = {
                    expandidoDropdownMenu.value = false
                }
            ) {
                DropdownMenuItem(
                    text = {Text("Idioma del sistema")},
                    onClick = { toastAleatorio(context) }
                )

                DropdownMenuItem(
                    text = {Text("Ingles")},
                    onClick = { toastAleatorio(context) }
                )

                DropdownMenuItem(
                    text = {Text("Español")},
                    onClick = { toastAleatorio(context) }
                )
            }
        }


        /*
            Enviar correos electronicos
         */
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "─── Opciones de correo ───",
            color = MaterialTheme.colorScheme.secondary,
        )
        CheckboxYTexto(
            "Enviar correos promocionales",
            subscribirseCorreosPromocionales
        )
        CheckboxYTexto(
            "Enviar correos de noticias",
            subscribirseCorreosNoticias
        )

        /*
            Terminos, condiciones y privacidad
         */
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "─── Terminos, Condiciones y Privacidad ───",
            color = MaterialTheme.colorScheme.secondary,
        )
        SwitchYTexto(
            "Terminos y condiciones",
            terminosCondiciones
        )
        SwitchYTexto(
            "Aceptar privacidad",
            privacidad
        )

        /*
            Radio button para elegir la pagina de inicio
         */
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "─── Pagina de inicio ───",
            color = MaterialTheme.colorScheme.secondary,
        )

        radioGroupASC(
            ayuda,
            sobreNosotros,
            configuracion
        )



        /*
            El boton de guardar
         */
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {aceptaPrivacidad(context,terminosCondiciones.value, privacidad.value)}) {
            Text("guardar")
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "es")
@Composable
fun previewConfiguracion() {
    ProyectoMovilesTheme{
        configuracion()
    }
}

fun aceptaPrivacidad(context: Context,terminos: Boolean, privacidad: Boolean){
    if (terminos == privacidad && terminos == true) {
        Toast.makeText(context, "Aceptado correctamente ambos", Toast.LENGTH_LONG).show();
    } else {
        Toast.makeText(context, "Denegado ambos apartados", Toast.LENGTH_LONG).show();
    }

}

fun toastAleatorio(context: Context){
    Toast.makeText(context, "funciona el onClick", Toast.LENGTH_SHORT).show();
}


@Composable
fun radioGroupASC(
    ayuda: MutableState<Boolean>,
    sobreNosotros: MutableState<Boolean>,
    configuracion: MutableState<Boolean>
){


    ProyectoMovilesTheme {
        Column {
            /*
                AYUDA
             */
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = ayuda.value,
                    onClick = { desSeleccionar(ayuda,sobreNosotros,configuracion); ayuda.value = !ayuda.value },
                    colors = RadioButtonColors(
                        selectedColor = MaterialTheme.colorScheme.primary,
                        disabledSelectedColor = MaterialTheme.colorScheme.secondary,
                        unselectedColor = MaterialTheme.colorScheme.secondaryContainer,
                        disabledUnselectedColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
                Text(
                    text = "Ayuda",
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

            /*
                sobreNosotros
             */
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = sobreNosotros.value,
                    onClick = { desSeleccionar(ayuda,sobreNosotros,configuracion); sobreNosotros.value = !sobreNosotros.value },
                    colors = RadioButtonColors(
                        selectedColor = MaterialTheme.colorScheme.primary,
                        disabledSelectedColor = MaterialTheme.colorScheme.secondary,
                        unselectedColor = MaterialTheme.colorScheme.secondaryContainer,
                        disabledUnselectedColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
                Text(
                    text = "Sobre nosotros",
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

            /*
                Configuracion
            */
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = configuracion.value,
                    onClick = { desSeleccionar(ayuda,sobreNosotros,configuracion); configuracion.value = !configuracion.value },
                    colors = RadioButtonColors(
                        selectedColor = MaterialTheme.colorScheme.primary,
                        disabledSelectedColor = MaterialTheme.colorScheme.secondary,
                        unselectedColor = MaterialTheme.colorScheme.secondaryContainer,
                        disabledUnselectedColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
                Text(
                    text = "Sobre nosotros",
                    color = MaterialTheme.colorScheme.secondary,
                )
            }
        }
    }
}

fun desSeleccionar(
    ayuda: MutableState<Boolean>,
    sobreNosotros: MutableState<Boolean>,
    configuracion: MutableState<Boolean>
)
{
    ayuda.value = false
    sobreNosotros.value = false
    configuracion.value = false
}