package com.app.builduikt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {

    private var adapter: MyRecyclerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val onClick: OnSelectPlayer = object : OnSelectPlayer {
            override fun onPlayerSelected(position: Int, players: Cricketers) {
                consumeClickEvent(position, players)
            }
        }
        adapter = MyRecyclerAdapter(
            Players.getInstance().allPlayers(),
            onClick
        )
        recyclerView.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        adapter!!.notifyDataSetChanged()

        findViewById<Button>(R.id.btn_all_items).setOnClickListener {
            //todo show all items
            Log.d(TAG, "onCreate: btn_all_items")
            adapter!!.updateListItems(Players.getInstance().allPlayers())
        }

        findViewById<Button>(R.id.btn_all_rcb).setOnClickListener {
            //todo show all items
            Log.d(TAG, "onCreate: btn_all_rcb")
            adapter!!.updateListItems(Players.getInstance().getAllRCB())

        }

        findViewById<Button>(R.id.btn_all_mi).setOnClickListener {
            //todo show all items
            Log.d(TAG, "onCreate: btn_all_mi")
            adapter!!.updateListItems(Players.getInstance().getAllMI())
        }
    }

    private fun consumeClickEvent(position: Int, player: Cricketers) {
        Log.d(
            TAG,
            "consumeClickEvent: onClickHappened at " + position + " for player "
                    + resources.getString(player.playerName)
        )

        //after modification
        //adapter?.notifyItemChanged(position)
        adapter?.notifyItemChanged(position, player)
    }

    companion object {
        private const val TAG = "RecyclerActivity"
    }
}