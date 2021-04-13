package pers.qjw.admin.service;

import org.springframework.web.multipart.MultipartFile;
import pers.qjw.admin.model.Blog;

import java.util.List;

public interface ArticlesService {
    void createArticles(MultipartFile photo, Blog blog);

    List<Blog> getArticles(String page, String number, String columnSelect, String tagsSelect);

    Blog getArticles(String id);

    void updateArticles(MultipartFile photo, Blog blog);

    void deleteArticles(String id);
}
