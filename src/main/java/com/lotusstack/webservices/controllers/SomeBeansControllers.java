package com.lotusstack.webservices.controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.lotusstack.webservices.dto.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SomeBeansControllers {


    @GetMapping("/getOne")
    public MappingJacksonValue getSomeBeans() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filter = new SimpleFilterProvider().addFilter("SomeBeanFilter", propertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        mappingJacksonValue.setFilters(filter);
        return mappingJacksonValue;
    }

    @GetMapping("/getAll")
    public MappingJacksonValue getAllValues() {
        List<SomeBean> someBeanList = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value11", "value12", "value13"));
        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", propertyFilter);
        MappingJacksonValue jacksonValue = new MappingJacksonValue(someBeanList);
        jacksonValue.setFilters(filterProvider);
        return jacksonValue;
    }
}
