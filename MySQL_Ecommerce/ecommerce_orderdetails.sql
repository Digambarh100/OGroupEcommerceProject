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
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetails` (
  `orderId` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(300) DEFAULT NULL,
  `mobileNo` varchar(45) DEFAULT NULL,
  `mailId` varchar(300) DEFAULT NULL,
  `adresss` varchar(600) DEFAULT NULL,
  `pincode` int NOT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
INSERT INTO `orderdetails` VALUES (1,'dh1234','9423559852','dvh@gmail.com','Kolhapur Rajdhani',416114),(2,'dh1234','9898987878','dfgt@gmail.com','pune',415126),(3,'dh1234','7845854548','rvf@gmail.com','Sangli',418457),(4,'dh1234','9012525256','fgh@gmail.com','Pune',415658),(5,'dh1234','9885958585','hgvlf@gmail.com','Jalgoan',415858),(6,'dh1234','9025256554','kjf@gmail.com','London',7845748),(7,'dh1234','8085868485','gfh@gmail.com','Satara',419568),(8,'dh1234','9856235689','rdh@gmail.com','Dhule',415757),(9,'dh1234','8695858989','dgh@gmail.com','Paris',745874),(10,'dh1234','9885451274','dvg@gmail.com','Kini',416112),(11,'dh1234','7417845252','edr@gmail.com','hampi',415258),(12,'dh1234','9878787887','dvy@gmail.com','pune',415784),(13,'dh1234','985652565','dht@hjkkds.com','gunki',41547),(14,'dh1234','985548856','djhhwej.com','pune',458755),(15,'dh1234','56823688','gjlhfyuj.com','pimtu',415698),(16,'dh1234','8889959895','dvh@3456','hji',412584);
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
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
