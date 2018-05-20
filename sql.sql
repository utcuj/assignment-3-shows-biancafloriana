
CREATE TABLE `shows`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `shows`.`movie` (
  `id` INT NOT NULL,
  `actors` VARCHAR(45) NULL,
  `rating` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `idSE`
    FOREIGN KEY (`id`)
    REFERENCES `shows`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `shows`.`theatre` (
  `id` INT NOT NULL,
  `actors` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `idTE`
    FOREIGN KEY (`id`)
    REFERENCES `shows`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `shows`.`sport` (
  `id` INT NOT NULL,
  `team1` VARCHAR(45) NULL,
  `team2` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `idES`
    FOREIGN KEY (`id`)
    REFERENCES `shows`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
CREATE TABLE `shows`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `shows`.`history` (
  `id` INT NOT NULL,
  `id_user` INT NULL,
  `id_show` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `idU_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `idU`
    FOREIGN KEY (`id_user`)
    REFERENCES `shows`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idS`
    FOREIGN KEY (`id_user`)
    REFERENCES `shows`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
CREATE TABLE `shows`.`comment` (
  `id` INT NOT NULL,
  `id_user` INT NULL,
  `id_show` INT NULL,
  `text` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `idUC_idx` (`id_user` ASC) VISIBLE,
  INDEX `idEC_idx` (`id_show` ASC) VISIBLE,
  CONSTRAINT `idUC`
    FOREIGN KEY (`id_user`)
    REFERENCES `shows`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idEC`
    FOREIGN KEY (`id_show`)
    REFERENCES `shows`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
CREATE TABLE `shows`.`ratings` (
  `id` INT NOT NULL,
  `id_user` INT NULL,
  `id_show` INT NULL,
  `rating` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `idUR_idx` (`id_user` ASC) VISIBLE,
  INDEX `idEU_idx` (`id_show` ASC) VISIBLE,
  CONSTRAINT `idUR`
    FOREIGN KEY (`id_user`)
    REFERENCES `shows`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idEU`
    FOREIGN KEY (`id_show`)
    REFERENCES `shows`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
movie    