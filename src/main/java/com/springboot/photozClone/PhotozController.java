package com.springboot.photozClone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PhotozController {

    Map<String, Photo> mapOfAllPhotoz = new HashMap<>(){{
        put("1", new Photo("1", "hello.jpg"));
    }};

    List<Photo> listOfAllPhotoz = List.of(new Photo("1", "hello.jpg"));
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Collection<Photo> getAllPhoto() {
        return mapOfAllPhotoz.values();
    }

    @GetMapping("/photoz/{id}")
    public Photo getPhotoById(@PathVariable String id) {

        Photo photo = mapOfAllPhotoz.get(id);

        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return photo;
        }
    }
}
