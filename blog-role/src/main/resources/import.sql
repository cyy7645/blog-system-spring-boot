INSERT INTO user (id, username, password, name, email) VALUES (1, 'admin', '123456', 'Yuyao', 'yuc107@pitt.com');
INSERT INTO user (id, username, password, name, email)  VALUES (2, 'Carl', '123456', 'Carl Chen', 'chenyuyao2017@gmail.com');

INSERT INTO authority (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authority (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 2);