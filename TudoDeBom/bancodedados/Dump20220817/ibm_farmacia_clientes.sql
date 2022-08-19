-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: farmacia-ibm.mysql.database.azure.com    Database: ibm_farmacia
-- ------------------------------------------------------
-- Server version	5.6.47.0

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(80) NOT NULL,
  `email_cliente` varchar(80) DEFAULT NULL,
  `cpf_cliente` varchar(20) NOT NULL,
  `data_nasc` varchar(20) NOT NULL,
  `celular_cliente` varchar(30) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Carmem Oliveira','carmemoliveira@hotmail.com','458.965.458-78','28/02/1978','(89)95687-7856'),(2,'Bruno Azevedo','brunoazevedo@hotmail.com','946.965.258-19','14/08/1982','(53)9887-3156'),(3,'Maria do Amparo','carolinaferreira@hotmail.com','016.765.258-82','01/06/1951','(12)3487-8152'),(4,'Carolina Ferreira Santos','carolinaferreira@hotmail.com','716.845.258-71','23/11/1998','(24)96587-3156'),(5,'José Luis de Andrade','carolinaferreira@hotmail.com','113.955.258-71','18/03/1954','(35)98587-1556'),(6,'Milena Costa Soares','milenasoares@gmail.com','975.652.413-96','26/12/1986','(98)96587-3156'),(7,'Eduardo Silva','eduardo-silva159@hotmail.com','118.471.934-98','07/02/1997','(81)99595-1722'),(8,'Maria Joana Silva','maria@hotmail.com','111.222.333-98','02/05/1998','81-99929963');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-17  0:44:12
