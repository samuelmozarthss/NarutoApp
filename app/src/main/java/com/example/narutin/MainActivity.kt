package com.example.narutin

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat.HORIZONTAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private lateinit var mRecyclerview: RecyclerView
    private var mCharacterList : ArrayList <CharactersModel> = ArrayList()
    private val mAdapter: CharacterAdapter = CharacterAdapter(mCharacterList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val remote = RetrofitClient.createService(CharacterServices::class.java)
        val call: Call<List<CharactersModel>> = remote.list()

        val response = call.enqueue(object : Callback<List<CharactersModel>> {

            override fun onResponse(
                call: Call<List<CharactersModel>>,
                response: Response<List<CharactersModel>>
            ) {
                response.body()?.forEach {
                    mCharacterList.add(it)

                }
                Log.d("teste",mCharacterList.toString())
                mAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<CharactersModel>>, t: Throwable) {
                val s = t.message
            }
        })

        mRecyclerview = findViewById(R.id.characters_list)
        mRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mRecyclerview.adapter = mAdapter
    }
}