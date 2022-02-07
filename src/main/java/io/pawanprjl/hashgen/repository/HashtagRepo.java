package io.pawanprjl.hashgen.repository;

import io.pawanprjl.hashgen.model.db.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Pawan Parajuli
 * @created 06/01/2022 - 3:50 PM
 * @email pawanparajuli8@gmail.com
 **/

@Repository
public interface HashtagRepo extends JpaRepository<Hashtag, Long> {

    @Query("select tag from Hashtag as tag where tag.mediaCount >= :mediaCount and tag.name like CONCAT('%', :filter, '%') order by tag.mediaCount desc")
    List<Hashtag> findMostFrequent(String filter, int mediaCount);

    @Query("select tag from Hashtag as tag where tag.mediaCount < :start and tag.mediaCount >= :end and tag.name like CONCAT('%', :filter, '%') order by tag.mediaCount desc")
    List<Hashtag> findAverage(String filter, int start, int end);

    @Query("select tag from Hashtag as tag where  tag.mediaCount < :mediaCount and tag.name like CONCAT('%', :filter, '%') order by tag.mediaCount desc")
    List<Hashtag> findRare(String filter, int mediaCount);
}

