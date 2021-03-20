package com.loureiro.cookbook.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Cookbook {

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String title;
    private List<String> ingredients;
    private List<String> preparationSteps;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Cookbook() {
    }
}
