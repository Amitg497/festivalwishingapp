package com.agcodepeak.allfestivalwishingapp.models;

public class model_class {

    int festiv;
    String nemo;

    public model_class(int festiv, String nemo) {
        this.festiv = festiv;
        this.nemo = nemo;
    }

    public int getFestiv() {
        return festiv;
    }

    public void setFestiv(int festiv) {
        this.festiv = festiv;
    }

    public String getNemo() {
        return nemo;
    }

    public void setNemo(String nemo) {
        this.nemo = nemo;
    }
}
