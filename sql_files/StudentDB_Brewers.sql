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
-- Table structure for table `Brewers`
--
-- USE beersDB;

DROP TABLE IF EXISTS `Brewers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Brewers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `ZipCode` varchar(6) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Turnover` int(11) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Brewers`
--

LOCK TABLES `Brewers` WRITE;
/*!40000 ALTER TABLE `Brewers` DISABLE KEYS */;
INSERT INTO `Brewers` VALUES (1,'Achouffe','Route du Village 32','6666','Achouffe-Wibrin',10000),(2,'Alken','Stationstraat 2','3570','Alken',950000),(3,'Ambly','Rue Principale 45','6953','Ambly-Nassogne',500),(4,'Anker','Guido Gezellelaan 49','2800','Mechelen',3000),(6,'Artois','Vaartstraat 94','3000','Leuven',4000000),(8,'Bavik','Rijksweg 33','8531','Bavikhove',110000),(9,'Belle Vue - Molenbeek','Henegouwenkaai 33','1080','Sint-Jans-Molenbeek',0),(10,'Belle Vue - Zuun','Steenweg naar Bergen','1600','Sint- Pieters-Leeuw',0),(11,'Belle Vue','Delaunoy-straat 58-60','1080','Sint-Jans-Molenbeek',300000),(12,'Bie (De)','Stoppelweg 26','8978','Watou',280),(13,'Binchoise','Faubourg St. Paul 38','7130','Binche',700),(14,'Bios','Lindenlaan 25','9940','Ertvelde',40000),(15,'Blaugies','Rue de la Frontiere 435','7370','Blaugies',280),(17,'Bocq','Rue de la Brasserie 4','5530','Purnode',60000),(18,'Boelens','Kerkstraat 7','9111','Belsele',300),(19,'Boon','Fonteinstraat 65','1502','Lembeek',2350),(20,'Bosteels','Kerkstraat 92','9255','Buggenhout',50000),(21,'Brunehaut','Rue des Panneries 17','7623','Brunehaut',3800),(22,'Cantillon','Gheudestraat 56','1070','Anderlecht',850),(23,'Caracole','Cote Marie-Therese 86','5500','Falmignoul',350),(24,'Caulier','Rue Sondeveille 134','7600','Peruwelz',1500),(25,'Chimay','Rue de la Trappe 294','6464','Forges-les-Chimay',100000),(26,'Clarysse','Krekelput 16-18','9700','Oudenaarde',15000),(27,'Cnudde','Fabriekstraat 8','9700','Eine',0),(28,'Contreras','Molenstraat 115','9890','Gavere',2000),(29,'Crombe','Hospitaalstraat 10','9620','Zottegem',1000),(30,'Deca','Elverdingestraat 4','8640','Woesten-Vleteren',10000),(32,'Dolle Brewers','Roeselarestraat 12b','8600','Esen- Diksmuide',1200),(33,'Domus','Tiensestraat 8','3000','Leuven',1000),(34,'Dool','Eikendreef 21','3530','Helchteren',1500),(35,'Drie Fonteinen','H. Teirlinckplein 3','1650','Beersel',180),(36,'Dubuisson','Chaussee de Mons 28','7904','Pipaix',15840),(37,'Dupont','Rue Basse 5','7904','Tourpes-Leuze',6000),(38,'Duwac','Rue des Rossignols 20','7700','Mouscron',900),(39,'Duysters','Michel Theysstraat 58 a','3290','Diest',0),(40,'Ellezelloise','Guinaumont 75','7890','Ellezelles',1000),(41,'Eupener','Paveestrasse 12-14','4700','Eupen',20000),(42,'Eylenbosch - Maes','Ninoofsesteenweg 5','1703','Schepdaal',12000),(43,'Facon','Kwabrugstraat 27','8510','Bellegem',8000),(44,'Fantome','Rue Preal 8','6997','Soy',900),(45,'Ferme au Chene','Rue Comte d\'Ursel 36','6940','Durbuy',100),(46,'Friart','Rue d\' Houdeng 20','7070','Le Roeulx',18000),(47,'Gaverhopke','Steenbrugstraat 187','8530','Harelbeke- Stasegem',800),(48,'Gigi','Grand rue 96','6769','Gerouville',4000),(49,'Girardin','Lindenberg 10','1700','Sint-Ulriks-Kapelle',3900),(50,'Gouden Boom','Langestraat 45','8000','Brugge',20000),(51,'Haacht','Provinciesteenweg 28','3190','Boortmeerbeek',1100000),(53,'Hanssens','Vroenenbosstraat 15','1653','Dworp',500),(54,'Hopduvel','Coupure links 625','9000','Gent',550),(55,'Hopperd','Matestraat 7','2230','Ramsel',0),(56,'Huyghe','Brusselsesteenweg 282','9090','Melle',50000),(57,'John Martin','Rue du Cerf 191','1332','Genval',0),(58,'Jupiler','Rue de Vise 243','4020','Jupille-sur-Meuse',2200000),(59,'K.I.H.O.','Gebroeders de Smetstraat 1','9000','Gent',0),(60,'Keersmaeker (De)','Lierput 1','1730','Kobbegem',60000),(62,'Koninck - Antwerpen (De)','Mechelsesteenweg 291','2018','Antwerpen',140000),(64,'Lefebvre','Rue de Croly 54','1430','Quenast',15000),(65,'Leroy','Diksmuideseweg 406','8904','Boezinge',32000),(66,'Liefmans','Aalststraat 200','9700','Oudenaarde',10000),(67,'Lindemans','Lenniksebaan 1479','1602','Vlezenbeek',19000),(68,'Louwaege','Markt 14','8610','Kortemark',22000),(69,'Maes','Waarloosveld 10','2550','Waarloos',1150000),(70,'Martens','Reppelerweg 1','3950','Bocholt',600000),(71,'Meesters','Hoogstraat 50','1570','Galmaarden',160),(72,'Mibrana','Place de la station 2','5000','Namur',380),(73,'Miroir','Koningin Astridplein 24-26','1090','Jette',100),(74,'Moortgat','Breendonkdorp 58','2870','Breendonk-Puurs',250000),(75,'Old Bailey','Kerkplein 5','8880','St.-Eloois-Winkel',1200),(76,'Oleye','Rue d\'Elmette 39','4300','Oleye-Waremme',200),(78,'Orval','Orval 2','6823','Villers-devant-Orval',37000),(79,'Paeleman','Boekakker 1','9230','Wetteren',350),(80,'Pakhuis','Vlaamse kaai 76','2000','Antwerpen',1200),(81,'Palm','Steenhuffeldorp 3','1840','Steenhuffel',530000),(82,'Pater Van Damme','Jacob Van Maerlantstraat 2','8340','Damme',7),(83,'Praile','Rue de la Praile 3','7120','Peissant',24),(84,'Proefbrouwerij','Smalle Heerweg 78','9080','Lochristi',500),(85,'Ranke','Brugstraat 43','8560','Wevelgem',100),(86,'Regenboog','Astridlaan 134','8310','Assebroek-Brugge',0),(87,'Riva','Wontergemstraat 42','8720','Dentergem',115000),(88,'Roberg','Rodebergstraat 46','8954','Westouter',1000),(89,'Rochefort','Rue de l\'abbaye 8','5580','Rochefort',15000),(90,'Rochefortoise','Rue du Treux 43b','5580','Eprave',0),(91,'Rocs','Chaussee Brunehaut 37','7387','Montignies-sur-Roc',500),(92,'Rodenbach','Spanjestraat 133','8800','Roeselare',150000),(93,'Roman','Hauwaert 61','9700','Oudenaarde-Mater',100000),(94,'Ruwet','Rue Victor Besme 27','4800','Verviers',100),(95,'Ryck (De)','Kerkstraat 28','9550','Herzele',6000),(96,'Schuur','Gobbelsrode 75','3220','Kortrijk-Dutsel',0),(97,'Silenrieux','Rue Noupre 1','5630','Silenrieux',500),(98,'Silly','Ville Basse A 141','7830','Silly',12000),(99,'Slaghmuylder','Denderhoutembaan 2','9400','Ninove',6500),(100,'Smedt (De)','Ringlaan 18','1745','Opwijk',50000),(101,'St. Bernardus','Trappistenweg 23','8978','Watou',13000),(102,'St. Guibert','Rue de Riquau 1','1435','Mont-Saint-Guibert',350000),(103,'St. Jozef','Itterplein 19','3960','Opitter',65000),(104,'Steedje','Schoolstraat 45b','8460','Ettelgem',1000),(105,'Sterkens','Meerdorp 20','2321','Meer',8613),(106,'Straffe Hendrik','Walplein 26','8000','Brugge',5800),(107,'Strubbe','Markt 1','8480','Ichtegem',20000),(108,'Timmermans','Kerkstraat 11','1701','Itterbeek',10000),(109,'Tour','Rue Chera 9','4180','Comblain-la-Tour',240),(110,'Troch (De)','Langestraat 20','1741','Ternat-Wambeek',3500),(111,'Union','Rue Derbeque 7','6040','Jumet',200000),(112,'Van Den Bossche','Sint-Lievensplein 16','9550','Sint- Lievens-Esse',1700),(113,'Van Eecke','Douvieweg 2','8978','Watou',10000),(114,'Van Honsebrouck','Oostrozebekestraat 43','8770','Ingelmunster',80000),(115,'Vander Linden','Brouwerijstraat 2','1500','Halle',2000),(116,'Vandervelden Henri','Laarheidestraat 230','1650','Beersel',500),(117,'Vapeur','Rue de Marechal 1','7904','Pipaix-Leuze',1000),(118,'Verhaeghe','Beukenhofstraat 96','8570','Vichte',7200),(119,'Vervifontaine','xxx','0','fontaine-Jalhay',0),(120,'Villers','Liezeledorp 37','2870','Liezele-Puurs',1450),(121,'Walrave','Lepelstraat 36','9270','Laarne',2500),(122,'Weldebroec','Mechelse Steenweg 53','2830','Willebroek',800),(123,'Westmalle','Antwerpsesteenweg 496','2390','Malle',125000),(124,'Westvleteren','Donkerstraat 12','8640','Westvleteren',4000),(125,'Wieze','Nieuwstraat 1','9280','Wieze',120000),(126,'Zwingel','Damweg 6','8530','Harelbeke',250);
/*!40000 ALTER TABLE `Brewers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-07 11:18:31
