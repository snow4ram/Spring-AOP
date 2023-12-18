package sectional.springsectional.mvc;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String title;


    public Post(String author, String title) {
        this.author = author;
        this.title = title;
    }
}
