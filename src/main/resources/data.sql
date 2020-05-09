INSERT INTO roles(role_id, role)
VALUES (1, 'USER'),
       (2, 'ADMIN')
ON CONFLICT DO NOTHING;
