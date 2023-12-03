package sem2.task03.models;


import sem2.task03.Column;

import java.util.UUID;

@sem2.task03.Entity
public class Entity {

    @Column(name = "id", primaryKey = true)
    private UUID id;

}
