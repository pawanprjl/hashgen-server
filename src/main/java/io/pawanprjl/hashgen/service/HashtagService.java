package io.pawanprjl.hashgen.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.pawanprjl.hashgen.controller.RequestResponseMapper;
import io.pawanprjl.hashgen.model.callback.HashResponse;
import io.pawanprjl.hashgen.model.db.Hashtag;
import io.pawanprjl.hashgen.model.response.CategorizedResponse;
import io.pawanprjl.hashgen.repository.HashtagRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pawan Parajuli
 * @created 06/01/2022 - 2:27 PM
 * @email pawanparajuli8@gmail.com
 **/

@Slf4j
@Service
public class HashtagService {

    private final HashtagRepo hashtagRepo;
    private final GeneratorService generatorService;

    File output = new File("data/output.json");

    public HashtagService(
            @Autowired HashtagRepo hashtagRepo,
            @Autowired GeneratorService generatorService
    )  {
        this.hashtagRepo = hashtagRepo;
        this.generatorService = generatorService;

//        HashResponse jsonFile = new ObjectMapper().readValue(output, HashResponse.class);
//
//        List<Hashtag> hashtags = jsonFile.hashtags.stream().map(value -> {
//            Hashtag hashtag = new Hashtag();
//            hashtag.id(value.hash.id);
//            hashtag.name(value.hash.name);
//            hashtag.mediaCount(value.hash.mediaCount);
//            hashtag.subtitle(value.hash.subtitle);
//            return hashtag;
//        }).collect(Collectors.toList());
//
//        hashtagRepo.saveAll(hashtags);
    }


    public CategorizedResponse getHashtags(String tag) throws IOException {

        HashResponse jsonFile = new ObjectMapper().readValue(generatorService.getHashtags(tag), HashResponse.class);

        List<Hashtag> hashtags = jsonFile.hashtags.stream().map(value -> {
            Hashtag hashtag = new Hashtag();
            hashtag.id(value.hash.id);
            hashtag.name(value.hash.name);
            hashtag.mediaCount(value.hash.mediaCount);
            hashtag.subtitle(value.hash.subtitle);
            return hashtag;
        }).collect(Collectors.toList());

        hashtagRepo.saveAll(hashtags);

        CategorizedResponse response = new CategorizedResponse();
        response.setFrequent(RequestResponseMapper.hashtagResponses(hashtagRepo.findMostFrequent(tag,100000000)));
        response.setAverage(RequestResponseMapper.hashtagResponses(hashtagRepo.findAverage(tag, 100000000, 10000000)));
        response.setRare(RequestResponseMapper.hashtagResponses(hashtagRepo.findRare(tag,10000000)));
        return response;
    }
}
