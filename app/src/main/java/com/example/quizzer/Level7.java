package com.example.quizzer;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Level7 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int count = 0; // счетчик правильных ответов
    Array array = new Array();//создали новый объект для класса Array
    private int currentIndex = 0; // переменная-счетчик для отслеживания текущего индекса в массиве


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //создаем переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level7); //установили текст

        final ImageView img_left = findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        final ImageView img_right = findViewById(R.id.img_right);
        img_right.setClipToOutline(true);

        final TextView text_left = findViewById(R.id.text_left);
        final TextView text_right = findViewById(R.id.text_right);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        ImageView previewimg = dialog.findViewById(R.id.previewimg);
        previewimg.setImageResource(R.drawable.previewimg6);

        TextView textdescription = dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.levelsix);

        TextView btnclose = dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Level7.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
            }
            dialog.dismiss();
        });

        Button btncontinue = dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(v -> dialog.dismiss());
        dialog.show();

        //Вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);

        TextView btnclose2 = dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Level7.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
            }
            dialogEnd.dismiss();
        });

        Button btncontinue2 = dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Level7.this, Level8.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
            }
            dialogEnd.dismiss();
        });

        Button btn_back = findViewById(R.id.button_back);
        btn_back.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Level7.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
            }
        });

        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };

        final Animation a = AnimationUtils.loadAnimation(Level7.this, R.anim.alpha);

        // устанавливаем изображения из массива в порядке очередности
        img_left.setImageResource(array.images7[currentIndex]);
        text_left.setText(array.texts7[currentIndex]);
        currentIndex++;

        img_right.setImageResource(array.images7[currentIndex]);
        text_right.setText(array.texts7[currentIndex]);
        currentIndex++;

        img_left.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                img_right.setEnabled(false);
                // Проверяем правильный ли ответ выбран
                if (array.correctAnswers[currentIndex / 2 - 1] == 0) {
                    img_left.setImageResource(R.drawable.img_true);
                } else {
                    img_left.setImageResource(R.drawable.img_false);
                }
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                if (array.correctAnswers[currentIndex / 2 - 1] == 0) {
                    if (count < 20) {
                        count = count + 1;
                    }
                    //закрашиваем прогресс серым цветом
                    for (int i = 0; i < 20; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points);
                    }
                    //определяем правильные ответы и закрашиваем зеленым
                    for (int i = 0; i < count; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }

                } else {
                    //Если ответ неправильный
                    if (count > 0) {
                        if (count == 1) {
                            count = 0;
                        } else {
                            count = count - 2;
                        }
                    }
                    for (int i = 0; i < 19; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points);
                    }
                    //определяем правильные ответы и закрашиваем зеленым
                    for (int i = 0; i < count; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }

                }
                if (count == 20) {
                    // Выход из уровня
                    SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
                    final int level = save.getInt("Level",1);
                    if(level>7){
                        //пусто
                    }else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Level",8);
                        editor.commit();
                    }
                    dialogEnd.show();
                } else {
                    if (currentIndex >= array.images7.length) {
                        currentIndex = 0; // Сброс индекса на начало массива
                    }

                    img_left.setImageResource(array.images7[currentIndex]);
                    text_left.setText(array.texts7[currentIndex]);
                    currentIndex++;

                    img_right.setImageResource(array.images7[currentIndex]);
                    text_right.setText(array.texts7[currentIndex]);
                    currentIndex++;

                    img_right.setEnabled(true); //включаем обратно правую картинку
                }
            }
            return true;
        });

        img_right.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                img_left.setEnabled(false);
                // Проверяем правильный ли ответ выбран
                if (array.correctAnswers[currentIndex / 2 - 1] == 1) {
                    img_right.setImageResource(R.drawable.img_true);
                } else {
                    img_right.setImageResource(R.drawable.img_false);
                }
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                if (array.correctAnswers[currentIndex / 2 - 1] == 1) {
                    if (count < 20) {
                        count = count + 1;
                    }
                    //закрашиваем прогресс серым цветом
                    for (int i = 0; i < 20; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points);
                    }
                    //определяем правильные ответы и закрашиваем зеленым
                    for (int i = 0; i < count; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }

                } else {
                    //Если ответ неправильный
                    if (count > 0) {
                        if (count == 1) {
                            count = 0;
                        } else {
                            count = count - 2;
                        }
                    }
                    for (int i = 0; i < 19; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points);
                    }
                    //определяем правильные ответы и закрашиваем зеленым
                    for (int i = 0; i < count; i++) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }

                }
                if (count == 20) {
                    // Выход из уровня
                    SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
                    final int level = save.getInt("Level",1);
                    if(level>7){
                        //пусто
                    }else {
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Level",8);
                        editor.commit();
                    }
                    dialogEnd.show();
                } else {
                    if (currentIndex >= array.images7.length) {
                        currentIndex = 0; // Сброс индекса на начало массива
                    }

                    img_left.setImageResource(array.images7[currentIndex]);
                    text_left.setText(array.texts7[currentIndex]);
                    currentIndex++;

                    img_right.setImageResource(array.images7[currentIndex]);
                    text_right.setText(array.texts7[currentIndex]);
                    currentIndex++;

                    img_left.setEnabled(true); //включаем обратно левую картинку
                }
            }
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level7.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }
}
