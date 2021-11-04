CREATE TABLE todo(
    id BIGSERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    isComplete BOOLEAN NOT NULL
);