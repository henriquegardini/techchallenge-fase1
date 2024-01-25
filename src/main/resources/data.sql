CREATE TABLE IF NOT EXISTS morador
(
    nome VARCHAR
(
    255
),
    documento VARCHAR
(
    14
) PRIMARY KEY,
    email VARCHAR
(
    255
),
    telefone VARCHAR
(
    15
) UNIQUE,
    apartamento INTEGER,
    andar INTEGER,
    torre VARCHAR
(
    10
),
    inclusao DATE,
    atualizacao DATE
    );
-- Exemplos de inserção na tabela "morador" com a coluna "atualizacao" sendo 1 ano após a "inclusao" e telefones no formato (xx)xxxxx-xxxx
INSERT INTO morador (nome, documento, email, telefone, apartamento, andar, torre, inclusao, atualizacao)
VALUES ('João Silva', '123.456.789-01', 'joao.silva@email.com', '(12)34567-8901', 101, 1, 'A', '2023-01-15',
        '2022-01-15'),
       ('Maria Oliveira', '987.654.321-02', 'maria.oliveira@email.com', '(98)76543-2102', 202, 2, 'B', '2023-02-10',
        '2023-02-10'),
       ('Carlos Santos', '567.890.123-03', 'carlos.santos@email.com', '(56)78901-2303', 303, 3, 'C', '2023-03-25',
        '2023-03-25'),
       ('Ana Pereira', '345.678.901-04', 'ana.pereira@email.com', '(34)56789-0104', 404, 4, 'A', '2023-04-05',
        '2023-04-05'),
       ('Roberto Lima', '901.234.567-05', 'roberto.lima@email.com', '(90)12345-6705', 505, 5, 'B', '2023-05-20',
        '2023-05-20'),
       ('Fernanda Costa', '234.567.890-06', 'fernanda.costa@email.com', '(23)45678-9006', 606, 6, 'C', '2023-06-30',
        '2023-06-30'),
       ('Ricardo Almeida', '789.012.345-07', 'ricardo.almeida@email.com', '(78)90123-4507', 707, 7, 'A', '2023-07-15',
        '2023-07-15'),
       ('Cristina Santos', '456.789.012-08', 'cristina.santos@email.com', '(45)67890-1208', 808, 8, 'B', '2023-08-25',
        '2023-08-25'),
       ('Lucas Pereira', '123.456.789-09', 'lucas.pereira@email.com', '(12)34567-8909', 909, 9, 'C', '2023-09-05',
        '2023-09-05'),
       ('Camila Oliveira', '987.654.321-10', 'camila.oliveira@email.com', '(98)76543-21010', 1010, 10, 'A',
        '2023-10-20', '2023-10-20'),
       ('Marcos Silva', '567.890.123-11', 'marcos.silva@email.com', '(56)78901-2311', 1111, 11, 'B', '2023-11-30',
        '2023-11-30'),
       ('Juliana Costa', '345.678.901-12', 'juliana.costa@email.com', '(34)56789-01212', 1212, 12, 'C', '2023-12-15',
        '2023-12-15'),
       ('Pedro Lima', '901.234.567-13', 'pedro.lima@email.com', '(90)12345-6713', 1313, 13, 'A', '2024-01-25',
        '2024-01-25'),
       ('Larissa Santos', '234.567.890-14', 'larissa.santos@email.com', '(23)45678-9014', 1414, 14, 'B', '2024-02-05',
        '2024-02-05'),
       ('Gustavo Almeida', '789.012.345-15', 'gustavo.almeida@email.com', '(78)90123-4515', 1515, 15, 'C', '2024-03-15',
        '2024-03-15'),
       ('Amanda Pereira', '456.789.012-16', 'amanda.pereira@email.com', '(45)67890-1216', 1616, 16, 'A', '2024-04-25',
        '2024-04-25'),
       ('Bruno Silva', '123.456.789-17', 'bruno.silva@email.com', '(12)34567-8917', 1717, 17, 'B', '2024-05-05',
        '2024-05-05'),
       ('Carla Oliveira', '987.654.321-18', 'carla.oliveira@email.com', '(98)76543-2118', 1818, 18, 'C', '2024-06-20',
        '2024-06-20'),
       ('Rodrigo Santos', '567.890.123-19', 'rodrigo.santos@email.com', '(56)78901-2319', 1919, 19, 'A', '2024-07-30',
        '2024-07-30'),
       ('Renata Lima', '345.678.901-20', 'renata.lima@email.com', '(34)56789-01220', 2020, 20, 'B', '2024-08-15',
        '2024-08-15'),
       ('Marcelo Costa', '901.234.567-21', 'marcelo.costa@email.com', '(90)12345-6721', 2121, 21, 'C', '2024-09-25',
        '2024-09-25'),
       ('Viviane Santos', '234.567.890-22', 'viviane.santos@email.com', '(23)45678-9022', 2222, 22, 'A', '2024-10-05',
        '2024-10-05'),
       ('Eduardo Oliveira', '789.012.345-23', 'eduardo.oliveira@email.com', '(78)90123-4523', 2323, 23, 'B',
        '2024-11-20', '2024-11-20'),
       ('Patricia Lima', '456.789.012-24', 'patricia.lima@email.com', '(45)67890-1224', 2424, 24, 'C', '2024-12-30',
        '2024-12-30'),
       ('Henrique Silva', '123.456.789-25', 'henrique.silva@email.com', '(12)34567-8925', 2525, 25, 'A', '2025-01-10',
        '2025-01-10'),
       ('Leticia Costa', '987.654.321-26', 'leticia.costa@email.com', '(98)76543-2126', 2626, 26, 'B', '2025-02-20',
        '2025-02-20'),
       ('Fábio Santos', '567.890.123-27', 'fabio.santos@email.com', '(56)78901-2727', 2727, 27, 'C', '2025-03-30',
        '2025-03-30'),
       ('Sandra Oliveira', '345.678.901-28', 'sandra.oliveira@email.com', '(34)56789-0128', 2828, 28, 'A', '2025-04-15',
        '2025-04-15'),
       ('Robson Lima', '901.234.567-29', 'robson.lima@email.com', '(90)12345-6729', 2929, 29, 'B', '2025-05-25',
        '2025-05-25');



