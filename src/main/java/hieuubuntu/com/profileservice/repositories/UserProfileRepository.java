package hieuubuntu.com.profileservice.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import hieuubuntu.com.profileservice.entities.UserProfile;

@Repository
public interface UserProfileRepository extends Neo4jRepository<UserProfile, Long> {
    UserProfile findUserProfileByUserId(Integer userid);
}
