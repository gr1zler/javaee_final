package DB;

import java.sql.Timestamp;

public class comment {
    private long id;
    private String comment;
    private Timestamp post_date;
    private users user;
    private news news;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }

    public DB.news getNews() {
        return news;
    }

    public void setNews(DB.news news) {
        this.news = news;
    }
}
