package com.example.dam.pokedex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_poke.*
import kotlinx.android.synthetic.main.pokeview.*

class addPoke : AppCompatActivity() {

    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_poke)

        database = FirebaseDatabase.getInstance()
        dbReference = database.getReference("Kanto")

        Anade.setOnClickListener {
            loadDatabase(dbReference)
        }
    }

    fun loadDatabase(firebaseData: DatabaseReference) {
        val pokemon= Pokemon(numero.text.toString(),nombre.text.toString(),tipo.text.toString(),txtHabilidad.text.toString())

        firebaseData.child(nombre.text.toString()).setValue(pokemon)
    }
}
