package com.example.proyectomoviles.ui.navigationdrawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.Configuracion
import com.example.proyectomoviles.R
import com.example.proyectomoviles.model.Rutas
import com.example.proyectomoviles.ui.AcercaDe
import com.example.proyectomoviles.ui.Ayuda
import com.example.proyectomoviles.ui.LlantasScreen
import com.example.proyectomoviles.ui.Perfil
import com.example.proyectomoviles.ui.Principal
import com.example.proyectomoviles.ui.Tareas
import com.example.proyectomoviles.ui.auth.inicioSesion
import com.example.proyectomoviles.ui.auth.registrarseSesion
import com.example.proyectomoviles.ui.usables.AlertDialogDoc
import com.example.proyectomoviles.ui.viewmodels.AuthState
import com.example.proyectomoviles.ui.viewmodels.AuthViewModel
import com.example.proyectomoviles.ui.viewmodels.HomeViewModel
import com.example.proyectomoviles.ui.viewmodels.LlantasViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer() {
    val context = LocalContext.current
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navController = rememberNavController()
    val tareasViewModel: HomeViewModel = viewModel()
    val llantasViewModel: LlantasViewModel = viewModel()
    val authViewModel: AuthViewModel = viewModel()

    val openDialog = remember { mutableStateOf(false) }

    val authState = authViewModel.authState.observeAsState()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "EcoRing",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                    HorizontalDivider()

                    NavigationDrawerItem(
                        label = { Text("Menu") },
                        selected = false,
                        onClick = {
                            navController.navigate(Rutas.Principal.route)
                            scope.launch { drawerState.close() }
                        }
                    )

                    NavigationDrawerItem(
                        label = { Text("RimAPI") },
                        selected = false,
                        onClick = {
                            navController.navigate(Rutas.LlantasAPI.route)
                            scope.launch { drawerState.close() }
                        }
                    )

                    NavigationDrawerItem(
                        label = { Text("Tareas") },
                        selected = false,
                        onClick = {
                            navController.navigate(Rutas.Tareas.route)
                            scope.launch { drawerState.close() }
                        }
                    )

                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                    when(authState.value) {
                        AuthState.Authenticated -> {
                            NavigationDrawerItem(
                                label = { Text(context.getString(R.string.perfil)) },
                                selected = false,
                                onClick = {
                                    navController.navigate(Rutas.Perfil.route)
                                    scope.launch { drawerState.close() }
                                }
                            )
                        }
                        else -> {
                            NavigationDrawerItem(
                                label = { Text(context.getString(R.string.iniciarsesion)) },
                                selected = false,
                                icon = {
                                    Icon(
                                        Icons.Outlined.AccountCircle,
                                        contentDescription = null
                                    )
                                },
                                onClick = {
                                    navController.navigate(Rutas.Login.route)
                                    scope.launch { drawerState.close() }
                                }
                            )
                        }
                    }
                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    NavigationDrawerItem(
                        label = { Text(context.getString(R.string.configuracion)) },
                        selected = false,
                        icon = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                        onClick = {
                            navController.navigate(Rutas.Configuracion.route)
                            scope.launch { drawerState.close() }
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text(context.getString(R.string.Ayuda)) },
                        selected = false,
                        icon = { Icon(Icons.Outlined.Info, contentDescription = null) },
                        onClick = {
                            navController.navigate(Rutas.Ayuda.route)
                            scope.launch { drawerState.close() }
                        }
                    )

                    NavigationDrawerItem(
                        label = { Text(context.getString(R.string.SobreNosotros)) },
                        selected = false,
                        icon = { Icon(Icons.Outlined.Person, contentDescription = null) },
                        onClick = {
                            navController.navigate(Rutas.AcercaDe.route)
                            scope.launch { drawerState.close() }
                                  },
                    )
                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    NavigationDrawerItem(
                        label = { Text(context.getString(R.string.salirAplicacion)) },
                        selected = false,
                        icon = { Icon(Icons.Outlined.ExitToApp, contentDescription = null) },
                        onClick = { openDialog.value = true }
                    )

                    if (openDialog.value) {
                        AlertDialogDoc(openDialog)
                    }
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("EcoRing") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                NavHost(
                    navController = navController,
                    startDestination = Rutas.Principal.route
                ) {
                    composable(Rutas.Principal.route) { Principal(navController, authViewModel) }
                    composable(Rutas.Ayuda.route) { Ayuda(navController) }
                    composable(Rutas.AcercaDe.route) { AcercaDe(navController) }
                    composable(Rutas.Configuracion.route) { Configuracion(navController) }
                    composable(Rutas.LlantasAPI.route) { LlantasScreen(llantasViewModel, navController) }
                    composable(Rutas.Login.route) { inicioSesion(navController, authViewModel) }
                    composable(Rutas.Register.route) { registrarseSesion(navController, authViewModel) }
                    composable(Rutas.Perfil.route) { Perfil(navController, authViewModel) }
                    composable(Rutas.Tareas.route) { Tareas(navController) }

                }
            }
        }
    }
}
