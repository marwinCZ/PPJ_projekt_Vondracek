/*DROP TABLE IF EXISTS countries;
DROP TABLE IF EXISTS cities;

CREATE TABLE countries (
  countryCode VARCHAR(10)  PRIMARY KEY,
  countryName VARCHAR(30) NOT NULL,
);

CREATE TABLE cities (
  cityId INT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  countryCode VARCHAR(30),
  foreign key (countryCode) references countries(countryCode)
);

INSERT INTO countries (countryCode, countryName) VALUES
  ('CZ', 'Czechia'),
  ('SK', 'Slovakia'),
  ('HU', 'Hungary');

INSERT INTO cities (cityId, name, countryCode) VALUES
(3067696, 'Prague', 'CZ'),
(3078610, 'Brno', 'CZ'),
(3060972, 'Bratislava', 'SK');*/
