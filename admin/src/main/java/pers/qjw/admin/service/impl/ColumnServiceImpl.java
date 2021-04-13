package pers.qjw.admin.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pers.qjw.admin.mapper.BlogColumnMapper;
import pers.qjw.admin.model.BlogColumn;
import pers.qjw.admin.service.ColumnService;

import java.util.List;

@Service
@AllArgsConstructor
public class ColumnServiceImpl implements ColumnService {

    private final BlogColumnMapper blogColumnMapper;

    @Override
    public List<BlogColumn> getAllBlogColumn() {
        return blogColumnMapper.select(c -> c);
    }
}
