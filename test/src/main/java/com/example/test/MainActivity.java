package com.example.test;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import java.io.File;


public class MainActivity extends Activity {
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
//            player=new MediaPlayer();
//            player.reset();
//            player.setDataSource("/storage/emulated/0/music.mp3");
//            player.prepare();
//            player.start();
            File file=new File(Environment.getExternalStorageDirectory(),"music.mp3");
            player=MediaPlayer.create(this, Uri.parse(file.getPath()));
//            player.prepare();
            player.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }
}
