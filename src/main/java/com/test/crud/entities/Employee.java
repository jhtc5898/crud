package com.test.crud.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bay_temployee") //manejamos acronimo: 'bay'= esquema  y 'T' = Tabla
public class Employee implements Serializable {

    private static final long serialVersionUUID = 1L;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "pk_employee", strategy = "org.hibernate.id.UUIDGenerator ")
    @Comment("identifier primary key")
    @Column(name = "id", nullable = false)
    private UUID id;
    @Comment("identification document")
    @Column(name = "identification_card", nullable = false, unique = true, length = 10)
    private String identificationCard;
    @Comment("Employee first name")
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstname;
    @Comment("Employee second name")
    @Column(name = "second_name", length = 50, nullable = false)
    private String second_name;
    @Comment("Employee first surname")
    @Column(name = "first_surname", length = 50, nullable = false)
    private String first_surname;
    @Comment("Employee second surname")
    @Column(name = "second_surname", length = 50, nullable = false)
    private String second_surname;
    @Comment("Employee mail")
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    @Comment("Employe status:  1 = Active  2 =Disabled  ")
    @Column(name = "status", length = 1, columnDefinition = "boolean default true")
    private Boolean status = true;
    @Comment("Employe gender:   M =Masculino F = Femenino")
    @Column(name = "gender", length = 1)
    private String gender;
    @Comment("Employee date birth")
    @Temporal(TemporalType.DATE)
    @Column(name = "date_birth")
    private Date date_birth;


}
