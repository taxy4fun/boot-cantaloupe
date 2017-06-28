package com.springuers.taxy4fun;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jperezdelafuente
 */
@Controller
public class UserController {

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> listUsers() {

        List<User> list = this.getUsers();

        if (list != null && !list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.FOUND);
        }
 
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private List<User>  getUsers(){
        List<User> list = new LinkedList<>();

        User user = new User();

        user.setId(1L);
        user.setFirstname("First Name");
        user.setLastname("Last Name");
        user.setAge(22);
        user.setActive(true);

        list.add(user);

        return list;
    }
}
