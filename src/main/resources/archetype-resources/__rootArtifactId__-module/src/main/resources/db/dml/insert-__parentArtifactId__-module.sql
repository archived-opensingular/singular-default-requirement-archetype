
INSERT INTO DBSINGULAR.TB_GRUPO_PROCESSO VALUES
(
'${moduleConstant}',
'${moduleConstant}',
'https://localhost:8443/${modulePrefixName}module/rest/flow'
);


insert into dbsingular.tb_parametro (CO_PARAMETRO, CO_GRUPO_PROCESSO, NO_PARAMETRO, VL_PARAMETRO) values (1 ,'${moduleConstant}','ADMIN_HASH_PASSWORD','0aca995b93addee9348dcef9016c0f9624dfae3a');
insert into dbsingular.tb_parametro (CO_PARAMETRO, CO_GRUPO_PROCESSO, NO_PARAMETRO, VL_PARAMETRO) values (2, '${moduleConstant}','ADMIN_USERNAME','singular');
