package pers.qjw.admin.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pers.qjw.admin.mapper.TagsMapper;
import pers.qjw.admin.model.Tags;
import pers.qjw.admin.service.TagsService;

import java.util.List;

@Service
@AllArgsConstructor
public class TagsServiceImpl implements TagsService {

    private final TagsMapper tagsMapper;

    @Override
    public List<Tags> getAllTag() {
        return tagsMapper.select(c -> c);
    }

}
