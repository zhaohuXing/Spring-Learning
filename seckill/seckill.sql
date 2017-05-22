-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: seckill
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

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
-- Table structure for table `mytime`
--

DROP TABLE IF EXISTS `mytime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mytime` (
  `id` int(11) DEFAULT NULL,
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mytime`
--

LOCK TABLES `mytime` WRITE;
/*!40000 ALTER TABLE `mytime` DISABLE KEYS */;
/*!40000 ALTER TABLE `mytime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seckill`
--

DROP TABLE IF EXISTS `seckill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seckill` (
  `seckill_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '商品库存',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀开始时间',
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀开始时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`),
  KEY `idx_start_time` (`start_time`),
  KEY `idx_end_time` (`end_time`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seckill`
--

LOCK TABLES `seckill` WRITE;
/*!40000 ALTER TABLE `seckill` DISABLE KEYS */;
INSERT INTO `seckill` VALUES (1,'1000元秒杀MacPro',52,'2017-05-13 16:00:00','2017-05-17 16:00:00','2017-05-09 14:18:17'),(2,'300元秒杀Iphone7',199,'2017-05-09 16:00:00','2017-05-17 16:00:00','2017-05-09 14:18:17'),(3,'200元秒杀小米6',99,'2017-05-09 16:00:00','2017-05-17 16:00:00','2017-05-09 14:18:17'),(4,'100元秒杀OPPO R9 Plus',49,'2017-05-09 16:00:00','2017-05-17 16:00:00','2017-05-09 14:18:17');
/*!40000 ALTER TABLE `seckill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `success_seckill`
--

DROP TABLE IF EXISTS `success_seckill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `success_seckill` (
  `seckill_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  `user_phone` bigint(20) NOT NULL COMMENT '用户手机号',
  `state` tinyint(4) NOT NULL DEFAULT '-1' COMMENT '状态标识,',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`,`user_phone`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `success_seckill`
--

LOCK TABLES `success_seckill` WRITE;
/*!40000 ALTER TABLE `success_seckill` DISABLE KEYS */;
INSERT INTO `success_seckill` VALUES (1,15589517517,-1,'2017-05-10 08:22:54'),(2,17862822537,-1,'2017-05-13 02:38:51'),(3,17862822537,-1,'2017-05-13 02:39:12'),(4,17862822537,-1,'2017-05-13 02:39:18');
/*!40000 ALTER TABLE `success_seckill` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-22 16:13:56
