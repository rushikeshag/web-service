package com.lotusstack.webservices;

import com.lotusstack.webservices.db.User;
import com.lotusstack.webservices.db.UserDaoService;
import com.lotusstack.webservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class WebServiceController {

    @Autowired
    private UserDaoService userDaoService;
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/users")
    public ArrayList<User> getAll() {
        return userDaoService.getAll();
    }

    @GetMapping("/goodMorning")
    public String sayGodMorning() {

        return messageSource.getMessage("good.morning.msg", null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getOne(@PathVariable int id) {
        User user = userDaoService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id " + id);
        }
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(this.getClass()).getAll());
        entityModel.add(webMvcLinkBuilder.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> getPathVariable(@Valid @RequestBody User user) {
        User save = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/id")
    public void deleteUser(@PathVariable int id) {
        User user = userDaoService.deleteById(id);
        if (user == null) {
            throw new UserNotFoundException("id " + id);
        }
    }
}
