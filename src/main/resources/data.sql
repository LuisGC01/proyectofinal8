

/*
     INSERT’s para la tabla usuario.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
INSERT INTO usuario(usu_nombre_usuario,usu_password,usu_puesto,usu_nombre,usu_primer_apellido,usu_segundo_apellido,usu_activo) VALUES 
('LUIS','123456789','supervisor','Luis','Garcia','Cervantes',TRUE),
('WALTER','987654321','Director','Walter','Louis','Buehler',TRUE),
('ROGELIO','123451234','supervisor','Rogelio','Reyes','Atristain',TRUE),
('RENE','987698754','Tecnico','Rene','Herrera','Ferrara',TRUE),
('UZAY','654321789','Tecnico','Uzay','Torrez',NULL,FALSE);

/*
     INSERT’s para la tabla imagen.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
INSERT INTO imagen(img_imagen,img_leyenda,img_descripcion) VALUES 
('../imagenes/arreglos/arreglo1.jpg','Arreglo 1','Descripcion de la imagen general del arreglo 1'),
('../imagenes/magnitudes/aceleracion/acelracion1.jpg','Aceleracion','Imagen ilustrativa de una acelracion'),
('../imagenes/magnitudes/masa/masa1.jpg','Masa','Imagen ilustrativa de una masa'),
('../imagenes/arreglos/arreglo2.jpg','Arreglo 2','Descripcion de la imagen general del arreglo 2'),
('../imagenes/magnitudes/volumen/volumen1.jpg','Volumen','Imagen ilustrativa de un volumen'),
('../imagenes/magnitudes/densidad/densidad1.jpg','Densidad','Imagen ilustrativa de una densidad'),
('../imagenes/magnitudes/aceleracion/gravedad.jpg','Aceleracion de gravedad','Imagen ilustrativa de la gravedad');

/*
     INSERT’s para la tabla arreglo_medicion.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
INSERT INTO arreglo_medicion(id_usuario, id_imagen, arr_med_titulo, arr_med_fecha, arr_med_version, arr_med_descripcion, arr_med_formato_cal_cert) VALUES
(1,1,'Arreglo 1',now(),'1.0.0','Descripcion del Arreglo 1','../formatos_certificados/certificado_arreglo1.pdf'),
(3,4,'Arreglo 2',now(),'1.0.0','Descripcion del Arreglo 2','../formatos_certificados/certificado_arreglo2.pdf');

/*
     INSERT’s para la tabla modelo_matematico.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
INSERT INTO modelo_matematico(id_arreglo_medicion,mod_mat_ecuacion) VALUES 
(1,'F=m*a'),
(2,'E=ro*g*v');

/*
     INSERT’s para la tabla derivada_modelo_matematico.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
INSERT INTO derivada_modelo_matematico(id_modelo_matematico,der_mod_mat_derivada_parcial,der_mod_mat_respecto_a) VALUES 
(1,'m','a'),
(1,'a','m'),
(2,'g*ro','v'),
(2,'g*v','ro'),
(2,'ro*v','g');

/*
     INSERT’s para la tabla magnitud_arreglo.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
INSERT INTO magnitud_arreglo(id_modelo_matematico,mag_arr_magnitud,mag_arr_unidad,mag_arr_definicion,mag_arr_capturar,mag_arr_repetir,mag_arr_asociado) VALUES 
(1,'F','N','Fuerza resultante',FALSE,FALSE,NULL),
(1,'a','m/s^2','Aceleracion',TRUE,FALSE,NULL),
(1,'m','Kg','Masa',TRUE,TRUE,NULL),
(2,'E','N','Empuje',FALSE,FALSE,NULL),
(2,'v','m^3','volumen del liquido',TRUE,TRUE,NULL),
(2,'ro','Kg/m^3','densidad',TRUE,TRUE,NULL),
(2,'g','m/s^2','sceleracion de la gravedad',TRUE,FALSE,NULL);

/*
     INSERT’s para la tabla magnitud_detalle.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
INSERT INTO magnitud_detalle(id_magnitud_arreglo,id_imagen,mag_det_tipo,mag_det_descripcion,mag_det_distribucion,mag_det_evaluacion_incertidumbre,mag_det_metodo_observacion,mag_det_valor) VALUES 
(2,2,'Tipo A','Magnitud del tipo A','Normal','Bayesiano Agrupado','Directa',NULL),
(3,3,'Tipo A Resumida','Magnitud del tipo A Resumida','Normal','Bayesiano',NULL,NULL),
(5,5,'Tipo B','Magnitud del tipo B','Normal',NULL,NULL,NULL),
(6,6,'Tipo B','Magnitud del tipo B','Triangular',NULL,NULL,NULL),
(7,7,'Tipo Constante','Magnitud del tipo Constante',NULL,NULL,NULL,9.81);

/*
     INSERT’s para la tabla secuencia_medicion.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
INSERT INTO secuencia_medicion(id_usuario,sec_med_titulo,sec_med_descripcion,sec_med_fecha) values 
(1,'Titulo secuencia 1','Descripcion de la secuencia de medicion 1',now()),
(1,'Titulo secuencia 2','Descripcion de la secuencia de medicion 2',now());

/*
     INSERT’s para la tabla secuencia_detalle.
     @author   Luis Angel Garcia Cervantes
     @creationDate       20211108
     @lastModification   20211108
*/
INSERT INTO secuencia_detalle(id_secuencia_medicion,id_arreglo_medicion,id_magnitud_arreglo,sec_det_numero_punto_secuencia,sec_det_tipo_punto,sec_det_descripcion_punto,sec_det_valor,sec_det_barrido_principal,sec_det_barrido_secundario,sec_det_numero_mediciones,sec_det_instrucciones,sec_det_comentarios,sec_det_dialogo_txto,sec_det_dialogo_entrada,sec_det_dialogo_validacion) VALUES 
(1,NULL,NULL,1,'D','descripcion d1',NULL,NULL,NULL,NULL,NULL,NULL,'texto d1','entrada d1','validacion d1'),
(1,1,2,2,'D','descripcion d2',NULL,NULL,NULL,NULL,NULL,NULL,'texto d2','entrada d2','validacion d2'),
(1,1,3,3,'D','descripcion d3',NULL,NULL,NULL,NULL,NULL,NULL,'texto d3','entrada d3','validacion d3'),
(1,1,NULL,4,'C','descripcion c1','0','Ascendente°','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(1,1,NULL,5,'C','descripcion c1','33','Ascendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(1,1,NULL,6,'C','descripcion c1','67','Ascendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(1,1,NULL,7,'C','descripcion c1','100','Ascendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(1,1,NULL,8,'C','descripcion c1','0','Ascendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(1,1,NULL,9,'C','descripcion c1','33','Ascendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(1,1,NULL,10,'C','descripcion c1','67','Ascendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(1,1,NULL,11,'C','descripcion c1','100','Ascendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(1,1,NULL,12,'C','descripcion c1','0','Ascendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(1,1,NULL,13,'C','descripcion c1','33','Ascendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(1,1,NULL,14,'C','descripcion c1','67','Ascendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(1,1,NULL,15,'C','descripcion c1','100','Ascendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),						
(1,1,NULL,16,'S','descripcion s1','0','Ascendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,17,'S','descripcion s1','25','Ascendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,18,'S','descripcion s1','50','Ascendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,19,'S','descripcion s1','75','Ascendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,20,'S','descripcion s1','100','Ascendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,21,'S','descripcion s1','100','Descendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,22,'S','descripcion s1','75','Descendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,23,'S','descripcion s1','50','Descendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,24,'S','descripcion s1','25','Descendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,25,'S','descripcion s1','0','Descendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,26,'S','descripcion s1','0','Ascendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,27,'S','descripcion s1','25','Ascendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,28,'S','descripcion s1','50','Ascendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,29,'S','descripcion s1','75','Ascendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(1,1,NULL,30,'S','descripcion s1','100','Ascendente','0°',2,'instrucciones s1','comentarios s1',NULL,NULL,NULL),
(2,NULL,NULL,1,'D','descripcion d1',NULL,NULL,NULL,NULL,NULL,NULL,'texto d1','entrada d1','validacion d1'),
(2,2,2,2,'D','descripcion d2',NULL,NULL,NULL,NULL,NULL,NULL,'texto d2','entrada d2','validacion d2'),
(2,2,3,3,'D','descripcion d3',NULL,NULL,NULL,NULL,NULL,NULL,'texto d3','entrada d3','validacion d3'),
(2,2,4,4,'D','descripcion d4',NULL,NULL,NULL,NULL,NULL,NULL,'texto d4','entrada d4','validacion d4'),
(2,2,NULL,5,'C','descripcion c1','100','Descendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(2,2,NULL,6,'C','descripcion c1','50','Descendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(2,2,NULL,7,'C','descripcion c1','0','Descendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(2,2,NULL,8,'C','descripcion c1','100','Descendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(2,2,NULL,9,'C','descripcion c1','50','Descendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(2,2,NULL,10,'C','descripcion c1','0','Descendente','0°',NULL,'instrucciones c1','comentarios c1',NULL,NULL,NULL),
(2,2,NULL,11,'I','descripcion I1','S','S.U.U.S',NULL,NULL,'instrucciones I1','comentarios I1',NULL,NULL,NULL),
(2,2,NULL,12,'I','descripcion I1','U','S.U.U.S',NULL,NULL,'instrucciones I1','comentarios I1',NULL,NULL,NULL),
(2,2,NULL,13,'I','descripcion I1','U','S.U.U.S',NULL,NULL,'instrucciones I1','comentarios I1',NULL,NULL,NULL),
(2,2,NULL,14,'I','descripcion I1','S','S.U.U.S',NULL,NULL,'instrucciones I1','comentarios I1',NULL,NULL,NULL),
(2,2,NULL,15,'I','descripcion I1','S','S.U.U.S',NULL,NULL,'instrucciones I1','comentarios I1',NULL,NULL,NULL),
(2,2,NULL,16,'I','descripcion I1','U','S.U.U.S',NULL,NULL,'instrucciones I1','comentarios I1',NULL,NULL,NULL),
(2,2,NULL,17,'I','descripcion I1','U','S.U.U.S',NULL,NULL,'instrucciones I1','comentarios I1',NULL,NULL,NULL),
(2,2,NULL,18,'I','descripcion I1','S','S.U.U.S',NULL,NULL,'instrucciones I1','comentarios I1',NULL,NULL,NULL),
(2,2,NULL,19,'I','descripcion I1','S','S.U.U.S',NULL,NULL,'instrucciones I1','comentarios I1',NULL,NULL,NULL),
(2,2,NULL,20,'I','descripcion I1','U','S.U.U.S',NULL,NULL,'instrucciones I1','comentarios I1',NULL,NULL,NULL),
(2,2,NULL,21,'I','descripcion I1','U','S.U.U.S',NULL,NULL,'instrucciones I1','comentarios I1',NULL,NULL,NULL),
(2,2,NULL,22,'I','descripcion I1','S','S.U.U.S',NULL,NULL,'instrucciones I1','comentarios I1',NULL,NULL,NULL);

