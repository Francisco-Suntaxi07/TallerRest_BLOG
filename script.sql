/*==============================================================*/
/* Table: COMENTARIO                                            */
/*==============================================================*/
CREATE TABLE COMENTARIO 
(
   IDCOMENTARIO         VARCHAR(8)                     NOT NULL,
   IDPOST               VARCHAR(8)                     NOT NULL,
   IDUSUARIO            VARCHAR(8)                     NOT NULL,
   MENSAJECOMENTARIO    VARCHAR(255)                   NULL,
   FECHACOMENTARIO      TIMESTAMP                      NULL,
   CONSTRAINT PK_COMENTARIO PRIMARY KEY CLUSTERED (IDCOMENTARIO)
);

/*==============================================================*/
/* Index: USUARIO_COMENTARIO_FK                                 */
/*==============================================================*/
CREATE INDEX USUARIO_COMENTARIO_FK ON COMENTARIO (
IDUSUARIO ASC
);

/*==============================================================*/
/* Index: POST_COMENTARIO_FK                                    */
/*==============================================================*/
CREATE INDEX POST_COMENTARIO_FK ON COMENTARIO (
IDPOST ASC
);

/*==============================================================*/
/* Table: POST                                                  */
/*==============================================================*/
CREATE TABLE POST 
(
   IDPOST               VARCHAR(8)                     NOT NULL,
   IDUSUARIO            VARCHAR(8)                     NOT NULL,
   DESCRIPCIONPOST      VARCHAR(128)                   NULL,
   FECHACREACIONPOST    DATE                      NULL,
   CONSTRAINT PK_POST PRIMARY KEY CLUSTERED (IDPOST)
);

/*==============================================================*/
/* Index: USUARIO_POST_FK                                       */
/*==============================================================*/
CREATE INDEX USUARIO_POST_FK ON POST (
IDUSUARIO ASC
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
CREATE TABLE USUARIO 
(
   IDUSUARIO            VARCHAR(8)                     NOT NULL,
   NOMBREUSUARIO        VARCHAR(32)                    NULL,
   EMAILUSUARIO         VARCHAR(32)                    NULL,
   ROLUSUARIO           VARCHAR(16)                    NULL,
   CONSTRAINT PK_USUARIO PRIMARY KEY CLUSTERED (IDUSUARIO)
);

ALTER TABLE COMENTARIO
   ADD CONSTRAINT FK_COMENTAR_POST_COME_POST FOREIGN KEY (IDPOST)
      REFERENCES POST (IDPOST)
      ON UPDATE NO ACTION
      ON DELETE NO ACTION;

ALTER TABLE COMENTARIO
   ADD CONSTRAINT FK_COMENTAR_USUARIO_C_USUARIO FOREIGN KEY (IDUSUARIO)
      REFERENCES USUARIO (IDUSUARIO)
      ON UPDATE NO ACTION
      ON DELETE NO ACTION;

ALTER TABLE POST
   ADD CONSTRAINT FK_POST_USUARIO_P_USUARIO FOREIGN KEY (IDUSUARIO)
      REFERENCES USUARIO (IDUSUARIO)
      ON UPDATE NO ACTION
      ON DELETE NO ACTION;

INSERT INTO USUARIO (IDUSUARIO, NOMBREUSUARIO, EMAILUSUARIO, ROLUSUARIO)
VALUES ('172343', 'Francisco Suntaxi', 'sf@espe.edu.ec', 'ADMIN'),
       ('172612', 'Ricardo Grijalva', 'rs@espe.edu.ec', 'AUTOR'),
       ('101234', 'Luis Espinosa', 'lx@espe.edu.ec', 'LECTOR');

INSERT INTO POST (IDPOST, IDUSUARIO, DESCRIPCIONPOST, FECHACREACIONPOST)
VALUES ('123', '172343', 'mipost', '2024-05-01');

