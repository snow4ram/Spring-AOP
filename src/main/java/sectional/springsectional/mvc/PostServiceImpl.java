package sectional.springsectional.mvc;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository repository;

    @Override
//    @Transactional
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Post post) {
        if (post == null) {
            throw new RuntimeException();
        }
        repository.save(post);
    }

    @Override
    public Post findPost(Long postId) {
        return repository.findById(postId).orElseThrow();
    }
}
