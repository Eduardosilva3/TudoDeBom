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
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estoque` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `nome_produto` varchar(30) NOT NULL,
  `qtd_produto` int(11) NOT NULL,
  `valor_unit` double NOT NULL,
  `generic_value` int(11) NOT NULL,
  `id_grupo` int(11) NOT NULL,
  PRIMARY KEY (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (1,'Dipirona',0,2.99,0,1),(2,'Paracetamol',8,3.99,0,1),(3,'Codeina',1,4,0,1),(4,'Morfinitina',1,2.99,1,2),(5,'Morfina',20,2.99,0,1),(6,'Tramadol',20,2.99,1,1),(7,'Cloridrato',20,2.99,0,2),(8,'Xarelto',20,2.99,0,2),(9,'Dorflex',20,2.99,0,2),(10,'Saxenda',20,2.99,0,5),(11,'Glifage',20,2.99,1,2),(12,'Neosaldina',20,2.99,0,1),(13,'Torsilax',20,2.99,0,2),(14,'Jardiance',20,2.99,0,2),(15,'Novalgina',20,2.99,1,1),(16,'Victoza',20,2.99,1,2),(17,'Aradois',20,2.99,0,2),(18,'Selozok',20,2.99,0,2),(19,'Sal Eno',20,2.99,0,4),(20,'Engov',20,2.99,0,4),(21,'Doralgina',20,2.99,1,1),(22,'Doril',20,2.99,0,2),(23,'Losartana',20,2.99,0,2),(24,'Torsilax',20,2.99,0,2),(25,'Loratadina',20,2.99,1,4),(26,'Centrum',20,2.99,1,5),(27,'Soro Fisiologico',20,2.99,0,2);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-17  0:44:04
