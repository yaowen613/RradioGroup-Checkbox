package com.yaowen.radiogroupcheckbox;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by HelloWorld on 2015/10/15.
 */
public class CheckboxGroup extends LinearLayout {
    public CheckboxGroup(Context context) {
        super(context);
    }

    public CheckboxGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckboxGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
View.inflate(context,R.layout.checkbox,null);
    }
//    public void addView(View child, int index, ViewGroup.LayoutParams params) {
//        if (child instanceof RadioButton) {
//
//        }
//
//        super.addView(child, index, params);
//    }
}
