-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 22, 2015 at 01:07 AM
-- Server version: 5.5.40-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `resumein`
--

-- --------------------------------------------------------

--
-- Table structure for table `Informations`
--

CREATE TABLE IF NOT EXISTS `Informations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `field_name` varchar(300) DEFAULT NULL,
  `field_value` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Informations_1_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Resumes`
--

CREATE TABLE IF NOT EXISTS `Resumes` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `link` varchar(150) DEFAULT NULL,
  `path` varchar(150) DEFAULT NULL,
  `index` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Resumes_1_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE IF NOT EXISTS `Users` (
  `id` int(11) NOT NULL,
  `token` varchar(200) DEFAULT NULL,
  `expiry_date` timestamp NULL DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`id`, `token`, `expiry_date`, `name`, `last_name`) VALUES
(404930028, 'AQXN7o0s4KFO9ofu-325cn_jPsrwG894BwIKFEcSUeeprI0MDfDJB2ndZRAq1Bp6BJBxOnpSdB_H9QSzLD_UrZknOX7uHaiFCLWAuqxUCh11GXkGH4eNZM0kMCRDmyyAC3Q92mOZTvvm6Fz1_cw12hVEbYTlmXCAlJrwJ1zSym0iEvEuWOI', '2015-03-04 05:37:02', NULL, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Informations`
--
ALTER TABLE `Informations`
  ADD CONSTRAINT `fk_Informations_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Resumes`
--
ALTER TABLE `Resumes`
  ADD CONSTRAINT `fk_Resumes_1` FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;