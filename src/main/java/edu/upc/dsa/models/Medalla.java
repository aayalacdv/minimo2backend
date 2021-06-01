package edu.upc.dsa.models;

public class Medalla {

    private String imgUrl;

    public Medalla (){

    }

    public Medalla (String imgUrl){
        this.imgUrl = imgUrl;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Medalla{" +
                "imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
