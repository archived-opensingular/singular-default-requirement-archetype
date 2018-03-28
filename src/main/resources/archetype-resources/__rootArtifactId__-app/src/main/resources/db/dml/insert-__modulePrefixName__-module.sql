#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
INSERT INTO DBSINGULAR.TB_MODULO (CO_MODULO, NO_MODULO, URL_CONEXAO)  VALUES
(
'${moduleStringIDName}',
'${moduleStringIDName}',
'https://localhost:8443/${modulePrefixName}module/rest/flow'
);


insert into dbsingular.tb_parametro (CO_PARAMETRO, CO_MODULO, NO_PARAMETRO, VL_PARAMETRO) values (1 ,'${moduleStringIDName}','ADMIN_HASH_PASSWORD','0aca995b93addee9348dcef9016c0f9624dfae3a');
insert into dbsingular.tb_parametro (CO_PARAMETRO, CO_MODULO, NO_PARAMETRO, VL_PARAMETRO) values (2, '${moduleStringIDName}','ADMIN_USERNAME','singular');
