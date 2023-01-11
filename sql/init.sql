CREATE SCHEMA bayteq;


CREATE TABLE bayteq.bay_temployee
(
    id                  uuid        NOT NULL,
    date_birth          date NULL,
    email               varchar(50) NOT NULL,
    first_surname       varchar(50) NOT NULL,
    first_name          varchar(50) NOT NULL,
    gender              varchar(1) NULL,
    identification_card varchar(10) NOT NULL,
    second_name         varchar(50) NOT NULL,
    second_surname      varchar(50) NOT NULL,
    status              bool NULL DEFAULT true,
    CONSTRAINT uk_so273jv2p5vfhil0xn5hfbwks UNIQUE (identification_card),
    CONSTRAINT vac_temployee_pkey PRIMARY KEY (id)
);

INSERT INTO bayteq.bay_temployee (id,date_birth,email,first_surname,first_name,gender,identification_card,second_name,second_surname,status) VALUES
                                                                                                                                                 ('ddf115c6-4e16-4455-bfd6-9ba328e95180','2023-01-04','johnecu15@gmail.com','John','Henry','M','0105598259','Tenesaca','Criollo',true),
                                                                                                                                                 ('88cd8cae-69c6-455e-91d6-17d9b8b52021','2022-02-10','pepito@gmail.com','Morales','Pepito','M','0105598258','Carlos','Caderas',false);
