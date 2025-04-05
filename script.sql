CREATE TABLE IF NOT EXISTS `Empleado`(
`id` INT NOT NULL auto_increment,
`personaempleado_id` INT NOT NULL,
`clave_ingreso` VARCHAR (20) NOT NULL,
`sueldo` DECIMAL (20,2) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `sueldo_UNIQUE` (`sueldo` ASC), 
INDEX `fk_empleado_personaempleado_idx` (`personaempleado_id` ASC),
CONSTRAINT `fk_empleado_personaempleado`
FOREIGN KEY (`personaempleado_id`)
REFERENCES `personaempleado` (`id`)
ON DELETE CASCADE
ON UPDATE NO ACTION
)ENGINE = InnoDB;

