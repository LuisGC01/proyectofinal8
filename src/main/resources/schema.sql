DROP TABLE IF EXISTS secuencia_detalle;
DROP TABLE IF EXISTS magnitud_detalle;
DROP TABLE IF EXISTS magnitud_arreglo;
DROP TABLE IF EXISTS secuencia_medicion;
DROP TABLE IF EXISTS derivada_modelo_matematico;
DROP TABLE IF EXISTS modelo_matematico;
DROP TABLE IF EXISTS arreglo_medicion;
DROP TABLE IF EXISTS imagen;
DROP TABLE IF EXISTS usuario;

/*
     Tabla que contiene la información de los usuarios del sistema.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
CREATE TABLE usuario(
     id_usuario INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
     usu_nombre_usuario VARCHAR(10) NOT NULL,
     usu_password VARCHAR(16) NOT NULL,
     usu_puesto VARCHAR(50) NOT NULL,
     usu_nombre VARCHAR(50) NOT NULL,
     usu_primer_apellido VARCHAR(50) NOT NULL,
     usu_segundo_apellido VARCHAR(50) NULL,
     usu_activo BOOLEAN NOT NULL
) ENGINE=INNODB;

/*
     Tabla que contiene imágenes usadas por el sistema.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
CREATE TABLE imagen(
     id_imagen INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
     img_imagen TEXT NOT NULL,
     img_leyenda VARCHAR(40) NULL,
     img_descripcion TEXT NULL
) ENGINE=INNODB;

/*
     Tabla que contiene la definición de arreglos de medición.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
CREATE TABLE arreglo_medicion(
     id_arreglo_medicion INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
     id_usuario INT NOT NULL,
     id_imagen INT NOT NULL UNIQUE,
     arr_med_titulo VARCHAR(100) NOT NULL,
     arr_med_fecha DATETIME NOT NULL,
     arr_med_version VARCHAR(15) NOT NULL,
     arr_med_descripcion TEXT NOT NULL,
     arr_med_formato_cal_cert TEXT NOT NULL,
     FOREIGN KEY (id_usuario)
     REFERENCES usuario(id_usuario),
     FOREIGN KEY (id_imagen)
     REFERENCES imagen(id_imagen)
) ENGINE=INNODB;

/*
     Tabla que contiene las ecuaciones simbólicas del arreglo de medición.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
CREATE TABLE modelo_matematico(
     id_modelo_matematico INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
     id_arreglo_medicion INT NOT NULL UNIQUE,
     mod_mat_ecuacion TEXT NOT NULL,
     FOREIGN KEY (id_arreglo_medicion)
     REFERENCES arreglo_medicion(id_arreglo_medicion)
) ENGINE=INNODB;

/*
     Tabla que contiene las derivadas parciales de la ecuación matemática del arreglo.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
CREATE TABLE derivada_modelo_matematico(
     id_derivada_modelo_matematico INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
     id_modelo_matematico INT NOT NULL,
     der_mod_mat_derivada_parcial TEXT NOT NULL,
     der_mod_mat_respecto_a VARCHAR(10) NOT NULL,
     FOREIGN KEY (id_modelo_matematico)
     REFERENCES modelo_matematico(id_modelo_matematico)
) ENGINE=INNODB;

/*
     Tabla que contiene las magnitudes que conforman la ecuación del arreglo.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
CREATE TABLE magnitud_arreglo(
     id_magnitud_arreglo INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
     id_modelo_matematico INT NOT NULL,
     mag_arr_magnitud VARCHAR(10) NOT NULL,
     mag_arr_unidad VARCHAR(10) NOT NULL,
     mag_arr_definicion VARCHAR(30) NOT NULL,
     mag_arr_capturar BOOLEAN NOT NULL DEFAULT FALSE,
     mag_arr_repetir BOOLEAN NOT NULL DEFAULT FALSE,
     mag_arr_asociado VARCHAR(10) NULL,
     FOREIGN KEY (id_modelo_matematico)
     REFERENCES modelo_matematico(id_modelo_matematico)
) ENGINE=INNODB;

/*
     Tabla que contiene el detalle de las magnitudes de la ecuación.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
CREATE TABLE magnitud_detalle(
     id_magnitud_detalle INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
     id_magnitud_arreglo INT NOT NULL UNIQUE,
     id_imagen INT NOT NULL UNIQUE,
     mag_det_tipo VARCHAR(15) NOT NULL,
     mag_det_descripcion TEXT NOT NULL,
     mag_det_distribucion VARCHAR(14) NULL,
     mag_det_evaluacion_incertidumbre VARCHAR(19) NULL,
     mag_det_metodo_observacion VARCHAR(19) NULL,
     mag_det_valor DOUBLE,
     FOREIGN KEY (id_magnitud_arreglo)
     REFERENCES magnitud_arreglo(id_magnitud_arreglo),
     FOREIGN KEY (id_imagen)
     REFERENCES imagen(id_imagen)
) ENGINE=INNODB;

/*
     Tabla que contiene las definiciones de la secuencias de medición.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
CREATE TABLE secuencia_medicion(
     id_secuencia_medicion INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
     id_usuario INT NOT NULL,
     sec_med_titulo VARCHAR(100) NOT NULL,
     sec_med_descripcion TEXT NOT NULL,
     sec_med_fecha DATETIME NOT NULL,
     FOREIGN KEY (id_usuario)
     REFERENCES usuario(id_usuario)
) ENGINE=INNODB;

/*
     Tabla que contiene los puntos de las secuencias de medición.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
CREATE TABLE secuencia_detalle(
     id_secuencia_detalle BIGINT UNSIGNED NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
     id_secuencia_medicion INT NOT NULL,
     id_arreglo_medicion INT NULL,
     id_magnitud_arreglo INT NULL,
     sec_det_numero_punto_secuencia INT NOT NULL,
     sec_det_tipo_punto CHAR(1) NOT NULL,
     sec_det_descripcion_punto TEXT NOT NULL,
     sec_det_valor VARCHAR(4) NULL,
     sec_det_barrido_principal VARCHAR(18) NULL,
     sec_det_barrido_secundario VARCHAR(4) NULL,
     sec_det_numero_mediciones SMALLINT NULL,
     sec_det_instrucciones TEXT NULL,
     sec_det_comentarios TEXT NULL,
     sec_det_dialogo_txto TEXT NULL,
     sec_det_dialogo_entrada TEXT NULL,
     sec_det_dialogo_validacion TEXT NULL,
     FOREIGN KEY (id_secuencia_medicion)
     REFERENCES secuencia_medicion(id_secuencia_medicion),
     FOREIGN KEY (id_arreglo_medicion)
     REFERENCES arreglo_medicion(id_arreglo_medicion),
     FOREIGN KEY (id_magnitud_arreglo)
     REFERENCES magnitud_arreglo(id_magnitud_arreglo)
) ENGINE=INNODB;


