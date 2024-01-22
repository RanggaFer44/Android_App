package com.example.apps;

public class DataClass {

    private String Image;
    private String Title;
    private String Desc;
    private String Step;
    private String key;
    private String Ingredients;
    private String Additional;

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }

    public String getAdditional() {
        return Additional;
    }

    public void setAdditional(String additional) {
        Additional = additional;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public void setStep(String step) {
        Step = step;
    }

    public String getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

    public String getDesc() {
        return Desc;
    }

    public String getStep() {
        return Step;
    }

    public DataClass(String image, String title, String desc, String step, String ingredients, String additional) {
        this.Image = image;
        this.Title = title;
        this.Desc = desc;
        this.Ingredients = ingredients;
        this.Additional = additional;
        this.Step = step;
    }

    public DataClass () {

    }

}
