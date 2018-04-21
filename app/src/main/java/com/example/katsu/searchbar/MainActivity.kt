package com.example.katsu.searchbar

import android.content.res.Resources
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import com.mancj.materialsearchbar.MaterialSearchBar
import com.mancj.materialsearchbar.adapter.DefaultSuggestionsAdapter
import com.mancj.materialsearchbar.adapter.SuggestionsAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.tool_bar) as Toolbar
        val background = findViewById(R.id.trans_background)
        background.visibility = View.GONE
        val searchBar = findViewById(R.id.searchBar) as MaterialSearchBar
        val adapter = DefaultSuggestionsAdapter(LayoutInflater.from(this)).apply {
            suggestions = listOf("hogehoge", "hugahuga", "piyopiyo")
            setListener(object : SuggestionsAdapter.OnItemViewClickListener{
                override fun OnItemDeleteListener(position: Int, v: View?) {
                }
                override fun OnItemClickListener(position: Int, v: View?) {
                }
            })
        }
        searchBar.setCustomSuggestionAdapter(adapter)
        searchBar.setOnSearchActionListener(object : MaterialSearchBar.OnSearchActionListener {
            override fun onButtonClicked(buttonCode: Int) {
            }

            override fun onSearchStateChanged(enabled: Boolean) {
                if (enabled) {
                    background.visibility = View.VISIBLE
                    toolbar.setBackgroundColor(resources.getColor(R.color.transparentBlack, theme))
                } else {
                    background.visibility = View.GONE
                    toolbar.setBackgroundColor(resources.getColor(R.color.white, theme))
                }
            }

            override fun onSearchConfirmed(text: CharSequence?) {
            }

        })
        setSupportActionBar(toolbar)

    }
}
