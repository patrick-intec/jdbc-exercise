-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: noelvaes.eu    Database: StudentDB
-- ------------------------------------------------------
-- Server version	5.1.73

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Categories`
--
-- USE beersDB;

DROP TABLE IF EXISTS `Categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Categories` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Category` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categories`
--

LOCK TABLES `Categories` WRITE;
/*!40000 ALTER TABLE `Categories` DISABLE KEYS */;
INSERT INTO `Categories` VALUES (2,'Alcoholarm'),(3,'Alcoholvrij'),(4,'Ale'),(5,'Alt'),(6,'Amber'),(8,'Bierette'),(11,'Bitter'),(12,'Donkerbok'),(13,'Dort'),(14,'Dubbel Donker'),(15,'Edelbier'),(18,'Extra'),(19,'Faro'),(21,'Gerstewijn'),(22,'Geuze'),(25,'Helderbok'),(26,'IJsbier'),(31,'Lambik'),(33,'Lichtblond'),(34,'Light'),(35,'Mars'),(36,'Massieve Ale'),(42,'Pils'),(44,'Rookbier'),(45,'Saison'),(46,'Scotch'),(49,'Stout'),(51,'Tafelbier'),(53,'Tarwebier of witbier'),(54,'Traditionele Faro'),(55,'Traditionele Geuze'),(56,'Traditionele Lambik'),(59,'Tripel'),(60,'Versnijbier'),(61,'Vlaams Bruin'),(62,'Vlaams Rood'),(64,'West-Vlaamse Geuze'),(65,'West-Vlaamse spontane Geuze');
/*!40000 ALTER TABLE `Categories` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-07 11:18:33
