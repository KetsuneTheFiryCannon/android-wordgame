package com.example.wordgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button inputBtn;

    EditText inputText;

    TextView first, second, third, fourth, tree;

    String middle;

    Boolean found = false;

    int mistakes = 0, winPoint = 0;

    String[] chars =
            {
                    "A",
                    "L",
                    "E",
                    "X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        fourth = findViewById(R.id.fourth);
        tree = findViewById(R.id.tree);

        TextView[] fields = {
                first,
                second,
                third,
                fourth
        };

        inputBtn = findViewById(R.id.input_button);
        inputText = findViewById(R.id.input_text);


        inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                middle = inputText.getText().toString();

                for (int i = 0; i < chars.length; i++) {
                    if (middle.equals(chars[i]))
                    {
                        fields[i].setText(middle);
                        chars[i] = "qwertyu";
                        found = true;
                        winPoint++;
                        break;
                    }
                    else {
                        found = false;
                    }
                }
                if (!found){
                    found=false;
                    mistakes++;
                }
                System.out.println("Mistakes " + mistakes);
                System.out.println("Winpoints " + winPoint);

                switch (mistakes){
                    case 1:
                        tree.setText("|_");
                        break;
                    case 2:
                        tree.setText("|\n" + "|_");
                        break;
                    case 3:
                        tree.setText("__\n" + "|\n" + "|_");
                        break;
                    case 4:
                        tree.setText( "__\n" + "|  0\n" + "|_");
                        break;
                }


                if(winPoint==4){
                    inputBtn.setEnabled(false);
                    inputText.setText("You win");
                }

                if(mistakes==4){
                    inputBtn.setEnabled(false);
                    inputText.setText("You lose");
                }
            }
        });
    }
}