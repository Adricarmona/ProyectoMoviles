package com.example.proyectomoviles.ui.usables

import android.app.Activity
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import com.example.proyectomoviles.R


@Composable
fun AlertDialogDoc(openDialog: MutableState<Boolean>) {
    val context = LocalContext.current
    val activity = context as? Activity
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = context.getString(R.string.salirAplicacion))
            },
            text = {
                Text(
                    context.getString(R.string.SeguroDeSalir)
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        activity?.finishAffinity()
                    }
                ) {
                    Text(context.getString(R.string.aceptar))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text(context.getString(R.string.cancelar))
                }
            }
        )
    }
}