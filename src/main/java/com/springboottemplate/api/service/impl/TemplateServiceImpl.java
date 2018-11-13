package com.springboottemplate.api.service.impl;

import com.springboottemplate.api.service.TemplateService;
import com.springboottemplate.api.mapper.TemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("templateService")
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public String testDBConnection() throws Exception {
        return templateMapper.testDBConnection();
    }
}
