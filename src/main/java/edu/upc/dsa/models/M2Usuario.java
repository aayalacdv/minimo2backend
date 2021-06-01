package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class M2Usuario {

    private String imgUrl;
    private String name;
    private List<Medalla> medallaList;

    public M2Usuario(){

    }

    public M2Usuario (String name,  String imgUrl){
        this.imgUrl = imgUrl;
        this.name = name;
        this.medallaList = new ArrayList<>();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Medalla> getMedallaList() {
        return medallaList;
    }

    public void setMedallaList(List<Medalla> medallaList) {
        this.medallaList = medallaList;
    }


    @Override
    public String toString() {
        return "M2Usuario{" +
                "imgUrl='" + imgUrl + '\'' +
                ", name='" + name + '\'' +
                ", medallaList=" + medallaList +
                '}';
    }
}
