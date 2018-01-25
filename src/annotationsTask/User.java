package annotationsTask;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private List<Roles> roles;


    public User(int id){
        roles=new ArrayList<>();
        roles.add(Roles.DEFAULT);
    }

    public User(int id, List<Roles> roles) {
        this.id = id;
        this.roles = roles;
    }


    public int getId() {
        return id;
    }


    public List<Roles> getRoles() {
        return roles;
    }




}
