package com.yaowen.radiogroupcheckbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by HelloWorld on 2015/10/14.
 */
public class SecondActivity extends Activity{
    private Button next,back;
    private RadioGroup radioGroup;
    private RadioButton radioButton_man,radioButton_women;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next= (Button) findViewById(R.id.nextProblem2);
        back= (Button) findViewById(R.id.backProblem2);
        radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        radioButton_man= (RadioButton) findViewById(R.id.radioButton1);
        radioButton_women= (RadioButton) findViewById(R.id.radioButton2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast("已经是最后一道题了！");
                Intent intent=new Intent();
                intent.setClass(SecondActivity.this,CheckboxActivity.class);
                startActivity(intent);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(SecondActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String temp = "";
                if (checkedId==radioButton_man.getId()){
                    temp= (String) radioButton_man.getText();
                    //displayToast("你选择的是性别为："+radioButton_man.getText());
                }if (checkedId==radioButton_women.getId()){
                    temp= (String) radioButton_women.getText();
                    //displayToast("你选择的是性别为："+radioButton_women.getText());
                }
                displayToast("你选择的是性别为："+temp);
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
