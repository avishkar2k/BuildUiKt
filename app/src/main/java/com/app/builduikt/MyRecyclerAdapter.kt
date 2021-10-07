package com.app.builduikt

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter(var arrayList: ArrayList<Cricketers>, var click: OnSelectPlayer) :
    RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>() {

    fun updateListItems(arrayList: ArrayList<Cricketers>) {
        this.arrayList = arrayList
        Log.d(TAG, "updateListItems: ")
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var playerName: TextView = view.findViewById(R.id.tv_player_name)
        var playerSpecialization: TextView =
            view.findViewById(R.id.tv_player_specialization)
        var playerTeam: TextView = view.findViewById(R.id.tv_player_team)
        var profile: ImageView = view.findViewById(R.id.iv_profile_icon)
        var background: ViewGroup = view.findViewById(R.id.viewholder_background)

        init {
            playerName.text = ""
            playerSpecialization.text = ""
            playerTeam.text = ""
            profile.setImageResource(0)
            background.setBackgroundResource(android.R.color.darker_gray)

            //adding listener for the click
            profile.setOnClickListener({
                click.onPlayerSelected(adapterPosition, arrayList.get(adapterPosition))
            })
        }
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: ")
        return arrayList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder: ")
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item2, parent, false)
        )
        /*return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.list_item1, parent, false)
            )*/
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        if (payloads.size == 0) return
        val player: Cricketers = payloads[0] as Cricketers
        Log.d(
            TAG,
            "onBindViewHolder: Item Change Notified " + holder.itemView.context.resources.getString(
                player.playerName
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: $position")
        //render ui
        val cricketer: Cricketers = arrayList[position]
        val backgroundColor = getBackgroundColor(cricketer)
        holder.profile.setImageResource(cricketer.profile)
        holder.playerName.setText(cricketer.playerName)
        holder.playerSpecialization.setText(cricketer.playerSpecialization)
        holder.playerTeam.setText(cricketer.playerTeam)
        holder.background.setBackgroundResource(backgroundColor)
    }

    private fun getBackgroundColor(cricketer: Cricketers): Int {
        @ColorRes val background: Int
        if (cricketer.playerTeam == R.string.mi)
            background = R.color.purple_200
        else background = R.color.lialac_200
        return background
    }

    companion object {
        private const val TAG = "MyRecyclerAdapter"
    }
}