package pers.qjw.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.qjw.admin.annotations.Authorization;
import pers.qjw.admin.model.Blog;
import pers.qjw.admin.service.ArticlesService;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@AllArgsConstructor
@Api(tags = "articles 接口")
public class ArticlesController {

    private final ArticlesService articlesService;

    @PostMapping
    @Authorization
    @ApiOperation("新键文章")
    public ResponseEntity<String> createArticles(MultipartFile photo, Blog blog) {
        articlesService.createArticles(photo, blog);
        return new ResponseEntity<>("添加成功", HttpStatus.OK);
    }

    @GetMapping
    @Authorization
    @ApiOperation("获取指定范围的文章")
    public ResponseEntity<List<Blog>> getArticles(String page, String number, String columnSelect, String tagsSelect) {
        return new ResponseEntity<>(articlesService.getArticles(page, number, columnSelect, tagsSelect), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Authorization
    @ApiOperation("获取指定id的文章")
    public ResponseEntity<Blog> getArticles(@PathVariable String id) {
        return new ResponseEntity<>(articlesService.getArticles(id), HttpStatus.OK);
    }

    @PutMapping
    @Authorization
    @ApiOperation("更新文章")
    public ResponseEntity<String> updateArticles(MultipartFile photo, Blog blog) {
        articlesService.updateArticles(photo, blog);
        return new ResponseEntity<>("更新成功", HttpStatus.OK);
    }

}
