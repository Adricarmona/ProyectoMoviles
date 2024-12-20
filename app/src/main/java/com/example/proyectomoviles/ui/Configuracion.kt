package com.example.proyectomoviles

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectomoviles.model.dataStore.ConfiguracionDataStore
import com.example.proyectomoviles.model.Rutas
import com.example.proyectomoviles.ui.usables.EsteticaTitulo
import com.example.proyectomoviles.ui.theme.TipografiaTitulo
import com.example.proyectomoviles.ui.usables.SwitchYTexto
import kotlinx.coroutines.launch


@Composable
fun Configuracion(navController: NavController) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope() // el scoped
    val dataStore = ConfiguracionDataStore(context) // el data store

    var idioma = dataStore.getIdioma.collectAsState(initial = "Idioma del sistema")

    var subscribirseCorreosPromocionales = dataStore.getCorreosPromocionales.collectAsState(initial = false)
    var subscribirseCorreosNoticias = dataStore.getCorreosNoticias.collectAsState(initial = false)


    var privacidad = dataStore.getPrivacidad.collectAsState(initial = false)
    var terminosCondiciones = dataStore.getTerminos.collectAsState(initial = false)

    var expandidoDropdownMenu = remember { mutableStateOf(false) }

    var pagina = dataStore.getPagina.collectAsState(initial = 0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
            text = context.getString(R.string.IdiomaEstetico),
            color = MaterialTheme.colorScheme.secondary,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Text(
                text = context.getString(R.string.Idioma_aplicacion),
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
                    text = {Text(context.getString(R.string.Idioma_del_sistema))},
                    onClick = {
                        toastAleatorio(context)
                        scope.launch { dataStore.saveIdioma("Idioma del sistema") }
                    }
                )

                DropdownMenuItem(
                    text = {Text(context.getString(R.string.Ingles))},
                    onClick = {
                        toastAleatorio(context)
                        scope.launch { dataStore.saveIdioma("English") }
                    }

                )

                DropdownMenuItem(
                    text = {Text(context.getString(R.string.Español))},
                    onClick = {
                        toastAleatorio(context)
                        scope.launch { dataStore.saveIdioma("Español") }
                    }
                )
            }
        }


        /*
            Enviar correos electronicos
         */
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = context.getString(R.string.OpcionesDeCorreoEstetico),
            color = MaterialTheme.colorScheme.secondary,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = subscribirseCorreosPromocionales.value,
                onCheckedChange = { isChecked ->
                    scope.launch {
                        dataStore.saveCorreosPromocionales(isChecked)
                    }
                }
            )
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Text(
                text = context.getString(R.string.EnviarCorreosPromocionales),
                color = MaterialTheme.colorScheme.secondary,
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = subscribirseCorreosNoticias.value,
                onCheckedChange = { isChecked ->
                    scope.launch {
                        dataStore.saveCorreosNoticias(isChecked)
                    }
                }
            )

            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Text(
                text = context.getString(R.string.EnviarCorreosDeNoticias),
                color = MaterialTheme.colorScheme.secondary,
            )
        }
        /*
            Terminos, condiciones y privacidad
         */
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = context.getString(R.string.TerminosCondicionesPrivacidadEstetico),
            color = MaterialTheme.colorScheme.secondary,
        )

        SwitchYTexto(
            context.getString(R.string.TerminosYCondiciones),
            terminosCondiciones as MutableState<Boolean>
        )
        SwitchYTexto(
            context.getString(R.string.AceptarPrivacidad),
            privacidad as MutableState<Boolean>
        )

        /*
            Radio button para elegir la pagina de inicio
         */
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = context.getString(R.string.PaginaDeInicioEstetica),
            color = MaterialTheme.colorScheme.secondary,
        )

        radioGroupASC(
            context,
            pagina as MutableState<Int>,
        )



        /*
            El boton de guardar
         */
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            aceptaPrivacidad(context,terminosCondiciones.value, privacidad.value)
            scope.launch {
                dataStore.saveIdioma(idioma = idioma.value)
                dataStore.saveCorreosPromocionales(correosPromocionales = subscribirseCorreosPromocionales.value)
                dataStore.saveCorreosNoticias(correosNoticias = subscribirseCorreosNoticias.value)
                dataStore.saveTerminos(terminos = terminosCondiciones.value)
                dataStore.savePrivacidad(privacidad = privacidad.value)
                dataStore.savePagina(pagina = pagina.value)

                // para enviarte al inicio
                navController.navigate(Rutas.Principal.route)

            }
        }) {
            Text(context.getString(R.string.Guardar))
        }
    }
}

/*
 * Los toast, privacidad y uno aleatorio
 */

fun aceptaPrivacidad(context: Context,terminos: Boolean, privacidad: Boolean){
    if (terminos == privacidad && terminos == true) {
        Toast.makeText(context, context.getString(R.string.AceptadoCorrectamenteAmbos), Toast.LENGTH_LONG).show();
    } else {
        Toast.makeText(context, context.getString(R.string.DenegadoAmbosApartados), Toast.LENGTH_LONG).show();
    }

}

fun toastAleatorio(context: Context){
    Toast.makeText(context, context.getString(R.string.FuncionaElOnClick), Toast.LENGTH_SHORT).show();
}


/*
 *  Los radio groups
 */

@Composable
fun radioGroupASC(
    context: Context,
    pagina: MutableState<Int>,
){


    ProyectoMovilesTheme {
        Column {
            /*
             *  AYUDA
             */
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = if (pagina.value == 1) { true } else { false },
                    onClick = { pagina.value = 1},
                    colors = RadioButtonColors(
                        selectedColor = MaterialTheme.colorScheme.primary,
                        disabledSelectedColor = MaterialTheme.colorScheme.secondary,
                        unselectedColor = MaterialTheme.colorScheme.secondaryContainer,
                        disabledUnselectedColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )

                Text(
                    text = context.getString(R.string.Ayuda),
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

            /*
             *  sobreNosotros
             */
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = if (pagina.value == 2) { true } else { false },
                    onClick = { pagina.value = 2},
                    colors = RadioButtonColors(
                        selectedColor = MaterialTheme.colorScheme.primary,
                        disabledSelectedColor = MaterialTheme.colorScheme.secondary,
                        unselectedColor = MaterialTheme.colorScheme.secondaryContainer,
                        disabledUnselectedColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
                Text(
                    text = context.getString(R.string.SobreNosotros),
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

            /*
             *   Configuracion
             */
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = if (pagina.value == 3) { true } else { false },
                    onClick = { pagina.value = 3},
                    colors = RadioButtonColors(
                        selectedColor = MaterialTheme.colorScheme.primary,
                        disabledSelectedColor = MaterialTheme.colorScheme.secondary,
                        unselectedColor = MaterialTheme.colorScheme.secondaryContainer,
                        disabledUnselectedColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
                Text(
                    text = context.getString(R.string.Configuracion),
                    color = MaterialTheme.colorScheme.secondary,
                )
            }
        }
    }
}

/*
 * LA Preview
 */


/*@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "es")
@Composable
fun previewConfiguracion() {
    ProyectoMovilesTheme{
        Configuracion()
    }
}*/