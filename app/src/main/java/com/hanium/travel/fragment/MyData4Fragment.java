package com.hanium.travel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.hanium.travel.R;

public class MyData4Fragment extends Fragment {

    private ImageView lover_image;
    private ImageView friend_image;
    private ImageView family_image;
    private ImageView solo_image;

    private MaterialCardView lover_card;
    private MaterialCardView friend_card;
    private MaterialCardView family_card;
    private MaterialCardView solo_card;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_mydata4, container, false);

        lover_image = view.findViewById(R.id.lover_image);
        friend_image = view.findViewById(R.id.friend_image);
        family_image = view.findViewById(R.id.family_image);
        solo_image = view.findViewById(R.id.solo_image);

        lover_card = view.findViewById(R.id.lover_card);
        friend_card = view.findViewById(R.id.friend_card);
        family_card = view.findViewById(R.id.family_card);
        solo_card = view.findViewById(R.id.solo_card);

        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(lover_image);
        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(friend_image);
        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(family_image);
        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(solo_image);

        lover_card.setOnClickListener(onClickListener);
        friend_card.setOnClickListener(onClickListener);
        family_card.setOnClickListener(onClickListener);
        solo_card.setOnClickListener(onClickListener);

        return view;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.lover_card:
                    lover_card.setChecked(!lover_card.isChecked());
                    break;
                case R.id.friend_card:
                    friend_card.setChecked(!friend_card.isChecked());
                    break;
                case R.id.family_card:
                    family_card.setChecked(!family_card.isChecked());
                    break;
                case R.id.solo_card:
                    solo_card.setChecked(!solo_card.isChecked());
                    break;
            }
        }
    };
}
