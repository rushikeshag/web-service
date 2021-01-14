package com.lotusstack.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {
    //URI versioning
    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Abhijit Gore");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Abhijit", "Gore"));
    }

    //Request Parameter versioning
    //use URL = localhost:8080/person/param?version1
    @GetMapping(value = "person/param", params = "version1")
    public PersonV1 paramsV1() {
        return new PersonV1("Abhijit Gore");
    }

    @GetMapping(value = "person/param", params = "version2")
    public PersonV2 paramsV2() {
        return new PersonV2(new Name("Abhijit", "Gore"));
    }

    //Header versioning Or Mine Type versioning
    @GetMapping(value = "person/headers", headers = "X-API-VERSION=1")
    public PersonV1 headersV1() {
        return new PersonV1("Abhijit Gore");
    }

    @GetMapping(value = "person/headers", headers = "X-API-VERSION=2")
    public PersonV2 headersV2() {
        return new PersonV2(new Name("Abhijit", "Gore"));
    }

    //Accept header versioning
    @GetMapping(value = "person/headers", produces = "application/app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Abhijit Gore");
    }

    @GetMapping(value = "person/headers", produces = "application/app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Abhijit", "Gore"));
    }
}
