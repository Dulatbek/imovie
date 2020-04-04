package models;

import java.io.Serializable;

public class Movie implements Serializable {
    private Long id;
    private Long genre_id;
    private String gif_way;
    private String name;
    private int price;
    private String time;

    public Movie(Long id, Long genre_id, String gif_way, String name, int price, String time) {
        this.id = id;
        this.genre_id = genre_id;
        this.gif_way = gif_way;
        this.name = name;
        this.price = price;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }

    public String getGif_way() {
        return gif_way;
    }

    public void setGif_way(String gif_way) {
        this.gif_way = gif_way;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
