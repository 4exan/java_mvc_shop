package ua.dev.shopservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(length = 75, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String role;

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != getClass()){
            return false;
        } else {
            User user = (User)o;
            return user.getEmail() == this.getEmail();
        }
    }

    @Override
    public int hashCode(){
        return email.hashCode();
    }

    @Override
    public String toString(){
        return "[ " + this.id
        + ", " + this.firstName
        + ", " + this.lastName
        + ", " + this.email
        + ", " + this.password
        + ", " + this.role
        + " ]";
    }

}
