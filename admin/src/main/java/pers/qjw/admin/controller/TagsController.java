package pers.qjw.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.qjw.admin.annotations.Authorization;
import pers.qjw.admin.model.Tags;
import pers.qjw.admin.service.TagsService;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@Api(tags = "tags 接口")
@AllArgsConstructor
public class TagsController {

    private final TagsService tagsService;

    @GetMapping
    @ApiOperation("获取所有标签")
    @Authorization
    public ResponseEntity<List<Tags>> getAllTag() {
        return new ResponseEntity<>(tagsService.getAllTag(), HttpStatus.OK);
    }

}
