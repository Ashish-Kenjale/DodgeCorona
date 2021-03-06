package com.project.dodgekarona

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game_home.*
import java.util.*

/**
 * Created by Ashish Kenjale on 5/05/20.
 */
class GameHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_home)

        startGameButton.setOnClickListener {
            val navigationIntent = Intent(this, GamePlayActivity::class.java)
            startActivity(navigationIntent)
        }

        controlsButton.setOnClickListener(View.OnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.controls_title))
                .setMessage(getString(R.string.controls_text))
                .setNegativeButton(
                    "OK"
                ) { dialog, which -> }.show()
        })

        aboutButton.setOnClickListener(View.OnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.about_dodgekarona_title))
                .setMessage(getLocaleBasedAboutUsMessage())
                .setNegativeButton(
                    "OK"
                ) { dialog, which -> }.show()
        })
    }

    private fun getLocaleBasedAboutUsMessage(): String {
        val message: String
        Log.i(TAG, "isMetric: ${Locale.getDefault().isMetric()}")
        if (Locale.getDefault().isMetric()) {
            message = String.format(getString(R.string.about_game_text), getString(R.string.safe_social_distance_in_meter))
        } else {
            message = String.format(getString(R.string.about_game_text), getString(R.string.safe_social_distance_in_feet))
        }
        return message
    }
}
