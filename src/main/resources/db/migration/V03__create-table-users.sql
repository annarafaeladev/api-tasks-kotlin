CREATE TABLE users (
    id UUID PRIMARY KEY,
    is_admin BOOLEAN DEFAULT FALSE,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Criação de índice para a coluna de e-mail
CREATE INDEX idx_users_email ON users (email);