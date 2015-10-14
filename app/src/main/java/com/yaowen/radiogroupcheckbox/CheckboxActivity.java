package com.yaowen.radiogroupcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckboxActivity extends AppCompatActivity {
private CheckBox youyong,paobu,pingpangqiu,tiaoyuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox);
        youyong= (CheckBox) findViewById(R.id.checkbox_youyong);
        paobu= (CheckBox) findViewById(R.id.checkbox_paobu);
        pingpangqiu= (CheckBox) findViewById(R.id.checkbox_pingpangqiu);
        tiaoyuan= (CheckBox) findViewById(R.id.checkbox_tiaoyuan);

        OnCheckBoxClickListener listener =new OnCheckBoxClickListener();
        youyong.setOnClickListener(listener);
        paobu.setOnClickListener(listener);
        pingpangqiu.setOnClickListener(listener);
        tiaoyuan.setOnClickListener(listener);

    }
    class OnCheckBoxClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            CheckBox box= (CheckBox) v;
            if (box.getId()==R.id.checkbox_youyong){
                displayToast("你点击的是："+youyong.getText());
            }

        }
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
