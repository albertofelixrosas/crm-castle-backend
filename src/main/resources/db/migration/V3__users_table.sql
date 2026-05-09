CREATE TABLE IF NOT EXISTS crm.users (
    id         BIGSERIAL PRIMARY KEY,
    email      VARCHAR(120) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    first_name VARCHAR(80)  NOT NULL,
    last_name  VARCHAR(80)  NOT NULL,
    role       VARCHAR(20)  NOT NULL DEFAULT 'AGENT',
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_users_email ON crm.users(email);
