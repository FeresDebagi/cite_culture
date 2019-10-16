-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 16, 2019 at 07:34 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projet_pi`
--

-- --------------------------------------------------------

--
-- Table structure for table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id_event` int(11) NOT NULL AUTO_INCREMENT,
  `type_event` varchar(255) DEFAULT NULL,
  `description_event` varchar(255) DEFAULT NULL,
  `image_event` varchar(255) DEFAULT NULL,
  `titre_event` varchar(255) DEFAULT NULL,
  `date_event` date DEFAULT NULL,
  `heure_event` time DEFAULT NULL,
  `prix_event` int(11) DEFAULT NULL,
  `salle_event` varchar(255) DEFAULT NULL,
  `user_name_event` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_event`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `formation`
--

DROP TABLE IF EXISTS `formation`;
CREATE TABLE IF NOT EXISTS `formation` (
  `id_formation` int(11) NOT NULL AUTO_INCREMENT,
  `formateur_formation` varchar(255) DEFAULT NULL,
  `classe_formation` varchar(255) DEFAULT NULL,
  `prix_formation` float DEFAULT NULL,
  `type_formation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_formation`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `historique`
--

DROP TABLE IF EXISTS `historique`;
CREATE TABLE IF NOT EXISTS `historique` (
  `id_historique` int(11) NOT NULL AUTO_INCREMENT,
  `description_his` varchar(255) DEFAULT NULL,
  `image_his` varchar(255) DEFAULT NULL,
  `video_his` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_historique`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id_reservation` int(11) NOT NULL AUTO_INCREMENT,
  `id_salle` int(11) DEFAULT NULL,
  `id_evenement` int(11) DEFAULT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `image_reservation` varchar(255) DEFAULT NULL,
  `titre_reservation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_reservation`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id_salle` int(11) NOT NULL AUTO_INCREMENT,
  `num_salle` int(11) DEFAULT NULL,
  `capacite_salle` int(11) DEFAULT NULL,
  `type_salle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_salle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `speaker`
--

DROP TABLE IF EXISTS `speaker`;
CREATE TABLE IF NOT EXISTS `speaker` (
  `id_speaker` int(11) NOT NULL,
  `nom_speaker` varchar(255) DEFAULT NULL,
  `prenom_speaker` varchar(255) DEFAULT NULL,
  `mail_speaker` varchar(255) DEFAULT NULL,
  `date_arrive` varchar(255) DEFAULT NULL,
  `date_depart` varchar(255) DEFAULT NULL,
  `description_speaker` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stand`
--

DROP TABLE IF EXISTS `stand`;
CREATE TABLE IF NOT EXISTS `stand` (
  `id_stand` int(11) NOT NULL AUTO_INCREMENT,
  `titre_stand` varchar(255) NOT NULL,
  `proprietaire_stand` varchar(255) NOT NULL,
  `type_marchandise` varchar(255) NOT NULL,
  `date_debut_stand` varchar(255) NOT NULL,
  `date_fin_stand` varchar(255) NOT NULL,
  PRIMARY KEY (`id_stand`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `login_user` varchar(255) DEFAULT NULL,
  `mdp_user` varchar(255) DEFAULT NULL,
  `mail_user` varchar(255) DEFAULT NULL,
  `prenom_user` varchar(255) DEFAULT NULL,
  `nom_user` varchar(255) DEFAULT NULL,
  `cin_user` int(11) DEFAULT NULL,
  `date_naissance_user` varchar(255) DEFAULT NULL,
  `num_tel_user` int(11) DEFAULT NULL,
  `photo_profil_user` varchar(255) DEFAULT NULL,
  `role_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
