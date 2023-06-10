-- Drop user first if they exist
DROP USER if exists 'yashdev'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'yashdev'@'localhost' IDENTIFIED BY 'yashdev';

GRANT ALL PRIVILEGES ON * . * TO 'yashdev'@'localhost';