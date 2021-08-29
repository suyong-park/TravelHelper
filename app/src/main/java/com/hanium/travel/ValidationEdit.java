package com.hanium.travel;

import com.google.android.material.textfield.TextInputEditText;

public interface ValidationEdit {
    void setDialog();
    boolean isEnterAllValue(TextInputEditText editText1, TextInputEditText editText2);
    boolean isEnterAllValue(TextInputEditText editText1, TextInputEditText editText2, TextInputEditText editText3);
}
