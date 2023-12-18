package sectional.springsectional.mvc;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostServiceImpl service;

    @PostMapping("/create")
    public String create(Post post) {
        service.save(post);

        return "저장완료!!";
    }


    @GetMapping("/find")
    public void find(@RequestParam("postId") Long postId) {
        service.findPost(postId);
    }


}
