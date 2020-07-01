package pl.robertburek.nameday.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private long idCustomer;
    private String nickCustomer;
    private String passwordCustomer;
    private String roleCustomer;
    private String ipCustomer;



    public Customer() {
    }



    public enum RoleCustomer {
        ADMIN, USER, MODERATOR
    }
}
