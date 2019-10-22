-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 22, 2019 at 02:17 PM
-- Server version: 5.7.26
-- PHP Version: 5.6.40

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
  `date_event` varchar(255) DEFAULT NULL,
  `heure_event` varchar(255) DEFAULT NULL,
  `prix_event` int(11) DEFAULT NULL,
  `salle_event` varchar(255) DEFAULT NULL,
  `user_name_event` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_event`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evenement`
--

INSERT INTO `evenement` (`id_event`, `type_event`, `description_event`, `image_event`, `titre_event`, `date_event`, `heure_event`, `prix_event`, `salle_event`, `user_name_event`) VALUES
(5, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(2, 'test2', 'test2', 'test2', 'test2', 'test2', 'test2', 2, 'test2', 'test2'),
(3, 'i m a god', 'test2', 'test2', 'test2', 'test2', 'test2', 2, 'test2', 'test2'),
(4, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(6, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(7, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(8, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(9, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(10, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(11, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(12, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(13, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(14, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(15, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(16, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(17, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(18, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(19, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(20, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(21, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(22, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(23, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(24, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(25, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979'),
(26, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 9797979, 'test97979', 'test97979');

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
  `date_debut` varchar(255) DEFAULT NULL,
  `date_fin` varchar(255) DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `image_reservation` varchar(255) DEFAULT NULL,
  `titre_reservation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_reservation`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `id_salle`, `id_evenement`, `date_debut`, `date_fin`, `etat`, `description`, `mail`, `tel`, `image_reservation`, `titre_reservation`) VALUES
(1, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(2, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(3, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(4, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(5, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(6, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(7, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(8, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(9, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(10, 10, 10, 'test10', 'test10', 'test10', 'test10', 'test10', 10, 'test10', 'test10'),
(11, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(12, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(13, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(14, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1'),
(15, 1, 1, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 'test1');

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
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stand`
--

INSERT INTO `stand` (`id_stand`, `titre_stand`, `proprietaire_stand`, `type_marchandise`, `date_debut_stand`, `date_fin_stand`) VALUES
(12, 'test1', 'test1', 'test1', 'test1', 'test1'),
(3, 'titre12', 'titre12', 'titre12', 'titre12', 'titre12'),
(4, 'test1', 'test1', 'test1', 'test1', 'test1'),
(11, 'test1', 'test1', 'test1', 'test1', 'test1'),
(6, 'yes', 'yes', 'yes', 'yes', 'yes'),
(7, 'test1', 'test1', 'test1', 'test1', 'test1'),
(8, 'final', 'final', 'final', 'final', 'final'),
(9, 'trash', 'trash', 'trash', 'trash', 'trash'),
(10, 'feres', 'feres', 'feres', 'feres', 'feres'),
(13, 'test1', 'test1', 'test1', 'test1', 'test1'),
(15, 'test1', 'test1', 'test1', 'test1', 'test1'),
(16, 'test1', 'test1', 'test1', 'test1', 'test1'),
(17, 'plz', 'plz', 'plz', 'plz', 'plz'),
(18, 'yassertrash', 'yassertrash', 'yassertrash', 'yassertrash', 'yassertrash');

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
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `login_user`, `mdp_user`, `mail_user`, `prenom_user`, `nom_user`, `cin_user`, `date_naissance_user`, `num_tel_user`, `photo_profil_user`, `role_user`) VALUES
(7, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 97979, 'test97979', 979797, '25/25/25', 'test97979'),
(2, 'test26', 'test26', 'test26', 'test26', 'test26', 26, 'test26', 26, '26/26/26', 'test26'),
(4, 'test25', 'test25', 'test25', 'test25', 'test25', 25, 'test25', 25, '25/25/25', 'test25'),
(5, 'i m a god', 'test25', 'test25', 'test25', 'test25', 25, 'test25', 25, '25/25/25', 'test25'),
(6, 'test97979', 'test97979', 'test97979', 'test97979', 'test97979', 97979, 'test97979', 979797, '25/25/25', 'test97979'),
(35, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL),
(34, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL),
(31, 'test1', 'test1', 'test1', 'test1', 'test1', 1, 'test1', 1, 'test1', '1'),
(30, 'test0', 'test0', 'test0', 'test0', 'test0', 0, 'test0', 0, 'test0', '0'),
(32, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, 'test'),
(33, 'Koussay', '123', 'koussay@koussay.kouusay', 'Koussay', 'Koussay', 123, '123/123/123', 123, 'Koussay', 'Member');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
