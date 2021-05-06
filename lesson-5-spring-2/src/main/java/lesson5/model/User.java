package lesson5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@SqlResultSetMapping(
        name = "userMapping",
        classes = @ConstructorResult(
                targetClass = lesson5.dto.UserDto.class,
                columns = {
                        @ColumnResult(name = "id",type=Long.class),
                        @ColumnResult(name = "name",type=String.class)
                }
        )
)

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {
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
    @Column(name = "password_hash", length = 30)
    @ApiModelProperty("hash of password")
    @JsonIgnore
    public String password_hash;

    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<Account> accounts;
}
