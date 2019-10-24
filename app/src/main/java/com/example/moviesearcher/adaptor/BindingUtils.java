package com.example.moviesearcher.adaptor;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

public class BindingUtils {
    @BindingAdapter("android:text")
    public static void setText(TextView textView, String text){

    }

    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    public static String getTextString(TextView textView){
        return textView.getText().toString();
    }

    @BindingAdapter("android:textAttrChanged")
    public static void setTextWatcher(TextView textView, final InverseBindingListener listener){
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listener.onChange();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
