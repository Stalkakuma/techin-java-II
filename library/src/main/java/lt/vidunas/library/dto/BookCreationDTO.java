package lt.vidunas.library.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookCreationDTO {
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    @NotEmpty(message = "Author cannot be empty")
    private String author;
    @NotEmpty(message = "Category cannot be empty")
    private String category;
    @Positive(message = "Price cannot be negative")
    private BigDecimal price;
    private String cover;
    private boolean reserved;
}
