package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup colorRadioGroup;
    private RadioButton selectedRadioButton;
    private Button submitButton;
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorRadioGroup = findViewById(R.id.color_radio_group);
        submitButton = findViewById(R.id.submit_button);
        clearButton = findViewById(R.id.clear_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = colorRadioGroup.getCheckedRadioButtonId();

                if (selectedRadioButtonId != -1) {
                    selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedColor = selectedRadioButton.getText().toString();
                    Toast.makeText(MainActivity.this, "Your favorite subject is: " + selectedColor, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please select a subject!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorRadioGroup.clearCheck();
                Toast.makeText(MainActivity.this, "Selection cleared!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}