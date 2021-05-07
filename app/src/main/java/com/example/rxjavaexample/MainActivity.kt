package com.example.rxjavaexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var waifus = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Configuração da RecyclerView
        var recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        var adapter = WaifusAdapter()

        recyclerView.adapter = adapter

        //População de lista de Waifus e RxJava
        waifus.add("Tsukasa Yuzaki")
        waifus.add("Gasai Yuno")
        waifus.add("Momo Deviluke")
        waifus.add("Emilia")
        waifus.add("Zero Two")
        waifus.add("Chizuru Mizuhara")

        Observable.just(waifus) //O observável irá emitir o ArrayList inteiro
            .subscribe(object: Observer<ArrayList<String>>{ //No método subscribe configuramos o observador
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: ArrayList<String>) {
                    Log.d("STAGES", "ON NEXT")

                    for(i in waifus){
                        Log.d("STAGES", i)
                    }

                    adapter.updateList(t)
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {
                    Log.d("STAGES", "ON COMPLETE")
                }

            })
    }
}