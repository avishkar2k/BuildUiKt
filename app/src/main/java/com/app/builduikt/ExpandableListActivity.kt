package com.app.builduikt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExpandableListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_list)
        setupExpandableRecyclerView()
    }

    private fun setupExpandableRecyclerView() {
        val recyclerViewExpandable: RecyclerView = findViewById(R.id.rl_expandable)
        val adapter = ExpandableAdapter(
            this.resources,
            arrayListOf(
                resources.getString(R.string.mi),
                resources.getString(R.string.rcb)
            ),
            Players.getInstance().allPlayers()
        )
        recyclerViewExpandable.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        recyclerViewExpandable.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}