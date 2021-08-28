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

public class MyData2Fragment extends Fragment {

    private ImageView sea_image;
    private ImageView mountain_image;
    private ImageView city_image;

    private MaterialCardView sea_card;
    private MaterialCardView mountain_card;
    private MaterialCardView city_card;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_mydata2, container, false);

        sea_image = view.findViewById(R.id.sea_image);
        mountain_image = view.findViewById(R.id.mountain_image);
        city_image = view.findViewById(R.id.city_image);

        sea_card = view.findViewById(R.id.sea_card);
        mountain_card = view.findViewById(R.id.mountain_card);
        city_card = view.findViewById(R.id.city_card);

        sea_card.setOnClickListener(onClickListener);
        mountain_card.setOnClickListener(onClickListener);
        city_card.setOnClickListener(onClickListener);

        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(sea_image);
        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(mountain_image);
        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(city_image);

        return view;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.sea_card:
                    sea_card.setChecked(!sea_card.isChecked());
                    break;
                case R.id.mountain_card:
                    mountain_card.setChecked(!mountain_card.isChecked());
                    break;
                case R.id.city_card:
                    city_card.setChecked(!city_card.isChecked());
                    break;
            }
        }
    };
}
