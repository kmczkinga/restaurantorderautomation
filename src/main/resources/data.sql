INSERT INTO allergic (id, name, image) VALUES (1, 'glutén', '/images/allergic/gluten.png');
INSERT INTO allergic (id, name, image) VALUES (2, 'laktóz', '/images/allergic/laktoz.png');
INSERT INTO allergic (id, name, image) VALUES (3, 'fruktóz', '/images/allergic/fruktoz.jpg');
INSERT INTO allergic (id, name, image) VALUES (4, 'tojás', '/images/allergic/tojas.png');

INSERT INTO tables (id, number_of_seats, occupied) VALUES (1, 2, false);
INSERT INTO tables (id, number_of_seats, occupied) VALUES (2, 4, false);
INSERT INTO tables (id, number_of_seats, occupied) VALUES (3, 4, false);
INSERT INTO tables (id, number_of_seats, occupied) VALUES (4, 4, false);
INSERT INTO tables (id, number_of_seats, occupied) VALUES (5, 4, false);
INSERT INTO tables (id, number_of_seats, occupied) VALUES (6, 6, false);
INSERT INTO tables (id, number_of_seats, occupied) VALUES (7, 6, false);
INSERT INTO tables (id, number_of_seats, occupied) VALUES (8, 8, false);

INSERT INTO payment_method (id, name, image) VALUES (1, "Kézpénz", "/images/paymentmethod/cash.jpg");
INSERT INTO payment_method (id, name, image) VALUES (2, "Kártya", "/images/paymentmethod/card.png");
INSERT INTO payment_method (id, name, image) VALUES (3, "Ajándékutalvány vagy Szépkártya", "/images/paymentmethod/ticket.jpg");

INSERT INTO food (id, name, type, price, image) VALUES (1, 'Paradicsomleves', 'Leves', 1080, "/images/soup/paradicsomleves.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (2, 'Meggyleves', 'Leves', 980, "/images/soup/meggyleves.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (3, 'Zöldborsóleves', 'Leves', 980, "/images/soup/zoldborsoleves.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (4, 'Babgulyás', 'Leves', 1350, "/images/soup/babgulyas.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (5, 'Orjaleves', 'Leves', 1280, "/images/soup/orjaleves.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (6, 'Carbonara', 'Főétel', 1890, "/images/main-meal/carbonara.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (7, 'Hentes tokány, párolt rizzsel', 'Főétel', 2250, "/images/main-meal/hentestokany.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (8, 'Rántott szelet, rizibizivel', 'Főétel', 1920, "/images/main-meal/rantottszelet.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (9, 'Natúr csirkemell, sült édesburgonyával', 'Főétel', 2550, "/images/main-meal/naturcsirke.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (10, 'Sült csirkecomb, rizzsel, salátával', 'Főétel', 1890, "/images/main-meal/sultcsirkecomb.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (11, 'Erdélyi rakott káposzta', 'Főétel', 1950, "/images/main-meal/rakottkaposzta.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (12, 'Brassói, héjában sült burgonyával', 'Főétel', 2120, "/images/main-meal/brassoi.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (13, 'Mákosguba, vaníla sodóval', 'Desszert', 890, "/images/dessert/makosguba.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (14, 'Palacsinta', 'Desszert', 890, "/images/dessert/palacsinta.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (15, 'Gesztenyepüré', 'Desszert', 950, "/images/dessert/gesztenyepure.jpg");
INSERT INTO food (id, name, type, price, image) VALUES (16, 'Tiramisu', 'Desszert', 1250, "/images/dessert/tiramisu.jpg");

INSERT INTO food_allergic (food_id, allergic_id) VALUES (1,1);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (1,3);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (2,1);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (2,2);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (2,3);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (3,1);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (3,3);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (4,3);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (5,3);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (6,1);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (6,2);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (6,4);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (8,1);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (8,4);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (9,3);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (11,2);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (13,1);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (13,2);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (14,1);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (14,2);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (14,4);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (15,2);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (16,1);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (16,2);
INSERT INTO food_allergic (food_id, allergic_id) VALUES (16,4);
