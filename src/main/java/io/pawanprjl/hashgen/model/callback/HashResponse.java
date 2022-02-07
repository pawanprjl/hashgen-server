package io.pawanprjl.hashgen.model.callback;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Pawan Parajuli
 * @created 06/01/2022 - 3:24 PM
 * @email pawanparajuli8@gmail.com
 **/


@JsonIgnoreProperties(ignoreUnknown = true)
public class HashResponse {

    @JsonProperty("hashtags")
    public List<Hashtags> hashtags;

    @JsonProperty("status")
    public String status;
}

