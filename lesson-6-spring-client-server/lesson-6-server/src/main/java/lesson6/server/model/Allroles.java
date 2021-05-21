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
        name = "rolesMapping",
        classes = @ConstructorResult(
                targetClass = AdminDto.class,
                columns = {

                        @ColumnResult(name ="login", type =String.class),
                        @ColumnResult(name ="password", type =String.class),
                        @ColumnResult(name ="type", type =String.class),


                }
        )
)

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "allroles")
public class Allroles {

    @NotNull
    @Column(name = "type", length = 30)
    @ApiModelProperty("admin name")
    public String type;



    @NotNull
    @Column(name = "login", length = 30)
    @ApiModelProperty("admin login")
    public String login;


    @NotNull
    @Column(name = "password", length = 30)
    @ApiModelProperty("hash of password")
    @JsonIgnore
    public String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("account id")
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
