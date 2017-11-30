CREATE SCHEMA IF NOT EXISTS `mtgadb`;
USE `mtgadb`;

-- -----------------------------------------------------
-- Table `mtgadb`.`klient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`klient` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
