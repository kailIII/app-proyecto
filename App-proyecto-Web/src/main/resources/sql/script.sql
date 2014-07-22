--<ScriptOptions statementTerminator=";"/>
DROP TABLE `app-erp`.`formula_detalles`;

DROP TABLE `app-erp`.`pedidos`;

DROP TABLE `app-erp`.`depositos`;

DROP TABLE `app-erp`.`proveedores`;

DROP TABLE `app-erp`.`compra_detalles`;

DROP TABLE `app-erp`.`produccion_detalles`;

DROP TABLE `app-erp`.`venta_detalles`;

DROP TABLE `app-erp`.`bancos`;

DROP TABLE `app-erp`.`unidades_medidas`;

DROP TABLE `app-erp`.`roles`;

DROP TABLE `app-erp`.`clientes`;

DROP TABLE `app-erp`.`marcas`;

DROP TABLE `app-erp`.`impuestos`;

DROP TABLE `app-erp`.`horarios`;

DROP TABLE `app-erp`.`compras`;

DROP TABLE `app-erp`.`empleados`;

DROP TABLE `app-erp`.`grupos`;

DROP TABLE `app-erp`.`produccion`;

DROP TABLE `app-erp`.`productos`;

DROP TABLE `app-erp`.`lotes`;

DROP TABLE `app-erp`.`producto_lista_precios`;

DROP TABLE `app-erp`.`formulas`;

DROP TABLE `app-erp`.`usuarios`;

DROP TABLE `app-erp`.`pedido_detalles`;

DROP TABLE `app-erp`.`cargos`;

DROP TABLE `app-erp`.`grupos_usu`;

DROP TABLE `app-erp`.`ciudades`;

DROP TABLE `app-erp`.`departamentos`;

DROP TABLE `app-erp`.`cheques`;

DROP TABLE `app-erp`.`tipo_personas`;

DROP TABLE `app-erp`.`grupos_roles`;

DROP TABLE `app-erp`.`paises`;

DROP TABLE `app-erp`.`ventas`;

