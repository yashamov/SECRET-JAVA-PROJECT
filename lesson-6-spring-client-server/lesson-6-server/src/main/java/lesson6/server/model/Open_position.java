package lesson6.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lesson6.api.dto.AdminDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "Open_positionMapping",
        classes = @ConstructorResult(
                targetClass = AdminDto.class,
                columns = {

                        @ColumnResult(name ="name", type =String.class),
                        @ColumnResult(name ="price", type =Double.class),
                        @ColumnResult(name ="count", type =Long.class)


                }
        )
)

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "open_position")
public class Open_position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    public Long id;

    @NotNull
    @Column(name = "name", length = 30)

    public String name;



    @NotNull
    @Column(name = "price", length = 30)
    @ApiModelProperty("admin login")
    public Double price;
    @NotNull
    @Column(name = "count", length = 30)
    @ApiModelProperty("admin login")
    public Long count;



}
