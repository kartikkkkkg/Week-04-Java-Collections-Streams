import java.util.*;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }
}

public class BookRecommendations {
    public List<List<BookRecommendation>> getRecommendations(List<Book> books) {
        List<BookRecommendation> recommendations = books.stream()
                .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
                .map(b -> new BookRecommendation(b.title, b.rating))
                .sorted(Comparator.comparingDouble((BookRecommendation br) -> br.rating).reversed())
                .limit(10)
                .collect(Collectors.toList());

        List<List<BookRecommendation>> paginated = new ArrayList<>();
        for (int i = 0; i < recommendations.size(); i += 5) {
            paginated.add(recommendations.subList(i, Math.min(i + 5, recommendations.size())));
        }
        return paginated;
    }
}