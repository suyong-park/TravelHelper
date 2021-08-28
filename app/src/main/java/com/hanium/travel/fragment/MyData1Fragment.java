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
import com.hanium.travel.activity.CollectMyDataActivity;
import com.hanium.travel.R;

public class MyData1Fragment extends Fragment {

    ImageView car_image;
    ImageView public_image;
    ImageView bike_image;
    ImageView walk_image;

    MaterialCardView car_card;
    MaterialCardView public_card;
    MaterialCardView bike_card;
    MaterialCardView walk_card;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_mydata1, container, false);

        ((CollectMyDataActivity) getActivity()).setButton();

        car_image = view.findViewById(R.id.car_image);
        public_image = view.findViewById(R.id.public_image);
        bike_image = view.findViewById(R.id.bike_image);
        walk_image = view.findViewById(R.id.walk_image);

        car_card = view.findViewById(R.id.car_card);
        bike_card = view.findViewById(R.id.bike_card);
        public_card = view.findViewById(R.id.public_card);
        walk_card = view.findViewById(R.id.walk_card);

        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(car_image);
        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(public_image);
        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(bike_image);
        Glide.with(getActivity()).load(R.drawable.sample).placeholder(R.drawable.noimage).into(walk_image);

        car_card.setOnClickListener(onClickListener);
        bike_card.setOnClickListener(onClickListener);
        public_card.setOnClickListener(onClickListener);
        walk_card.setOnClickListener(onClickListener);

        return view;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.car_card:
                    car_card.setChecked(!car_card.isChecked());
                    break;
                case R.id.bike_card:
                    bike_card.setChecked(!bike_card.isChecked());
                    break;
                case R.id.walk_card:
                    walk_card.setChecked(!walk_card.isChecked());
                    break;
                case R.id.public_card:
                    public_card.setChecked(!public_card.isChecked());
                    break;
            }
        }
    };
}
