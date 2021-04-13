package com.grigorievfinance.resraurantserver.model;

import lombok.*;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public abstract class AbstractBaseNamedEntity extends AbstractBaseEntity {
    protected String name;

    public AbstractBaseNamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
