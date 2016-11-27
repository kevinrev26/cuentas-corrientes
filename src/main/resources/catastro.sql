/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     24/11/2016 11:16:31 a.m.                     */
/*==============================================================*/


drop index CONTRIBUYENTE_PK;

drop table CONTRIBUYENTE;

drop index TIENE_FK;

drop index CUENTA_CORRIENTE_PK;

drop table CUENTA_CORRIENTE;

drop index CANCELA_FK;

drop index CUOTA_PK;

drop table CUOTA;

drop index POSEE_FK;

drop index POSEE2_FK;

drop index DETALLE_TASA_PK;

drop table DETALLE_TASA;

drop index INMUEBLE_PK;

drop table INMUEBLE;

drop index INVOLUCRA_FK;

drop index EFECTUA_FK;

drop index PAGO_PK;

drop table PAGO;

drop index CONVIENE_FK;

drop index PLAN_DE_PAGO_PK;

drop table PLAN_DE_PAGO;

drop index TASA_PK;

drop table TASA;

drop index MODIFICA_FK;

drop index TRAMITA_FK;

drop index TRASPASO_PK;

drop table TRASPASO;

/*==============================================================*/
/* Table: CONTRIBUYENTE                                         */
/*==============================================================*/
create table CONTRIBUYENTE (
   NUMEROCONTRIBUYENTE  SERIAL               not null,
   NOMBRE               VARCHAR(250)         not null,
   APELLIDO             VARCHAR(250)         not null,
   NIT                  VARCHAR(14)          not null,
   DIRECCION            VARCHAR(250)         not null,
   TELEFONO             VARCHAR(8)           not null,
   CORREOELECTRONICO    VARCHAR(250)         null,
   constraint PK_CONTRIBUYENTE primary key (NUMEROCONTRIBUYENTE)
);

/*==============================================================*/
/* Index: CONTRIBUYENTE_PK                                      */
/*==============================================================*/
create unique index CONTRIBUYENTE_PK on CONTRIBUYENTE (
NUMEROCONTRIBUYENTE
);

/*==============================================================*/
/* Table: CUENTA_CORRIENTE                                      */
/*==============================================================*/
create table CUENTA_CORRIENTE (
   IDCUENTACORRIENTE    SERIAL               not null,
   NUMEROCONTRIBUYENTE  INT4                 not null,
   FECHAULTIMOPAGO      DATE                 not null,
   INTERES              FLOAT8               not null,
   TASAMENSUAL          FLOAT8               not null,
   SALDOACUMULADO       FLOAT8               not null,
   constraint PK_CUENTA_CORRIENTE primary key (IDCUENTACORRIENTE)
);

/*==============================================================*/
/* Index: CUENTA_CORRIENTE_PK                                   */
/*==============================================================*/
create unique index CUENTA_CORRIENTE_PK on CUENTA_CORRIENTE (
IDCUENTACORRIENTE
);

/*==============================================================*/
/* Index: TIENE_FK                                              */
/*==============================================================*/
create  index TIENE_FK on CUENTA_CORRIENTE (
NUMEROCONTRIBUYENTE
);

/*==============================================================*/
/* Table: CUOTA                                                 */
/*==============================================================*/
create table CUOTA (
   IDCUOTA              SERIAL               not null,
   IDENTIFICADORPLAN    INT4                 not null,
   ESTADO               BOOL                 null,
   constraint PK_CUOTA primary key (IDCUOTA)
);

/*==============================================================*/
/* Index: CUOTA_PK                                              */
/*==============================================================*/
create unique index CUOTA_PK on CUOTA (
IDCUOTA
);

/*==============================================================*/
/* Index: CANCELA_FK                                            */
/*==============================================================*/
create  index CANCELA_FK on CUOTA (
IDENTIFICADORPLAN
);

/*==============================================================*/
/* Table: DETALLE_TASA                                          */
/*==============================================================*/
create table DETALLE_TASA (
   CODIGO               INT4                 not null,
   CLAVECATASTRAL       INT4                 not null,
   constraint PK_DETALLE_TASA primary key (CODIGO, CLAVECATASTRAL)
);

/*==============================================================*/
/* Index: DETALLE_TASA_PK                                       */
/*==============================================================*/
create unique index DETALLE_TASA_PK on DETALLE_TASA (
CODIGO,
CLAVECATASTRAL
);

/*==============================================================*/
/* Index: POSEE2_FK                                             */
/*==============================================================*/
create  index POSEE2_FK on DETALLE_TASA (
CLAVECATASTRAL
);

/*==============================================================*/
/* Index: POSEE_FK                                              */
/*==============================================================*/
create  index POSEE_FK on DETALLE_TASA (
CODIGO
);

/*==============================================================*/
/* Table: INMUEBLE                                              */
/*==============================================================*/
create table INMUEBLE (
   CLAVECATASTRAL       INT4                 not null,
   DIRECCIONINMUEBLE    VARCHAR(250)         not null,
   AREASUPERFICIAL      FLOAT8               not null,
   METROSLINEALES       FLOAT8               not null,
   VALOR                FLOAT8               not null,
   OBSERVACION          VARCHAR(250)         null,
   constraint PK_INMUEBLE primary key (CLAVECATASTRAL)
);

/*==============================================================*/
/* Index: INMUEBLE_PK                                           */
/*==============================================================*/
create unique index INMUEBLE_PK on INMUEBLE (
CLAVECATASTRAL
);

/*==============================================================*/
/* Table: PAGO                                                  */
/*==============================================================*/
create table PAGO (
   IDPAGO               SERIAL               not null,
   NUMEROCONTRIBUYENTE  INT4                 not null,
   IDCUOTA              INT4                 null,
   ABONO                FLOAT8               not null,
   FECHAPAGO            DATE                 null,
   constraint PK_PAGO primary key (IDPAGO)
);

