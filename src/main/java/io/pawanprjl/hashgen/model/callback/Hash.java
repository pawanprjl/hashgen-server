package io.pawanprjl.hashgen.model.callback;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Pawan Parajuli
 * @created 06/01/2022 - 3:30 PM
 * @email pawanparajuli8@gmail.com
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hash {

    @JsonProperty("id")
    public Long id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("media_count")
    public Integer mediaCount;

    @JsonProperty("search_result_subtitle")
    public String subtitle;
}
