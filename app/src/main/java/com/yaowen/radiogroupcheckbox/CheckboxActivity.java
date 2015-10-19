package com.yaowen.radiogroupcheckbox;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CheckboxActivity extends AppCompatActivity {
    private CheckBox youyong, paobu, pingpangqiu, tiaoyuan,qiche,tubu,zhuoqiu,lanqiiu;
    private List<CheckBox> checkBoxes = new ArrayList<CheckBox>();
    private Button getValueButton,setCheckAll,CheckBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox);
        final GridLayout gridLayout= (GridLayout) findViewById(R.id.gridlayout);
        getValueButton= (Button) findViewById(R.id.getValueButto);
        setCheckAll= (Button) findViewById(R.id.setCheckAll);
        CheckBack= (Button) findViewById(R.id.setCheckBack);
        youyong = (CheckBox) findViewById(R.id.checkbox_youyong);
        paobu = (CheckBox) findViewById(R.id.checkbox_paobu);
        pingpangqiu = (CheckBox) findViewById(R.id.checkbox_pingpangqiu);
        tiaoyuan = (CheckBox) findViewById(R.id.checkbox_tiaoyuan);
        qiche= (CheckBox) findViewById(R.id.checkbox_qiche);
        tubu= (CheckBox) findViewById(R.id.checkbox_tubu);
        zhuoqiu= (CheckBox) findViewById(R.id.checkbox_zhuoqiu);
        lanqiiu= (CheckBox) findViewById(R.id.checkbox_lanqiu);

        // 默认选项
        youyong.setChecked(true);
        tiaoyuan.setChecked(true);

        //注册时事件
        MyOnCheckedChangeListener listener = new MyOnCheckedChangeListener();
        getValueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValue(v);
                gridLayout.setColumnCount(4);
            }
        });
       /* setCheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<checkBoxes.size();i++){

                }
            }
        });*/
        //OnCheckBoxClickListener listener = new OnCheckBoxClickListener();
        youyong.setOnCheckedChangeListener(listener);
        paobu.setOnCheckedChangeListener(listener);
        pingpangqiu.setOnCheckedChangeListener(listener);
        tiaoyuan.setOnCheckedChangeListener(listener);
        qiche.setOnCheckedChangeListener(listener);
        tubu.setOnCheckedChangeListener(listener);
        zhuoqiu.setOnCheckedChangeListener(listener);
        lanqiiu.setOnCheckedChangeListener(listener);

        // 添加到集合中
        checkBoxes.add(youyong);
        checkBoxes.add(paobu);
        checkBoxes.add(pingpangqiu);
        checkBoxes.add(tiaoyuan);
        checkBoxes.add(qiche);
        checkBoxes.add(zhuoqiu);
        checkBoxes.add(tubu);
        checkBoxes.add(lanqiiu);

    }

    public void getValue(View v) {
        String content = "";
        for (CheckBox box : checkBoxes) {
            if (box.isChecked()) {
                content += box.getText() + "\n";
            }
        }
        if ("".equals(content)) {
            content = "你还没有做出选择！";
        }
        new AlertDialog.Builder(this).setMessage(content).setTitle("你做出的选择是：")
                .setPositiveButton("关闭", null).show();
    }

    class MyOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            CheckBox box = (CheckBox) buttonView;
            displayToast("你做出的选择是：" + isChecked +","+ box.getText());
        }
    }

    /*class OnCheckBoxClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            CheckBox box = (CheckBox) v;
            if (box.getId() == R.id.checkbox_youyong) {
                displayToast("你点击的是：" + youyong.getText());
            }

        }
    }*/

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
