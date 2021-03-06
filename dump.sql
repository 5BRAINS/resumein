-- MySQL Script generated by MySQL Workbench
-- нд, 22-лют-2015 07:19:57 +0200
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema resumein
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `resumein` ;

-- -----------------------------------------------------
-- Schema resumein
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `resumein` DEFAULT CHARACTER SET utf8 ;
USE `resumein` ;

-- -----------------------------------------------------
-- Table `resumein`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `resumein`.`Users` (
  `id` INT(11) NOT NULL,
  `token` VARCHAR(200) NULL DEFAULT NULL,
  `expiry_date` TIMESTAMP NULL,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `resumein`.`Resumes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `resumein`.`Resumes` (
  `id` INT(11) NOT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  `link` VARCHAR(150) NULL DEFAULT NULL,
  `path` VARCHAR(150) NULL DEFAULT NULL,
  `user_info` TEXT NULL,
  `template_id` INT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Resumes_1_idx` (`user_id` ASC),
  CONSTRAINT `fk_Resumes_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `resumein`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `resumein`.`Informations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `resumein`.`Informations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `field_name` VARCHAR(300) NULL,
  `field_value` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Informations_1_idx` (`user_id` ASC),
  CONSTRAINT `fk_Informations_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `resumein`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
