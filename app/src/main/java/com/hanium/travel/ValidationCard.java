package com.hanium.travel;

import com.google.android.material.card.MaterialCardView;

public interface ValidationCard {
    void setDialog();
    boolean isSelectCard(MaterialCardView cardView1, MaterialCardView cardView2, MaterialCardView cardView3);
    boolean isSelectCard(MaterialCardView cardView1, MaterialCardView cardView2, MaterialCardView cardView3, MaterialCardView cardView4);
}
