package entity;

import javax.persistence.*;

@Entity
@Table(name = "news_link")

public class NewsLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryNews category;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;

    public CategoryNews getCategory() {
        return category;
    }

    public void setCategory(CategoryNews category) {
        this.category = category;
    }

    public News getNews() {

        return news;
    }

    public void setNews(News news) {

        this.news = news;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
