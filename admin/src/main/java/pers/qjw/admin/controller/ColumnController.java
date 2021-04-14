package pers.qjw.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.qjw.admin.model.BlogColumn;
import pers.qjw.admin.service.ColumnService;

import java.util.List;

@RestController
@RequestMapping("/api/columns")
@AllArgsConstructor
@Api("columns 接口")
public class ColumnController {

    private final ColumnService columnService;

    @GetMapping
    @ApiOperation("获取所有专栏")
    public ResponseEntity<List<BlogColumn>> getAllTag() {
        return new ResponseEntity<>(columnService.getAllBlogColumn(), HttpStatus.OK);
    }

}
