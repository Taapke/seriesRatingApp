create schema Series;

DROP USER IF EXISTS 'userSeries'@'localhost';
CREATE USER 'userSeries'@'localhost' IDENTIFIED BY 'pwSeries';
GRANT ALL PRIVILEGES ON Series.* TO 'userSeries'@'localhost';