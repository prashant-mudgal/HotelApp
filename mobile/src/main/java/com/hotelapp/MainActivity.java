package com.hotelapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.Random;

import uk.co.senab.photoview.PhotoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test", " token :::: " + FirebaseInstanceId.getInstance().getToken());
        TextView tvOpenDoor = (TextView) findViewById(R.id.tv_open_door);
        tvOpenDoor.setOnClickListener(this);
        TextView tvOnLight = (TextView) findViewById(R.id.tv_on_light);
        tvOnLight.setOnClickListener(this);
        TextView tvOffLight = (TextView) findViewById(R.id.tv_off_light);
        tvOffLight.setOnClickListener(this);
        TextView tvOnAc = (TextView) findViewById(R.id.tv_on_ac);
        tvOnAc.setOnClickListener(this);

        TextView tvCaptcha = (TextView) findViewById(R.id.captcha);
        Typeface mTypeface = Typeface.createFromAsset(getAssets(), "Chalkduster.ttf");
        tvCaptcha.setTypeface(mTypeface);
        String generatedCaptcha = "";
        for (int index = 0; index < 4; index++) {
            String temp = generateRandomText();
            generatedCaptcha = generatedCaptcha + temp;
        }
        tvCaptcha.setText(generatedCaptcha);
//        final CaptchaImageView captchaImageView = (CaptchaImageView) findViewById(R.id.image);
//        ImageView refreshButton = (ImageView) findViewById(R.id.regen);
//        refreshButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                captchaImageView.regenerate();
//            }
//        });
//        captchaImageView.setCaptchaType(CaptchaImageView.CaptchaGenerator.BOTH);
        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        photoView.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_open_door:
                break;
            case R.id.tv_on_light:
                break;
            case R.id.tv_off_light:
                break;
            case R.id.tv_on_ac:
                break;
        }
    }

    private String generateRandomText() {
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] alphabets = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
                , "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Random random = new Random();
        Random mixedRandom = new Random();
        String temp;
        temp = (mixedRandom.nextBoolean()) ? (alphabets[random.nextInt(alphabets.length)]) : (numbers[random.nextInt(numbers.length)]);
        return temp;
    }
}
