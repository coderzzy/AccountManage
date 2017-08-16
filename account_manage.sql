-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: account_manage
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  `level` int(10) unsigned NOT NULL,
  `over_time` datetime NOT NULL,
  `del` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (16,'account1','account1',2,'2017-02-26 00:00:00',0),(18,'account2','account2',3,'2018-02-21 00:00:00',0),(19,'account9','account9',4,'2018-03-23 00:00:00',0),(20,'account3','account3',3,'2018-05-30 00:00:00',0),(21,'account8','account8',2,'2018-06-21 00:00:00',0),(22,'account4','account4',4,'2018-09-24 00:00:00',0),(23,'account7','account7',2,'2018-08-21 00:00:00',0),(24,'account5','account5',3,'2018-03-21 00:00:00',0),(25,'account6','account6',2,'2018-04-01 00:00:00',0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platform`
--

DROP TABLE IF EXISTS `platform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platform` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `other` char(20) NOT NULL,
  `del` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platform`
--

LOCK TABLES `platform` WRITE;
/*!40000 ALTER TABLE `platform` DISABLE KEYS */;
INSERT INTO `platform` VALUES (7,'爱奇艺','',0),(8,'迅雷','',0),(9,'优酷','',0);
/*!40000 ALTER TABLE `platform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platform_account`
--

DROP TABLE IF EXISTS `platform_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platform_account` (
  `plat_id` int(10) unsigned DEFAULT NULL,
  `account_id` int(10) unsigned DEFAULT NULL,
  `other` char(20) DEFAULT NULL,
  `del` int(11) DEFAULT NULL,
  KEY `plat_id` (`plat_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `platform_account_ibfk_1` FOREIGN KEY (`plat_id`) REFERENCES `platform` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `platform_account_ibfk_2` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platform_account`
--

LOCK TABLES `platform_account` WRITE;
/*!40000 ALTER TABLE `platform_account` DISABLE KEYS */;
INSERT INTO `platform_account` VALUES (7,16,'',0),(8,18,'',0),(9,19,'',0),(7,20,'',0),(8,21,'',0),(8,22,'',0),(9,23,'',0),(8,24,'',0),(9,25,'',0);
/*!40000 ALTER TABLE `platform_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  `mobile` char(20) NOT NULL,
  `email` char(20) NOT NULL,
  `honest_level` int(10) unsigned NOT NULL,
  `del` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test1','test1test1','12345123451','12345@126.com',0,0),(2,'test2','test2test2','23456234562','23456@126.com',0,0),(3,'test3','test3test3','34567345673','34567@126.com',0,0),(4,'test4','test4test4','45678456784','45678@126.com',0,0),(5,'test5','test5test5','56789567895','56789@126.com',0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_account` (
  `user_id` int(10) unsigned DEFAULT NULL,
  `account_id` int(10) unsigned DEFAULT NULL,
  `lend_time` datetime DEFAULT NULL,
  `return_time` datetime DEFAULT NULL,
  `money_hour` float(3,2) DEFAULT NULL,
  `del` int(11) DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `user_account_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_account_ibfk_2` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (1,18,'2016-12-17 11:22:24','2016-12-17 15:50:30',0.25,0),(1,18,'2016-12-17 14:41:23','2016-12-17 15:50:30',0.25,0),(1,21,'2016-12-17 14:42:18','2016-12-17 20:55:42',0.25,0),(1,18,'2016-12-17 15:50:17','2016-12-17 15:50:30',0.25,0),(1,21,'2016-12-17 20:49:33','2016-12-17 20:55:42',0.25,0);
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vip`
--

DROP TABLE IF EXISTS `vip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vip` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  `mobile` char(20) NOT NULL,
  `email` char(20) NOT NULL,
  `del` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vip`
--

LOCK TABLES `vip` WRITE;
/*!40000 ALTER TABLE `vip` DISABLE KEYS */;
INSERT INTO `vip` VALUES (3,'vip1','vip1vip1','12345678901','54321@126.com',0),(4,'vip2','vip2vip2','23456789012','65432@126.com',0),(5,'vip3','vip3vip3','34567890123','876543@126.com',0),(6,'vip4','vip4vip4','45678901234','98765@126.com',0),(7,'vip5','vip5vip5','56789012345','09876@126.com',0);
/*!40000 ALTER TABLE `vip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vip_account`
--

DROP TABLE IF EXISTS `vip_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vip_account` (
  `vip_id` int(10) unsigned DEFAULT NULL,
  `account_id` int(10) unsigned DEFAULT NULL,
  `money_hour` float(3,2) DEFAULT NULL,
  `del` int(11) DEFAULT NULL,
  KEY `vip_id` (`vip_id`),
  KEY `account_id` (`account_id`),
  CONSTRAINT `vip_account_ibfk_1` FOREIGN KEY (`vip_id`) REFERENCES `vip` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vip_account_ibfk_2` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vip_account`
--

LOCK TABLES `vip_account` WRITE;
/*!40000 ALTER TABLE `vip_account` DISABLE KEYS */;
INSERT INTO `vip_account` VALUES (3,16,0.25,0),(4,18,0.25,0),(4,19,0.25,0),(5,20,0.25,0),(5,21,0.25,0),(6,22,0.25,0),(6,23,0.25,0),(7,24,0.25,0),(7,25,0.25,0);
/*!40000 ALTER TABLE `vip_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-17 21:36:03
