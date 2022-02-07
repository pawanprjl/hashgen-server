package io.pawanprjl.hashgen.controller;

import io.pawanprjl.hashgen.model.response.CategorizedResponse;
import io.pawanprjl.hashgen.service.GeneratorService;
import io.pawanprjl.hashgen.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Pawan Parajuli
 * @created 06/01/2022 - 2:14 PM
 * @email pawanparajuli8@gmail.com
 **/

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private final HashtagService hashtagService;
    private final GeneratorService generatorService;

    public ApiController (
            @Autowired HashtagService hashtagService,
            @Autowired GeneratorService generatorService
    ) {
        this.hashtagService = hashtagService;
        this.generatorService = generatorService;
    }

    @GetMapping("/tag")
    public CategorizedResponse getHashtags(@RequestParam("query") String tag) throws IOException {
        return hashtagService.getHashtags(tag);
    }

    @GetMapping("/tag/test")
    public String getHashtagsFromWebdriver() {
        return generatorService.getHashtags("test");
    }
}
