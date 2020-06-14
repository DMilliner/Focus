package milliner.hc

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.preference.PreferenceManager
import android.text.Html
import android.util.DisplayMetrics
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.BounceInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

/**
 * Created by davidmilliner on 28/05/16.
 */
class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.name
    private var toDp = 0f
    private var victoryCounter: TextView? = null
    private var topCounter: TextView? = null
    private var timer: TextView? = null
    private var puke1: ImageView? = null
    private var puke2: ImageView? = null
    private var puke3: ImageView? = null
    private var puke4: ImageView? = null
    private var puke5: ImageView? = null
    private var puke6: ImageView? = null
    private var puke7: ImageView? = null
    private var puke8: ImageView? = null
    private var betPuke1: Button? = null
    private var betPuke2: Button? = null
    private var betPuke3: Button? = null
    private var betPuke4: Button? = null
    private var betPuke5: Button? = null
    private var betPuke6: Button? = null
    private var betPuke7: Button? = null
    private var betPuke8: Button? = null
    private var fab_shuffle: FloatingActionButton? = null
    private var score = 0
    private var topScore = 0
    private var timeAttackHighScore = 0
    private var listAnimations: MutableList<Int>? = null
    private var pukeInPosOne: ImageView? = null
    private var pukeInPosTwo: ImageView? = null
    private var pukeInPosThree: ImageView? = null
    private var pukeInPosFour: ImageView? = null
    private var pukeInPosFive: ImageView? = null
    private var pukeInPosSix: ImageView? = null
    private var pukeInPosSeven: ImageView? = null
    private var pukeInPosEight: ImageView? = null
    private var iterator = 0
    private var speed: Long = 0
    private var isFirstTime = true
    private var AnimationMoveA: AnimatorSet? = null
    private var AnimationMoveB: AnimatorSet? = null
    private var AnimationMoveC: AnimatorSet? = null
    private var AnimationMoveD: AnimatorSet? = null
    private var AnimationMoveE: AnimatorSet? = null
    private var AnimationMoveF: AnimatorSet? = null
    private var AnimationMoveG: AnimatorSet? = null
    private var AnimationMoveH: AnimatorSet? = null
    private var AnimationMoveI: AnimatorSet? = null
    private var AnimationMoveJ: AnimatorSet? = null
    private var AnimationMoveK: AnimatorSet? = null
    private var AnimationMoveL: AnimatorSet? = null
    private var AnimationMoveM: AnimatorSet? = null
    private var AnimationMoveMbis: AnimatorSet? = null
    private var AnimationMoveN: AnimatorSet? = null
    private var AnimationMoveNbis: AnimatorSet? = null
    private var AnimationMoveO: AnimatorSet? = null
    private var AnimationMoveObis: AnimatorSet? = null
    private var AnimationMoveP: AnimatorSet? = null
    private var AnimationMovePbis: AnimatorSet? = null
    private var AnimationMoveQ: AnimatorSet? = null
    private var AnimationMoveQbis: AnimatorSet? = null
    private var AnimationMoveR: AnimatorSet? = null
    private var AnimationMoveRbis: AnimatorSet? = null
    private var AnimationMoveS: AnimatorSet? = null
    private var AnimationMoveT: AnimatorSet? = null
    private var AnimationMoveU: AnimatorSet? = null
    private var AnimationMoveUbis: AnimatorSet? = null
    private var AnimationMoveV: AnimatorSet? = null
    private var AnimationMoveVbis: AnimatorSet? = null
    private var AnimationMoveW: AnimatorSet? = null
    private var AnimationMoveWbis: AnimatorSet? = null
    private var AnimationMoveX: AnimatorSet? = null
    private var AnimationMoveXbis: AnimatorSet? = null
    private var AnimationMoveY: AnimatorSet? = null
    private var AnimationMoveYbis: AnimatorSet? = null
    private var AnimationMoveZ: AnimatorSet? = null
    private var AnimationMoveZbis: AnimatorSet? = null
    private var AnimationMoveAlpha: AnimatorSet? = null
    private var AnimationMoveAlphaBis: AnimatorSet? = null
    private var AnimationMoveBeta: AnimatorSet? = null
    private var AnimationMoveBetaBis: AnimatorSet? = null
    private var gameMode: String? = null
    private var userName: String? = null
    private var deltaTopX = 0f
    private var deltaCenterX = 0f
    private var deltaCenterY = 0f
    private var deltaBottomX = 0f
    private var deltaBottomY = 0f
    private var playground: RelativeLayout? = null
    private var topScoreOnClickIsEnabled = false
    private var isFirstLost = false
    private var remainingTime: Long = 0
    private var countDown: CountDownTimer? = null
    private var gameStarted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Debug-HC", "onCreate")
        setContentView(R.layout.activity_main)
        playground = findViewById<View>(R.id.playground) as RelativeLayout
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Debug-HC", "onStart")
        userName = mSharedPreferences!!.getString("user_name", "Guest")
        gameMode = mSharedPreferences!!.getString("game_mode", "Infinity Mode")
        val gameModeView = findViewById<View>(R.id.game_mode_value) as TextView
        if (gameModeView != null) {
            gameModeView.text = gameMode
        }
        puke1 = findViewById<View>(R.id.puke1) as ImageView
        puke2 = findViewById<View>(R.id.puke2) as ImageView
        puke3 = findViewById<View>(R.id.puke3) as ImageView
        puke4 = findViewById<View>(R.id.puke4) as ImageView
        puke5 = findViewById<View>(R.id.puke5) as ImageView
        puke6 = findViewById<View>(R.id.puke6) as ImageView
        puke7 = findViewById<View>(R.id.puke7) as ImageView
        puke8 = findViewById<View>(R.id.puke8) as ImageView
        betPuke1 = findViewById<View>(R.id.bet_puke1) as Button
        betPuke2 = findViewById<View>(R.id.bet_puke2) as Button
        betPuke3 = findViewById<View>(R.id.bet_puke3) as Button
        betPuke4 = findViewById<View>(R.id.bet_puke4) as Button
        betPuke5 = findViewById<View>(R.id.bet_puke5) as Button
        betPuke6 = findViewById<View>(R.id.bet_puke6) as Button
        betPuke7 = findViewById<View>(R.id.bet_puke7) as Button
        betPuke8 = findViewById<View>(R.id.bet_puke8) as Button
        val face = Typeface.createFromAsset(assets, "fonts/Digital.ttf")
        victoryCounter = findViewById<View>(R.id.counter) as TextView
        if (victoryCounter != null) {
            victoryCounter!!.typeface = face
        }
        victoryCounter!!.text = String.format("%1$03d", score)
        topCounter = findViewById<View>(R.id.counter_top) as TextView
        if (topCounter != null) {
            topCounter!!.typeface = face
        }
        topScore = mSharedPreferences!!.getInt("topScore", 0)
        topCounter!!.text = String.format("%1$03d", topScore)
        timer = findViewById<View>(R.id.timer) as TextView
        if (gameMode == "Infinity Mode") {
            topCounter!!.visibility = View.VISIBLE
            timer!!.visibility = View.INVISIBLE
        } else if (gameMode == "Time Attack") {
            topCounter!!.visibility = View.INVISIBLE
            score = 0
            timeAttackHighScore = mSharedPreferences!!.getInt("timeAttackTopScore", 0)
            if (timer != null) {
                timer!!.visibility = View.VISIBLE
                timer!!.typeface = face
            }
            timer!!.text = String.format("%1$03d", 30)
            createCountDownTimer(30000)
        }
        isFirstLost = mSharedPreferences!!.getBoolean("isFirstLost", true)
        val isTutorialSeen = mSharedPreferences!!.getBoolean("isTutorialSeen", false)
        if (!isTutorialSeen) {
            val editor = mSharedPreferences!!.edit()
            editor.putBoolean("isTutorialSeen", true)
            editor.apply()
            initialTutorialDialog()
        }
        toDp = 1 / (applicationContext.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        fab_shuffle = findViewById<View>(R.id.fab_shuffle) as FloatingActionButton
        fab_shuffle!!.setOnClickListener {
            fab_shuffle!!.isClickable = false
            fab_shuffle!!.isEnabled = false
            if (!gameStarted && gameMode == "Time Attack") {
                countDown!!.start()
                gameStarted = true
            }
            topScoreOnClickIsEnabled = false
            posOneX = puke1!!.left.toFloat()
            posTwoX = puke2!!.left.toFloat()
            posThreeX = puke3!!.left.toFloat()
            posFourX = puke4!!.left.toFloat()
            posFiveX = puke5!!.left.toFloat()
            posSixX = puke6!!.left.toFloat()
            posSevenX = puke7!!.left.toFloat()
            posEightX = puke8!!.left.toFloat()
            posOneY = puke1!!.top.toFloat()
            posTwoY = puke2!!.top.toFloat()
            posThreeY = puke3!!.top.toFloat()
            posFourY = puke4!!.top.toFloat()
            posFiveY = puke5!!.top.toFloat()
            posSixY = puke6!!.top.toFloat()
            posSevenY = puke7!!.top.toFloat()
            posEightY = puke8!!.top.toFloat()
            deltaTopX = betPuke1!!.left - puke1!!.left.toFloat()
            deltaCenterX = betPuke4!!.left - puke4!!.left.toFloat()
            deltaCenterY = betPuke4!!.top - puke4!!.top.toFloat()
            deltaBottomX = betPuke6!!.left - puke6!!.left.toFloat()
            deltaBottomY = betPuke6!!.top - puke6!!.top.toFloat()
            shuffle()
        }
        betPuke1!!.setOnClickListener {
            buttonsAlgorithm(false)
            if ((betPuke1!!.left - deltaTopX) * toDp == puke2!!.left * toDp &&
                    betPuke1!!.top * toDp == puke2!!.top * toDp) {
                score++
                if (countDown != null) {
                    countDown!!.cancel()
                    createCountDownTimer(remainingTime * 1000 + 5500)
                    countDown!!.start()
                }
                checkScore()
            } else {
                score = 0
                if (isFirstLost) {
                    val editor = mSharedPreferences!!.edit()
                    editor.putBoolean("isFirstLost", false)
                    editor.apply()
                    isFirstLost = false
                    initialLostDialog()
                }
            }
            victoryCounter!!.text = String.format("%1$03d", score)
            reveal()
        }
        betPuke2!!.setOnClickListener {
            buttonsAlgorithm(false)
            if ((betPuke2!!.left - deltaTopX) * toDp == puke2!!.left * toDp &&
                    betPuke2!!.top * toDp == puke2!!.top * toDp) {
                score++
                if (gameMode == "Time Attack") {
                    if (countDown != null) countDown!!.cancel()
                    createCountDownTimer(remainingTime * 1000 + 5500)
                    countDown!!.start()
                }
                checkScore()
            } else {
                score = 0
                if (isFirstLost) {
                    val editor = mSharedPreferences!!.edit()
                    editor.putBoolean("isFirstLost", false)
                    editor.apply()
                    isFirstLost = false
                    initialLostDialog()
                }
            }
            victoryCounter!!.text = String.format("%1$03d", score)
            reveal()
        }
        betPuke3!!.setOnClickListener {
            buttonsAlgorithm(false)
            if ((betPuke3!!.left - deltaTopX) * toDp == puke2!!.left * toDp &&
                    betPuke3!!.top * toDp == puke2!!.top * toDp) {
                score++
                if (gameMode == "Time Attack") {
                    if (countDown != null) countDown!!.cancel()
                    createCountDownTimer(remainingTime * 1000 + 5500)
                    countDown!!.start()
                }
                checkScore()
            } else {
                score = 0
                if (isFirstLost) {
                    val editor = mSharedPreferences!!.edit()
                    editor.putBoolean("isFirstLost", false)
                    editor.apply()
                    isFirstLost = false
                    initialLostDialog()
                }
            }
            victoryCounter!!.text = String.format("%1$03d", score)
            reveal()
        }
        betPuke4!!.setOnClickListener {
            buttonsAlgorithm(false)
            if ((betPuke4!!.left - deltaCenterX) * toDp == puke2!!.left * toDp &&
                    (betPuke4!!.top - deltaCenterY) * toDp == puke2!!.top * toDp) {
                score++
                if (gameMode == "Time Attack") {
                    if (countDown != null) countDown!!.cancel()
                    createCountDownTimer(remainingTime * 1000 + 5500)
                    countDown!!.start()
                }
                checkScore()
            } else {
                score = 0
                if (isFirstLost) {
                    val editor = mSharedPreferences!!.edit()
                    editor.putBoolean("isFirstLost", false)
                    editor.apply()
                    isFirstLost = false
                    initialLostDialog()
                }
            }
            victoryCounter!!.text = String.format("%1$03d", score)
            reveal()
        }
        betPuke5!!.setOnClickListener {
            buttonsAlgorithm(false)
            if ((betPuke5!!.left - deltaCenterX) * toDp != puke2!!.left * toDp &&
                    (betPuke5!!.top - deltaCenterY) * toDp == puke2!!.top * toDp) {
                score++
                if (gameMode == "Time Attack") {
                    if (countDown != null) countDown!!.cancel()
                    createCountDownTimer(remainingTime * 1000 + 5500)
                    countDown!!.start()
                }
                checkScore()
            } else {
                score = 0
                if (isFirstLost) {
                    val editor = mSharedPreferences!!.edit()
                    editor.putBoolean("isFirstLost", false)
                    editor.apply()
                    isFirstLost = false
                    initialLostDialog()
                }
            }
            victoryCounter!!.text = String.format("%1$03d", score)
            reveal()
        }
        betPuke6!!.setOnClickListener {
            buttonsAlgorithm(false)
            if ((betPuke6!!.left - deltaBottomX) * toDp == puke2!!.left * toDp &&
                    (betPuke6!!.top - deltaBottomY) * toDp == puke2!!.top * toDp) {
                score++
                if (gameMode == "Time Attack") {
                    if (countDown != null) countDown!!.cancel()
                    createCountDownTimer(remainingTime * 1000 + 5500)
                    countDown!!.start()
                }
                checkScore()
            } else {
                score = 0
                if (isFirstLost) {
                    val editor = mSharedPreferences!!.edit()
                    editor.putBoolean("isFirstLost", false)
                    editor.apply()
                    isFirstLost = false
                    initialLostDialog()
                }
            }
            victoryCounter!!.text = String.format("%1$03d", score)
            reveal()
        }
        betPuke7!!.setOnClickListener {
            buttonsAlgorithm(false)
            if ((betPuke7!!.left - deltaBottomX) * toDp == puke2!!.left * toDp &&
                    (betPuke7!!.top - deltaBottomY) * toDp == puke2!!.top * toDp) {
                score++
                if (gameMode == "Time Attack") {
                    if (countDown != null) countDown!!.cancel()
                    createCountDownTimer(remainingTime * 1000 + 5500)
                    countDown!!.start()
                }
                checkScore()
            } else {
                score = 0
                if (isFirstLost) {
                    val editor = mSharedPreferences!!.edit()
                    editor.putBoolean("isFirstLost", false)
                    editor.apply()
                    isFirstLost = false
                    initialLostDialog()
                }
            }
            victoryCounter!!.text = String.format("%1$03d", score)
            reveal()
        }
        betPuke8!!.setOnClickListener {
            buttonsAlgorithm(false)
            if ((betPuke8!!.left - deltaBottomX) * toDp == puke2!!.left * toDp &&
                    (betPuke8!!.top - deltaBottomY) * toDp == puke2!!.top * toDp) {
                score++
                if (gameMode == "Time Attack") {
                    if (countDown != null) countDown!!.cancel()
                    createCountDownTimer(remainingTime * 1000 + 5500)
                    countDown!!.start()
                }
                checkScore()
            } else {
                score = 0
                if (isFirstLost) {
                    val editor = mSharedPreferences!!.edit()
                    editor.putBoolean("isFirstLost", false)
                    editor.apply()
                    isFirstLost = false
                    initialLostDialog()
                }
            }
            victoryCounter!!.text = String.format("%1$03d", score)
            reveal()
        }
        if (fab_shuffle != null) {
            fab_shuffle!!.backgroundTintList = ColorStateList.valueOf(Color.MAGENTA)
            if (isFirstTime) {
                val animY = ObjectAnimator.ofFloat(fab_shuffle, View.TRANSLATION_Y, -80f, 0f)
                animY.duration = 750 //850 milliseconds
                animY.interpolator = BounceInterpolator()
                animY.repeatCount = 4
                animY.start()
                isFirstTime = false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("Debug-HC", "onResume")
        reveal()
        buttonsAlgorithm(false)
    }

    override fun onPause() {
        super.onPause()
        Log.d("Debug-HC", "onPause")
        cleanAnimations()
    }

    private fun cleanAnimations() {
        if (AnimationMoveA != null && AnimationMoveA!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveA!!.end()
        }
        if (AnimationMoveB != null && AnimationMoveB!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveB!!.end()
        }
        if (AnimationMoveC != null && AnimationMoveC!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveC!!.end()
        }
        if (AnimationMoveD != null && AnimationMoveD!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveD!!.end()
        }
        if (AnimationMoveE != null && AnimationMoveE!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveE!!.end()
        }
        if (AnimationMoveF != null && AnimationMoveF!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveF!!.end()
        }
        if (AnimationMoveG != null && AnimationMoveG!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveG!!.end()
        }
        if (AnimationMoveH != null && AnimationMoveH!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveH!!.end()
        }
        if (AnimationMoveI != null && AnimationMoveI!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveI!!.end()
        }
        if (AnimationMoveJ != null && AnimationMoveJ!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveJ!!.end()
        }
        if (AnimationMoveK != null && AnimationMoveK!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveK!!.end()
        }
        if (AnimationMoveL != null && AnimationMoveL!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveL!!.end()
        }
        if (AnimationMoveM != null && AnimationMoveM!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveM!!.end()
        }
        if (AnimationMoveMbis != null && AnimationMoveMbis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveMbis!!.end()
        }
        if (AnimationMoveN != null && AnimationMoveN!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveN!!.end()
        }
        if (AnimationMoveNbis != null && AnimationMoveNbis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveNbis!!.end()
        }
        if (AnimationMoveO != null && AnimationMoveO!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveO!!.end()
        }
        if (AnimationMoveObis != null && AnimationMoveObis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveObis!!.end()
        }
        if (AnimationMoveP != null && AnimationMoveP!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveP!!.end()
        }
        if (AnimationMovePbis != null && AnimationMovePbis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMovePbis!!.end()
        }
        if (AnimationMoveQ != null && AnimationMoveQ!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveQ!!.end()
        }
        if (AnimationMoveQbis != null && AnimationMoveQbis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveQbis!!.end()
        }
        if (AnimationMoveR != null && AnimationMoveR!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveR!!.end()
        }
        if (AnimationMoveRbis != null && AnimationMoveRbis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveRbis!!.end()
        }
        if (AnimationMoveS != null && AnimationMoveS!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveS!!.end()
        }
        if (AnimationMoveT != null && AnimationMoveT!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveT!!.end()
        }
        if (AnimationMoveU != null && AnimationMoveU!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveU!!.end()
        }
        if (AnimationMoveUbis != null && AnimationMoveUbis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveUbis!!.end()
        }
        if (AnimationMoveV != null && AnimationMoveV!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveV!!.end()
        }
        if (AnimationMoveVbis != null && AnimationMoveVbis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveVbis!!.end()
        }
        if (AnimationMoveW != null && AnimationMoveW!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveW!!.end()
        }
        if (AnimationMoveWbis != null && AnimationMoveWbis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveWbis!!.end()
        }
        if (AnimationMoveX != null && AnimationMoveX!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveX!!.end()
        }
        if (AnimationMoveXbis != null && AnimationMoveXbis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveXbis!!.end()
        }
        if (AnimationMoveY != null && AnimationMoveY!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveY!!.end()
        }
        if (AnimationMoveYbis != null && AnimationMoveYbis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveYbis!!.end()
        }
        if (AnimationMoveZ != null && AnimationMoveZ!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveZ!!.end()
        }
        if (AnimationMoveZbis != null && AnimationMoveZbis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveZbis!!.end()
        }
        if (AnimationMoveAlpha != null && AnimationMoveAlpha!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveAlpha!!.end()
        }
        if (AnimationMoveAlphaBis != null && AnimationMoveAlphaBis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveAlphaBis!!.end()
        }
        if (AnimationMoveBeta != null && AnimationMoveBeta!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveBeta!!.end()
        }
        if (AnimationMoveBetaBis != null && AnimationMoveBetaBis!!.isRunning) {
            if (listAnimations != null && listAnimations!!.isNotEmpty()) {
                iterator = 0
                listAnimations!!.clear()
            }
            AnimationMoveBetaBis!!.end()
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d("Debug-HC", "onStop")
    }

    private fun buttonsAlgorithm(bool: Boolean) {
        betPuke1!!.isClickable = bool
        betPuke1!!.isEnabled = bool
        betPuke2!!.isClickable = bool
        betPuke2!!.isEnabled = bool
        betPuke3!!.isClickable = bool
        betPuke3!!.isEnabled = bool
        betPuke4!!.isClickable = bool
        betPuke4!!.isEnabled = bool
        betPuke5!!.isClickable = bool
        betPuke5!!.isEnabled = bool
        betPuke6!!.isClickable = bool
        betPuke6!!.isEnabled = bool
        betPuke7!!.isClickable = bool
        betPuke7!!.isEnabled = bool
        betPuke8!!.isClickable = bool
        betPuke8!!.isEnabled = bool
        fab_shuffle!!.isClickable = !bool
        fab_shuffle!!.isEnabled = !bool
        topScoreOnClickIsEnabled = !bool
    }

    private fun checkScore() {
        if (gameMode == "Time Attack") {
            if (score > timeAttackHighScore) {
                timeAttackHighScore = score
                val editor = mSharedPreferences!!.edit()
                editor.putInt("timeAttackTopScore", timeAttackHighScore)
                editor.apply()
            }
        } else if (gameMode == "Infinity Mode") {
            if (score > topScore) {
                topScore = score
                val editor = mSharedPreferences!!.edit()
                editor.putInt("topScore", topScore)
                editor.apply()
                topCounter!!.text = String.format("%1$03d", topScore)
            }
        }
        defineSpeed()
        when (score) {
            5 -> {
                showSpeedDialog(speed.toFloat())
            }
            10 -> {
                showSpeedDialog(speed.toFloat())
            }
            15 -> {
                showSpeedDialog(speed.toFloat())
            }
            25 -> {
                showSpeedDialog(speed.toFloat())
            }
            50 -> {
                showSpeedDialog(speed.toFloat())
            }
            75 -> {
                showSpeedDialog(speed.toFloat())
            }
            100 -> {
                showSpeedDialog(speed.toFloat())
            }
            150 -> {
                showSpeedDialog(speed.toFloat())
            }
            200 -> {
                showSpeedDialog(speed.toFloat())
            }
            300 -> {
                showSpeedDialog(speed.toFloat())
            }
            450 -> {
                showSpeedDialog(speed.toFloat())
            }
            500 -> {
                showSpeedDialog(speed.toFloat())
            }
        }
    }

    private fun defineSpeed() {
        if (gameMode == "Time Attack") {
            when {
                score in 0..14 -> {
                    speed = 420
                }
                score in 15..24 -> {
                    speed = 314
                }
                score in 25..49 -> {
                    speed = 200
                }
                score >= 50 -> {
                    speed = 100
                }
            }
        } else if (gameMode == "Infinity Mode") {
            when {
                score in 0..4 -> {
                    speed = 1000
                }
                score in 5..9 -> {
                    speed = 900
                }
                score in 10..14 -> {
                    speed = 800
                }
                score in 15..24 -> {
                    speed = 700
                }
                score in 25..49 -> {
                    speed = 600
                }
                score in 50..74 -> {
                    speed = 500
                }
                score in 75..99 -> {
                    speed = 400
                }
                score >= 100 -> {
                    speed = 300
                }
            }
        }
    }

    fun onClickTopScore(v: View?) {
        if (topScoreOnClickIsEnabled) {
            score = topScore
            topCounter!!.text = String.format("%1$03d", topScore)
            victoryCounter!!.text = String.format("%1$03d", score)
        }
    }

    private fun moveA() {
        pukeInPosOne = returnPukeInPos(posOneX, posOneY)
        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY)
        val animX = ObjectAnimator.ofFloat(pukeInPosOne, View.X, posTwoX)
        val animXx = ObjectAnimator.ofFloat(pukeInPosTwo, View.X, posOneX)
        AnimationMoveA = AnimatorSet()
        AnimationMoveA!!.playTogether(animX, animXx)
        AnimationMoveA!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveA!!.duration = speed
        AnimationMoveA!!.start()
        pukeInPosOne!!.left = posTwoX.toInt()
        pukeInPosTwo!!.left = posOneX.toInt()
    }

    private fun moveB() {
        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY)
        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY)
        val animY = ObjectAnimator.ofFloat(pukeInPosTwo, View.X, posThreeX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosThree, View.X, posTwoX)
        AnimationMoveB = AnimatorSet()
        AnimationMoveB!!.playTogether(animY, animYy)
        AnimationMoveB!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveB!!.duration = speed
        AnimationMoveB!!.start()
        pukeInPosThree!!.left = posTwoX.toInt()
        pukeInPosTwo!!.left = posThreeX.toInt()
    }

    private fun moveC() {
        pukeInPosOne = returnPukeInPos(posOneX, posOneY)
        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY)
        val animX = ObjectAnimator.ofFloat(pukeInPosOne, View.X, posThreeX)
        val animXx = ObjectAnimator.ofFloat(pukeInPosThree, View.X, posOneX)
        AnimationMoveC = AnimatorSet()
        AnimationMoveC!!.playTogether(animX, animXx)
        AnimationMoveC!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveC!!.duration = speed
        AnimationMoveC!!.start()
        pukeInPosThree!!.left = posOneX.toInt()
        pukeInPosOne!!.left = posThreeX.toInt()
    }

    private fun moveD() {
        pukeInPosOne = returnPukeInPos(posOneX, posOneY)
        pukeInPosFour = returnPukeInPos(posFourX, posFourY)
        val animY = ObjectAnimator.ofFloat(pukeInPosOne, View.Y, posOneY, posFourY)
        val animYy = ObjectAnimator.ofFloat(pukeInPosFour, View.Y, posFourY, posOneY)
        AnimationMoveD = AnimatorSet()
        AnimationMoveD!!.playTogether(animY, animYy)
        AnimationMoveD!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveD!!.duration = speed
        AnimationMoveD!!.start()
        pukeInPosFour!!.top = posOneY.toInt()
        pukeInPosOne!!.top = posFourY.toInt()
    }

    private fun moveE() {
        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY)
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY)
        val animY = ObjectAnimator.ofFloat(pukeInPosThree, View.Y, posThreeY, posFiveY)
        val animYy = ObjectAnimator.ofFloat(pukeInPosFive, View.Y, posFiveY, posThreeY)
        AnimationMoveE = AnimatorSet()
        AnimationMoveE!!.playTogether(animY, animYy)
        AnimationMoveE!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveE!!.duration = speed
        AnimationMoveE!!.start()
        pukeInPosFive!!.top = posThreeY.toInt()
        pukeInPosThree!!.top = posFiveY.toInt()
    }

    private fun moveF() {
        pukeInPosOne = returnPukeInPos(posOneX, posOneY)
        pukeInPosSix = returnPukeInPos(posSixX, posSixY)
        val animY = ObjectAnimator.ofFloat(pukeInPosOne, View.Y, posOneY, posSixY)
        val animYy = ObjectAnimator.ofFloat(pukeInPosSix, View.Y, posSixY, posOneY)
        AnimationMoveF = AnimatorSet()
        AnimationMoveF!!.playTogether(animY, animYy)
        AnimationMoveF!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveF!!.duration = speed
        AnimationMoveF!!.start()
        pukeInPosSix!!.top = posOneY.toInt()
        pukeInPosOne!!.top = posSixY.toInt()
    }

    private fun moveG() {
        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY)
        pukeInPosEight = returnPukeInPos(posEightX, posEightY)
        val animY = ObjectAnimator.ofFloat(pukeInPosThree, View.Y, posThreeY, posEightY)
        val animYy = ObjectAnimator.ofFloat(pukeInPosEight, View.Y, posEightY, posThreeY)
        AnimationMoveG = AnimatorSet()
        AnimationMoveG!!.playTogether(animY, animYy)
        AnimationMoveG!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveG!!.duration = speed
        AnimationMoveG!!.start()
        pukeInPosEight!!.top = posThreeY.toInt()
        pukeInPosThree!!.top = posEightY.toInt()
    }

    private fun moveH() {
        pukeInPosFour = returnPukeInPos(posFourX, posFourY)
        pukeInPosSix = returnPukeInPos(posSixX, posSixY)
        val animY = ObjectAnimator.ofFloat(pukeInPosFour, View.Y, posFourY, posSixY)
        val animYy = ObjectAnimator.ofFloat(pukeInPosSix, View.Y, posSixY, posFourY)
        AnimationMoveH = AnimatorSet()
        AnimationMoveH!!.playTogether(animY, animYy)
        AnimationMoveH!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveH!!.duration = speed
        AnimationMoveH!!.start()
        pukeInPosSix!!.top = posFourY.toInt()
        pukeInPosFour!!.top = posSixY.toInt()
    }

    private fun moveI() {
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY)
        pukeInPosEight = returnPukeInPos(posEightX, posEightY)
        val animY = ObjectAnimator.ofFloat(pukeInPosFive, View.Y, posFiveY, posEightY)
        val animYy = ObjectAnimator.ofFloat(pukeInPosEight, View.Y, posEightY, posFiveY)
        AnimationMoveI = AnimatorSet()
        AnimationMoveI!!.playTogether(animY, animYy)
        AnimationMoveI!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveI!!.duration = speed
        AnimationMoveI!!.start()
        pukeInPosEight!!.top = posFiveY.toInt()
        pukeInPosFive!!.top = posEightY.toInt()
    }

    private fun moveJ() {
        pukeInPosSix = returnPukeInPos(posSixX, posSixY)
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY)
        val animY = ObjectAnimator.ofFloat(pukeInPosSix, View.X, posSixX, posSevenX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosSeven, View.X, posSevenX, posSixX)
        AnimationMoveJ = AnimatorSet()
        AnimationMoveJ!!.playTogether(animY, animYy)
        AnimationMoveJ!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveJ!!.duration = speed
        AnimationMoveJ!!.start()
        pukeInPosSeven!!.left = posSixX.toInt()
        pukeInPosSix!!.left = posSevenX.toInt()
    }

    private fun moveK() {
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY)
        pukeInPosEight = returnPukeInPos(posEightX, posEightY)
        val animY = ObjectAnimator.ofFloat(pukeInPosSeven, View.X, posSevenX, posEightX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosEight, View.X, posEightX, posSevenX)
        AnimationMoveK = AnimatorSet()
        AnimationMoveK!!.playTogether(animY, animYy)
        AnimationMoveK!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveK!!.duration = speed
        AnimationMoveK!!.start()
        pukeInPosEight!!.left = posSevenX.toInt()
        pukeInPosSeven!!.left = posEightX.toInt()
    }

    private fun moveL() {
        pukeInPosSix = returnPukeInPos(posSixX, posSixY)
        pukeInPosEight = returnPukeInPos(posEightX, posEightY)
        val animY = ObjectAnimator.ofFloat(pukeInPosSix, View.X, posSixX, posEightX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosEight, View.X, posEightX, posSixX)
        AnimationMoveL = AnimatorSet()
        AnimationMoveL!!.playTogether(animY, animYy)
        AnimationMoveL!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveL!!.duration = speed
        AnimationMoveL!!.start()
        pukeInPosEight!!.left = posSixX.toInt()
        pukeInPosSix!!.left = posEightX.toInt()
    }

    private fun moveM() {
        pukeInPosOne = returnPukeInPos(posOneX, posOneY)
        pukeInPosEight = returnPukeInPos(posEightX, posEightY)
        val animX = ObjectAnimator.ofFloat(pukeInPosOne, View.X, posOneX, posEightX)
        val animY = ObjectAnimator.ofFloat(pukeInPosOne, View.Y, posOneY, posEightY)
        AnimationMoveM = AnimatorSet()
        AnimationMoveM!!.playTogether(animX, animY)
        AnimationMoveM!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveM!!.duration = speed
        AnimationMoveM!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosEight, View.X, posEightX, posOneX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosEight, View.Y, posEightY, posOneY)
        AnimationMoveMbis = AnimatorSet()
        AnimationMoveMbis!!.playTogether(animXx, animYy)
        AnimationMoveMbis!!.duration = speed
        AnimationMoveMbis!!.start()
        pukeInPosEight!!.left = posOneX.toInt()
        pukeInPosOne!!.left = posEightX.toInt()
        pukeInPosEight!!.top = posOneY.toInt()
        pukeInPosOne!!.top = posEightY.toInt()
    }

    private fun moveN() {
        pukeInPosFour = returnPukeInPos(posFourX, posFourY)
        pukeInPosEight = returnPukeInPos(posEightX, posEightY)
        val animX = ObjectAnimator.ofFloat(pukeInPosFour, View.X, posFourX, posEightX)
        val animY = ObjectAnimator.ofFloat(pukeInPosFour, View.Y, posFourY, posEightY)
        AnimationMoveN = AnimatorSet()
        AnimationMoveN!!.playTogether(animX, animY)
        AnimationMoveN!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveN!!.duration = speed
        AnimationMoveN!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosEight, View.X, posEightX, posFourX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosEight, View.Y, posEightY, posFourY)
        AnimationMoveNbis = AnimatorSet()
        AnimationMoveNbis!!.playTogether(animXx, animYy)
        AnimationMoveNbis!!.duration = speed
        AnimationMoveNbis!!.start()
        pukeInPosEight!!.left = posFourX.toInt()
        pukeInPosFour!!.left = posEightX.toInt()
        pukeInPosEight!!.top = posFourY.toInt()
        pukeInPosFour!!.top = posEightY.toInt()
    }

    private fun moveO() {
        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY)
        pukeInPosEight = returnPukeInPos(posEightX, posEightY)
        val animX = ObjectAnimator.ofFloat(pukeInPosTwo, View.X, posTwoX, posEightX)
        val animY = ObjectAnimator.ofFloat(pukeInPosTwo, View.Y, posTwoY, posEightY)
        AnimationMoveO = AnimatorSet()
        AnimationMoveO!!.playTogether(animX, animY)
        AnimationMoveO!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveO!!.duration = speed
        AnimationMoveO!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosEight, View.X, posEightX, posTwoX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosEight, View.Y, posEightY, posTwoY)
        AnimationMoveObis = AnimatorSet()
        AnimationMoveObis!!.playTogether(animXx, animYy)
        AnimationMoveObis!!.duration = speed
        AnimationMoveObis!!.start()
        pukeInPosEight!!.left = posTwoX.toInt()
        pukeInPosTwo!!.left = posEightX.toInt()
        pukeInPosEight!!.top = posTwoY.toInt()
        pukeInPosTwo!!.top = posEightY.toInt()
    }

    private fun moveP() {
        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY)
        pukeInPosSix = returnPukeInPos(posSixX, posSixY)
        val animX = ObjectAnimator.ofFloat(pukeInPosThree, View.X, posThreeX, posSixX)
        val animY = ObjectAnimator.ofFloat(pukeInPosThree, View.Y, posThreeY, posSixY)
        AnimationMoveP = AnimatorSet()
        AnimationMoveP!!.playTogether(animX, animY)
        AnimationMoveP!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveP!!.duration = speed
        AnimationMoveP!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosSix, View.X, posSixX, posThreeX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosSix, View.Y, posSixY, posThreeY)
        AnimationMovePbis = AnimatorSet()
        AnimationMovePbis!!.playTogether(animXx, animYy)
        AnimationMovePbis!!.duration = speed
        AnimationMovePbis!!.start()
        pukeInPosSix!!.left = posThreeX.toInt()
        pukeInPosThree!!.left = posSixX.toInt()
        pukeInPosSix!!.top = posThreeY.toInt()
        pukeInPosThree!!.top = posSixY.toInt()
    }

    private fun moveQ() {
        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY)
        pukeInPosFour = returnPukeInPos(posFourX, posFourY)
        val animX = ObjectAnimator.ofFloat(pukeInPosThree, View.X, posThreeX, posFourX)
        val animY = ObjectAnimator.ofFloat(pukeInPosThree, View.Y, posThreeY, posFourY)
        AnimationMoveQ = AnimatorSet()
        AnimationMoveQ!!.playTogether(animX, animY)
        AnimationMoveQ!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveQ!!.duration = speed
        AnimationMoveQ!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosFour, View.X, posFourX, posThreeX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosFour, View.Y, posFourY, posThreeY)
        AnimationMoveQbis = AnimatorSet()
        AnimationMoveQbis!!.playTogether(animXx, animYy)
        AnimationMoveQbis!!.duration = speed
        AnimationMoveQbis!!.start()
        pukeInPosFour!!.left = posThreeX.toInt()
        pukeInPosThree!!.left = posFourX.toInt()
        pukeInPosFour!!.top = posThreeY.toInt()
        pukeInPosThree!!.top = posFourY.toInt()
    }

    private fun moveR() {
        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY)
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY)
        val animX = ObjectAnimator.ofFloat(pukeInPosThree, View.X, posThreeX, posSevenX)
        val animY = ObjectAnimator.ofFloat(pukeInPosThree, View.Y, posThreeY, posSevenY)
        AnimationMoveR = AnimatorSet()
        AnimationMoveR!!.playTogether(animX, animY)
        AnimationMoveR!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveR!!.duration = speed
        AnimationMoveR!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosSeven, View.X, posSevenX, posThreeX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosSeven, View.Y, posSevenY, posThreeY)
        AnimationMoveRbis = AnimatorSet()
        AnimationMoveRbis!!.playTogether(animXx, animYy)
        AnimationMoveRbis!!.duration = speed
        AnimationMoveRbis!!.start()
        pukeInPosSeven!!.left = posThreeX.toInt()
        pukeInPosThree!!.left = posSevenX.toInt()
        pukeInPosSeven!!.top = posThreeY.toInt()
        pukeInPosThree!!.top = posSevenY.toInt()
    }

    private fun moveS() {
        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY)
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY)
        val animY = ObjectAnimator.ofFloat(pukeInPosTwo, View.Y, posTwoY, posSevenY)
        val animYy = ObjectAnimator.ofFloat(pukeInPosSeven, View.Y, posSevenY, posTwoY)
        AnimationMoveS = AnimatorSet()
        AnimationMoveS!!.playTogether(animY, animYy)
        AnimationMoveS!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveS!!.duration = speed
        AnimationMoveS!!.start()
        pukeInPosSeven!!.top = posTwoY.toInt()
        pukeInPosTwo!!.top = posSevenY.toInt()
    }

    private fun moveT() {
        pukeInPosFour = returnPukeInPos(posFourX, posFourY)
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY)
        val animX = ObjectAnimator.ofFloat(pukeInPosFour, View.X, posFourX, posFiveX)
        val animXx = ObjectAnimator.ofFloat(pukeInPosFive, View.X, posFiveX, posFourX)
        AnimationMoveT = AnimatorSet()
        AnimationMoveT!!.playTogether(animX, animXx)
        AnimationMoveT!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveT!!.duration = speed
        AnimationMoveT!!.start()
        pukeInPosFive!!.left = posFourX.toInt()
        pukeInPosFour!!.left = posFiveX.toInt()
    }

    private fun moveU() {
        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY)
        pukeInPosFour = returnPukeInPos(posFourX, posFourY)
        val animX = ObjectAnimator.ofFloat(pukeInPosTwo, View.X, posTwoX, posFourX)
        val animY = ObjectAnimator.ofFloat(pukeInPosTwo, View.Y, posTwoY, posFourY)
        AnimationMoveU = AnimatorSet()
        AnimationMoveU!!.playTogether(animX, animY)
        AnimationMoveU!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveU!!.duration = speed
        AnimationMoveU!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosFour, View.X, posFourX, posTwoX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosFour, View.Y, posFourY, posTwoY)
        AnimationMoveUbis = AnimatorSet()
        AnimationMoveUbis!!.playTogether(animXx, animYy)
        AnimationMoveUbis!!.duration = speed
        AnimationMoveUbis!!.start()
        pukeInPosFour!!.left = posTwoX.toInt()
        pukeInPosTwo!!.left = posFourX.toInt()
        pukeInPosFour!!.top = posTwoY.toInt()
        pukeInPosTwo!!.top = posFourY.toInt()
    }

    private fun moveV() {
        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY)
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY)
        val animX = ObjectAnimator.ofFloat(pukeInPosTwo, View.X, posTwoX, posFiveX)
        val animY = ObjectAnimator.ofFloat(pukeInPosTwo, View.Y, posTwoY, posFiveY)
        AnimationMoveV = AnimatorSet()
        AnimationMoveV!!.playTogether(animX, animY)
        AnimationMoveV!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveV!!.duration = speed
        AnimationMoveV!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosFive, View.X, posFiveX, posTwoX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosFive, View.Y, posFiveY, posTwoY)
        AnimationMoveVbis = AnimatorSet()
        AnimationMoveVbis!!.playTogether(animXx, animYy)
        AnimationMoveVbis!!.duration = speed
        AnimationMoveVbis!!.start()
        pukeInPosFive!!.left = posTwoX.toInt()
        pukeInPosTwo!!.left = posFiveX.toInt()
        pukeInPosFive!!.top = posTwoY.toInt()
        pukeInPosTwo!!.top = posFiveY.toInt()
    }

    private fun moveW() {
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY)
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY)
        val animX = ObjectAnimator.ofFloat(pukeInPosSeven, View.X, posSevenX, posFiveX)
        val animY = ObjectAnimator.ofFloat(pukeInPosSeven, View.Y, posSevenY, posFiveY)
        AnimationMoveW = AnimatorSet()
        AnimationMoveW!!.playTogether(animX, animY)
        AnimationMoveW!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveW!!.duration = speed
        AnimationMoveW!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosFive, View.X, posFiveX, posSevenX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosFive, View.Y, posFiveY, posSevenY)
        AnimationMoveWbis = AnimatorSet()
        AnimationMoveWbis!!.playTogether(animXx, animYy)
        AnimationMoveWbis!!.duration = speed
        AnimationMoveWbis!!.start()
        pukeInPosFive!!.left = posSevenX.toInt()
        pukeInPosSeven!!.left = posFiveX.toInt()
        pukeInPosFive!!.top = posSevenY.toInt()
        pukeInPosSeven!!.top = posFiveY.toInt()
    }

    private fun moveX() {
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY)
        pukeInPosFour = returnPukeInPos(posFourX, posFourY)
        val animX = ObjectAnimator.ofFloat(pukeInPosSeven, View.X, posSevenX, posFourX)
        val animY = ObjectAnimator.ofFloat(pukeInPosSeven, View.Y, posSevenY, posFourY)
        AnimationMoveX = AnimatorSet()
        AnimationMoveX!!.playTogether(animX, animY)
        AnimationMoveX!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveX!!.duration = speed
        AnimationMoveX!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosFour, View.X, posFourX, posSevenX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosFour, View.Y, posFourY, posSevenY)
        AnimationMoveXbis = AnimatorSet()
        AnimationMoveXbis!!.playTogether(animXx, animYy)
        AnimationMoveXbis!!.duration = speed
        AnimationMoveXbis!!.start()
        pukeInPosFour!!.left = posSevenX.toInt()
        pukeInPosSeven!!.left = posFourX.toInt()
        pukeInPosFour!!.top = posSevenY.toInt()
        pukeInPosSeven!!.top = posFourY.toInt()
    }

    private fun moveY() {
        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY)
        pukeInPosSix = returnPukeInPos(posSixX, posSixY)
        val animX = ObjectAnimator.ofFloat(pukeInPosTwo, View.X, posTwoX, posSixX)
        val animY = ObjectAnimator.ofFloat(pukeInPosTwo, View.Y, posTwoY, posSixY)
        AnimationMoveY = AnimatorSet()
        AnimationMoveY!!.playTogether(animX, animY)
        AnimationMoveY!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveY!!.duration = speed
        AnimationMoveY!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosSix, View.X, posSixX, posTwoX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosSix, View.Y, posSixY, posTwoY)
        AnimationMoveYbis = AnimatorSet()
        AnimationMoveYbis!!.playTogether(animXx, animYy)
        AnimationMoveYbis!!.duration = speed
        AnimationMoveYbis!!.start()
        pukeInPosTwo!!.left = posSixX.toInt()
        pukeInPosSix!!.left = posTwoX.toInt()
        pukeInPosTwo!!.top = posSixY.toInt()
        pukeInPosSix!!.top = posTwoY.toInt()
    }

    private fun moveZ() {
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY)
        pukeInPosOne = returnPukeInPos(posOneX, posOneY)
        val animX = ObjectAnimator.ofFloat(pukeInPosSeven, View.X, posSevenX, posOneX)
        val animY = ObjectAnimator.ofFloat(pukeInPosSeven, View.Y, posSevenY, posOneY)
        AnimationMoveZ = AnimatorSet()
        AnimationMoveZ!!.playTogether(animX, animY)
        AnimationMoveZ!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveZ!!.duration = speed
        AnimationMoveZ!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosOne, View.X, posOneX, posSevenX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosOne, View.Y, posOneY, posSevenY)
        AnimationMoveZbis = AnimatorSet()
        AnimationMoveZbis!!.playTogether(animXx, animYy)
        AnimationMoveZbis!!.duration = speed
        AnimationMoveZbis!!.start()
        pukeInPosOne!!.left = posSevenX.toInt()
        pukeInPosSeven!!.left = posOneX.toInt()
        pukeInPosOne!!.top = posSevenY.toInt()
        pukeInPosSeven!!.top = posOneY.toInt()
    }

    private fun moveAlpha() {
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY)
        pukeInPosOne = returnPukeInPos(posOneX, posOneY)
        val animX = ObjectAnimator.ofFloat(pukeInPosFive, View.X, posFiveX, posOneX)
        val animY = ObjectAnimator.ofFloat(pukeInPosFive, View.Y, posFiveY, posOneY)
        AnimationMoveAlpha = AnimatorSet()
        AnimationMoveAlpha!!.playTogether(animX, animY)
        AnimationMoveAlpha!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveAlpha!!.duration = speed
        AnimationMoveAlpha!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosOne, View.X, posOneX, posFiveX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosOne, View.Y, posOneY, posFiveY)
        AnimationMoveAlphaBis = AnimatorSet()
        AnimationMoveAlphaBis!!.playTogether(animXx, animYy)
        AnimationMoveAlphaBis!!.duration = speed
        AnimationMoveAlphaBis!!.start()
        pukeInPosOne!!.left = posFiveX.toInt()
        pukeInPosFive!!.left = posOneX.toInt()
        pukeInPosOne!!.top = posFiveY.toInt()
        pukeInPosFive!!.top = posOneY.toInt()
    }

    private fun moveBeta() {
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY)
        pukeInPosSix = returnPukeInPos(posSixX, posSixY)
        val animX = ObjectAnimator.ofFloat(pukeInPosFive, View.X, posFiveX, posSixX)
        val animY = ObjectAnimator.ofFloat(pukeInPosFive, View.Y, posFiveY, posSixY)
        AnimationMoveBeta = AnimatorSet()
        AnimationMoveBeta!!.playTogether(animX, animY)
        AnimationMoveBeta!!.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                iterator--
            }

            override fun onAnimationEnd(animation: Animator) {
                if (iterator != 0) {
                    moveToDo(listAnimations!![iterator - 1])
                } else {
                    buttonsAlgorithm(true)
                }
            }

            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}
        })
        AnimationMoveBeta!!.duration = speed
        AnimationMoveBeta!!.start()
        val animXx = ObjectAnimator.ofFloat(pukeInPosSix, View.X, posSixX, posFiveX)
        val animYy = ObjectAnimator.ofFloat(pukeInPosSix, View.Y, posSixY, posFiveY)
        AnimationMoveBetaBis = AnimatorSet()
        AnimationMoveBetaBis!!.playTogether(animXx, animYy)
        AnimationMoveBetaBis!!.duration = speed
        AnimationMoveBetaBis!!.start()
        pukeInPosSix!!.left = posFiveX.toInt()
        pukeInPosFive!!.left = posSixX.toInt()
        pukeInPosSix!!.top = posFiveY.toInt()
        pukeInPosFive!!.top = posSixY.toInt()
    }

    private fun returnPukeInPos(x: Float, y: Float): ImageView? {
        val pukeToReturn: ImageView?
        if (puke1!!.left.toFloat() == x && puke1!!.top.toFloat() == y) {
            pukeToReturn = puke1
        } else if (puke2!!.left.toFloat() == x && puke2!!.top.toFloat() == y) {
            pukeToReturn = puke2
        } else if (puke3!!.left.toFloat() == x && puke3!!.top.toFloat() == y) {
            pukeToReturn = puke3
        } else if (puke4!!.left.toFloat() == x && puke4!!.top.toFloat() == y) {
            pukeToReturn = puke4
        } else if (puke5!!.left.toFloat() == x && puke5!!.top.toFloat() == y) {
            pukeToReturn = puke5
        } else if (puke6!!.left.toFloat() == x && puke6!!.top.toFloat() == y) {
            pukeToReturn = puke6
        } else if (puke7!!.left.toFloat() == x && puke7!!.top.toFloat() == y) {
            pukeToReturn = puke7
        } else if (puke8!!.left.toFloat() == x && puke8!!.top.toFloat() == y) {
            pukeToReturn = puke8
        } else {
            pukeToReturn = null
            Log.e("Debug-HC", "Puke to return is null...")
        }
        return pukeToReturn
    }

    fun moveToDo(`val`: Int) {
        when (`val`) {
            0 -> moveA()
            1 -> moveB()
            2 -> moveC()
            3 -> moveD()
            4 -> moveE()
            5 -> moveF()
            6 -> moveG()
            7 -> moveH()
            8 -> moveI()
            9 -> moveJ()
            10 -> moveK()
            11 -> moveL()
            12 -> moveM()
            13 -> moveN()
            14 -> moveO()
            15 -> moveP()
            16 -> moveQ()
            17 -> moveR()
            18 -> moveS()
            19 -> moveT()
            20 -> moveU()
            21 -> moveV()
            22 -> moveW()
            23 -> moveX()
            24 -> moveY()
            25 -> moveZ()
            26 -> moveAlpha()
            27 -> moveBeta()
        }
    }

    private fun shuffle() {
        defineSpeed()
        hide()
        listAnimations = mutableListOf()
        val shuffleTimes = 7 + victoryCounter!!.text.toString().toInt()
        for (i in 0 until shuffleTimes) {
            //new random value
            val randomGenerator = Random()
            val randomValue = randomGenerator.nextInt(28)
            listAnimations?.add(randomValue)
        }

        listAnimations?.let {
            iterator = it.size
            moveToDo(it[iterator - 1])
        }
    }

    fun hide() {
        puke2!!.setImageResource(R.drawable.ic_track_changes_black)
    }

    fun reveal() {
        playground!!.requestLayout()
        puke1!!.setImageResource(R.drawable.ic_track_changes_black)
        puke2!!.setImageResource(R.drawable.ic_stars_black)
        puke3!!.setImageResource(R.drawable.ic_track_changes_black)
        puke4!!.setImageResource(R.drawable.ic_track_changes_black)
        puke5!!.setImageResource(R.drawable.ic_track_changes_black)
        puke6!!.setImageResource(R.drawable.ic_track_changes_black)
        puke7!!.setImageResource(R.drawable.ic_track_changes_black)
        puke8!!.setImageResource(R.drawable.ic_track_changes_black)
    }

    fun showSpeedDialog(speed: Float) {
        val builder = AlertDialog.Builder(this@MainActivity)
        val dialogTitleSpeed = "Speed Up !" + " " + speed.toInt() + "ms"
        builder.setTitle(dialogTitleSpeed)
                .setCancelable(true)
                .setOnCancelListener { fab_shuffle!!.callOnClick() }
                .setIcon(R.drawable.ic_flash_on)
        if (gameMode == "Infinity Mode") {
            builder.create().show()
        }
    }

    fun initialLostDialog() {
        val builder = AlertDialog.Builder(this@MainActivity)
        val dialogTitle = "Hint"
        val highScoreString = "<b><font color='#B0171F'>High Score</font></b>"
        val content = "Tap on $highScoreString to pick up where you left off"
        builder.setTitle(dialogTitle)
                .setMessage(Html.fromHtml(content))
                .setCancelable(true)
                .setIcon(R.drawable.ic_developer_mode_black)
        if (gameMode == "Infinity Mode") {
            builder.create().show()
        }
    }

    fun initialTutorialDialog() {
        val builder = AlertDialog.Builder(this@MainActivity)
        val dialogTitle = "Tutorial"
        val magentaString = "<b><font color='#ff00ff'>magenta</font></b>"
        val gameModeString = "<i><font color='#00c7c7'>Game Mode</font></i>"
        val content = "Click on the " + magentaString + " button to shuffle the pucks, then try to find the star. " +
                "You can try another " + gameModeString + " in Settings. Enjoy the game!"
        builder.setTitle(dialogTitle)
                .setMessage(Html.fromHtml(content))
                .setCancelable(true)
                .setIcon(R.drawable.ic_developer_mode_black)
        builder.create().show()
    }

    fun lostTimeAttackDialog() {
        cleanAnimations()
        reveal()
        buttonsAlgorithm(false)
        val builder = AlertDialog.Builder(this@MainActivity)
        val dialogTitle = "Time Attack"
        val content = "HighScore : $timeAttackHighScore"
        builder.setTitle(dialogTitle)
                .setMessage(content)
                .setCancelable(true)
                .setIcon(R.drawable.ic_grade_black)
        if (gameMode == "Time Attack") {
            builder.create().show()
        }
    }

    fun createCountDownTimer(startValue: Long) {
        countDown = object : CountDownTimer(startValue, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished / 1000
                timer!!.text = String.format("%1$03d", remainingTime)
            }

            override fun onFinish() {
                timer!!.text = String.format("%1$03d", 0)
                lostTimeAttackDialog()
                gameStarted = false
                timer!!.text = String.format("%1$03d", 30)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val preferenceIntent = Intent(this, SettingsActivity::class.java)
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(preferenceIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        var posOneX = 0f
        var posTwoX = 0f
        var posThreeX = 0f
        var posFourX = 0f
        var posFiveX = 0f
        var posSixX = 0f
        var posSevenX = 0f
        var posEightX = 0f
        var posOneY = 0f
        var posTwoY = 0f
        var posThreeY = 0f
        var posFourY = 0f
        var posFiveY = 0f
        var posSixY = 0f
        var posSevenY = 0f
        var posEightY = 0f
        var mSharedPreferences: SharedPreferences? = null
    }
}