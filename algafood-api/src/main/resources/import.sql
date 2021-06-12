insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Italiana');
insert into cozinha (nome) values ('Marroquina');




insert into restaurante (nome, taxa_Frete, cozinha_Id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_Frete, cozinha_Id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_Frete, cozinha_Id) values ('Tuk Tuk Comida Indiana', 15, 2);
insert into restaurante (nome, taxa_Frete, cozinha_Id) values ('Palermo', 18.4, 3);
insert into restaurante (nome, taxa_Frete, cozinha_Id) values ('Marroco Gordo', 15, 4);



insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Ceará');

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2);
insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');