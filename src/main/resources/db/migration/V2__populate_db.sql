INSERT INTO client (name) VALUES
  ('John Smith'),
  ('Jane Doe'),
  ('Bob Johnson'),
  ('Alice Lee'),
  ('Charlie Brown'),
  ('Lucy Smith'),
  ('Mike Lee'),
  ('Lily Chen'),
  ('Emily Johnson'),
  ('Tom Lee');

INSERT INTO planet (id, name) VALUES
  ('MARS', 'Mars'),
  ('VEN', 'Venus'),
  ('JUP', 'Jupiter'),
  ('SAT', 'Saturn'),
  ('NEP', 'Neptune');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
  ('2023-02-12 10:30:00', 1, 'MARS', 'VEN'),
  ('2023-02-13 15:00:00', 2, 'VEN', 'MARS'),
  ('2023-02-14 08:45:00', 3, 'MARS', 'JUP'),
  ('2023-02-14 10:30:00', 4, 'NEP', 'MARS'),
  ('2023-02-14 12:00:00', 5, 'JUP', 'SAT'),
  ('2023-02-14 13:15:00', 6, 'SAT', 'MARS'),
  ('2023-02-14 14:30:00', 7, 'VEN', 'SAT'),
  ('2023-02-14 15:45:00', 8, 'MARS', 'NEP'),
  ('2023-02-14 17:00:00', 9, 'JUP', 'NEP'),
  ('2023-02-14 18:15:00', 10, 'VEN', 'JUP');
