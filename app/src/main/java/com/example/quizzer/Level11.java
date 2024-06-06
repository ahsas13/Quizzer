package com.example.quizzer;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level11 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft; //переменная для левой картинки
    public int numRight; //переменная для 2 правой
    Array array = new Array();//создали новый объект для класса Array
    Random random = new Random(); //Для генерации случайных чисел
    public int count = 0; //счетчик правильных ответов


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //создаем переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level11); //установили текст


        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        // скругляем углы
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        // скругляем углы
        img_right.setClipToOutline(true);

        //путь к левой TextView
        final TextView text_left = findViewById(R.id.text_left);
        //путь к правой TextView
        final TextView text_right = findViewById(R.id.text_right);


        //Развернуть игру на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //Вызов диалогового окна в начале игры
        dialog = new Dialog(this); //создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialog.setContentView(R.layout.previewdialog); //путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалог окна
        dialog.setCancelable(false); //окно нельзя закрыть кнопной "Назад"

        ImageView previewimg = dialog.findViewById(R.id.previewimg);
        previewimg.setImageResource(R.drawable.previewimg10);

        LinearLayout dialogfon = (LinearLayout)dialog.findViewById(R.id.dialogfon);
        dialogfon.setBackgroundResource(R.drawable.previewbackground2);

        TextView textdescription = dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.levelten);

        //Кнопка закрыть диалог окно
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обрабатываем нажатие кнопки
                try {
                    //вернуться назад к выбору уровня
                    Intent intent = new Intent(Level11.this,GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){
                }
                dialog.dismiss();
        }
        });
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show(); //показать диалог окно


        //_____________________________________
        //Вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this); //создаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogend); //путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалог окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); //окно нельзя закрыть кнопной "Назад"
        //Кнопка закрыть диалог окно
        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обрабатываем нажатие кнопки
                try {
                    //вернуться назад к выбору уровня
                    Intent intent = new Intent(Level11.this,GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){
                }
                dialogEnd.dismiss();
            }
        });
        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level11.this, Level12.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
                dialogEnd.dismiss();
            }
        });
        //______________________________________
        //Кнопка назад
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Вернуться к выбору уровня
                    Intent intent = new Intent(Level11.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });

        //массив для прогресса игры
        final int[] progress = {
                R.id.point1,R.id.point2,R.id.point3,R.id.point4,R.id.point5,
                R.id.point6,R.id.point7,R.id.point8,R.id.point9,R.id.point10,
                R.id.point11,R.id.point12,R.id.point13,R.id.point14,R.id.point15,
                R.id.point16,R.id.point17,R.id.point18,R.id.point19,R.id.point20,
        };


        //подключаем анимацию
        final Animation a = AnimationUtils.loadAnimation(Level11.this, R.anim.alpha);
        numLeft = random.nextInt(20);
        img_left.setImageResource(array.images11[numLeft]);// Достаем из массива картинку
        text_left.setText(array.texts11[numLeft]);// Достаем из массива текст

        numRight = random.nextInt(20);

        while (numLeft==numRight){
            numRight = random.nextInt(20);
        }
        img_right.setImageResource(array.images11[numRight]);// Достаем из массива картинку
        text_right.setText(array.texts11[numRight]);// Достаем из массива текст

        //обрабатываем нажатие на левую картинку
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки
                if (event.getAction() ==MotionEvent.ACTION_DOWN){
                    //если коснулся картинки
                    img_right.setEnabled(false);//блокируем правую картинку
                    if (numLeft>numRight){
                        img_left.setImageResource(R.drawable.img_true);
                    }else{
                        img_left.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (numLeft>numRight){
                        if(count<20){
                            count=count+1;
                        }
                        //закрашиваем прогресс серым цветом
                        for (int i=0; i<20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //определяем правильные ответы и закрашиваем зеленым
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }else {
                     //Если левая картинка меньше
                    if (count>0){
                        if (count==1){
                            count=0;
                        } else {
                            count=count-2;
                        }
                    }
                        for (int i=0; i<19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //определяем правильные ответы и закрашиваем зеленым
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }
                    if (count==20){
                        // Выход из уровня
                        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
                        final int level = save.getInt("Level",1);
                        if(level>11){
                            //пусто
                        }else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",12);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(20);
                        img_left.setImageResource(array.images11[numLeft]);// Достаем из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts11[numLeft]);// Достаем из массива текст

                        numRight = random.nextInt(20);

                        while (numLeft==numRight){
                            numRight = random.nextInt(20);
                        }
                        img_right.setImageResource(array.images11[numRight]);// Достаем из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts11[numRight]);// Достаем из массива текст

                        img_right.setEnabled(true); //включаем обратно правую картинку
                    }
                }
                return true;
            }
        });
        //обрабатываем нажатие на правую картинку
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки
                if (event.getAction() ==MotionEvent.ACTION_DOWN){
                    //если коснулся картинки
                    img_left.setEnabled(false);//блокируем левую картинку
                    if (numLeft<numRight){
                        img_right.setImageResource(R.drawable.img_true);
                    }else{
                        img_right.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction()==MotionEvent.ACTION_UP) {
                    if (numLeft<numRight){
                        if(count<20){
                            count=count+1;
                        }
                        //закрашиваем прогресс серым цветом
                        for (int i=0; i<20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //определяем правильные ответы и закрашиваем зеленым
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }else {
                        //Если левая картинка меньше
                        if (count>0){
                            if (count==1){
                                count=0;
                            } else {
                                count=count-2;
                            }
                        }
                        for (int i=0; i<19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //определяем правильные ответы и закрашиваем зеленым
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }
                    if (count==20){
                        // Выход из уровня
                        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
                        final int level = save.getInt("Level",1);
                        if(level>11){
                            //пусто
                        }else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",12);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(20);
                        img_left.setImageResource(array.images11[numLeft]);// Достаем из массива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts11[numLeft]);// Достаем из массива текст

                        numRight = random.nextInt(20);

                        while (numLeft==numRight){
                            numRight = random.nextInt(20);
                        }
                        img_right.setImageResource(array.images11[numRight]);// Достаем из массива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts11[numRight]);// Достаем из массива текст

                        img_left.setEnabled(true); //включаем обратно левую картинку
                    }
                }
                return true;
            }
        });
    }
    //Системная кнопка назад
    @Override
    public void onBackPressed(){
        try {
            //Вернуться к выбору уровня
            Intent intent = new Intent(Level11.this, GameLevels.class);
            startActivity(intent);
            finish();
        }catch (Exception e) {
        }
    }
}