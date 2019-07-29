--------------------
--    drop all    --
--------------------

drop table if exists onboarding_declaracao;
drop sequence if exists onboarding_declaracao_id_seq;

drop table if exists onboarding;
drop sequence if exists onboarding_id_seq;

drop table if exists declaracao;
drop sequence if exists declaracao_id_seq;


----------------------
--    declaracao    --
----------------------

create sequence declaracao_id_seq increment 1 minvalue 1 maxvalue 9223372036854775807 start 1 cache 1;

create table declaracao (
    id bigint default nextval('declaracao_id_seq') not null,
    descricao character varying(500) not null,
    constraint declaracao_pkey primary key (id)
);

insert into declaracao (descricao) values ('criação de nome e logo');
insert into declaracao (descricao) values ('criação de item a mais sobre identidade do projeto');
insert into declaracao (descricao) values ('elaboração do canvas');
insert into declaracao (descricao) values ('criação de algo a mais para o onboarding do projeto');


----------------------
--    onboarding    --
----------------------

create sequence onboarding_id_seq;

create table onboarding (
    id bigint not null default nextval('onboarding_id_seq'),
    data_evento date not null,
    nome_projeto character varying(250) collate pg_catalog."default" not null,
    constraint onboarding_pkey primary key (id)
);


------------------------------------
--    onboarding -> declaracao    --
------------------------------------

create sequence onboarding_declaracao_id_seq increment 1 minvalue 1 maxvalue 9223372036854775807 start 1 cache 1;

create table onboarding_declaracao (
    id bigint not null default nextval('onboarding_declaracao_id_seq'),
    id_declaracao bigint not null,
    id_onboarding bigint not null,
    constraint onboarding_declaracao_pk primary key (id),
    constraint id_declaracao_fk foreign key (id_declaracao) references public.declaracao (id) match simple,
    constraint id_onboarding_fk foreign key (id_onboarding) references public.onboarding (id) match simple
);


-- insert into onboarding(data_evento, nome_projeto) values ('2018-12-03', 'projeto boot');
-- insert into public.onboarding_declaracao(id_declaracao, id_onboarding) values (1, currval('onboarding_id_seq'));
-- insert into public.onboarding_declaracao(id_declaracao, id_onboarding) values (4, currval('onboarding_id_seq'));


-- list all onboardings --

-- select * from onboarding obrd
-- join onboarding_declaracao odec on odec.id_onboarding = obrd.id


-- select obrd.id, obrd.data_evento, obrd.nome_projeto, count(obrdec.id_onboarding) quantidade
-- from onboarding obrd
-- left join onboarding_declaracao obrdec on obrdec.id_onboarding = obrd.id
-- group by obrd.id, obrd.data_evento, obrd.nome_projeto	
