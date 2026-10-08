-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: entidades
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `domicilio`
--

DROP TABLE IF EXISTS `domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domicilio` (
  `id_domicilio` int NOT NULL AUTO_INCREMENT,
  `calle` varchar(100) DEFAULT NULL,
  `numero` varchar(20) DEFAULT NULL,
  `colonia` varchar(100) DEFAULT NULL,
  `municipio` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `codigo_postal` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_domicilio`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
INSERT INTO `domicilio` VALUES (1,'Calle Morelos','15','Centro','Nezahualcoyotl','Estado de Mexico','57000'),(2,'Avenida Mexico','120','Benito Juarez','Nezahualcoyotl','Estado de Mexico','57100'),(3,'Calle Hidalgo','45','Las Flores','Chimalhuacan','Estado de Mexico','56330'),(4,'Avenida Central','200','La Esperanza','Ecatepec','Estado de Mexico','55000'),(5,'Calle Reforma','78','Roma','Ciudad de Mexico','CDMX','06700'),(6,'Calle Juarez','34','San Miguel','Ixtapaluca','Estado de Mexico','56530'),(7,'Avenida Texcoco','156','El Sol','Nezahualcoyotl','Estado de Mexico','57200'),(8,'Calle Independencia','89','San Lorenzo','Chimalhuacan','Estado de Mexico','56340'),(9,'Calle Morelos','230','Centro','Texcoco','Estado de Mexico','56100'),(10,'Avenida Zaragoza','67','La Paz','La Paz','Estado de Mexico','56400'),(11,'Av. Reforma','456','Centro Actualizado','Nezahualcoyotl','Estado de Mexico','57000');
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id_persona` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido_paterno` varchar(50) DEFAULT NULL,
  `apellido_materno` varchar(50) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `id_domicilio` int DEFAULT NULL,
  PRIMARY KEY (`id_persona`),
  KEY `fk_persona_domicilio` (`id_domicilio`),
  CONSTRAINT `fk_persona_domicilio` FOREIGN KEY (`id_domicilio`) REFERENCES `domicilio` (`id_domicilio`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Juan','Perez','Garcia','5511111111','juan@gmail.com',1),(2,'Maria','Lopez','Hernandez','5522222222','maria@gmail.com',2),(3,'Carlos','Ramirez','Torres','5533333333','carlos@gmail.com',3),(4,'Ana','Martinez','Sanchez','5544444444','ana@gmail.com',4),(5,'Luis','Gonzalez','Morales','5555555555','luis@gmail.com',5),(6,'Laura','Hernandez','Vega','5566666666','laura@gmail.com',6),(7,'Miguel','Torres','Castillo','5577777777','miguel@gmail.com',7),(8,'Sofia','Ramirez','Flores','5588888888','sofia@gmail.com',8),(9,'Diego','Morales','Cruz','5599999999','diego@gmail.com',9),(10,'Elena','Castillo','Ruiz','5500000000','elena@gmail.com',10),(11,'Victor Manuel','Bautista','Manuel','5511111111','victor@correo.com',11);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(50) DEFAULT NULL,
  `contrasena` varchar(100) DEFAULT NULL,
  `id_persona` int DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_usuario_persona` (`id_persona`),
  CONSTRAINT `fk_usuario_persona` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'juan123','12345',1),(2,'maria123','12345',2),(3,'carlos123','12345',3),(4,'ana123','12345',4),(5,'luis123','12345',5),(6,'laura123','12345',6),(7,'miguel123','12345',7),(8,'sofia123','12345',8),(9,'diego123','12345',9),(10,'elena123','12345',10),(11,'fatyma','123456',11),(13,'FATYMA','12345',11);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-08  0:18:36
