package arush.smartinternsassignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import arush.smartinternsassignment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    var diceNum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.rollButton.setOnClickListener {
            mainBinding.welcomTextView.isVisible = false
            mainBinding.rollTextView.isVisible = false
            mainBinding.rollButton.text = "Roll Again"
            rollDice()
        }
    }

    private fun rollDice(){
        diceNum = (1..6).random()
        Log.d("diceNum", diceNum.toString())
        when(diceNum){
            1 -> {
                mainBinding.imageView.setImageResource(R.drawable.diceone)
                mainBinding.diceImageView.isVisible = true
                mainBinding.diceImageView.setImageResource(R.drawable.dicefaceone)
            }
            2 -> {
                mainBinding.imageView.setImageResource(R.drawable.dicetwo)
                mainBinding.diceImageView.setImageResource(R.drawable.dicefacetwo)
                mainBinding.diceImageView.isVisible = true
            }
            3 -> {
                mainBinding.imageView.setImageResource(R.drawable.dicethree)
                mainBinding.diceImageView.setImageResource(R.drawable.dicefacethree)
                mainBinding.diceImageView.isVisible = true
            }
            4 -> {
                mainBinding.imageView.setImageResource(R.drawable.dicefour)
                mainBinding.diceImageView.setImageResource(R.drawable.dicefacefour)
                mainBinding.diceImageView.isVisible = true
            }
            5 -> {
                mainBinding.imageView.setImageResource(R.drawable.dicefive)
                mainBinding.diceImageView.setImageResource(R.drawable.dicefacefive)
                mainBinding.diceImageView.isVisible = true
            }
            6 -> {
                mainBinding.imageView.setImageResource(R.drawable.dicesix)
                mainBinding.diceImageView.setImageResource(R.drawable.dicefacesix)
                mainBinding.diceImageView.isVisible = true
            }
        }
    }
}