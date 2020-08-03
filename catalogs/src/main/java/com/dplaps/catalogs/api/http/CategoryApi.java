package com.dplaps.catalogs.api.http;

import com.dplaps.catalogs.dto.CatgTree;
import com.dplaps.catalogs.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
@Slf4j
public class CategoryApi {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/catg/{id}")
    public ResponseEntity<CatgTree> findCatg(@PathVariable("id") Integer id) {
        log.info("getting data for catg for id:{}", id);
        CatgTree resp = categoryService.findCatg(id);
        return new ResponseEntity<CatgTree>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/catgs")
    public ResponseEntity<Map<Integer, CatgTree>> findCatgs() {
        log.info("getting data for all catgs");
        Map<Integer, CatgTree> resp = categoryService.findCatgs();
        return new ResponseEntity<Map<Integer, CatgTree>>(resp, HttpStatus.OK);
    }
}