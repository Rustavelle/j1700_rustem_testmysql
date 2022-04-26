package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "category_news")

public class CategoryNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "category")
    private List<NewsLink> CategoryId;

    @Column(name = "category_name")
    private String CategoryName;

    public List<NewsLink> getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(List<NewsLink> category_id) {
        this.CategoryId = category_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String category_name) {
        this.CategoryName = category_name;
    }
}
