package com.app.builduikt

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.RecyclerView

class ExpandableAdapter(
    resources: Resources,
    var teamList: ArrayList<String>,
    playersList: ArrayList<Cricketers>
) :
    RecyclerView.Adapter<ExpandableAdapter.ViewHolder>() {

    private var teamHashMap: HashMap<String, ArrayList<Cricketers>> = HashMap()
    private var expandableState: Int = COLLAPSED
    private var expandedTeam: String? = null

    init {
        //create the hash-map for expanding and collapsing the views
        // 1st time for mi
        // 2nd time for rcb
        for (team: String in teamList) { //size 2
            val arrayOfTeamPlayers: ArrayList<Cricketers> = ArrayList()
            for (player: Cricketers in playersList) {
                if (resources.getString(player.playerTeam) == team) {
                    arrayOfTeamPlayers.add(player)
                }
            }
            //1st time mi with 13 players
            //2nd time rcb with 16 players
            teamHashMap.set(team, arrayOfTeamPlayers)
        }
    }

    //base class
    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        open fun bind() {
            //implementation of ui rendering
        }

        open fun addListeners() {
            //implementation of ui interaction listeners
        }

    }

    inner class ParentViewHolder(view: View) : ViewHolder(view) {
        private val tvTeamTitle: TextView = view.findViewById(R.id.tv_team_name)
        private val fl: FrameLayout = view.findViewById(R.id.fl)

        init {
            addListeners()
        }

        override fun bind() {
            when (expandableState) {
                EXPANDED -> {
                    //fetch the index of previously selected/expanded item and number of players
                    val indexOfTeamName: Int = getActualPosition(adapterPosition)
                    tvTeamTitle.text = teamList[indexOfTeamName]
                }
                else -> {
                    tvTeamTitle.text = teamList[adapterPosition]
                }
            }
            updateStateTextDrawable()
        }

        override fun addListeners() {
            super.addListeners()
            val onClick: View.OnClickListener =
                View.OnClickListener {
                    expandCollapseItems()
                    notifyDataSetChanged()
                }
            tvTeamTitle.setOnClickListener(onClick)
            fl.setOnClickListener(onClick)
        }

        private fun updateStateTextDrawable() {
            if (expandedTeam == teamList[getActualPosition(adapterPosition)]) {
                when (expandableState) {
                    EXPANDED -> tvTeamTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.arrow_expanded,
                        0
                    )
                    else -> tvTeamTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.arrow_collapsed,
                        0
                    )
                }
            } else {
                tvTeamTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.arrow_collapsed,
                    0
                )
            }
        }

        private fun expandCollapseItems() {
            when (expandableState) {
                EXPANDED -> {

                    //fetch the index of previously selected/expanded item and number of players
                    val indexOfTeamExpanded = indexOfTeamExpanded()
                    val numberOfTeamPlayers = numberOfTeamPlayers()
                    val localExpandedTeam: String = if (indexOfTeamExpanded >= adapterPosition) {
                        teamList[adapterPosition]
                    } else teamList[adapterPosition - numberOfTeamPlayers]
                    if (expandedTeam != null && expandedTeam != localExpandedTeam) {
                        expandedTeam = localExpandedTeam
                        expandableState = EXPANDED
                    } else {
                        expandableState = COLLAPSED
                        expandedTeam = null
                    }

                }
                else -> {
                    expandableState = EXPANDED
                    expandedTeam = teamList[adapterPosition]
                }

            }
        }
    }

    inner class ChildViewHolder(view: View) : ViewHolder(view) {
        private var playerName: TextView = view.findViewById(R.id.tv_player_name)
        private var playerSpecialization: TextView =
            view.findViewById(R.id.tv_player_specialization)
        private var playerTeam: TextView = view.findViewById(R.id.tv_player_team)
        private var profile: ImageView = view.findViewById(R.id.iv_profile_icon)
        private var background: ViewGroup = view.findViewById(R.id.viewholder_background)

        init {
            playerName.text = ""
            playerSpecialization.text = ""
            playerTeam.text = ""
            profile.setImageResource(0)
            background.setBackgroundResource(android.R.color.darker_gray)
        }


        override fun bind() {
            //render ui
            val cricketer: Cricketers =
                teamHashMap[expandedTeam]?.get(getActualPosition(adapterPosition))
                    ?: return
            val backgroundColor = getBackgroundColor(cricketer)
            profile.setImageResource(cricketer.profile)
            playerName.setText(cricketer.playerName)
            playerSpecialization.setText(cricketer.playerSpecialization)
            playerTeam.setText(cricketer.playerTeam)
            background.setBackgroundResource(backgroundColor)
        }

        private fun getBackgroundColor(cricketer: Cricketers): Int {
            @ColorRes val background: Int
            if (cricketer.playerTeam == R.string.mi)
                background = R.color.purple_200
            else background = R.color.lialac_200
            return background
        }
    }

    /**
     *Function to create the ViewHolder based on the ViewHolder type as identified by viewType
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return when (viewType) {
            CHILD -> ChildViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.list_item1, parent, false)
            )

            /*PARENT -> ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.list_item1, parent, false)
            )*/
            else -> ParentViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.list_parent1, parent, false)
            )
        }

    }

    /**
     * Calls the bind function to render the view
     * Function Overriding helps handle the UI rendering based the ViewHolder Type for PARENT or CHILD
     * Alternative would be to check the ViewHolder type by calling function getItemViewType with position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    /**
     * Function that returns the size of list based the expandableState of the ExpandableAdapter
     */
    override fun getItemCount(): Int {
        return when (expandableState) {
            EXPANDED -> {
                teamHashMap.size + (teamHashMap[expandedTeam]?.size ?: 0)
            }
            COLLAPSED -> teamHashMap.size
            else -> teamHashMap.size
        }

    }

    /**
     * Function defines whether the view type at position is CHILD or PARENT
     * Considering the expandableState of the ExpandableAdapter
     */
    override fun getItemViewType(position: Int): Int {
        return when (expandableState) {
            EXPANDED -> {
                val indexOfTeamExpanded: Int = indexOfTeamExpanded()
                val numberOfTeamPlayers = numberOfTeamPlayers()
                //return view type child for anything between indexOfTeamExpanded till numberOfTeamPlayers
                when (position) {
                    in indexOfTeamExpanded + 1..(indexOfTeamExpanded + numberOfTeamPlayers) -> CHILD
                    else -> PARENT
                }
            }
            COLLAPSED -> PARENT
            else -> PARENT
        }
    }

    private fun numberOfTeamPlayers(): Int = teamHashMap[expandedTeam]?.size ?: 0

    private fun indexOfTeamExpanded(): Int = teamList.indexOf(expandedTeam)


    private fun getActualPosition(adapterPosition: Int): Int = when (expandableState) {
        EXPANDED -> {
            when (adapterPosition) {
                in indexOfTeamExpanded() + 1..(indexOfTeamExpanded() + numberOfTeamPlayers()) ->
                    adapterPosition - (indexOfTeamExpanded() + 1)
                in (indexOfTeamExpanded() + numberOfTeamPlayers())..itemCount ->
                    adapterPosition - (indexOfTeamExpanded() + numberOfTeamPlayers())
                else -> adapterPosition
            }
        }
        else -> adapterPosition
    }

    companion object {
        //view type
        const val CHILD = 1
        const val PARENT = 0

        //expandable view state
        const val COLLAPSED = 0
        const val EXPANDED = 1

    }
}