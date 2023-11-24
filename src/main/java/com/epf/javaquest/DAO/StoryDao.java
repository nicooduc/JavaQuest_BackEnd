package com.epf.javaquest.DAO;

import com.epf.javaquest.models.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryDao extends JpaRepository<Story, Long> {

    Story findByDescriptionID(int descriptionID);

}
