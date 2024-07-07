CREATE TABLE expenditure (
    id              BIGSERIAL PRIMARY KEY,
    user_id         BIGINT NOT NULL,
    description     VARCHAR(255) NOT NULL,
    payment_method  VARCHAR(255) NOT NULL,
    price           DOUBLE PRECISION NOT NULL,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
