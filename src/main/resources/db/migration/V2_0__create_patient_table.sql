CREATE TABLE patients (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(13) NOT NULL,
    cpf CHAR(11) UNIQUE NOT NULL,
    active boolean default True,
    first_line VARCHAR(100) NOT NULL,
    second_line VARCHAR(100),
    number int NOT NULL,
    zip_code CHAR(8) NOT NULL,
    complement VARCHAR(100)
);
