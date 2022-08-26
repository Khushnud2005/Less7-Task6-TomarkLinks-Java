package uz.exemple.less7_task6_java;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews() {
        String text = "I would like to do something similar to the https://twitter.com app. I would like to do something similar to the https://twitter.com app.";
        TextView tv = findViewById(R.id.textView);

        Spannable text2Span = new SpannableString(text);
        String[] str = text.split(" ");
        int startS = 0;

        for (int i = 0; i < str.length; i++) {

            if (str[i].startsWith("http")) {
                if(str[i].endsWith(".")||str[i].endsWith(",")||str[i].endsWith("!")||str[i].endsWith("?")||str[i].endsWith("-")){
                    text2Span.setSpan(new ForegroundColorSpan(Color.BLUE), startS, startS + str[i].length()-1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                }
                text2Span.setSpan(new ForegroundColorSpan(Color.BLUE), startS, startS + str[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            }
            startS += str[i].length() + 1;
        }
        tv.setText(text2Span);
    }
}