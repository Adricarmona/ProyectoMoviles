package com.example.proyectomoviles

import android.app.Application
import com.example.proyectomoviles.model.tareas.MyFriendsContainer

class MyFriendsApplication : Application() {
    lateinit var container: MyFriendsContainer

    override fun onCreate() {
        super.onCreate()
        container = MyFriendsContainer(this)
    }
}