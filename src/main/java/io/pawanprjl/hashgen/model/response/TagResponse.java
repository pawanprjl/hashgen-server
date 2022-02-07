package io.pawanprjl.hashgen.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Pawan Parajuli
 * @created 06/01/2022 - 3:59 PM
 * @email pawanparajuli8@gmail.com
 **/

@Data
public class TagResponse {
    @JsonProperty("name")
    String name;
    @JsonProperty("subtitle")
    String subtitle;
}
