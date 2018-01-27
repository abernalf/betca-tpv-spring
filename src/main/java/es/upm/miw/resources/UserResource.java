package es.upm.miw.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.upm.miw.controllers.UserController;
import es.upm.miw.documents.users.Role;
import es.upm.miw.dtos.input.UserDto;
import es.upm.miw.resources.exceptions.ForbiddenException;
import es.upm.miw.resources.exceptions.UserFieldAlreadyExistException;
import es.upm.miw.resources.exceptions.UserFieldInvalidException;

@RestController
@RequestMapping(UserResource.USERS)
@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('OPERATOR')")
public class UserResource {

    public static final String USERS = "/users";

    public static final String MOBILE_ID = "/{mobile}";

    @Autowired
    private UserController userController;

    @RequestMapping(method = RequestMethod.POST)
    public void createCustomer(@RequestBody UserDto userDto) throws UserFieldInvalidException, UserFieldAlreadyExistException {
        this.validateFieldObject(userDto, "No se ha enviado el usuario");
        this.validateFieldObject(userDto.getMobile(), "Mobile invalido");
        this.validateFieldObject(userDto.getUsername(), "Nombre de usuario invalido");
        this.validateFieldObject(userDto.getPassword(), "Nombre de clave invalida");
        Optional<String> error = this.userController.createUser(userDto, new Role[] {Role.CUSTOMER});
        if (error.isPresent()) {
            throw new UserFieldAlreadyExistException(error.get());
        }
    }

    @RequestMapping(value = MOBILE_ID, method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable long mobile) throws UserFieldInvalidException, ForbiddenException {
        Optional<String> error = this.userController.deleteUser(mobile, new Role[] {Role.CUSTOMER});
        if (error.isPresent()) {
            throw new ForbiddenException(error.get());
        }
    }

    private void validateFieldObject(Object objeto, String msg) throws UserFieldInvalidException {
        if (objeto == null) {
            throw new UserFieldInvalidException(msg);
        }
    }

}