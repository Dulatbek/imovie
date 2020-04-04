package models;

import java.io.Serializable;

public class Ticket implements Serializable {
    private Long id;
    private Long user_id;
    private Long genre_id;
    private Long movie_id;
    private String movie_name;
    private String time;
    private String count;
    public Ticket() {
    }

    public Ticket(Long id, Long user_id,Long genre_id, Long movie_id, String movie_name, String time,String count) {
        this.id = id;
        this.user_id = user_id;
        this.genre_id = genre_id;
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.time = time;
        this.count = count;
    }
    public String getCount(){return count;}

    public void setCount(String count){this.count = count;}

    public Long getGenre_id(){return genre_id;}

    public void setGenre_id(Long genre_id){this.genre_id=genre_id;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString(){
        return "Name: "+getMovie_name()+" time: "+getTime()+" count: "+getCount();
    }
}
