
-- -----------------------------------------------------
-- Schema mtgadb
-- -----------------------------------------------------
-- h2 version

CREATE SCHEMA IF NOT EXISTS `mtgadb`;

-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`id`));

-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NULL,
  `role` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`id`));



-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_branch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_branch` (
  `id` VARCHAR(3) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE(`id`));


-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_project` (
  `id` VARCHAR(6) NOT NULL,
  `branch_id` VARCHAR(3) NOT NULL,
  `name` VARCHAR(50) NULL,
  `customer_id` INT NULL,
  `salesman_id` INT NULL,
  `type` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`id`),
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
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_task` (
  `id` INT  NOT NULL AUTO_INCREMENT,
  `project_id` VARCHAR(6) NOT NULL,
  `ordered_by_id` INT  NULL,
  `executed_by_id` INT  NULL,
  `requested_on` TIMESTAMP NULL,
  `must_be_made_before` TIMESTAMP NULL,
  `finished_on` TIMESTAMP NULL,
  `structure_element` VARCHAR(45) NOT NULL,
  `work_type` VARCHAR(45) NOT NULL,
  `work_description` VARCHAR(45) NOT NULL,
  `task_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`id`),
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
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `task_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `creation_date` DATETIME NOT NULL,
  `contents` VARCHAR(300) NULL,
  PRIMARY KEY (`id`),
  UNIQUE(`id`),
  CONSTRAINT `fk_task_id`
    FOREIGN KEY (`task_id`)
    REFERENCES `mtgadb`.`mtga_task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mtgadb`.`mtga_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_task_status_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_task_status_history` (
  `id` INT  NOT NULL AUTO_INCREMENT,
  `user_id` INT  NOT NULL,
  `task_id` INT  NOT NULL,
  `change_time` TIMESTAMP NOT NULL,
  `task_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE(`id`),
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
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `mtgadb`.`mtga_task_relationship`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mtgadb`.`mtga_task_relationship` (
  `parent_task` INT NOT NULL,
  `child_taks` INT NOT NULL,
  PRIMARY KEY (`parent_task`, `child_taks`),
  CONSTRAINT `fk_parent_task_id`
    FOREIGN KEY (`parent_task`)
    REFERENCES `mtgadb`.`mtga_task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_child_task_id`
    FOREIGN KEY (`child_taks`)
    REFERENCES `mtgadb`.`mtga_task` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

