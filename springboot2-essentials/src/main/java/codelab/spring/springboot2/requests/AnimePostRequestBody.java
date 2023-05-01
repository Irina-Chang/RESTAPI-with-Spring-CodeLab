package codelab.spring.springboot2.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data

public class AnimePostRequestBody {
    @NotEmpty(message = "The anime name cannot be empty!")
    @NotNull
    private String name;

}
