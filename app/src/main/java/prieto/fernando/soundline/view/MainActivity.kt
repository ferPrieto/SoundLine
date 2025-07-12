package prieto.fernando.soundline.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import prieto.fernando.soundline.R
import prieto.fernando.soundline.SoundLineView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val soundLineView = findViewById<SoundLineView>(R.id.sound_line_view)
        soundLineView.initWaves()
    }
}
