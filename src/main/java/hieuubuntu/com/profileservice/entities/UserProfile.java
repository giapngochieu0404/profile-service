package hieuubuntu.com.profileservice.entities;

import java.time.LocalDate;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Node("user_profiles")
public class UserProfile {
    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("user_id")
    private Integer userId;

    private LocalDate birthday;

    @JsonProperty("position_id")
    private Integer positionId;

    @Property("address")
    private String address;
}
