CREATE TABLE tasks (
    id UUID NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    priority INT DEFAULT 1,
    PRIMARY KEY (id)
);