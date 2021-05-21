package lesson6.server.model;

import io.swagger.annotations.ApiModelProperty;
import lesson6.api.dto.AdminDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "newsMapping",
        classes = @ConstructorResult(
                targetClass = AdminDto.class,
                columns = {

                        @ColumnResult(name ="id", type =Integer.class),
                        @ColumnResult(name ="text", type =String.class),

                }
        )
)

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "news")

public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty("new's id")
    public Long id;

    @NotNull
    @Column(name = "text", length = 1500)
    @ApiModelProperty("text")
    public String text;
}
