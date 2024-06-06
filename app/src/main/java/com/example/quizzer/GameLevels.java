package com.example.quizzer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
        final int level = save.getInt("Level",1);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(v -> {
            //команда для кнопки
            try {
                Intent intent = new Intent(GameLevels.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
            }
        });
        //кнопка для перехода на 1 уровень
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(v -> {
            try {
                if(level>=1) {
                    Intent intent = new Intent(GameLevels.this, Level1.class);
                    startActivity(intent);
                    finish();
                }else { }
            } catch (Exception e) { }  });
        //кнопка для перехода на 2 уровень
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(v -> {
            try {
                if(level>=2) {
                    Intent intent = new Intent(GameLevels.this, Level2.class);
                    startActivity(intent);
                    finish();
                }
                else{ }
            } catch (Exception e) { }  });
        //кнопка для перехода на 3 уровень
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(v -> {
            try {
                if(level>=3) {
                    Intent intent = new Intent(GameLevels.this, Level3.class);
                    startActivity(intent);
                    finish();
                }else{ }
            } catch (Exception e) { }  });
        //кнопка для перехода на 4 уровень
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(v -> {
            try {
                if(level>=4) {
                    Intent intent = new Intent(GameLevels.this, Level4.class);
                    startActivity(intent);
                    finish();
                }else{ }
            } catch (Exception e) { }  });

        //кнопка для перехода на 5 уровень
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(v -> {
            try {
                if(level>=5) {
                    Intent intent = new Intent(GameLevels.this, Level5.class);
                    startActivity(intent);
                    finish();
                }else{}
            } catch (Exception e) {
            }
        });
        //кнопка для перехода на 6 уровень
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        textView6.setOnClickListener(v -> {
            try {
                if(level>=6) {
                    Intent intent = new Intent(GameLevels.this, Level6.class);
                    startActivity(intent);
                    finish();
                }else{}
            } catch (Exception e) {
            }
        });
        //кнопка для перехода на 7 уровень
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setOnClickListener(v -> {
            try {
                if(level>=7) {
                    Intent intent = new Intent(GameLevels.this, Level7.class);
                    startActivity(intent);
                    finish();
                }else{}
            } catch (Exception e) {
            }
        });
        //кнопка для перехода на 8 уровень
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setOnClickListener(v -> {
            try {
                if(level>=8) {
                    Intent intent = new Intent(GameLevels.this, Level8.class);
                    startActivity(intent);
                    finish();
                }else{}
            } catch (Exception e) {
            }
        });
        //кнопка для перехода на 9 уровень
        TextView textView9 = (TextView) findViewById(R.id.textView9);
        textView9.setOnClickListener(v -> {
            try {
                if(level>=9) {
                    Intent intent = new Intent(GameLevels.this, Level9.class);
                    startActivity(intent);
                    finish();
                }else{}
            } catch (Exception e) {
            }
        });

        //кнопка для перехода на 10 уровень
        TextView textView10 = (TextView) findViewById(R.id.textView10);
        textView10.setOnClickListener(v -> {
            try {
                if(level>=10) {
                    Intent intent = new Intent(GameLevels.this, Level10.class);
                    startActivity(intent);
                    finish();
                }else{}
            } catch (Exception e) {
            }
        });
        //кнопка для перехода на 11 уровень
        TextView textView11 = (TextView) findViewById(R.id.textView11);
        textView11.setOnClickListener(v -> {
            try {
                if(level>=11) {
                    Intent intent = new Intent(GameLevels.this, Level11.class);
                    startActivity(intent);
                    finish();
                }else{}
            } catch (Exception e) {
            }
        });
        //кнопка для перехода на 12 уровень
        TextView textView12 = (TextView) findViewById(R.id.textView12);
        textView12.setOnClickListener(v -> {
            try {
                if(level>=12) {
                    Intent intent = new Intent(GameLevels.this, Level12.class);
                    startActivity(intent);
                    finish();
                }else{}
            } catch (Exception e) {
            }
        });
        //кнопка для перехода на 13 уровень
        TextView textView13 = (TextView) findViewById(R.id.textView13);
        textView13.setOnClickListener(v -> {
            try {
                if(level>=13) {
                    Intent intent = new Intent(GameLevels.this, Level13.class);
                    startActivity(intent);
                    finish();
                }else{}
            } catch (Exception e) {
            }
        });
        //кнопка для перехода на 14 уровень
        TextView textView14 = (TextView) findViewById(R.id.textView14);
        textView14.setOnClickListener(v -> {
            try {
                if(level>=14) {
                    Intent intent = new Intent(GameLevels.this, Level14.class);
                    startActivity(intent);
                    finish();
                }else{}
            } catch (Exception e) {
            }
        });
        //кнопка для перехода на 15 уровень
        TextView textView15 = (TextView) findViewById(R.id.textView15);
        textView15.setOnClickListener(v -> {
            try {
                if(level>=15) {
                    Intent intent = new Intent(GameLevels.this, Level15.class);
                    startActivity(intent);
                    finish();
                }else{}
            } catch (Exception e) {
            }
        });
        final int[] x={
                R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
                R.id.textView6,
                R.id.textView7,
                R.id.textView8,
                R.id.textView9,
                R.id.textView10,
                R.id.textView11,
                R.id.textView12,
                R.id.textView13,
                R.id.textView14,
                R.id.textView15,
        };
        for(int i=1; i<level; i++){
            TextView tv = findViewById(x[i]);
            tv.setText(""+(i+1));
        }
    }
    //Системная кнопка "Назад"
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent); finish();
        } catch (Exception e){
        }
    }
}