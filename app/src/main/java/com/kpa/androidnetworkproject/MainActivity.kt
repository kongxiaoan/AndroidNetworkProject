package com.kpa.androidnetworkproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kpa.androidnetworkproject.entry.MovieSuject
import com.kpa.androidnetworkproject.net.loader.MovieLoader
import kotlinx.android.synthetic.main.main_activity.*
import rx.functions.Action1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        button.setOnClickListener {
            MovieLoader().getTap(10)?.subscribe(object :Action1<List<MovieSuject>>{
                override fun call(t: List<MovieSuject>?) {

                }

            },object :Action1<Throwable>{
                override fun call(t: Throwable?) {

                }

            })
        }
    }
}
