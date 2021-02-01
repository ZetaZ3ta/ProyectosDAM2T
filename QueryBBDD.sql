DROP USER IF EXISTS 'TrioCalavera';
CREATE USER 'TrioCalavera' IDENTIFIED BY 'ElTrioCalaverita';
GRANT ALL PRIVILEGES ON m06uf4p1.* TO 'TrioCalavera'@'%';


DROP DATABASE IF EXISTS m06uf4p1;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema M06Uf4P1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema M06Uf4P1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `M06Uf4P1` DEFAULT CHARACTER SET latin1 ;
USE `M06Uf4P1` ;

-- -----------------------------------------------------
-- Table `M06Uf4P1`.`Vuelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `M06Uf4P1`.`Vuelo` (
  `numVuelo` INT NOT NULL,
  `capacidad` INT NULL DEFAULT NULL,
  `fechaHora` TIMESTAMP NOT NULL,
  PRIMARY KEY (`numVuelo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `M06Uf4P1`.`Asiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `M06Uf4P1`.`Asiento` (
  `idAsiento` VARCHAR(4) CHARACTER SET 'latin1' NOT NULL,
  `numVuelo` INT NOT NULL,
  `Lleno` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idAsiento`),
  INDEX `fk_Asiento_Avion_idx` (`numVuelo` ASC) VISIBLE,
  CONSTRAINT `fk_Asiento_Avion`
    FOREIGN KEY (`numVuelo`)
    REFERENCES `M06Uf4P1`.`Vuelo` (`numVuelo`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `M06Uf4P1`.`Pasajero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `M06Uf4P1`.`Pasajero` (
  `DNI` VARCHAR(9) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `numVuelo` INT NOT NULL,
  `idAsiento` VARCHAR(4) NOT NULL,
  `IDbillete` VARCHAR(9) NULL,
  PRIMARY KEY (`DNI`),
  INDEX `Vuelo_pasajero` (`numVuelo` ASC) VISIBLE,
  INDEX `fk_Asiento_pasajero_idx` (`idAsiento` ASC) VISIBLE,
  CONSTRAINT `fk_Vuelo_pasajero`
    FOREIGN KEY (`numVuelo`)
    REFERENCES `M06Uf4P1`.`Vuelo` (`numVuelo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asiento_pasajero`
    FOREIGN KEY (`idAsiento`)
    REFERENCES `M06Uf4P1`.`Asiento` (`idAsiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO vuelo VALUES (1,3,DATE_ADD(NOW(),INTERVAL 2 DAY));
INSERT INTO vuelo VALUES (2,5,DATE_ADD(NOW(),INTERVAL 10 DAY));
