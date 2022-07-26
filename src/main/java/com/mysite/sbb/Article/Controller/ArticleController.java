package com.mysite.sbb.Article.Controller;

import com.mysite.sbb.Article.dao.ArticleRepository;
import com.mysite.sbb.Article.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/usr/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/test")
    @ResponseBody
    public String testFunc() {
        return "test";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Article> showArticleList(String title, String body) {
        if(title != null && body == null) {

            if (articleRepository.existsByTitle(title) == false) {
                System.out.println("제목과 일치하는 게시물이 없습니다.");
                return null;
            }
            return articleRepository.findByTitle(title);
        } else if(title == null && body != null){
            if(articleRepository.existByBody(body) == false) {
                System.out.println("내용과 일치하는 게시물이 없습니다.");
                return null;
            }
            return articleRepository.findByBody(body);
        } else if(title != null && body != null) {
            if(articleRepository.existsByTitleAndBody(title, body) == false) {
                System.out.println("제목, 내용과 일치하는 게시물이 없습니다.");
                return null;
            }
            return articleRepository.findBytitleAndBody(title, body);
        }
        return articleRepository.findAll();



    @RequestMapping("/detail")
    @ResponseBody
    public Article showArticleDetail(@RequestParam long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.orElse(null);
    }

    @RequestMapping("/doModify")
    @ResponseBody
    public Article showModify(long id, String title, String body) {
        Article article = articleRepository.findById(id).get();
        if (title != null) {
            article.setTitle(title);

        }
        if (body != null) {
            article.setBody(body);

        }
        article.setUpdateDate(LocalDateTime.now());
        articleRepository.save(article);
        return article;
    }

    @RequestMapping("/doDelete")
    @ResponseBody
    public String doDelete(long id) {
        if (articleRepository.existsById(id) == false) {
            return "%d번 게시물은 이미 삭제되었거나 존재하지 않습니다.".formatted(id);
        }
        articleRepository.deleteById(id);
        return "%d번 게시물이 삭제되었습니다".formatted(id);
    }

    @RequestMapping("/findByTitle")
    @ResponseBody
    public List<Article> findByTitle(String title) {
        List<Article> articles = articleRepository.findByTitle(title);
        return articles;
    }

}