CREATE TABLE `app-erp`.`formula_detalles` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`formula_id` INT NOT NULL,
	`producto_id` INT NOT NULL,
	`cantidad` DECIMAL(10 , 2),
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`pedidos` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`fecha_registro` DATETIME,
	`ped_proveedor_id` INT NOT NULL,
	`estado` VARCHAR(20),
	`activo` INT,
	`fecha_vencimiento` DATETIME,
	`fecha_recepcion` DATETIME,
	`total_exentas` DECIMAL(10 , 2),
	`total_gravada10` DECIMAL(10 , 2),
	`total_gravada5` DECIMAL(10 , 2),
	`total_iva10` DECIMAL(10 , 2),
	`total_iva5` DECIMAL(10 , 2),
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`depositos` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`proveedores` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(120),
	`ci` VARCHAR(45),
	`ruc` VARCHAR(45),
	`representante` VARCHAR(45),
	`direccion` VARCHAR(120),
	`direccion2` VARCHAR(120),
	`barrio` VARCHAR(45),
	`telefono` VARCHAR(20),
	`telefono2` VARCHAR(20),
	`celular` VARCHAR(20),
	`celular2` VARCHAR(20),
	`activo` INT,
	`ciudad_id` INT NOT NULL,
	`codigo_postal` VARCHAR(45),
	`apellido` VARCHAR(45),
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`compra_detalles` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`compra_id` INT NOT NULL,
	`producto_id` INT NOT NULL,
	`insumo_cantidad` DECIMAL(10 , 2),
	`lote_id` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`produccion_detalles` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`produccion_id` INT NOT NULL,
	`producto_id` INT NOT NULL,
	`cantidad` DECIMAL(10 , 2),
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`venta_detalles` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`venta_id` INT NOT NULL,
	`producto_id` INT NOT NULL,
	`cantidad` DECIMAL(10 , 2),
	`precio` DECIMAL(10 , 2),
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`bancos` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`direccion` VARCHAR(120),
	`barrio` VARCHAR(120),
	`telefono` VARCHAR(20),
	`telefono2` VARCHAR(20),
	`celular` VARCHAR(20),
	`celular2` VARCHAR(20),
	`fax` VARCHAR(45),
	`email` VARCHAR(45),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`unidades_medidas` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`abreviatura` VARCHAR(3),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`roles` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`usuario_id` INT NOT NULL,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`clientes` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(60),
	`apellido` VARCHAR(60),
	`ci` VARCHAR(20),
	`ruc` VARCHAR(20),
	`dv` VARCHAR(20),
	`rucdv` VARCHAR(20),
	`telefono` VARCHAR(20),
	`telefono2` VARCHAR(20),
	`celular` VARCHAR(20),
	`celular2` VARCHAR(20),
	`email` VARCHAR(60),
	`email2` VARCHAR(60),
	`fax` VARCHAR(60),
	`skype` VARCHAR(20),
	`web` VARCHAR(60),
	`obs` VARCHAR(120),
	`tp_id` INT NOT NULL,
	`ciudad_id` INT NOT NULL,
	`activo` INT,
	`direccion` VARCHAR(120),
	`barrio` VARCHAR(120),
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`marcas` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`impuestos` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(60),
	`abreviatura` VARCHAR(6),
	`porcentaje` DECIMAL(10 , 2),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`horarios` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`entrada1` VARCHAR(5),
	`salida1` VARCHAR(5),
	`entrada2` VARCHAR(5),
	`salida2` VARCHAR(5),
	`entrada3` VARCHAR(5),
	`salida3` VARCHAR(5),
	`entrada4` VARCHAR(5),
	`salida4` VARCHAR(5),
	`tolerancia` VARCHAR(5),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`compras` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`fecha_registro` DATETIME,
	`estado` VARCHAR(20),
	`condicion` VARCHAR(20),
	`fecha_documento` DATE,
	`comprobante_numero` VARCHAR(20),
	`obs` VARCHAR(120),
	`total_exentas` DECIMAL(10 , 2),
	`total_gravada5` DECIMAL(10 , 2),
	`total_gravada10` DECIMAL(10 , 2),
	`total_iva5` DECIMAL(10 , 2),
	`total_iva10` DECIMAL(10 , 2),
	`monto_total` DECIMAL(10 , 2),
	`com_proveedor_id` INT NOT NULL,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`empleados` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`ci` VARCHAR(20),
	`nombre` VARCHAR(45),
	`apellido` VARCHAR(45),
	`direccion` VARCHAR(120),
	`barrio` VARCHAR(120),
	`celular` VARCHAR(20),
	`telefono` VARCHAR(20),
	`fecha_ingreso` DATE,
	`fecha_nacimiento` DATE,
	`activo` INT,
	`email` VARCHAR(45),
	`sexo` INT,
	`hora_extra` INT,
	`tiene_credito` INT,
	`sueldo` DECIMAL(10 , 2),
	`nro_asegurado_ips` VARCHAR(20),
	`cant_hijos` INT,
	`descuento_ips` INT,
	`limite_credito` DECIMAL(10 , 2),
	`obs` VARCHAR(120),
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`grupos` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(60),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`produccion` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`fechaEmision` DATETIME,
	`fechaProduccion` DATETIME,
	`emitido_por` INT,
	`confirmado_por` INT,
	`obs` VARCHAR(120),
	`estado` VARCHAR(45),
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`productos` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`tipo` INT DEFAULT 0 NOT NULL,
	`nombre` VARCHAR(45) NOT NULL,
	`descripcion` VARCHAR(120),
	`activo` INT,
	`umedida_id` INT NOT NULL,
	`marca_id` INT NOT NULL,
	`proveedor_id` INT NOT NULL,
	`grupo_id` INT NOT NULL,
	`impuesto_id` INT NOT NULL,
	`codigo_barra` VARCHAR(60),
	`pcu` DECIMAL(10 , 2),
	`pcp` DECIMAL(10 , 2),
	`ultimaCompra` DATE,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`lotes` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(60),
	`vencimiento` DATE,
	`producto_id` INT NOT NULL,
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`producto_lista_precios` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(120),
	`producto_id` INT NOT NULL,
	`cantidad_minimo` DECIMAL(10 , 2),
	`cantidad_maximo` DECIMAL(10 , 2),
	`precio_minimo` DECIMAL(10 , 2),
	`precio_maximo` DECIMAL(10 , 2),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`formulas` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`descripcion` VARCHAR(120),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`usuarios` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(60),
	`login` VARCHAR(45),
	`clave` VARCHAR(45),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`pedido_detalles` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`pedido_id` INT NOT NULL,
	`producto_id` INT NOT NULL,
	`cantidad` DECIMAL(10 , 2),
	`cantidad_recibido` DECIMAL(10 , 2),
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`cargos` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`descripcion` VARCHAR(120),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`grupos_usu` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`ciudades` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`abreviatura` VARCHAR(3),
	`activo` INT,
	`departamento_id` INT NOT NULL,
	`pais_id` INT NOT NULL,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`departamentos` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`abreviatura` VARCHAR(3),
	`activo` INT,
	`pais_id_dep` INT NOT NULL,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`cheques` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`secuencia` INT,
	`serie` VARCHAR(20),
	`cheque_numero` VARCHAR(20),
	`vencimiento` DATE,
	`monto` DECIMAL(10 , 2),
	`orden` VARCHAR(20),
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`tipo_personas` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`grupos_roles` (
	`role_id` INT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`paises` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`nombre` VARCHAR(45),
	`abreviatura` VARCHAR(3),
	`activo` INT,
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE TABLE `app-erp`.`ventas` (
	`codigo` INT AUTO_INCREMENT NOT NULL,
	`fecha_registro` DATETIME,
	`fecha_documento` DATE,
	`comprobante_numero` VARCHAR(20),
	`condicion` VARCHAR(20),
	`cliente_id` INT NOT NULL,
	`obs` VARCHAR(120),
	`estado` VARCHAR(20),
	`total_exentas` DECIMAL(10 , 2),
	`total_gravada5` DECIMAL(10 , 2),
	`total_gravada10` DECIMAL(10 , 2),
	`total_iva5` DECIMAL(10 , 2),
	`total_iva10` DECIMAL(10 , 2),
	`monto_total` DECIMAL(10 , 2),
	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;

CREATE INDEX `fk_insumos_grupos1` ON `app-erp`.`productos` (`grupo_id` ASC);

CREATE UNIQUE INDEX `codigo_UNIQUE` ON `app-erp`.`unidades_medidas` (`codigo` ASC);

CREATE INDEX `fk_pedido_detalles_pedidos1` ON `app-erp`.`pedido_detalles` (`pedido_id` ASC);

CREATE INDEX `fk_compra_detalles_compras1` ON `app-erp`.`compra_detalles` (`compra_id` ASC);

CREATE INDEX `fk_ciudades_departamentos1` ON `app-erp`.`ciudades` (`departamento_id` ASC);

CREATE INDEX `fk_pedido_detalles_insumos1` ON `app-erp`.`pedido_detalles` (`producto_id` ASC);

CREATE INDEX `fk_produccion_detalles_productos1` ON `app-erp`.`produccion_detalles` (`producto_id` ASC);

CREATE INDEX `fk_venta_detalles_productos1` ON `app-erp`.`venta_detalles` (`producto_id` ASC);

CREATE INDEX `fk_formula_detalles_formulas1` ON `app-erp`.`formula_detalles` (`formula_id` ASC);

CREATE INDEX `fk_pedidos_proveedores1` ON `app-erp`.`pedidos` (`ped_proveedor_id` ASC);

CREATE INDEX `fk_insumos_marcas1` ON `app-erp`.`productos` (`marca_id` ASC);

CREATE INDEX `fk_lotes_insumos1` ON `app-erp`.`lotes` (`producto_id` ASC);

CREATE INDEX `fk_departamentos_paises1` ON `app-erp`.`departamentos` (`pais_id_dep` ASC);

CREATE INDEX `fk_venta_detalles_ventas1` ON `app-erp`.`venta_detalles` (`venta_id` ASC);

CREATE INDEX `fk_ventas_clientes1` ON `app-erp`.`ventas` (`cliente_id` ASC);

CREATE INDEX `fk_insumos_impuestos1` ON `app-erp`.`productos` (`impuesto_id` ASC);

CREATE INDEX `fk_ciudades_paises1` ON `app-erp`.`ciudades` (`pais_id` ASC);

CREATE INDEX `fk_clientes_tipo_personas1` ON `app-erp`.`clientes` (`tp_id` ASC);

CREATE INDEX `fk_insumo_precios_insumos1` ON `app-erp`.`producto_lista_precios` (`producto_id` ASC);

CREATE INDEX `fk_produccion_detalles_produccion1` ON `app-erp`.`produccion_detalles` (`produccion_id` ASC);

CREATE INDEX `fk_clientes_ciudades1` ON `app-erp`.`clientes` (`ciudad_id` ASC);

CREATE INDEX `fk_compra_detalles_insumos1` ON `app-erp`.`compra_detalles` (`producto_id` ASC);

CREATE INDEX `fk_proveedores_ciudades1` ON `app-erp`.`proveedores` (`ciudad_id` ASC);

CREATE INDEX `fk_insumos_proveedores1` ON `app-erp`.`productos` (`proveedor_id` ASC);

CREATE INDEX `fk_roles_usuarios1` ON `app-erp`.`roles` (`usuario_id` ASC);

CREATE INDEX `fk_formula_detalles_productos1` ON `app-erp`.`formula_detalles` (`producto_id` ASC);

CREATE INDEX `fk_insumos_unidades_medidas` ON `app-erp`.`productos` (`umedida_id` ASC);

CREATE INDEX `fk_compras_proveedores1` ON `app-erp`.`compras` (`com_proveedor_id` ASC);

CREATE INDEX `fk_roles_has_grupos_roles1` ON `app-erp`.`grupos_roles` (`role_id` ASC);

