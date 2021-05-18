package lesson6.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lesson6.api.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.List;

@SqlResultSetMapping(
        name = "userMapping",
        classes = @ConstructorResult(
                targetClass = UserDto.class,
                columns = {
                        @ColumnResult(name = "id", type=Long.class),
                        @ColumnResult(name = "username", type=String.class),
                        @ColumnResult(name ="surname", type =String.class),
                        @ColumnResult(name ="login", type =String.class),
                        @ColumnResult(name ="password", type =String.class),
                        @ColumnResult(name ="link", type =String.class),
                        @ColumnResult(name ="percentOfProfit", type =Long.class),

                }
        )
)

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty("user id")
    public Long id;

    @NotNull
    @Column(name = "name", length = 30)
    @ApiModelProperty("user name")
    public String name;

    @NotNull
    @Column(name = "surname", length = 30)
    @ApiModelProperty("user surname")
    public String surname;

    @NotNull
    @Column(name = "login", length = 30)
    @ApiModelProperty("user login")
    public String login;


    @NotNull
    @Column(name = "password", length = 30)
    @ApiModelProperty("hash of password")
    @JsonIgnore
    public String password;
    @NotNull
    @Column(name = "link", length = 30)
    @ApiModelProperty("hash of password")

    public String link;
    @NotNull
    @Column(name = "procentofprofit", length = 30)
    @ApiModelProperty("hash of password")
    public String percentOfProfit;

    /*@JsonIgnore
    @OneToMany(mappedBy = "owner")
    public List<Account> accounts;

    */



}
