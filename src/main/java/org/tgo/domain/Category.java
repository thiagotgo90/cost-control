package org.tgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "categoryIdGenerator")
    @TableGenerator(name = "categoryIdGenerator", table = "id_table")
    private int id;
    
    
    

}
