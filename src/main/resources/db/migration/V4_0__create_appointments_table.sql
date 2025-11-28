CREATE TABLE appointments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    id_doctor UUID NOT NULL,
    id_patient UUID NOT NULL,
    datetime TIMESTAMP NOT NULL,
    is_cancelled boolean DEFAULT false,
    CONSTRAINT fk_id_doctor
        FOREIGN KEY (id_doctor)
        REFERENCES doctors (id),
    CONSTRAINT fk_id_patient
        FOREIGN KEY (id_patient)
        REFERENCES patients (id)
);
