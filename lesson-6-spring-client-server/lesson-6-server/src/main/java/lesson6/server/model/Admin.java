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
        name = "adminMapping",
        classes = @ConstructorResult(
                targetClass = AdminDto.class,
                columns = {
                        @ColumnResult(name = "id", type=Long.class),
                        @ColumnResult(name = "name", type=String.class),
                        @ColumnResult(name ="surname", type =String.class),
                        @ColumnResult(name ="login", type =String.class),
                        @ColumnResult(name ="password", type =String.class),
                        @ColumnResult(name ="link", type =String.class),
                        @ColumnResult(name ="position", type =String.class),

                }
        )
)

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty("admin id")
    public Long id;

    @NotNull
    @Column(name = "name", length = 30)
    @ApiModelProperty("admin name")
    public String name;
    @NotNull
    @Column(name = "type", length = 30)
    @ApiModelProperty("admin name")
    public String type;

    @NotNull
    @Column(name = "surname", length = 30)
    @ApiModelProperty("admin surname")
    public String surname;

    @NotNull
    @Column(name = "login", length = 30)
    @ApiModelProperty("admin login")
    public String login;


    @NotNull
    @Column(name = "password", length = 30)
    @ApiModelProperty("hash of password")
    @JsonIgnore
    public String password_hash;

    @NotNull
    @Column(name = "link", length = 30)
    @ApiModelProperty("admin link")
    public String link;

    @NotNull
    @Column(name = "position", length = 30)
    @ApiModelProperty("position")
    public String position;
}
