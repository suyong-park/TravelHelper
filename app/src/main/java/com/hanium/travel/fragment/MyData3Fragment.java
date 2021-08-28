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

public class MyData3Fragment extends Fragment {

    private MaterialCardView food_card;
    private MaterialCardView picture_card;
    private MaterialCardView tour_card;
    private MaterialCardView healing_card;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_mydata3, container, false);

        ImageView food_image = view.findViewById(R.id.food_image);
        ImageView picture_image = view.findViewById(R.id.picture_image);
        ImageView tour_image = view.findViewById(R.id.tour_image);
        ImageView healing_image = view.findViewById(R.id.healing_image);

        food_card = view.findViewById(R.id.food_card);
        picture_card = view.findViewById(R.id.picture_card);
        tour_card = view.findViewById(R.id.tour_card);
        healing_card = view.findViewById(R.id.healing_card);

        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(food_image);
        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(picture_image);
        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(tour_image);
        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(healing_image);

        food_card.setOnClickListener(onClickListener);
        picture_card.setOnClickListener(onClickListener);
        tour_card.setOnClickListener(onClickListener);
        healing_card.setOnClickListener(onClickListener);

        return view;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.food_card:
                    food_card.setChecked(!food_card.isChecked());
                    break;
                case R.id.picture_card:
                    picture_card.setChecked(!picture_card.isChecked());
                    break;
                case R.id.tour_card:
                    tour_card.setChecked(!tour_card.isChecked());
                    break;
                case R.id.healing_card:
                    healing_card.setChecked(!healing_card.isChecked());
                    break;
            }
        }
    };
}
