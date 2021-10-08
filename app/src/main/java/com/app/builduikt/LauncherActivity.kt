package com.app.builduikt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import java.lang.invoke.ConstantCallSite

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        //recycler view
        val onClickRV: View.OnClickListener = View.OnClickListener {
            startNavigation(RECYCLERVIEW)
        }
        findViewById<CardView>(R.id.cv_rv).setOnClickListener(onClickRV)
        findViewById<TextView>(R.id.tv_rv).setOnClickListener(onClickRV)

        //exp recycler view
        val onClickExp: View.OnClickListener = View.OnClickListener {
            startNavigation(EXPANDABLE)
        }
        findViewById<CardView>(R.id.cv_exp_rv).setOnClickListener(onClickExp)
        findViewById<TextView>(R.id.tv_exp_rv).setOnClickListener(onClickExp)

        //Coordinator layout
        val onClickCoL: View.OnClickListener = View.OnClickListener {
            startNavigation(COORDINTOR)
        }
        findViewById<CardView>(R.id.cv_coordinator).setOnClickListener(onClickCoL)
        findViewById<TextView>(R.id.tv_coordinator).setOnClickListener(onClickCoL)

        //Constraint Layout
        val onClickCL: View.OnClickListener = View.OnClickListener {
            startNavigation(CONSTRAINT)
        }
        findViewById<CardView>(R.id.cv_constraint).setOnClickListener(onClickCL)
        findViewById<TextView>(R.id.tv_constraint).setOnClickListener(onClickCL)


        //Constraint Layout
        val onClickVp: View.OnClickListener = View.OnClickListener {
            startNavigation(VIEWPAGER)
        }
        findViewById<CardView>(R.id.cv_view_pager).setOnClickListener(onClickVp)
        findViewById<TextView>(R.id.tv_vp).setOnClickListener(onClickVp)



    }

    private fun startNavigation(navTo: Int) {
        when (navTo) {
            RECYCLERVIEW -> startActivity(Intent(this, RecyclerActivity::class.java))
            EXPANDABLE -> startActivity(Intent(this, ExpandableListActivity::class.java))
            COORDINTOR -> startActivity(Intent(this, com.example.coordinatorlayout_example.MainActivity::class.java))
            CONSTRAINT -> startActivity(Intent(this, ActivityConstraintLayout::class.java))
            VIEWPAGER -> startActivity(Intent(this, ViewPagerActivity::class.java))
            else -> Toast.makeText(this, "No Where To Go...!", Toast.LENGTH_LONG).show()
        }
    }

    companion object{
        const val RECYCLERVIEW = 0
        const val EXPANDABLE= 1
        const val LFLAYOUT= 2
        const val CONSTRAINT = 3
        const val COORDINTOR = 4
        const val VIEWPAGER = 5
    }


}
