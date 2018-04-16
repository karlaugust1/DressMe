-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: vsetmanagerdb
-- ------------------------------------------------------
-- Server version	5.7.6-m16-log

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
-- Table structure for table `pedidovenda`
--

DROP TABLE IF EXISTS `pedidovenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidovenda` (
  `numero` bigint(20) NOT NULL,
  `orcamento` tinyint(1) NOT NULL,
  `dataAbertura` datetime NOT NULL,
  `dataFechamento` datetime DEFAULT NULL,
  `cliente` bigint(20) NOT NULL,
  `condPag` int(11) NOT NULL,
  `vendedor` bigint(20) NOT NULL,
  `situacao` tinyint(1) NOT NULL,
  `valorTotal` double NOT NULL,
  `valorSubtotal` double NOT NULL,
  `desconto` double DEFAULT NULL,
  PRIMARY KEY (`numero`),
  KEY `condPag` (`condPag`),
  KEY `cliente` (`cliente`),
  KEY `vendedor` (`vendedor`),
  CONSTRAINT `pedidovenda_ibfk_1` FOREIGN KEY (`condPag`) REFERENCES `condicao_pagamento` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `pedidovenda_ibfk_2` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `pedidovenda_ibfk_3` FOREIGN KEY (`vendedor`) REFERENCES `funcionario` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidovenda`
--

LOCK TABLES `pedidovenda` WRITE;
/*!40000 ALTER TABLE `pedidovenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidovenda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-15 21:34:47
