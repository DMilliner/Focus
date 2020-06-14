package milliner.hc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by davidmilliner on 28/05/16.
 */

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getName();
    private float toDp;

    private TextView victoryCounter;
    private TextView topCounter;
    private TextView timer;
    private ImageView puke1, puke2, puke3, puke4, puke5, puke6, puke7, puke8;
    private Button betPuke1, betPuke2, betPuke3, betPuke4, betPuke5, betPuke6, betPuke7, betPuke8;
    private FloatingActionButton fab_shuffle;

    public static float posOneX = 0;
    public static float posTwoX = 0;
    public static float posThreeX = 0;
    public static float posFourX = 0;
    public static float posFiveX = 0;
    public static float posSixX = 0;
    public static float posSevenX = 0;
    public static float posEightX = 0;

    public static float posOneY = 0;
    public static float posTwoY = 0;
    public static float posThreeY = 0;
    public static float posFourY = 0;
    public static float posFiveY = 0;
    public static float posSixY = 0;
    public static float posSevenY = 0;
    public static float posEightY = 0;

    private int score = 0;
    private int topScore;
    private int timeAttackHighScore;

    private List<Integer> listAnimations;

    private ImageView pukeInPosOne;
    private ImageView pukeInPosTwo;
    private ImageView pukeInPosThree;
    private ImageView pukeInPosFour;
    private ImageView pukeInPosFive;
    private ImageView pukeInPosSix;
    private ImageView pukeInPosSeven;
    private ImageView pukeInPosEight;

    private int iterator;
    private long speed;
    private boolean isFirstTime = true;

    private AnimatorSet AnimationMoveA;
    private AnimatorSet AnimationMoveB;
    private AnimatorSet AnimationMoveC;
    private AnimatorSet AnimationMoveD;
    private AnimatorSet AnimationMoveE;
    private AnimatorSet AnimationMoveF;
    private AnimatorSet AnimationMoveG;
    private AnimatorSet AnimationMoveH;
    private AnimatorSet AnimationMoveI;
    private AnimatorSet AnimationMoveJ;
    private AnimatorSet AnimationMoveK;
    private AnimatorSet AnimationMoveL;
    private AnimatorSet AnimationMoveM;
    private AnimatorSet AnimationMoveMbis;
    private AnimatorSet AnimationMoveN;
    private AnimatorSet AnimationMoveNbis;
    private AnimatorSet AnimationMoveO;
    private AnimatorSet AnimationMoveObis;
    private AnimatorSet AnimationMoveP;
    private AnimatorSet AnimationMovePbis;
    private AnimatorSet AnimationMoveQ;
    private AnimatorSet AnimationMoveQbis;
    private AnimatorSet AnimationMoveR;
    private AnimatorSet AnimationMoveRbis;
    private AnimatorSet AnimationMoveS;
    private AnimatorSet AnimationMoveT;
    private AnimatorSet AnimationMoveU;
    private AnimatorSet AnimationMoveUbis;
    private AnimatorSet AnimationMoveV;
    private AnimatorSet AnimationMoveVbis;
    private AnimatorSet AnimationMoveW;
    private AnimatorSet AnimationMoveWbis;
    private AnimatorSet AnimationMoveX;
    private AnimatorSet AnimationMoveXbis;
    private AnimatorSet AnimationMoveY;
    private AnimatorSet AnimationMoveYbis;
    private AnimatorSet AnimationMoveZ;
    private AnimatorSet AnimationMoveZbis;
    private AnimatorSet AnimationMoveAlpha;
    private AnimatorSet AnimationMoveAlphaBis;
    private AnimatorSet AnimationMoveBeta;
    private AnimatorSet AnimationMoveBetaBis;

    public static SharedPreferences mSharedPreferences;
    private String gameMode;
    private String userName;

    private float deltaTopX = 0;
    private float deltaCenterX = 0;
    private float deltaCenterY = 0;
    private float deltaBottomX = 0;
    private float deltaBottomY = 0;

    private RelativeLayout playground;
    private boolean topScoreOnClickIsEnabled;
    private boolean isFirstLost;
    private long remainingTime;

    private CountDownTimer countDown;
    private boolean gameStarted = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Debug-HC", "onCreate");
        setContentView(R.layout.activity_main);

        playground = (RelativeLayout) findViewById(R.id.playground);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    }

    protected void onStart() {
        super.onStart();
        Log.d("Debug-HC", "onStart");
        userName = mSharedPreferences.getString("user_name", "Guest");
        gameMode = mSharedPreferences.getString("game_mode", "Infinity Mode");

        TextView gameModeView = (TextView) findViewById(R.id.game_mode_value);
        if (gameModeView != null) {
            gameModeView.setText(gameMode);
        }

        puke1 = (ImageView) findViewById(R.id.puke1);
        puke2 = (ImageView) findViewById(R.id.puke2);
        puke3 = (ImageView) findViewById(R.id.puke3);
        puke4 = (ImageView) findViewById(R.id.puke4);
        puke5 = (ImageView) findViewById(R.id.puke5);
        puke6 = (ImageView) findViewById(R.id.puke6);
        puke7 = (ImageView) findViewById(R.id.puke7);
        puke8 = (ImageView) findViewById(R.id.puke8);

        betPuke1 = (Button) findViewById(R.id.bet_puke1);
        betPuke2 = (Button) findViewById(R.id.bet_puke2);
        betPuke3 = (Button) findViewById(R.id.bet_puke3);
        betPuke4 = (Button) findViewById(R.id.bet_puke4);
        betPuke5 = (Button) findViewById(R.id.bet_puke5);
        betPuke6 = (Button) findViewById(R.id.bet_puke6);
        betPuke7 = (Button) findViewById(R.id.bet_puke7);
        betPuke8 = (Button) findViewById(R.id.bet_puke8);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Digital.ttf");
        victoryCounter = (TextView) findViewById(R.id.counter);
        if (victoryCounter != null) {
            victoryCounter.setTypeface(face);
        }
        victoryCounter.setText(String.format("%1$03d", score));

        topCounter = (TextView) findViewById(R.id.counter_top);
        if (topCounter != null) {
            topCounter.setTypeface(face);
        }
        topScore = mSharedPreferences.getInt("topScore", 0);
        topCounter.setText(String.format("%1$03d", topScore));

        timer = (TextView) findViewById(R.id.timer);


        if (gameMode.equals("Infinity Mode")) {
            topCounter.setVisibility(View.VISIBLE);
            timer.setVisibility(View.INVISIBLE);
        } else if (gameMode.equals("Time Attack")) {
            topCounter.setVisibility(View.INVISIBLE);
            score = 0;
            timeAttackHighScore = mSharedPreferences.getInt("timeAttackTopScore", 0);

            if (timer != null) {
                timer.setVisibility(View.VISIBLE);
                timer.setTypeface(face);
            }

            timer.setText(String.format("%1$03d", 30));
            createCountDownTimer(30000);
        }

        isFirstLost = mSharedPreferences.getBoolean("isFirstLost", true);
        boolean isTutorialSeen = mSharedPreferences.getBoolean("isTutorialSeen", false);
        if (!isTutorialSeen) {
            SharedPreferences.Editor editor = mSharedPreferences.edit();
            editor.putBoolean("isTutorialSeen", true);
            editor.apply();

            initialTutorialDialog();
        }

        toDp = 1 / ((float) getApplicationContext().getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);

        fab_shuffle = (FloatingActionButton) findViewById(R.id.fab_shuffle);
        fab_shuffle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                fab_shuffle.setClickable(false);
                fab_shuffle.setEnabled(false);

                if (!gameStarted && gameMode.equals("Time Attack")) {
                    countDown.start();
                    gameStarted = true;
                }


                topScoreOnClickIsEnabled = false;

                posOneX = puke1.getLeft();
                posTwoX = puke2.getLeft();
                posThreeX = puke3.getLeft();
                posFourX = puke4.getLeft();
                posFiveX = puke5.getLeft();
                posSixX = puke6.getLeft();
                posSevenX = puke7.getLeft();
                posEightX = puke8.getLeft();

                posOneY = puke1.getTop();
                posTwoY = puke2.getTop();
                posThreeY = puke3.getTop();
                posFourY = puke4.getTop();
                posFiveY = puke5.getTop();
                posSixY = puke6.getTop();
                posSevenY = puke7.getTop();
                posEightY = puke8.getTop();

                deltaTopX = betPuke1.getLeft() - puke1.getLeft();
                deltaCenterX = betPuke4.getLeft() - puke4.getLeft();
                deltaCenterY = betPuke4.getTop() - puke4.getTop();
                deltaBottomX = betPuke6.getLeft() - puke6.getLeft();
                deltaBottomY = betPuke6.getTop() - puke6.getTop();

                shuffle();
            }
        });

        betPuke1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonsAlgorithm(false);

                if ((betPuke1.getLeft() - deltaTopX) * toDp == puke2.getLeft() * toDp &&
                        betPuke1.getTop() * toDp == puke2.getTop() * toDp) {
                    score++;
                    if (countDown != null) {
                        countDown.cancel();
                        createCountDownTimer(remainingTime * 1000 + 5500);
                        countDown.start();
                    }

                    checkScore();
                } else {
                    score = 0;
                    if (isFirstLost) {
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putBoolean("isFirstLost", false);
                        editor.apply();
                        isFirstLost = false;

                        initialLostDialog();
                    }
                }
                victoryCounter.setText(String.format("%1$03d", score));
                reveal();
            }
        });

        betPuke2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonsAlgorithm(false);

                if ((betPuke2.getLeft() - deltaTopX) * toDp == puke2.getLeft() * toDp &&
                        betPuke2.getTop() * toDp == puke2.getTop() * toDp) {
                    score++;

                    if (gameMode.equals("Time Attack")) {
                        if (countDown != null)
                            countDown.cancel();
                        createCountDownTimer(remainingTime * 1000 + 5500);
                        countDown.start();
                    }

                    checkScore();
                } else {
                    score = 0;
                    if (isFirstLost) {
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putBoolean("isFirstLost", false);
                        editor.apply();
                        isFirstLost = false;

                        initialLostDialog();
                    }
                }
                victoryCounter.setText(String.format("%1$03d", score));
                reveal();
            }
        });

        betPuke3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonsAlgorithm(false);

                if ((betPuke3.getLeft() - deltaTopX) * toDp == puke2.getLeft() * toDp &&
                        betPuke3.getTop() * toDp == puke2.getTop() * toDp) {
                    score++;
                    if (gameMode.equals("Time Attack")) {
                        if (countDown != null)
                            countDown.cancel();
                        createCountDownTimer(remainingTime * 1000 + 5500);
                        countDown.start();
                    }
                    checkScore();
                } else {
                    score = 0;
                    if (isFirstLost) {
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putBoolean("isFirstLost", false);
                        editor.apply();
                        isFirstLost = false;

                        initialLostDialog();
                    }
                }
                victoryCounter.setText(String.format("%1$03d", score));
                reveal();
            }
        });

        betPuke4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonsAlgorithm(false);

                if ((betPuke4.getLeft() - deltaCenterX) * toDp == puke2.getLeft() * toDp &&
                        (betPuke4.getTop() - deltaCenterY) * toDp == puke2.getTop() * toDp) {
                    score++;
                    if (gameMode.equals("Time Attack")) {
                        if (countDown != null)
                            countDown.cancel();
                        createCountDownTimer(remainingTime * 1000 + 5500);
                        countDown.start();
                    }
                    checkScore();
                } else {
                    score = 0;
                    if (isFirstLost) {
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putBoolean("isFirstLost", false);
                        editor.apply();
                        isFirstLost = false;

                        initialLostDialog();
                    }
                }
                victoryCounter.setText(String.format("%1$03d", score));
                reveal();
            }
        });

        betPuke5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsAlgorithm(false);

                if ((betPuke5.getLeft() - deltaCenterX) * toDp != puke2.getLeft() * toDp &&
                        (betPuke5.getTop() - deltaCenterY) * toDp == puke2.getTop() * toDp) {
                    score++;
                    if (gameMode.equals("Time Attack")) {
                        if (countDown != null)
                            countDown.cancel();
                        createCountDownTimer(remainingTime * 1000 + 5500);
                        countDown.start();
                    }
                    checkScore();
                } else {
                    score = 0;
                    if (isFirstLost) {
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putBoolean("isFirstLost", false);
                        editor.apply();
                        isFirstLost = false;

                        initialLostDialog();
                    }
                }
                victoryCounter.setText(String.format("%1$03d", score));
                reveal();
            }
        });

        betPuke6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsAlgorithm(false);

                if ((betPuke6.getLeft() - deltaBottomX) * toDp == puke2.getLeft() * toDp &&
                        (betPuke6.getTop() - deltaBottomY) * toDp == puke2.getTop() * toDp) {
                    score++;
                    if (gameMode.equals("Time Attack")) {
                        if (countDown != null)
                            countDown.cancel();
                        createCountDownTimer(remainingTime * 1000 + 5500);
                        countDown.start();
                    }
                    checkScore();
                } else {
                    score = 0;
                    if (isFirstLost) {
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putBoolean("isFirstLost", false);
                        editor.apply();
                        isFirstLost = false;

                        initialLostDialog();
                    }
                }
                victoryCounter.setText(String.format("%1$03d", score));
                reveal();
            }
        });

        betPuke7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsAlgorithm(false);

                if ((betPuke7.getLeft() - deltaBottomX) * toDp == puke2.getLeft() * toDp &&
                        (betPuke7.getTop() - deltaBottomY) * toDp == puke2.getTop() * toDp) {
                    score++;
                    if (gameMode.equals("Time Attack")) {
                        if (countDown != null)
                            countDown.cancel();
                        createCountDownTimer(remainingTime * 1000 + 5500);
                        countDown.start();
                    }
                    checkScore();
                } else {
                    score = 0;
                    if (isFirstLost) {
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putBoolean("isFirstLost", false);
                        editor.apply();
                        isFirstLost = false;

                        initialLostDialog();
                    }
                }
                victoryCounter.setText(String.format("%1$03d", score));
                reveal();
            }
        });

        betPuke8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonsAlgorithm(false);

                if ((betPuke8.getLeft() - deltaBottomX) * toDp == puke2.getLeft() * toDp &&
                        (betPuke8.getTop() - deltaBottomY) * toDp == puke2.getTop() * toDp) {
                    score++;
                    if (gameMode.equals("Time Attack")) {
                        if (countDown != null)
                            countDown.cancel();
                        createCountDownTimer(remainingTime * 1000 + 5500);
                        countDown.start();
                    }
                    checkScore();
                } else {
                    score = 0;
                    if (isFirstLost) {
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putBoolean("isFirstLost", false);
                        editor.apply();
                        isFirstLost = false;

                        initialLostDialog();
                    }
                }
                victoryCounter.setText(String.format("%1$03d", score));
                reveal();
            }
        });

        if (fab_shuffle != null) {
            fab_shuffle.setBackgroundTintList(ColorStateList.valueOf(Color.MAGENTA));
            if (isFirstTime) {
                ObjectAnimator animY = ObjectAnimator.ofFloat(fab_shuffle, "translationY", -80f, 0f);
                animY.setDuration(750);//850 milliseconds
                animY.setInterpolator(new BounceInterpolator());
                animY.setRepeatCount(4);
                animY.start();
                isFirstTime = false;
            }
        }

    }

    protected void onResume() {
        super.onResume();
        Log.d("Debug-HC", "onResume");

        reveal();
        buttonsAlgorithm(false);
    }

    protected void onPause() {
        super.onPause();
        Log.d("Debug-HC", "onPause");
        cleanAnnimations();
    }

    private void cleanAnnimations() {
        if (AnimationMoveA != null && AnimationMoveA.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveA.end();
        }

        if (AnimationMoveB != null && AnimationMoveB.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveB.end();
        }

        if (AnimationMoveC != null && AnimationMoveC.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveC.end();
        }

        if (AnimationMoveD != null && AnimationMoveD.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveD.end();
        }

        if (AnimationMoveE != null && AnimationMoveE.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveE.end();
        }

        if (AnimationMoveF != null && AnimationMoveF.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveF.end();
        }

        if (AnimationMoveG != null && AnimationMoveG.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveG.end();
        }

        if (AnimationMoveH != null && AnimationMoveH.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveH.end();
        }

        if (AnimationMoveI != null && AnimationMoveI.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveI.end();
        }

        if (AnimationMoveJ != null && AnimationMoveJ.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveJ.end();
        }

        if (AnimationMoveK != null && AnimationMoveK.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveK.end();
        }

        if (AnimationMoveL != null && AnimationMoveL.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveL.end();
        }

        if (AnimationMoveM != null && AnimationMoveM.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveM.end();
        }

        if (AnimationMoveMbis != null && AnimationMoveMbis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveMbis.end();
        }

        if (AnimationMoveN != null && AnimationMoveN.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveN.end();
        }

        if (AnimationMoveNbis != null && AnimationMoveNbis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveNbis.end();
        }

        if (AnimationMoveO != null && AnimationMoveO.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveO.end();
        }

        if (AnimationMoveObis != null && AnimationMoveObis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveObis.end();
        }

        if (AnimationMoveP != null && AnimationMoveP.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveP.end();
        }

        if (AnimationMovePbis != null && AnimationMovePbis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMovePbis.end();
        }

        if (AnimationMoveQ != null && AnimationMoveQ.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveQ.end();
        }

        if (AnimationMoveQbis != null && AnimationMoveQbis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveQbis.end();
        }

        if (AnimationMoveR != null && AnimationMoveR.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveR.end();
        }

        if (AnimationMoveRbis != null && AnimationMoveRbis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveRbis.end();
        }

        if (AnimationMoveS != null && AnimationMoveS.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveS.end();
        }

        if (AnimationMoveT != null && AnimationMoveT.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveT.end();
        }

        if (AnimationMoveU != null && AnimationMoveU.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveU.end();
        }

        if (AnimationMoveUbis != null && AnimationMoveUbis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveUbis.end();
        }

        if (AnimationMoveV != null && AnimationMoveV.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveV.end();
        }

        if (AnimationMoveVbis != null && AnimationMoveVbis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveVbis.end();
        }

        if (AnimationMoveW != null && AnimationMoveW.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveW.end();
        }

        if (AnimationMoveWbis != null && AnimationMoveWbis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveWbis.end();
        }

        if (AnimationMoveX != null && AnimationMoveX.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveX.end();
        }

        if (AnimationMoveXbis != null && AnimationMoveXbis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveXbis.end();
        }

        if (AnimationMoveY != null && AnimationMoveY.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveY.end();
        }

        if (AnimationMoveYbis != null && AnimationMoveYbis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveYbis.end();
        }

        if (AnimationMoveZ != null && AnimationMoveZ.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveZ.end();
        }

        if (AnimationMoveZbis != null && AnimationMoveZbis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveZbis.end();
        }

        if (AnimationMoveAlpha != null && AnimationMoveAlpha.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveAlpha.end();
        }

        if (AnimationMoveAlphaBis != null && AnimationMoveAlphaBis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveAlphaBis.end();
        }

        if (AnimationMoveBeta != null && AnimationMoveBeta.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveBeta.end();
        }

        if (AnimationMoveBetaBis != null && AnimationMoveBetaBis.isRunning()) {
            if (listAnimations != null && !listAnimations.isEmpty()) {
                iterator = 0;
                listAnimations.clear();
            }
            AnimationMoveBetaBis.end();
        }
    }

    protected void onStop() {
        super.onStop();
        Log.d("Debug-HC", "onStop");
    }

    private void buttonsAlgorithm(boolean bool) {
        betPuke1.setClickable(bool);
        betPuke1.setEnabled(bool);
        betPuke2.setClickable(bool);
        betPuke2.setEnabled(bool);
        betPuke3.setClickable(bool);
        betPuke3.setEnabled(bool);
        betPuke4.setClickable(bool);
        betPuke4.setEnabled(bool);
        betPuke5.setClickable(bool);
        betPuke5.setEnabled(bool);
        betPuke6.setClickable(bool);
        betPuke6.setEnabled(bool);
        betPuke7.setClickable(bool);
        betPuke7.setEnabled(bool);
        betPuke8.setClickable(bool);
        betPuke8.setEnabled(bool);
        fab_shuffle.setClickable(!bool);
        fab_shuffle.setEnabled(!bool);
        topScoreOnClickIsEnabled = !bool;
    }

    private void checkScore() {

        if (gameMode.equals("Time Attack")) {
            if (score > timeAttackHighScore) {
                timeAttackHighScore = score;

                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putInt("timeAttackTopScore", timeAttackHighScore);
                editor.apply();

            }
        } else if (gameMode.equals("Infinity Mode")) {
            if (score > topScore) {
                topScore = score;

                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putInt("topScore", topScore);
                editor.apply();

                topCounter.setText(String.format("%1$03d", topScore));
            }
        }

        defineSpeed();

        if (score == 5) {
            showSpeedDialog(speed);
        } else if (score == 10) {
            showSpeedDialog(speed);
        } else if (score == 15) {
            showSpeedDialog(speed);
        } else if (score == 25) {
            showSpeedDialog(speed);
        } else if (score == 50) {
            showSpeedDialog(speed);
        } else if (score == 75) {
            showSpeedDialog(speed);
        } else if (score == 100) {
            showSpeedDialog(speed);
        } else if (score == 150) {
            showSpeedDialog(speed);
        } else if (score == 200) {
            showSpeedDialog(speed);
        } else if (score == 300) {
            showSpeedDialog(speed);
        } else if (score == 450) {
            showSpeedDialog(speed);
        } else if (score == 500) {
            showSpeedDialog(speed);
        }
    }

    private void defineSpeed() {

        if (gameMode.equals("Time Attack")) {
            if (score >= 0 && score < 15) {
                speed = 420;
            } else if (score >= 15 && score < 25) {
                speed = 314;
            } else if (score >= 25 && score < 50) {
                speed = 200;
            } else if (score >= 50) {
                speed = 100;
            }
        } else if (gameMode.equals("Infinity Mode")) {
            if (score >= 0 && score < 5) {
                speed = 1000;
            } else if (score >= 5 && score < 10) {
                speed = 900;
            } else if (score >= 10 && score < 15) {
                speed = 800;
            } else if (score >= 15 && score < 25) {
                speed = 700;
            } else if (score >= 25 && score < 50) {
                speed = 600;
            } else if (score >= 50 && score < 75) {
                speed = 500;
            } else if (score >= 75 && score < 100) {
                speed = 400;
            } else if (score >= 100) {
                speed = 300;
            }
        }
    }

    public void onClickTopScore(View v) {
        if (topScoreOnClickIsEnabled) {
            score = topScore;

            topCounter.setText(String.format("%1$03d", topScore));
            victoryCounter.setText(String.format("%1$03d", score));
        }
    }

    private void moveA() {

        pukeInPosOne = returnPukeInPos(posOneX, posOneY);
        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosOne, "x", posTwoX);
        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosTwo, "x", posOneX);
        AnimationMoveA = new AnimatorSet();
        AnimationMoveA.playTogether(animX, animXx);

        AnimationMoveA.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveA.setDuration(speed);
        AnimationMoveA.start();


        pukeInPosOne.setLeft((int) posTwoX);
        pukeInPosTwo.setLeft((int) posOneX);
    }


    private void moveB() {

        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY);
        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY);

        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosTwo, "x", posThreeX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosThree, "x", posTwoX);
        AnimationMoveB = new AnimatorSet();
        AnimationMoveB.playTogether(animY, animYy);

        AnimationMoveB.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveB.setDuration(speed);
        AnimationMoveB.start();

        pukeInPosThree.setLeft((int) posTwoX);
        pukeInPosTwo.setLeft((int) posThreeX);

    }

    private void moveC() {

        pukeInPosOne = returnPukeInPos(posOneX, posOneY);
        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosOne, "x", posThreeX);
        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosThree, "x", posOneX);
        AnimationMoveC = new AnimatorSet();
        AnimationMoveC.playTogether(animX, animXx);

        AnimationMoveC.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveC.setDuration(speed);
        AnimationMoveC.start();

        pukeInPosThree.setLeft((int) posOneX);
        pukeInPosOne.setLeft((int) posThreeX);

    }

    private void moveD() {

        pukeInPosOne = returnPukeInPos(posOneX, posOneY);
        pukeInPosFour = returnPukeInPos(posFourX, posFourY);

        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosOne, "y", posOneY, posFourY);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosFour, "y", posFourY, posOneY);

        AnimationMoveD = new AnimatorSet();
        AnimationMoveD.playTogether(animY, animYy);

        AnimationMoveD.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveD.setDuration(speed);
        AnimationMoveD.start();

        pukeInPosFour.setTop((int) posOneY);
        pukeInPosOne.setTop((int) posFourY);
    }

    private void moveE() {

        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY);
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY);

        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosThree, "y", posThreeY, posFiveY);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosFive, "y", posFiveY, posThreeY);

        AnimationMoveE = new AnimatorSet();
        AnimationMoveE.playTogether(animY, animYy);

        AnimationMoveE.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveE.setDuration(speed);
        AnimationMoveE.start();

        pukeInPosFive.setTop((int) posThreeY);
        pukeInPosThree.setTop((int) posFiveY);
    }

    private void moveF() {

        pukeInPosOne = returnPukeInPos(posOneX, posOneY);
        pukeInPosSix = returnPukeInPos(posSixX, posSixY);

        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosOne, "y", posOneY, posSixY);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosSix, "y", posSixY, posOneY);

        AnimationMoveF = new AnimatorSet();
        AnimationMoveF.playTogether(animY, animYy);

        AnimationMoveF.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveF.setDuration(speed);
        AnimationMoveF.start();

        pukeInPosSix.setTop((int) posOneY);
        pukeInPosOne.setTop((int) posSixY);
    }

    private void moveG() {

        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY);
        pukeInPosEight = returnPukeInPos(posEightX, posEightY);

        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosThree, "y", posThreeY, posEightY);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosEight, "y", posEightY, posThreeY);

        AnimationMoveG = new AnimatorSet();
        AnimationMoveG.playTogether(animY, animYy);

        AnimationMoveG.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveG.setDuration(speed);
        AnimationMoveG.start();

        pukeInPosEight.setTop((int) posThreeY);
        pukeInPosThree.setTop((int) posEightY);
    }

    private void moveH() {

        pukeInPosFour = returnPukeInPos(posFourX, posFourY);
        pukeInPosSix = returnPukeInPos(posSixX, posSixY);

        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosFour, "y", posFourY, posSixY);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosSix, "y", posSixY, posFourY);

        AnimationMoveH = new AnimatorSet();
        AnimationMoveH.playTogether(animY, animYy);

        AnimationMoveH.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveH.setDuration(speed);
        AnimationMoveH.start();

        pukeInPosSix.setTop((int) posFourY);
        pukeInPosFour.setTop((int) posSixY);
    }

    private void moveI() {

        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY);
        pukeInPosEight = returnPukeInPos(posEightX, posEightY);

        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosFive, "y", posFiveY, posEightY);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosEight, "y", posEightY, posFiveY);

        AnimationMoveI = new AnimatorSet();
        AnimationMoveI.playTogether(animY, animYy);

        AnimationMoveI.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveI.setDuration(speed);
        AnimationMoveI.start();

        pukeInPosEight.setTop((int) posFiveY);
        pukeInPosFive.setTop((int) posEightY);
    }

    private void moveJ() {

        pukeInPosSix = returnPukeInPos(posSixX, posSixY);
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY);

        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosSix, "x", posSixX, posSevenX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosSeven, "x", posSevenX, posSixX);

        AnimationMoveJ = new AnimatorSet();
        AnimationMoveJ.playTogether(animY, animYy);

        AnimationMoveJ.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveJ.setDuration(speed);
        AnimationMoveJ.start();

        pukeInPosSeven.setLeft((int) posSixX);
        pukeInPosSix.setLeft((int) posSevenX);
    }

    private void moveK() {

        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY);
        pukeInPosEight = returnPukeInPos(posEightX, posEightY);

        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosSeven, "x", posSevenX, posEightX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosEight, "x", posEightX, posSevenX);

        AnimationMoveK = new AnimatorSet();
        AnimationMoveK.playTogether(animY, animYy);

        AnimationMoveK.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveK.setDuration(speed);
        AnimationMoveK.start();

        pukeInPosEight.setLeft((int) posSevenX);
        pukeInPosSeven.setLeft((int) posEightX);
    }

    private void moveL() {

        pukeInPosSix = returnPukeInPos(posSixX, posSixY);
        pukeInPosEight = returnPukeInPos(posEightX, posEightY);

        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosSix, "x", posSixX, posEightX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosEight, "x", posEightX, posSixX);

        AnimationMoveL = new AnimatorSet();
        AnimationMoveL.playTogether(animY, animYy);

        AnimationMoveL.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveL.setDuration(speed);
        AnimationMoveL.start();

        pukeInPosEight.setLeft((int) posSixX);
        pukeInPosSix.setLeft((int) posEightX);
    }

    private void moveM() {

        pukeInPosOne = returnPukeInPos(posOneX, posOneY);
        pukeInPosEight = returnPukeInPos(posEightX, posEightY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosOne, "x", posOneX, posEightX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosOne, "y", posOneY, posEightY);

        AnimationMoveM = new AnimatorSet();
        AnimationMoveM.playTogether(animX, animY);

        AnimationMoveM.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveM.setDuration(speed);
        AnimationMoveM.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosEight, "x", posEightX, posOneX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosEight, "y", posEightY, posOneY);
        AnimationMoveMbis = new AnimatorSet();
        AnimationMoveMbis.playTogether(animXx, animYy);
        AnimationMoveMbis.setDuration(speed);
        AnimationMoveMbis.start();

        pukeInPosEight.setLeft((int) posOneX);
        pukeInPosOne.setLeft((int) posEightX);
        pukeInPosEight.setTop((int) posOneY);
        pukeInPosOne.setTop((int) posEightY);
    }

    private void moveN() {

        pukeInPosFour = returnPukeInPos(posFourX, posFourY);
        pukeInPosEight = returnPukeInPos(posEightX, posEightY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosFour, "x", posFourX, posEightX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosFour, "y", posFourY, posEightY);

        AnimationMoveN = new AnimatorSet();
        AnimationMoveN.playTogether(animX, animY);

        AnimationMoveN.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveN.setDuration(speed);
        AnimationMoveN.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosEight, "x", posEightX, posFourX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosEight, "y", posEightY, posFourY);
        AnimationMoveNbis = new AnimatorSet();
        AnimationMoveNbis.playTogether(animXx, animYy);
        AnimationMoveNbis.setDuration(speed);
        AnimationMoveNbis.start();

        pukeInPosEight.setLeft((int) posFourX);
        pukeInPosFour.setLeft((int) posEightX);
        pukeInPosEight.setTop((int) posFourY);
        pukeInPosFour.setTop((int) posEightY);
    }

    private void moveO() {

        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY);
        pukeInPosEight = returnPukeInPos(posEightX, posEightY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosTwo, "x", posTwoX, posEightX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosTwo, "y", posTwoY, posEightY);

        AnimationMoveO = new AnimatorSet();
        AnimationMoveO.playTogether(animX, animY);

        AnimationMoveO.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveO.setDuration(speed);
        AnimationMoveO.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosEight, "x", posEightX, posTwoX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosEight, "y", posEightY, posTwoY);
        AnimationMoveObis = new AnimatorSet();
        AnimationMoveObis.playTogether(animXx, animYy);
        AnimationMoveObis.setDuration(speed);
        AnimationMoveObis.start();

        pukeInPosEight.setLeft((int) posTwoX);
        pukeInPosTwo.setLeft((int) posEightX);
        pukeInPosEight.setTop((int) posTwoY);
        pukeInPosTwo.setTop((int) posEightY);
    }

    private void moveP() {

        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY);
        pukeInPosSix = returnPukeInPos(posSixX, posSixY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosThree, "x", posThreeX, posSixX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosThree, "y", posThreeY, posSixY);

        AnimationMoveP = new AnimatorSet();
        AnimationMoveP.playTogether(animX, animY);

        AnimationMoveP.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveP.setDuration(speed);
        AnimationMoveP.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosSix, "x", posSixX, posThreeX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosSix, "y", posSixY, posThreeY);
        AnimationMovePbis = new AnimatorSet();
        AnimationMovePbis.playTogether(animXx, animYy);
        AnimationMovePbis.setDuration(speed);
        AnimationMovePbis.start();

        pukeInPosSix.setLeft((int) posThreeX);
        pukeInPosThree.setLeft((int) posSixX);
        pukeInPosSix.setTop((int) posThreeY);
        pukeInPosThree.setTop((int) posSixY);
    }

    private void moveQ() {
        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY);
        pukeInPosFour = returnPukeInPos(posFourX, posFourY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosThree, "x", posThreeX, posFourX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosThree, "y", posThreeY, posFourY);

        AnimationMoveQ = new AnimatorSet();
        AnimationMoveQ.playTogether(animX, animY);

        AnimationMoveQ.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveQ.setDuration(speed);
        AnimationMoveQ.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosFour, "x", posFourX, posThreeX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosFour, "y", posFourY, posThreeY);
        AnimationMoveQbis = new AnimatorSet();
        AnimationMoveQbis.playTogether(animXx, animYy);
        AnimationMoveQbis.setDuration(speed);
        AnimationMoveQbis.start();

        pukeInPosFour.setLeft((int) posThreeX);
        pukeInPosThree.setLeft((int) posFourX);
        pukeInPosFour.setTop((int) posThreeY);
        pukeInPosThree.setTop((int) posFourY);
    }

    private void moveR() {
        pukeInPosThree = returnPukeInPos(posThreeX, posThreeY);
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosThree, "x", posThreeX, posSevenX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosThree, "y", posThreeY, posSevenY);

        AnimationMoveR = new AnimatorSet();
        AnimationMoveR.playTogether(animX, animY);

        AnimationMoveR.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveR.setDuration(speed);
        AnimationMoveR.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosSeven, "x", posSevenX, posThreeX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosSeven, "y", posSevenY, posThreeY);
        AnimationMoveRbis = new AnimatorSet();
        AnimationMoveRbis.playTogether(animXx, animYy);
        AnimationMoveRbis.setDuration(speed);
        AnimationMoveRbis.start();

        pukeInPosSeven.setLeft((int) posThreeX);
        pukeInPosThree.setLeft((int) posSevenX);
        pukeInPosSeven.setTop((int) posThreeY);
        pukeInPosThree.setTop((int) posSevenY);
    }

    private void moveS() {

        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY);
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY);

        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosTwo, "y", posTwoY, posSevenY);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosSeven, "y", posSevenY, posTwoY);

        AnimationMoveS = new AnimatorSet();
        AnimationMoveS.playTogether(animY, animYy);

        AnimationMoveS.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveS.setDuration(speed);
        AnimationMoveS.start();

        pukeInPosSeven.setTop((int) posTwoY);
        pukeInPosTwo.setTop((int) posSevenY);
    }

    private void moveT() {

        pukeInPosFour = returnPukeInPos(posFourX, posFourY);
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosFour, "x", posFourX, posFiveX);
        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosFive, "x", posFiveX, posFourX);

        AnimationMoveT = new AnimatorSet();
        AnimationMoveT.playTogether(animX, animXx);

        AnimationMoveT.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveT.setDuration(speed);
        AnimationMoveT.start();

        pukeInPosFive.setLeft((int) posFourX);
        pukeInPosFour.setLeft((int) posFiveX);
    }

    private void moveU() {
        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY);
        pukeInPosFour = returnPukeInPos(posFourX, posFourY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosTwo, "x", posTwoX, posFourX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosTwo, "y", posTwoY, posFourY);

        AnimationMoveU = new AnimatorSet();
        AnimationMoveU.playTogether(animX, animY);

        AnimationMoveU.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveU.setDuration(speed);
        AnimationMoveU.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosFour, "x", posFourX, posTwoX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosFour, "y", posFourY, posTwoY);
        AnimationMoveUbis = new AnimatorSet();
        AnimationMoveUbis.playTogether(animXx, animYy);
        AnimationMoveUbis.setDuration(speed);
        AnimationMoveUbis.start();

        pukeInPosFour.setLeft((int) posTwoX);
        pukeInPosTwo.setLeft((int) posFourX);
        pukeInPosFour.setTop((int) posTwoY);
        pukeInPosTwo.setTop((int) posFourY);
    }

    private void moveV() {
        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY);
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosTwo, "x", posTwoX, posFiveX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosTwo, "y", posTwoY, posFiveY);

        AnimationMoveV = new AnimatorSet();
        AnimationMoveV.playTogether(animX, animY);

        AnimationMoveV.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveV.setDuration(speed);
        AnimationMoveV.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosFive, "x", posFiveX, posTwoX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosFive, "y", posFiveY, posTwoY);
        AnimationMoveVbis = new AnimatorSet();
        AnimationMoveVbis.playTogether(animXx, animYy);
        AnimationMoveVbis.setDuration(speed);
        AnimationMoveVbis.start();

        pukeInPosFive.setLeft((int) posTwoX);
        pukeInPosTwo.setLeft((int) posFiveX);
        pukeInPosFive.setTop((int) posTwoY);
        pukeInPosTwo.setTop((int) posFiveY);
    }

    private void moveW() {
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY);
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosSeven, "x", posSevenX, posFiveX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosSeven, "y", posSevenY, posFiveY);

        AnimationMoveW = new AnimatorSet();
        AnimationMoveW.playTogether(animX, animY);

        AnimationMoveW.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveW.setDuration(speed);
        AnimationMoveW.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosFive, "x", posFiveX, posSevenX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosFive, "y", posFiveY, posSevenY);
        AnimationMoveWbis = new AnimatorSet();
        AnimationMoveWbis.playTogether(animXx, animYy);
        AnimationMoveWbis.setDuration(speed);
        AnimationMoveWbis.start();

        pukeInPosFive.setLeft((int) posSevenX);
        pukeInPosSeven.setLeft((int) posFiveX);
        pukeInPosFive.setTop((int) posSevenY);
        pukeInPosSeven.setTop((int) posFiveY);
    }

    private void moveX() {
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY);
        pukeInPosFour = returnPukeInPos(posFourX, posFourY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosSeven, "x", posSevenX, posFourX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosSeven, "y", posSevenY, posFourY);

        AnimationMoveX = new AnimatorSet();
        AnimationMoveX.playTogether(animX, animY);

        AnimationMoveX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveX.setDuration(speed);
        AnimationMoveX.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosFour, "x", posFourX, posSevenX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosFour, "y", posFourY, posSevenY);
        AnimationMoveXbis = new AnimatorSet();
        AnimationMoveXbis.playTogether(animXx, animYy);
        AnimationMoveXbis.setDuration(speed);
        AnimationMoveXbis.start();

        pukeInPosFour.setLeft((int) posSevenX);
        pukeInPosSeven.setLeft((int) posFourX);
        pukeInPosFour.setTop((int) posSevenY);
        pukeInPosSeven.setTop((int) posFourY);
    }

    private void moveY() {
        pukeInPosTwo = returnPukeInPos(posTwoX, posTwoY);
        pukeInPosSix = returnPukeInPos(posSixX, posSixY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosTwo, "x", posTwoX, posSixX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosTwo, "y", posTwoY, posSixY);

        AnimationMoveY = new AnimatorSet();
        AnimationMoveY.playTogether(animX, animY);

        AnimationMoveY.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveY.setDuration(speed);
        AnimationMoveY.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosSix, "x", posSixX, posTwoX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosSix, "y", posSixY, posTwoY);
        AnimationMoveYbis = new AnimatorSet();
        AnimationMoveYbis.playTogether(animXx, animYy);
        AnimationMoveYbis.setDuration(speed);
        AnimationMoveYbis.start();

        pukeInPosTwo.setLeft((int) posSixX);
        pukeInPosSix.setLeft((int) posTwoX);
        pukeInPosTwo.setTop((int) posSixY);
        pukeInPosSix.setTop((int) posTwoY);
    }

    private void moveZ() {
        pukeInPosSeven = returnPukeInPos(posSevenX, posSevenY);
        pukeInPosOne = returnPukeInPos(posOneX, posOneY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosSeven, "x", posSevenX, posOneX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosSeven, "y", posSevenY, posOneY);

        AnimationMoveZ = new AnimatorSet();
        AnimationMoveZ.playTogether(animX, animY);

        AnimationMoveZ.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveZ.setDuration(speed);
        AnimationMoveZ.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosOne, "x", posOneX, posSevenX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosOne, "y", posOneY, posSevenY);
        AnimationMoveZbis = new AnimatorSet();
        AnimationMoveZbis.playTogether(animXx, animYy);
        AnimationMoveZbis.setDuration(speed);
        AnimationMoveZbis.start();

        pukeInPosOne.setLeft((int) posSevenX);
        pukeInPosSeven.setLeft((int) posOneX);
        pukeInPosOne.setTop((int) posSevenY);
        pukeInPosSeven.setTop((int) posOneY);
    }

    private void moveAlpha() {
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY);
        pukeInPosOne = returnPukeInPos(posOneX, posOneY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosFive, "x", posFiveX, posOneX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosFive, "y", posFiveY, posOneY);

        AnimationMoveAlpha = new AnimatorSet();
        AnimationMoveAlpha.playTogether(animX, animY);

        AnimationMoveAlpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveAlpha.setDuration(speed);
        AnimationMoveAlpha.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosOne, "x", posOneX, posFiveX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosOne, "y", posOneY, posFiveY);
        AnimationMoveAlphaBis = new AnimatorSet();
        AnimationMoveAlphaBis.playTogether(animXx, animYy);
        AnimationMoveAlphaBis.setDuration(speed);
        AnimationMoveAlphaBis.start();

        pukeInPosOne.setLeft((int) posFiveX);
        pukeInPosFive.setLeft((int) posOneX);
        pukeInPosOne.setTop((int) posFiveY);
        pukeInPosFive.setTop((int) posOneY);
    }

    private void moveBeta() {
        pukeInPosFive = returnPukeInPos(posFiveX, posFiveY);
        pukeInPosSix = returnPukeInPos(posSixX, posSixY);

        ObjectAnimator animX = ObjectAnimator.ofFloat(pukeInPosFive, "x", posFiveX, posSixX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(pukeInPosFive, "y", posFiveY, posSixY);

        AnimationMoveBeta = new AnimatorSet();
        AnimationMoveBeta.playTogether(animX, animY);

        AnimationMoveBeta.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iterator--;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (iterator != 0) {
                    moveToDo(listAnimations.get(iterator - 1));
                } else {
                    buttonsAlgorithm(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        AnimationMoveBeta.setDuration(speed);
        AnimationMoveBeta.start();

        ObjectAnimator animXx = ObjectAnimator.ofFloat(pukeInPosSix, "x", posSixX, posFiveX);
        ObjectAnimator animYy = ObjectAnimator.ofFloat(pukeInPosSix, "y", posSixY, posFiveY);
        AnimationMoveBetaBis = new AnimatorSet();
        AnimationMoveBetaBis.playTogether(animXx, animYy);
        AnimationMoveBetaBis.setDuration(speed);
        AnimationMoveBetaBis.start();

        pukeInPosSix.setLeft((int) posFiveX);
        pukeInPosFive.setLeft((int) posSixX);
        pukeInPosSix.setTop((int) posFiveY);
        pukeInPosFive.setTop((int) posSixY);
    }

    private ImageView returnPukeInPos(float x, float y) {

        ImageView pukeToReturn;

        if (puke1.getLeft() == x && puke1.getTop() == y) {
            pukeToReturn = puke1;
        } else if (puke2.getLeft() == x && puke2.getTop() == y) {
            pukeToReturn = puke2;
        } else if (puke3.getLeft() == x && puke3.getTop() == y) {
            pukeToReturn = puke3;
        } else if (puke4.getLeft() == x && puke4.getTop() == y) {
            pukeToReturn = puke4;
        } else if (puke5.getLeft() == x && puke5.getTop() == y) {
            pukeToReturn = puke5;
        } else if (puke6.getLeft() == x && puke6.getTop() == y) {
            pukeToReturn = puke6;
        } else if (puke7.getLeft() == x && puke7.getTop() == y) {
            pukeToReturn = puke7;
        } else if (puke8.getLeft() == x && puke8.getTop() == y) {
            pukeToReturn = puke8;
        } else {
            pukeToReturn = null;
            Log.e("Debug-HC", "Puke to return is null...");
        }

        return pukeToReturn;
    }

    public void moveToDo(int val) {
        switch (val) {
            case 0:
                moveA();
                break;
            case 1:
                moveB();
                break;
            case 2:
                moveC();
                break;
            case 3:
                moveD();
                break;
            case 4:
                moveE();
                break;
            case 5:
                moveF();
                break;
            case 6:
                moveG();
                break;
            case 7:
                moveH();
                break;
            case 8:
                moveI();
                break;
            case 9:
                moveJ();
                break;
            case 10:
                moveK();
                break;
            case 11:
                moveL();
                break;
            case 12:
                moveM();
                break;
            case 13:
                moveN();
                break;
            case 14:
                moveO();
                break;
            case 15:
                moveP();
                break;
            case 16:
                moveQ();
                break;
            case 17:
                moveR();
                break;
            case 18:
                moveS();
                break;
            case 19:
                moveT();
                break;
            case 20:
                moveU();
                break;
            case 21:
                moveV();
                break;
            case 22:
                moveW();
                break;
            case 23:
                moveX();
                break;
            case 24:
                moveY();
                break;
            case 25:
                moveZ();
                break;
            case 26:
                moveAlpha();
                break;
            case 27:
                moveBeta();
                break;
        }
    }

    private void shuffle() {

        defineSpeed();

        hide();
        listAnimations = new ArrayList<>();

        int shuffleTimes = 7 + Integer.parseInt(victoryCounter.getText().toString());

        for (int i = 0; i < shuffleTimes; i++) {
            //new random value
            Random randomGenerator = new Random();
            int randomValue = randomGenerator.nextInt(28);
            listAnimations.add(randomValue);
        }

        iterator = listAnimations.size();
        moveToDo(listAnimations.get(iterator - 1));

    }

    public void hide() {
        puke2.setImageResource(R.drawable.ic_track_changes_black);
    }

    public void reveal() {

        playground.requestLayout();

        puke1.setImageResource(R.drawable.ic_track_changes_black);
        puke2.setImageResource(R.drawable.ic_stars_black);
        puke3.setImageResource(R.drawable.ic_track_changes_black);
        puke4.setImageResource(R.drawable.ic_track_changes_black);
        puke5.setImageResource(R.drawable.ic_track_changes_black);
        puke6.setImageResource(R.drawable.ic_track_changes_black);
        puke7.setImageResource(R.drawable.ic_track_changes_black);
        puke8.setImageResource(R.drawable.ic_track_changes_black);

    }

    public void showSpeedDialog(float speed) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        String dialogTitleSpeed = "Speed Up !" + " " + (int) speed + "ms";
        builder.setTitle(dialogTitleSpeed)
                .setCancelable(true)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        fab_shuffle.callOnClick();
                    }
                })
                .setIcon(R.drawable.ic_flash_on);

        if (gameMode.equals("Infinity Mode")) {
            builder.create().show();
        }
    }

    public void initialLostDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        String dialogTitle = "Hint";
        String highScoreString = "<b><font color='#B0171F'>High Score</font></b>";
        String content = "Tap on " + highScoreString + " to pick up where you left off";
        builder.setTitle(dialogTitle)
                .setMessage(Html.fromHtml(content))
                .setCancelable(true)
                .setIcon(R.drawable.ic_developer_mode_black);

        if (gameMode.equals("Infinity Mode")) {
            builder.create().show();
        }
    }

    public void initialTutorialDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        String dialogTitle = "Tutorial";
        String magentaString = "<b><font color='#ff00ff'>magenta</font></b>";
        String gameModeString = "<i><font color='#00c7c7'>Game Mode</font></i>";
        String content = "Click on the " + magentaString + " button to shuffle the pucks, then try to find the star. " +
                "You can try another " + gameModeString + " in Settings. Enjoy the game!";
        builder.setTitle(dialogTitle)
                .setMessage(Html.fromHtml(content))
                .setCancelable(true)
                .setIcon(R.drawable.ic_developer_mode_black);

        builder.create().show();
    }

    public void lostTimeAttackDialog() {
        cleanAnnimations();
        reveal();
        buttonsAlgorithm(false);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        String dialogTitle = "Time Attack";
        String content = "HighScore : " + String.valueOf(timeAttackHighScore);
        builder.setTitle(dialogTitle)
                .setMessage(content)
                .setCancelable(true)
                .setIcon(R.drawable.ic_grade_black);

        if (gameMode.equals("Time Attack")) {
            builder.create().show();
        }
    }

    public void createCountDownTimer(long startValue) {
        countDown = new CountDownTimer(startValue, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                remainingTime = millisUntilFinished / 1000;
                timer.setText(String.format("%1$03d", remainingTime));
            }

            @Override
            public void onFinish() {
                timer.setText(String.format("%1$03d", 0));
                lostTimeAttackDialog();
                gameStarted = false;
                timer.setText(String.format("%1$03d", 30));
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //noinspection SimplifiableIfStatement
        Intent preferenceIntent = new Intent(this, SettingsActivity.class);

        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(preferenceIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}