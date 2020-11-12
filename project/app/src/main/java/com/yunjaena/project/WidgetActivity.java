package com.yunjaena.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WidgetActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{
    private TextView helloTextView;
    private CheckBox helloCheckBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        Button button = new Button(this);
        button.setText("hello");
        layout.addView(button);
        setContentView(R.layout.activity_widget);

    }

    // 3번째 방법
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "hello and bye", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        Toast.makeText(getApplicationContext(), String.valueOf(helloCheckBox.isChecked()), Toast.LENGTH_SHORT).show();
    }

    // 첫번째 방법
    public class ButtonClickedEvent implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
        }
    }
}
