INSERT INTO drone_model (drone_model) VALUES ('Lightweight');
INSERT INTO drone_model (drone_model) VALUES ('Middleweight');
INSERT INTO drone_model (drone_model) VALUES ('Cruiserweight');
INSERT INTO drone_model (drone_model) VALUES ('Heavyweight');

INSERT INTO drone_state (drone_state) VALUES ('IDLE');
INSERT INTO drone_state (drone_state) VALUES ('LOADING');
INSERT INTO drone_state (drone_state) VALUES ('LOADED');
INSERT INTO drone_state (drone_state) VALUES ('DELIVERING');
INSERT INTO drone_state (drone_state) VALUES ('DELIVERED');
INSERT INTO drone_state (drone_state) VALUES ('RETURNING');

INSERT INTO deliver_status (deliver_status) VALUES ('WAITING_TO_DELIVER');
INSERT INTO deliver_status (deliver_status) VALUES ('DELIVERING');
INSERT INTO deliver_status (deliver_status) VALUES ('DELIVERED');

INSERT INTO location (location_coordinates) VALUES ('ABD652DE5F');
INSERT INTO location (location_coordinates) VALUES ('A5F87ED');