package io.pawanprjl.hashgen.model.db;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Pawan Parajuli
 * @created 06/01/2022 - 3:05 PM
 * @email pawanparajuli8@gmail.com
 **/

@Data
@Entity
@NoArgsConstructor
@Accessors(fluent = true)
public class Hashtag {

    @Id
    private Long id;
    private String name;
    private Integer mediaCount;
    private String subtitle;
}
