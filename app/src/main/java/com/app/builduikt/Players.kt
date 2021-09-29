import android.util.Log
import com.app.builduikt.Cricketers
import com.app.builduikt.R

class Players {
    private val arrayList: ArrayList<Cricketers> = allPlayers()

    init {
        Log.d(TAG, ": ")
    }

    fun getAllRCB(): ArrayList<Cricketers> {
        val arrayListRCB: ArrayList<Cricketers> = ArrayList()
        for (cricketers in arrayList) {
            if (cricketers.playerTeam == R.string.mi) continue
            arrayListRCB.add(cricketers)
        }
        return arrayListRCB
    }

    fun getAllMI(): ArrayList<Cricketers> {
        val arrayListMI: ArrayList<Cricketers> = ArrayList()
        for (cricketers in arrayList) {
            if (cricketers.playerTeam == R.string.mi)
                arrayListMI.add(cricketers)
        }
        return arrayListMI
    }

    /* Returns list of all players  */
    fun allPlayers(): ArrayList<Cricketers> {
        return arrayListOf(
            Cricketers(
                playerName = R.string.virat,
                profile = R.drawable.kohli,
                playerSpecialization = R.string.batsman,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.ab_de_villers,
                profile = R.drawable.ab,
                playerSpecialization = R.string.wicketk,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.devd,
                profile = R.drawable.devdutt,
                playerSpecialization = R.string.batsman,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.tim,
                profile = R.drawable.tim,
                playerSpecialization = R.string.batsman,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.maxwell,
                profile = R.drawable.glenn,
                playerSpecialization = R.string.allround,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.wanindu,
                profile = R.drawable.wanindu,
                playerSpecialization = R.string.allround,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.kyle,
                profile = R.drawable.kyle,
                playerSpecialization = R.string.bowler,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.harshal,
                profile = R.drawable.harshal,
                playerSpecialization = R.string.bowler,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.yuj,
                profile = R.drawable.yajuvendra,
                playerSpecialization = R.string.bowler,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.george,
                profile = R.drawable.george,
                playerSpecialization = R.string.bowler,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.sundar,
                profile = R.drawable.sundar,
                playerSpecialization = R.string.allround,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.finn,
                profile = R.drawable.finn,
                playerSpecialization = R.string.wicketk,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.siraj,
                profile = R.drawable.siraj,
                playerSpecialization = R.string.bowler,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.zampa,
                profile = R.drawable.zampa,
                playerSpecialization = R.string.bowler,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.scott,
                profile = R.drawable.scott,
                playerSpecialization = R.string.allround,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.josh,
                profile = R.drawable.josh,
                playerSpecialization = R.string.wicketk,
                playerTeam = R.string.rcb
            ),
            Cricketers(
                playerName = R.string.rohit,
                profile = R.drawable.rohit,
                playerSpecialization = R.string.batsman,
                playerTeam = R.string.mi
            ),
            Cricketers(
                playerName = R.string.hardik,
                profile = R.drawable.hardik,
                playerSpecialization = R.string.allround,
                playerTeam = R.string.mi
            ),
            Cricketers(
                playerName = R.string.pollard,
                profile = R.drawable.pollard,
                playerSpecialization = R.string.allround,
                playerTeam = R.string.mi
            ),
            Cricketers(
                playerName = R.string.bumrah,
                profile = R.drawable.bumrah,
                playerSpecialization = R.string.bowler,
                playerTeam = R.string.mi
            ),
            Cricketers(
                playerName = R.string.ishan,
                profile = R.drawable.ishan,
                playerSpecialization = R.string.wicketk,
                playerTeam = R.string.mi
            ),
            Cricketers(
                playerName = R.string.quinton,
                profile = R.drawable.quinton,
                playerSpecialization = R.string.wicketk,
                playerTeam = R.string.mi
            ),
            Cricketers(
                playerName = R.string.arjun,
                profile = R.drawable.arjun,
                playerSpecialization = R.string.allround,
                playerTeam = R.string.mi
            ),
            Cricketers(
                playerName = R.string.saurabh,
                profile = R.drawable.saurabh,
                playerSpecialization = R.string.batsman,
                playerTeam = R.string.mi
            ),
            Cricketers(
                playerName = R.string.adam,
                profile = R.drawable.adam,
                playerSpecialization = R.string.bowler,
                playerTeam = R.string.mi
            ),
            Cricketers(
                playerName = R.string.rahul,
                profile = R.drawable.rahul,
                playerSpecialization = R.string.bowler,
                playerTeam = R.string.mi
            ),
            Cricketers(
                playerName = R.string.boult,
                profile = R.drawable.boult,
                playerSpecialization = R.string.bowler,
                playerTeam = R.string.mi
            ),
            Cricketers(
                playerName = R.string.krunal,
                profile = R.drawable.krunal,
                playerSpecialization = R.string.allround,
                playerTeam = R.string.mi
            ),
            Cricketers(
                playerName = R.string.suryakumar,
                profile = R.drawable.suryakumar,
                playerSpecialization = R.string.batsman,
                playerTeam = R.string.mi
            )
        )
    }


    companion object {
        private const val TAG = "Players"
        private var INSTANCE: Players? = null

        fun getInstance(): Players {
            return synchronized(Players::class) {
                val newInstance = INSTANCE ?: Players()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

}