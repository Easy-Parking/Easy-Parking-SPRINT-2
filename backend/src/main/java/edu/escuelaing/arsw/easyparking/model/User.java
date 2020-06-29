package edu.escuelaing.arsw.easyparking.model;

//Required imports
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String rol;
    private String email;
    private List<String> parkings;

    //Standart constructors, getters and setters
    
    public User(String id, String name, String rol, String email, List<String> parkings) {
        this.id = id;
        this.name = name;
        this.rol = rol;
        this.email = email;
        this.parkings = parkings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getParkings() {
        return parkings;
    }

    public void setParkings(List<String> parkings) {
        this.parkings = parkings;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", rol=" + rol + ", email=" + email + ", parkings=" + parkings + '}';
    }

}
