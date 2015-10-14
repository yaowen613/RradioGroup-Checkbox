package com.yaowen.radiogroupcheckbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yaowen.radiogroupcheckbox.test.TableLayoutStudy;

public class MainActivity extends AppCompatActivity {
    private RadioGroup mRadioGroup;
    private Button nextPloblem,tableLayoutStudy;
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
        nextPloblem= (Button) findViewById(R.id.nextPloblemButton);
        tableLayoutStudy= (Button) findViewById(R.id.tableLayouStudyButton);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mRadio2.getId()) {
                    displayToast("正确答案：" + mRadio2.getText()
                            + ",恭喜你，答对了！");
                } else {
                    displayToast("请注意，回答错误！");
                }
            }
        });
        nextPloblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
        tableLayoutStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TableLayoutStudy.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * 显示Toast提示信息，相当于自带Tosat.makeText（）的方法；toast showing;
     *
     * @param str String
     **/
    public void displayToast(String str) {
        Toast toast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
        //设置显示的位置
        toast.setGravity(Gravity.TOP, 0, 200);
        //显示toast；
        toast.show();
    }
}
