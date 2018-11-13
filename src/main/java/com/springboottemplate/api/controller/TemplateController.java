package com.springboottemplate.api.controller;

import com.springboottemplate.api.service.TemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController("templateController")
@RequestMapping(value = "/test")
@Slf4j
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @GetMapping(value = "/getTestJson")
    public Map<String, String> getTestJson(Model model) throws Exception {
        log.debug("Get Api Test Called");

        Map<String, String> entity = new HashMap<>();
        entity.put("testStr", templateService.testDBConnection());

        return entity;
    }

    @GetMapping(value = "/getTestHtml")
    public ModelAndView getTestHtml(Model model) throws Exception {
        log.debug("Get Api Test Called");

        ModelAndView mav = new ModelAndView();
        mav.addObject("testStr", templateService.testDBConnection());
        mav.setViewName("template");

        return mav;
    }

    @PostMapping(value = "/postTestJson")
    public Map<String, String> postTest() throws Exception {
        log.debug("Post Api Test Called");

        Map<String, String> entity = new HashMap<>();
        entity.put("testStr", templateService.testDBConnection());

        return entity;
    }
}
