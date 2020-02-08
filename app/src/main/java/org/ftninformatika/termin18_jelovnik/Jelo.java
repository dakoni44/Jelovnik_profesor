package org.ftninformatika.termin18_jelovnik;

import java.util.List;

public class Jelo {
    private int id;
    private String name;
    private int categoryId;
    private List<String> ingridients;
    private String imgPath;
    private float cena;
    private float rating;

    public Jelo(int id, String name, int categoryId, List<String> ingridients, String imgPath, float cena, float rating) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.ingridients = ingridients;
        this.imgPath = imgPath;
        this.cena = cena;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getIngridients() {
        return ingridients;
    }

    public void setIngridients(List<String> ingridients) {
        this.ingridients = ingridients;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}