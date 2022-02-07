package io.pawanprjl.hashgen.model.callback;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Pawan Parajuli
 * @created 06/01/2022 - 3:30 PM
 * @email pawanparajuli8@gmail.com
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hashtags {

    @JsonProperty("position")
    public int position;

    @JsonProperty("hashtag")
    public Hash hash;
}
