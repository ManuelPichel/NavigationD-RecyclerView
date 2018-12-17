package com.example.dam.pokedex

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.firebase.database.*
import com.google.gson.Gson

class Kanto : AppCompatActivity() {

    private lateinit var rv: RecyclerView
    private lateinit var va: RecyclerView.Adapter<*>
    private lateinit var vm: RecyclerView.LayoutManager
    private lateinit var ref: DatabaseReference
    private lateinit var db: FirebaseDatabase
    var listPoke: ArrayList<Pokemon> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kanto)

        vm = LinearLayoutManager(this)
        va = NewAdapter(listPoke)

        db = FirebaseDatabase.getInstance()
        ref = db.getReference("Kanto")

        val menuListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listPoke.clear()
                val gson= Gson()
                for (objj  in dataSnapshot.children){
                    val registro=objj.getValue()
                    try {
                        val reg:Pokemon=gson.fromJson(registro.toString(),Pokemon::class.java)
                        listPoke.add(reg)
                    }
                    catch (e: com.google.gson.JsonSyntaxException) {}
                }
                rv = findViewById<RecyclerView>(R.id.listView).apply {
                    setHasFixedSize(true)
                    layoutManager = vm
                    adapter = va
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                println("loadPost:onCancelled ${databaseError.toException()}")
            }
        }
        ref.addValueEventListener(menuListener)
    }
}


