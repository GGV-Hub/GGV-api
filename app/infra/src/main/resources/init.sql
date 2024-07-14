CREATE TABLE user_expense (
    id              BIGSERIAL PRIMARY KEY,
    user_id         BIGINT NOT NULL,
    title           VARCHAR(255) NOT NULL,
    date_time       TIMESTAMPTZ  NOT NULL,
    price           DOUBLE PRECISION NOT NULL,
    payment_method  VARCHAR(255) NOT NULL,
    category        VARCHAR(255) NOT NULL,
    memo            TEXT,
    created_at      TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
