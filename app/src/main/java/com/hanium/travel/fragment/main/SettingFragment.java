package com.hanium.travel.fragment.main;

import android.os.Bundle;
import android.text.InputType;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.google.android.material.snackbar.Snackbar;
import com.hanium.travel.R;
import com.hanium.travel.activity.SettingActivity;
import com.hanium.travel.project.PreferenceManager;

public class SettingFragment extends PreferenceFragmentCompat {

    private SettingActivity activity;

    public static SettingFragment newInstance() {
        SettingFragment settingFragment = new SettingFragment();
        return settingFragment;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.fragment_setting, rootKey);

        activity = (SettingActivity) requireActivity();

        EditTextPreference modifyNickName = findPreference("modify_nickname");
        EditTextPreference modifyEmail = findPreference("modify_email");

        if(modifyNickName != null && modifyEmail != null) {

            modifyEmail.setText(PreferenceManager.getString(activity, "mydata6-2"));
            modifyNickName.setText(PreferenceManager.getString(activity, "mydata6-0"));

            modifyEmail.setOnBindEditTextListener(editText -> editText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS));

            /* 아래 2개는 입력 및 세팅 */
            modifyNickName.setSummaryProvider((Preference.SummaryProvider<EditTextPreference>) preference -> {
                String text = preference.getText();
                if(text.matches("^[ㄱ-ㅎ가-힣a-zA-Z0-9]*$")) {
                    PreferenceManager.setString(activity, "mydata6-0", text);
                    return text;
                }
                Snackbar.make(activity.settingLayout, "닉네임 특수문자는 허용되지 않아요!", Snackbar.LENGTH_LONG).show();
                return PreferenceManager.getString(activity, "mydata6-0");
            });

            modifyEmail.setSummaryProvider((Preference.SummaryProvider<EditTextPreference>) preference -> {
                String text = preference.getText();
                if(text.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$")) {
                    PreferenceManager.setString(activity, "mydata6-2", text);
                    return text;
                }
                Snackbar.make(activity.settingLayout, "이메일 형식에 맞지 않아요!", Snackbar.LENGTH_LONG).show();
                return PreferenceManager.getString(activity, "mydata6-2");
            });
        }
    }
}
