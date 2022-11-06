-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: ecommerce
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `ordereditems`
--

DROP TABLE IF EXISTS `ordereditems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordereditems` (
  `userName` varchar(300) DEFAULT NULL,
  `itemName` varchar(300) DEFAULT NULL,
  `totalPaid` int NOT NULL,
  `quantity` int NOT NULL,
  `billNo` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`billNo`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordereditems`
--

LOCK TABLES `ordereditems` WRITE;
/*!40000 ALTER TABLE `ordereditems` DISABLE KEYS */;
INSERT INTO `ordereditems` VALUES ('Pravin','mobiles',25000,1,1),('dh1234','charger',1200,2,2),('dh1234','charger',50,1,3),('dh1234','screengard',50,1,4),('dh1234','selfie stick',50,2,5),('dh1234','watch',50,3,6),('dh1234','mobiles',0,6,7),('dh1234','selfie stick',0,2,8),('dh1234','watch',0,2,9),('dh1234','charger',0,2,10),('dh1234','watch',0,1,11),('dh1234','selfie stick',150,2,12),('dh1234','watch',6000,2,13),('dh1234','mobiles',20000,2,14);
/*!40000 ALTER TABLE `ordereditems` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-06 20:09:49
