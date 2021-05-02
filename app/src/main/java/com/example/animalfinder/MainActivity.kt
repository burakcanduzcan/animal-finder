package com.example.animalfinder

import android.media.MediaPlayer
import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Chronometer
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null;
    private var mediaPlayer: MediaPlayer? = null;

    public var correctAnswerCount = 0;
    public var currentLevel = 1;
    public var levelAnimalCount = 2;
    public var timer = 20000;

    var selectedAnimalIndex = 0
    var selectAnimalSoundFileName = "";


    lateinit var imgBut1 : ImageButton;
    lateinit var imgBut2 : ImageButton;
    lateinit var imgBut3 : ImageButton;
    lateinit var imgBut4 : ImageButton;
    lateinit var imgBut5 : ImageButton;
    lateinit var imgBut6 : ImageButton;
    lateinit var imgBut7 : ImageButton;
    lateinit var imgBut8 : ImageButton;
    lateinit var tvLevel : TextView;
    lateinit var tvScore : TextView;
    lateinit var tvBestScore : TextView;

    val images: MutableList<Int> = mutableListOf(
        R.drawable.a_ape,
        R.drawable.a_bee,
        R.drawable.a_cat,
        R.drawable.a_chicken,
        R.drawable.a_cow,
        R.drawable.a_crow,
        R.drawable.a_dog,
        R.drawable.a_dove,
        R.drawable.a_duck,
        R.drawable.a_elephant,
        R.drawable.a_falcon,
        R.drawable.a_frog,
        R.drawable.a_horse,
        R.drawable.a_hyena,
        R.drawable.a_lion,
        R.drawable.a_owl,
        R.drawable.a_rooster,
        R.drawable.a_sheep,
        R.drawable.a_whale,
        R.drawable.a_wolf
    );

    val sounds: MutableList<Int> = mutableListOf(
        R.raw.a_ape, R.raw.a_bee,
        R.raw.a_cat, R.raw.a_chicken, R.raw.a_cow, R.raw.a_crow, R.raw.a_dog,
        R.raw.a_dove, R.raw.a_duck, R.raw.a_elephant, R.raw.a_falcon, R.raw.a_frog,
        R.raw.a_horse, R.raw.a_hyena, R.raw.a_lion, R.raw.a_owl, R.raw.a_rooster,
        R.raw.a_sheep, R.raw.a_whale, R.raw.a_wolf
    );

    val animalNames: MutableList<String> = mutableListOf(
        "ape",
        "bee",
        "cat",
        "chicken",
        "cow",
        "crow",
        "dog",
        "dove",
        "duck",
        "elephant",
        "falcon",
        "frog",
        "horse",
        "hyena",
        "lion",
        "owl",
        "rooster",
        "sheep",
        "whale",
        "wolf"
    );

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //loadData();

        tts = TextToSpeech(this, this);
        mediaPlayer = MediaPlayer.create(this, R.raw.a_ape);
        mediaPlayer?.setOnPreparedListener {
            println("Ready to go");
        }

        imgBut1 = findViewById<ImageButton>(R.id.imgBut1);
        imgBut2 = findViewById<ImageButton>(R.id.imgBut2);
        imgBut3 = findViewById<ImageButton>(R.id.imgBut3);
        imgBut4 = findViewById<ImageButton>(R.id.imgBut4);
        imgBut5 = findViewById<ImageButton>(R.id.imgBut5);
        imgBut6 = findViewById<ImageButton>(R.id.imgBut6);
        imgBut7 = findViewById<ImageButton>(R.id.imgBut7);
        imgBut8 = findViewById<ImageButton>(R.id.imgBut8);
        tvLevel = findViewById<TextView>(R.id.tvLevel);
        tvScore = findViewById<TextView>(R.id.tvScore);
        tvBestScore = findViewById<TextView>(R.id.tvBestScore);

        selectedAnimalIndex = (0..levelAnimalCount - 1).random();
        selectAnimalSoundFileName = "a_" + animalNames.get(selectedAnimalIndex).toString();
        mediaPlayer = MediaPlayer.create(this, resources.getIdentifier(selectAnimalSoundFileName, "raw", packageName));

        tvLevel.text = "Level " + currentLevel;

        imgBut1.setBackgroundResource(images.get(0));
        imgBut2.setBackgroundResource(images.get(1));

        val handler = Handler();
        handler.postDelayed({
            speakOut("Find the " + animalNames.get(selectedAnimalIndex) + ", " + animalNames.get(selectedAnimalIndex) + " makes this sound: ");
        }, 750);

        handler.postDelayed({
            mediaPlayer?.start();
        }, 4500);


        imgBut1.setOnClickListener {
            val IdBut = 0;
            if (IdBut == selectedAnimalIndex) {
                speakOut("You got it!");
                correctAnswer();
            } else {
                speakOut("Wrong answer.");
                wrongAnswer();
            }
        }

        imgBut2.setOnClickListener {
            val IdBut = 1;
            if (IdBut == selectedAnimalIndex) {
                speakOut("You got it!");
                correctAnswer();
            } else {
                speakOut("Wrong answer.");
                wrongAnswer();
            }
        }

        imgBut3.setOnClickListener {
            val IdBut = 2;
            if (IdBut == selectedAnimalIndex) {
                speakOut("You got it!");
                correctAnswer();
            } else {
                speakOut("Wrong answer.");
                wrongAnswer();
            }
        }

        imgBut4.setOnClickListener {
            val IdBut = 3;
            if (IdBut == selectedAnimalIndex) {
                speakOut("You got it!");
                correctAnswer();
            } else {
                speakOut("Wrong answer.");
                wrongAnswer();
            }
        }

        imgBut5.setOnClickListener {
            val IdBut = 4;
            if (IdBut == selectedAnimalIndex) {
                speakOut("You got it!");
                correctAnswer();
            } else {
                speakOut("Wrong answer.");
                wrongAnswer();
            }
        }

        imgBut6.setOnClickListener {
            val IdBut = 5;
            if (IdBut == selectedAnimalIndex) {
                speakOut("You got it!");
                correctAnswer();
            } else {
                speakOut("Wrong answer.");
                wrongAnswer();
            }
        }

        imgBut7.setOnClickListener {
            val IdBut = 6;
            if (IdBut == selectedAnimalIndex) {
                speakOut("You got it!");
                correctAnswer();
            } else {
                speakOut("Wrong answer.");
                wrongAnswer();
            }
        }

        imgBut8.setOnClickListener {
            val IdBut = 7;
            if (IdBut == selectedAnimalIndex) {
                speakOut("You got it!");
                correctAnswer();
            } else {
                speakOut("Wrong answer.");
                wrongAnswer();
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.US);
            tts!!.setSpeechRate(0.6f);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "The language specified is not supported!");
            }
        } else {
            Log.e("TTS", "Init. failed!");
        }
    }

    private fun speakOut(text: String) {
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "");
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        val savedInt = sharedPreferences.getInt("INTEGER_KEY", 0);
        tvBestScore.text = "Best score: " + savedInt.toString();
    }
    private fun saveData() {
        val tmpInt = Integer.parseInt(tvBestScore.text.toString());
        val currentPlayScore = currentLevel * 3 + correctAnswerCount;
        if (currentPlayScore > tmpInt) {
            tvBestScore.text = "Best score: " + currentPlayScore.toString();
            val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
            val editor = sharedPreferences.edit();
            editor.apply {
                putInt("INTEGER_KEY", currentPlayScore);
            }.apply();
        }
    }

    private fun wrongAnswer() {
        saveData();

        correctAnswerCount = 0;
        currentLevel = 1;
        levelAnimalCount = 2;


        tvScore.text = correctAnswerCount.toString();
        tvLevel.text = "Level " + currentLevel.toString();

        imgBut1.setBackgroundResource(images.get(0));
        imgBut2.setBackgroundResource(images.get(1));
        imgBut3.setBackgroundResource(0);
        imgBut4.setBackgroundResource(0);
        imgBut5.setBackgroundResource(0);
        imgBut6.setBackgroundResource(0);
        imgBut7.setBackgroundResource(0);
        imgBut8.setBackgroundResource(0);

        selectedAnimalIndex = (0..levelAnimalCount - 1).random();
        selectAnimalSoundFileName = "a_" + animalNames.get(selectedAnimalIndex).toString();
        mediaPlayer = MediaPlayer.create(this, resources.getIdentifier(selectAnimalSoundFileName, "raw", packageName));

        val handler = Handler();
        handler.postDelayed({
            speakOut("Find the " + animalNames.get(selectedAnimalIndex) + ", " + animalNames.get(selectedAnimalIndex) + " makes this sound: ");
        }, 750);

        handler.postDelayed({
            mediaPlayer?.start();
        }, 4500);
    }

    private fun correctAnswer() {
        correctAnswerCount++;
        if (correctAnswerCount == 3) {
            correctAnswerCount = 0;
            currentLevel++;
        }
        when (currentLevel) {
            1 -> levelAnimalCount = 2;
            2 -> levelAnimalCount = 3;
            3 -> levelAnimalCount = 4;
            4 -> levelAnimalCount = 6;
            5 -> levelAnimalCount = 8;
            else -> {
                levelAnimalCount = 8;
            }
        }

        tvScore.text = correctAnswerCount.toString();
        tvLevel.text = "Level " + currentLevel.toString();

        selectedAnimalIndex = (0..levelAnimalCount - 1).random();
        selectAnimalSoundFileName = "a_" + animalNames.get(selectedAnimalIndex).toString();
        mediaPlayer = MediaPlayer.create(this, resources.getIdentifier(selectAnimalSoundFileName, "raw", packageName));


        imgBut1.setBackgroundResource(images.get(0));
        imgBut2.setBackgroundResource(images.get(1));
        if (levelAnimalCount == 3) {
            imgBut3.setBackgroundResource(images.get(2));
        }
        if (levelAnimalCount == 4) {
            imgBut4.setBackgroundResource(images.get(3));
        }
        if (levelAnimalCount == 6) {
            imgBut5.setBackgroundResource(images.get(4));
            imgBut6.setBackgroundResource(images.get(5));
        }
        if (levelAnimalCount == 8) {
            imgBut7.setBackgroundResource(images.get(6));
            imgBut8.setBackgroundResource(images.get(7));
        }

        val handler = Handler();
        handler.postDelayed({
            speakOut("Find the " + animalNames.get(selectedAnimalIndex) + ", " + animalNames.get(selectedAnimalIndex) + " makes this sound: ");
        }, 750);

        handler.postDelayed({
            mediaPlayer?.start();
        }, 4000);
    }

    public override fun onDestroy() {
        if (tts != null) {
            tts!!.stop();
            tts!!.shutdown();
        }

        super.onDestroy()
    }

}