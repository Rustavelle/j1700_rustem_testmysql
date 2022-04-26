package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "news")

public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "news")
    private List<NewsLink> NewsId;

    @Column(name = "heading_name")
    private String HeadingName;

    @Column(name = "news_text")
    private String NewsText;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<NewsLink> getNewsId() {
        return NewsId;
    }

    public void setNewsId(List<NewsLink> news_id) {
        this.NewsId = news_id;
    }

    public String getHeadingName() {
        return HeadingName;
    }

    public void setHeadingName(String heading_name) {
        this.HeadingName = heading_name;
    }

    public String getNewsText() {

        return NewsText;
    }

    public void setNewsText(String news_text) {

        this.NewsText = news_text;
    }
}
