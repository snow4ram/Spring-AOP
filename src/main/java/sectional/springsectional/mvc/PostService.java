package sectional.springsectional.mvc;

public interface PostService {

    void save(Post post);

    Post findPost(Long postId);
}
