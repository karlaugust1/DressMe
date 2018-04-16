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
-- Table structure for table `log_faixa_uf`
--

DROP TABLE IF EXISTS `log_faixa_uf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_faixa_uf` (
  `ufe_sg` varchar(2) NOT NULL,
  `ufe_no` varchar(72) NOT NULL,
  `ufe_rad1_ini` varchar(5) NOT NULL,
  `ufe_suf1_ini` varchar(3) NOT NULL,
  `ufe_rad1_fim` varchar(5) NOT NULL,
  `ufe_suf1_fim` varchar(3) NOT NULL,
  `ufe_rad2_ini` varchar(5) DEFAULT NULL,
  `ufe_suf2_ini` varchar(3) DEFAULT NULL,
  `ufe_rad2_fim` varchar(5) DEFAULT NULL,
  `ufe_suf2_fim` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`ufe_sg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_faixa_uf`
--

LOCK TABLES `log_faixa_uf` WRITE;
/*!40000 ALTER TABLE `log_faixa_uf` DISABLE KEYS */;
INSERT INTO `log_faixa_uf` VALUES ('AC','Acre','69900','000','69999','999',NULL,NULL,NULL,NULL),('AL','Alagoas','57000','000','57999','999',NULL,NULL,NULL,NULL),('AM','Amazonas','69000','000','69299','999','69400','000','69899','999'),('AP','Amapá','68900','000','68999','999',NULL,NULL,NULL,NULL),('BA','Bahia','40000','000','48999','999',NULL,NULL,NULL,NULL),('CE','Ceará','60000','000','63999','999',NULL,NULL,NULL,NULL),('DF','Distrito Federal','70000','000','72799','999','73000','000','73699','999'),('ES','Espírito Santo','29000','000','29999','999',NULL,NULL,NULL,NULL),('GO','Goiás','72800','000','72999','999','73700','000','76799','999'),('MA','Maranhão','65000','000','65999','999',NULL,NULL,NULL,NULL),('MG','Minas Gerais','30000','000','39999','999',NULL,NULL,NULL,NULL),('MS','Mato Grosso do Sul','79000','000','79999','999',NULL,NULL,NULL,NULL),('MT','Mato Grosso','78000','000','78899','999',NULL,NULL,NULL,NULL),('PA','Pará','66000','000','68899','999',NULL,NULL,NULL,NULL),('PB','Paraíba','58000','000','58999','999',NULL,NULL,NULL,NULL),('PE','Pernambuco','50000','000','56999','999',NULL,NULL,NULL,NULL),('PI','Piauí','64000','000','64999','999',NULL,NULL,NULL,NULL),('PR','Paraná','80000','000','87999','999',NULL,NULL,NULL,NULL),('RJ','Rio de Janeiro','20000','000','28999','999',NULL,NULL,NULL,NULL),('RN','Rio Grande do Norte','59000','000','59999','999',NULL,NULL,NULL,NULL),('RO','Rondônia','76800','000','76999','999',NULL,NULL,NULL,NULL),('RR','Roraima','69300','000','69399','999',NULL,NULL,NULL,NULL),('RS','Rio Grande do Sul','90000','000','99999','999',NULL,NULL,NULL,NULL),('SC','Santa Catarina','88000','000','89999','999',NULL,NULL,NULL,NULL),('SE','Sergipe','49000','000','49999','999',NULL,NULL,NULL,NULL),('SP','São Paulo','01000','000','19999','999',NULL,NULL,NULL,NULL),('TO','Tocantins','77000','000','77999','999',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `log_faixa_uf` ENABLE KEYS */;
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