/*==============================================================*/
/* Index: PAGO_PK                                               */
/*==============================================================*/
create unique index PAGO_PK on PAGO (
IDPAGO
);

/*==============================================================*/
/* Index: EFECTUA_FK                                            */
/*==============================================================*/
create  index EFECTUA_FK on PAGO (
NUMEROCONTRIBUYENTE
);

/*==============================================================*/
/* Index: INVOLUCRA_FK                                          */
/*==============================================================*/
create  index INVOLUCRA_FK on PAGO (
IDCUOTA
);

/*==============================================================*/
/* Table: PLAN_DE_PAGO                                          */
/*==============================================================*/
create table PLAN_DE_PAGO (
   IDENTIFICADORPLAN    SERIAL               not null,
   NUMEROCONTRIBUYENTE  INT4                 not null,
   FECHA                DATE                 not null,
   SALDOACTUAL          FLOAT8               not null,
   PAGOMENSUAL          FLOAT8               not null,
   TOTALACOBRAR         FLOAT8               not null,
   constraint PK_PLAN_DE_PAGO primary key (IDENTIFICADORPLAN)
);

/*==============================================================*/
/* Index: PLAN_DE_PAGO_PK                                       */
/*==============================================================*/
create unique index PLAN_DE_PAGO_PK on PLAN_DE_PAGO (
IDENTIFICADORPLAN
);

/*==============================================================*/
/* Index: CONVIENE_FK                                           */
/*==============================================================*/
create  index CONVIENE_FK on PLAN_DE_PAGO (
NUMEROCONTRIBUYENTE
);

/*==============================================================*/
/* Table: TASA                                                  */
/*==============================================================*/
create table TASA (
   CODIGO               INT4                 not null,
   DESCRIPCIONTASA      VARCHAR(200)         null,
   VALOR                FLOAT8               null,
   constraint PK_TASA primary key (CODIGO)
);

/*==============================================================*/
/* Index: TASA_PK                                               */
/*==============================================================*/
create unique index TASA_PK on TASA (
CODIGO
);

/*==============================================================*/
/* Table: TRASPASO                                              */
/*==============================================================*/
create table TRASPASO (
   IDTRASPASO           VARCHAR(10)          not null,
   NUMEROCONTRIBUYENTE  INT4                 not null,
   CLAVECATASTRAL       INT4                 not null,
   FECHATRASPASO        DATE                 not null,
   DESCRIPCION          VARCHAR(250)         null,
   constraint PK_TRASPASO primary key (IDTRASPASO)
);

/*==============================================================*/
/* Index: TRASPASO_PK                                           */
/*==============================================================*/
create unique index TRASPASO_PK on TRASPASO (
IDTRASPASO
);

/*==============================================================*/
/* Index: TRAMITA_FK                                            */
/*==============================================================*/
create  index TRAMITA_FK on TRASPASO (
NUMEROCONTRIBUYENTE
);

/*==============================================================*/
/* Index: MODIFICA_FK                                           */
/*==============================================================*/
create  index MODIFICA_FK on TRASPASO (
CLAVECATASTRAL
);

/*==================================================*/
/* Table: INTERES                                   */
/*==================================================*/

create table INTERES(
    IDINTERES INT4 NOT NULL,
    TASA FLOAT8 NOT NULL,
    constraint PK_INTERES primary key (IDINTERES)
);

alter table CUENTA_CORRIENTE
   add constraint FK_CUENTA_C_TIENE_CONTRIBU foreign key (NUMEROCONTRIBUYENTE)
      references CONTRIBUYENTE (NUMEROCONTRIBUYENTE)
      on delete restrict on update restrict;

alter table CUOTA
   add constraint FK_CUOTA_CANCELA_PLAN_DE_ foreign key (IDENTIFICADORPLAN)
      references PLAN_DE_PAGO (IDENTIFICADORPLAN)
      on delete restrict on update restrict;

alter table DETALLE_TASA
   add constraint FK_DETALLE__POSEE_TASA foreign key (CODIGO)
      references TASA (CODIGO)
      on delete restrict on update restrict;

alter table DETALLE_TASA
   add constraint FK_DETALLE__POSEE2_INMUEBLE foreign key (CLAVECATASTRAL)
      references INMUEBLE (CLAVECATASTRAL)
      on delete restrict on update restrict;

alter table PAGO
   add constraint FK_PAGO_EFECTUA_CONTRIBU foreign key (NUMEROCONTRIBUYENTE)
      references CONTRIBUYENTE (NUMEROCONTRIBUYENTE)
      on delete restrict on update restrict;

alter table PAGO
   add constraint FK_PAGO_INVOLUCRA_CUOTA foreign key (IDCUOTA)
      references CUOTA (IDCUOTA)
      on delete restrict on update restrict;

alter table PLAN_DE_PAGO
   add constraint FK_PLAN_DE__CONVIENE_CONTRIBU foreign key (NUMEROCONTRIBUYENTE)
      references CONTRIBUYENTE (NUMEROCONTRIBUYENTE)
      on delete restrict on update restrict;

alter table TRASPASO
   add constraint FK_TRASPASO_MODIFICA_INMUEBLE foreign key (CLAVECATASTRAL)
      references INMUEBLE (CLAVECATASTRAL)
      on delete restrict on update restrict;

alter table TRASPASO
   add constraint FK_TRASPASO_TRAMITA_CONTRIBU foreign key (NUMEROCONTRIBUYENTE)
      references CONTRIBUYENTE (NUMEROCONTRIBUYENTE)
      on delete restrict on update restrict;

INSERT INTO INTERES(IDINTERES, tasa) VALUES(1,0.03);