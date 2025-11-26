CREATE TYPE specialty_type AS ENUM (
    'PSYCHIATRY',
    'SURGERY',
    'PEDIATRICS',
    'DERMATOLOGY',
    'OPHTHALMOLOGY',
    'CARDIOLOGY'
);

CREATE TABLE doctors (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    crm VARCHAR(6) UNIQUE NOT NULL,
    specialty specialty_type NOT NULL,
    active boolean default True,
    first_line VARCHAR(100) NOT NULL,
    second_line VARCHAR(100),
    number int NOT NULL,
    zip_code CHAR(8) NOT NULL,
    complement VARCHAR(100)
);
