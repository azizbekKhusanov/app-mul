package uz.pdp.appmultipledb.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    @NotBlank
    private String name;

    @NotBlank
    private int page;


}
