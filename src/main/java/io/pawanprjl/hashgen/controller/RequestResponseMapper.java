package io.pawanprjl.hashgen.controller;

import io.pawanprjl.hashgen.model.db.Hashtag;
import io.pawanprjl.hashgen.model.response.TagResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pawan Parajuli
 * @created 06/01/2022 - 4:02 PM
 * @email pawanparajuli8@gmail.com
 **/

public class RequestResponseMapper {

    public static TagResponse hashtagResponse(Hashtag hashtag) {
        TagResponse response = new TagResponse();
        response.setName(hashtag.name());
        response.setSubtitle(hashtag.subtitle());
        return response;
    }

    public static List<TagResponse> hashtagResponses(List<Hashtag> hashtags) {
        return hashtags.stream().map(RequestResponseMapper::hashtagResponse).collect(Collectors.toList());
    }
}
