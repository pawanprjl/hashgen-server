package io.pawanprjl.hashgen.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Pawan Parajuli
 * @created 06/01/2022 - 4:03 PM
 * @email pawanparajuli8@gmail.com
 **/

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategorizedResponse {

    @JsonProperty("frequent")
    List<TagResponse> frequent;

    @JsonProperty("average")
    List<TagResponse> average;

    @JsonProperty("rare")
    List<TagResponse> rare;

}
