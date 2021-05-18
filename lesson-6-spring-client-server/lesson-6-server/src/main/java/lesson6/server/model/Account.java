package lesson6.server.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("account id")
    public Long id;
    @NotNull
    @Column(name = "number", unique = true)
    @ApiModelProperty("unique account number")
    public String number;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "owner_id")
    public User owner;
}
