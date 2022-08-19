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
-- Table structure for table `historico_transacoes`
--

DROP TABLE IF EXISTS `historico_transacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico_transacoes` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `historico_cpf` varchar(50) NOT NULL,
  `valor_total` varchar(20) NOT NULL,
  `data_compra` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_transacoes`
--

LOCK TABLES `historico_transacoes` WRITE;
/*!40000 ALTER TABLE `historico_transacoes` DISABLE KEYS */;
INSERT INTO `historico_transacoes` VALUES (27,'118.471.934-98','3,99','2022/08/16 20:40:02'),(28,'118.471.934-98','2,99','2022/08/16 21:07:07'),(29,'118.471.934-98','11,99','2022/08/16 18:11:05'),(30,'118.471.934-98','7,99','2022/08/16 18:22:36'),(31,'946.965.258-19','25,57','2022/08/16 18:40:30');
/*!40000 ALTER TABLE `historico_transacoes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-17  0:44:15
