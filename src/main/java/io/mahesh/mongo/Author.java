package io.mmashevs.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Array;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Author {
    @NonNull
    @Generated
    private UUID id = UUID.randomUUID();
    private String FirstName;
    private String LastName;
    private List<String> Books;
}