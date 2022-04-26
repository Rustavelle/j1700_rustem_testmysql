import entity.CategoryNews;
import entity.News;
import entity.NewsLink;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class NewsMain {

    public static Scanner scanner = new Scanner(System.in);

    public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");

    public static void main(String[] args) {
        System.out.println("Выберете действие : \n 1)Добавить статью \n 2)Поиск ");
        String actionId = scanner.nextLine();
        switch (actionId) {
            case "1" -> createArticles();
            case "2" -> Search();
        }
    }

    private static void createArticles() {
        EntityManager manager = factory.createEntityManager();
        try {
            TypedQuery<CategoryNews> categoryNewsTypedQuery = manager.createQuery("select c from CategoryNews c", CategoryNews.class);
            List<CategoryNews> categoryNewsList = categoryNewsTypedQuery.getResultList();
            System.out.println("Выберите категорию для статьи(через ',' если несколько): ");

            for (CategoryNews categoryNews : categoryNewsList) {
                System.out.println(categoryNews.getId() + ") " + categoryNews.getCategoryName());
            }
            String categoryNumIn = scanner.nextLine();
            String[] words = categoryNumIn.split(",\\s?");

            System.out.println("Введите заголовок новой статьи : ");
            String newArticlesName = scanner.nextLine();
            News newNews = new News();
            newNews.setHeadingName(newArticlesName);

            System.out.println("Введите текст новой статьи: ");
            String newArticlesText = scanner.nextLine();
            newNews.setNewsText(newArticlesText);

            manager.getTransaction().begin();
            manager.persist(newNews);

            for (String word : words) {
                CategoryNews categoryNews = manager.find(CategoryNews.class, Long.parseLong(word));
                NewsLink newsLink = new NewsLink();
                newsLink.setNews(newNews);
                newsLink.setCategory(categoryNews);
                manager.persist(newsLink);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    private static void Search() {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();

            System.out.println("Введите слово или несколько через ,: ");
            String string = scanner.nextLine();
            String[] words = string.split(",\\s?");
            String query = "select n from News n";
            if (words.length != 0) {
                query += " where";
            }
            for (int i = 0; i < words.length; i++) {
                if (i != 0) {
                    query += "or";
                }
                query += " n.NewsText like '%" + words[i] + "%'";
            }
            System.out.println(query);
            TypedQuery<News> newsTypedQuery = manager.createQuery("select n from News n", News.class);
            List<News> newsList = newsTypedQuery.getResultList();
            for (News news : newsList) {
                System.out.println(news.getNewsText());
            }
            manager.createQuery(query, News.class);
            manager.getTransaction().commit();

        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
