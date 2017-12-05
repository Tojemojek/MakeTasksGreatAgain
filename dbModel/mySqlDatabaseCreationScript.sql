-- -----------------------------------------------------
-- Schema mtgadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mtgadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mtgadb` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;
USE `mtgadb` ;

-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_customer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NULL,
  `role` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_branch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_branch` (
  `id` VARCHAR(3) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_project` (
  `id` VARCHAR(6) NOT NULL,
  `branch_id` VARCHAR(3) NOT NULL,
  `name` VARCHAR(50) NULL,
  `customer_id` INT UNSIGNED NULL,
  `salesman_id` INT UNSIGNED NULL,
  `type` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_klient_id_idx` (`customer_id` ASC),
  INDEX `fk_salesman_id_idx` (`salesman_id` ASC),
  INDEX `fk_branch_id_idx` (`branch_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `mtgadb`.`mtga_customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_salesman_id`
    FOREIGN KEY (`salesman_id`)
    REFERENCES `mtgadb`.`mtga_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_branch_id`
    FOREIGN KEY (`branch_id`)
    REFERENCES `mtgadb`.`mtga_branch` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_task` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `project_id` VARCHAR(6) NOT NULL,
  `ordered_by_id` INT UNSIGNED NULL,
  `executed_by_id` INT UNSIGNED NULL,
  `requested_on` TIMESTAMP NULL,
  `must_be_made_before` TIMESTAMP NULL,
  `finished_on` TIMESTAMP NULL,
  `structure_element` VARCHAR(45) NOT NULL,
  `work_type` VARCHAR(45) NOT NULL,
  `work_description` VARCHAR(45) NOT NULL,
  `task_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_project_id_idx` (`project_id` ASC),
  INDEX `fk_ordered_by_id_idx` (`ordered_by_id` ASC),
  INDEX `fk_executed_by_id_idx` (`executed_by_id` ASC),
  CONSTRAINT `fk_project_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `mtgadb`.`mtga_project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordered_by_id`
    FOREIGN KEY (`ordered_by_id`)
    REFERENCES `mtgadb`.`mtga_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_executed_by_id`
    FOREIGN KEY (`executed_by_id`)
    REFERENCES `mtgadb`.`mtga_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_comment` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `task_id` INT UNSIGNED NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  `creation_date` DATETIME NOT NULL,
  `contents` VARCHAR(300) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_task_id_idx` (`task_id` ASC),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_task_id`
    FOREIGN KEY (`task_id`)
    REFERENCES `mtgadb`.`mtga_task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mtgadb`.`mtga_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_task_status_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_task_status_history` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `task_id` INT UNSIGNED NOT NULL,
  `change_time` TIMESTAMP NOT NULL,
  `task_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  INDEX `fk_task_id_idx` (`task_id` ASC),
      -- czemu nazwa nie może się powtarzać mimo że to inna tabelka? 
  CONSTRAINT `fk_task_status_history_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mtgadb`.`mtga_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    -- czemu nazwa nie może się powtarzać mimo że to inna tabelka? 
  CONSTRAINT `fk_task_status_history_task_id`
    FOREIGN KEY (`task_id`)
    REFERENCES `mtgadb`.`mtga_task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_task_relationship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_task_relationship` (
  `parent_task` INT UNSIGNED NOT NULL,
  `child_taks` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`parent_task`, `child_taks`),
  INDEX `fk_child_task_id_idx` (`child_taks` ASC),
  CONSTRAINT `fk_parent_task_id`
    FOREIGN KEY (`parent_task`)
    REFERENCES `mtgadb`.`mtga_task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_child_task_id`
    FOREIGN KEY (`child_taks`)
    REFERENCES `mtgadb`.`mtga_task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
