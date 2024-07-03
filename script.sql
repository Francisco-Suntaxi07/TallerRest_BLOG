/*==============================================================*/
/* DBMS name:      SAP SQL Anywhere 16                          */
/* Created on:     03/07/2024 09:39:00 a. m.                    */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_COMENTAR_POST_COME_POST') then
    alter table COMENTARIO
       delete foreign key FK_COMENTAR_POST_COME_POST
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_COMENTAR_USUARIO_C_USUARIO') then
    alter table COMENTARIO
       delete foreign key FK_COMENTAR_USUARIO_C_USUARIO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_POST_USUARIO_P_USUARIO') then
    alter table POST
       delete foreign key FK_POST_USUARIO_P_USUARIO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_USUARIO__USUARIO_R_USUARIO') then
    alter table USUARIO_ROL
       delete foreign key FK_USUARIO__USUARIO_R_USUARIO
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_USUARIO__USUARIO_R_ROL') then
    alter table USUARIO_ROL
       delete foreign key FK_USUARIO__USUARIO_R_ROL
end if;


/*==============================================================*/
/* Table: COMENTARIO                                            */
/*==============================================================*/
create table COMENTARIO 
(
   IDCOMENTARIO         varchar(8)                     not null,
   IDPOST               varchar(8)                     not null,
   IDUSUARIO            varchar(8)                     not null,
   MENSAJECOMENTARIO    varchar(255)                   null,
   FECHACOMENTARIO      timestamp                      null,
   constraint PK_COMENTARIO primary key clustered (IDCOMENTARIO)
);

/*==============================================================*/
/* Index: COMENTARIO_PK                                         */
/*==============================================================*/
create unique clustered index COMENTARIO_PK on COMENTARIO (
IDCOMENTARIO ASC
);

/*==============================================================*/
/* Index: USUARIO_COMENTARIO_FK                                 */
/*==============================================================*/
create index USUARIO_COMENTARIO_FK on COMENTARIO (
IDUSUARIO ASC
);

/*==============================================================*/
/* Index: POST_COMENTARIO_FK                                    */
/*==============================================================*/
create index POST_COMENTARIO_FK on COMENTARIO (
IDPOST ASC
);

/*==============================================================*/
/* Table: POST                                                  */
/*==============================================================*/
create table POST 
(
   IDPOST               varchar(8)                     not null,
   IDUSUARIO            varchar(8)                     not null,
   DESCRIPCIONPOST      varchar(128)                   null,
   FECHACREACIONPOST    timestamp                      null,
   constraint PK_POST primary key clustered (IDPOST)
);

/*==============================================================*/
/* Index: POST_PK                                               */
/*==============================================================*/
create unique clustered index POST_PK on POST (
IDPOST ASC
);

/*==============================================================*/
/* Index: USUARIO_POST_FK                                       */
/*==============================================================*/
create index USUARIO_POST_FK on POST (
IDUSUARIO ASC
);

/*==============================================================*/
/* Table: ROL                                                   */
/*==============================================================*/
create table ROL 
(
   IDROL                varchar(8)                     not null,
   NOMBREROL            varchar(16)                    null,
   constraint PK_ROL primary key clustered (IDROL)
);

/*==============================================================*/
/* Index: ROL_PK                                                */
/*==============================================================*/
create unique clustered index ROL_PK on ROL (
IDROL ASC
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO 
(
   IDUSUARIO            varchar(8)                     not null,
   NOMBREUSUARIO        varchar(32)                    null,
   EMAILUSUARIO         varchar(32)                    null,
   constraint PK_USUARIO primary key clustered (IDUSUARIO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique clustered index USUARIO_PK on USUARIO (
IDUSUARIO ASC
);

/*==============================================================*/
/* Table: USUARIO_ROL                                           */
/*==============================================================*/
create table USUARIO_ROL 
(
   IDUSUARIO            varchar(8)                     not null,
   IDROL                varchar(8)                     not null,
   constraint PK_USUARIO_ROL primary key clustered (IDUSUARIO, IDROL)
);

/*==============================================================*/
/* Index: USUARIO_ROL_PK                                        */
/*==============================================================*/
create unique clustered index USUARIO_ROL_PK on USUARIO_ROL (
IDUSUARIO ASC,
IDROL ASC
);

/*==============================================================*/
/* Index: USUARIO_ROL_FK                                        */
/*==============================================================*/
create index USUARIO_ROL_FK on USUARIO_ROL (
IDUSUARIO ASC
);

/*==============================================================*/
/* Index: USUARIO_ROL2_FK                                       */
/*==============================================================*/
create index USUARIO_ROL2_FK on USUARIO_ROL (
IDROL ASC
);

alter table COMENTARIO
   add constraint FK_COMENTAR_POST_COME_POST foreign key (IDPOST)
      references POST (IDPOST)
      on update restrict
      on delete restrict;

alter table COMENTARIO
   add constraint FK_COMENTAR_USUARIO_C_USUARIO foreign key (IDUSUARIO)
      references USUARIO (IDUSUARIO)
      on update restrict
      on delete restrict;

alter table POST
   add constraint FK_POST_USUARIO_P_USUARIO foreign key (IDUSUARIO)
      references USUARIO (IDUSUARIO)
      on update restrict
      on delete restrict;

alter table USUARIO_ROL
   add constraint FK_USUARIO__USUARIO_R_USUARIO foreign key (IDUSUARIO)
      references USUARIO (IDUSUARIO)
      on update restrict
      on delete restrict;

alter table USUARIO_ROL
   add constraint FK_USUARIO__USUARIO_R_ROL foreign key (IDROL)
      references ROL (IDROL)
      on update restrict
      on delete restrict;

