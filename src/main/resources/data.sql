INSERT INTO stoixhwomanrebooteddatabase.match (id, description, match_date, match_time, teama, teamb, sport)
VALUES (1, 'LAMIA-LEVADIAKOS', '2024-11-14', '18:00:00', 'LAMIA', 'LEVADIAKOS', 0),
       (2, 'VOLOS-KIFISIA', '2024-11-19', '21:30:00', 'VOLOS', 'KIFISIA', 0),
       (3, 'OSFP-PAO', '2024-11-19', '21:30:00', 'VOLOS', 'KIFISIA', 0),
       (4, 'LAVRIO-PERISTERI', '2024-11-17', '20:00:00', 'LAVRIO', 'PERISTERI', 1);

--       INVALID_COMMAND;

INSERT INTO stoixhwomanrebooteddatabase.match_odds (id, match_id, specifier, odd)
VALUES (7, 1, '1', 1.2),
       (8, 1, '2', 3),
       (9, 1, 'X', 6),
       (10, 2, '1', 1.8),
       (11, 2, '2', 2.5),
       (12, 2, 'X', 4),
       (13, 3, '1', 1.05),
       (14, 3, '2', 2.2),
       (15, 3, 'X', 7),
       (16, 4, '1', 1.6),
       (17, 4, '2', 2.6);