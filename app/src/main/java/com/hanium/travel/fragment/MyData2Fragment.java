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

    ImageView sea_image;
    ImageView mountain_image;
    ImageView city_image;

    MaterialCardView sea_card;
    MaterialCardView mountain_card;
    MaterialCardView city_card;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_mydata2, container, false);

        sea_image = view.findViewById(R.id.sea_image);
        mountain_image = view.findViewById(R.id.mountain_image);
        city_image = view.findViewById(R.id.city_image);

        sea_card = view.findViewById(R.id.sea_card);
        mountain_card = view.findViewById(R.id.mountain_card);
        city_card = view.findViewById(R.id.city_card);

        Glide.with(getActivity()).load(R.drawable.ic_launcher_foreground).into(sea_image);
        Glide.with(getActivity()).load(R.drawable.ic_launcher_foreground).into(mountain_image);
        Glide.with(getActivity()).load(R.drawable.ic_launcher_foreground).into(city_image);

        return view;
    }
}
