DROP TABLE IF EXISTS todo;

CREATE TABLE todo (
    id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    target_date date,
    is_done bit NOT NULL,
    PRIMARY KEY(id)
);