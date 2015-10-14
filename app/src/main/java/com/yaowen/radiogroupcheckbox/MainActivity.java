package com.yaowen.radiogroupcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mRadioGroup;
    private RadioButton mRadio1, mRadio2, mRadio3, mRadio4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup2);
        mRadio1 = (RadioButton) findViewById(R.id.radio1);
        mRadio2 = (RadioButton) findViewById(R.id.radio2);
        mRadio3 = (RadioButton) findViewById(R.id.radio3);
        mRadio4 = (RadioButton) findViewById(R.id.radio4);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mRadio2.getId()) {
                    Toast.makeText(MainActivity.this, "正确答案：" + mRadio2.getText()
                            + ",恭喜你，答对了！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "请注意，回答错误！",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
