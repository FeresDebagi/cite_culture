-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 15, 2019 at 10:14 AM
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
-- Database: `cite`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `IdCategorie` int(11) NOT NULL AUTO_INCREMENT,
  `TypeCategorie` varchar(255) NOT NULL,
  PRIMARY KEY (`IdCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`IdCategorie`, `TypeCategorie`) VALUES
(1, 'dance'),
(2, 'music');

-- --------------------------------------------------------

--
-- Table structure for table `conference`
--

DROP TABLE IF EXISTS `conference`;
CREATE TABLE IF NOT EXISTS `conference` (
  `idConference` int(11) NOT NULL AUTO_INCREMENT,
  `TitreConference` varchar(255) NOT NULL,
  `IdSalle` int(11) NOT NULL,
  `DescriptionConference` varchar(255) NOT NULL,
  `idSpeaker` int(11) NOT NULL,
  `DateConference` varchar(255) NOT NULL,
  `HeureConference` varchar(255) NOT NULL,
  PRIMARY KEY (`idConference`),
  KEY `IdSalle` (`IdSalle`),
  KEY `idSpeaker` (`idSpeaker`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id_event` int(11) NOT NULL AUTO_INCREMENT,
  `IdCategorie` int(11) DEFAULT NULL,
  `description_event` varchar(255) DEFAULT NULL,
  `image_event` varchar(255) DEFAULT NULL,
  `titre_event` varchar(255) DEFAULT NULL,
  `date_event` varchar(255) DEFAULT NULL,
  `heure_event` varchar(255) DEFAULT NULL,
  `prix_event` int(11) DEFAULT NULL,
  `salle_event` varchar(255) DEFAULT NULL,
  `user_name_event` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_event`),
  KEY `IdCategorie` (`IdCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evenement`
--

INSERT INTO `evenement` (`id_event`, `IdCategorie`, `description_event`, `image_event`, `titre_event`, `date_event`, `heure_event`, `prix_event`, `salle_event`, `user_name_event`) VALUES
(2, 2, 'aaaaaaaaaaa', 'bbb', 'bbb', 'bbb', 'bbb', 5, 'bbb', 'aaaaa');

-- --------------------------------------------------------

--
-- Table structure for table `foire`
--

DROP TABLE IF EXISTS `foire`;
CREATE TABLE IF NOT EXISTS `foire` (
  `idFoire` int(11) NOT NULL AUTO_INCREMENT,
  `TypeFoire` varchar(255) NOT NULL,
  PRIMARY KEY (`idFoire`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `idSalle` int(11) NOT NULL,
  `DateFormation` varchar(255) NOT NULL,
  PRIMARY KEY (`id_formation`),
  KEY `idSalle` (`idSalle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `idSalle` int(11) NOT NULL AUTO_INCREMENT,
  `numSalle` int(11) NOT NULL,
  PRIMARY KEY (`idSalle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `speaker`
--

DROP TABLE IF EXISTS `speaker`;
CREATE TABLE IF NOT EXISTS `speaker` (
  `id_speaker` int(11) NOT NULL AUTO_INCREMENT,
  `nom_speaker` varchar(255) DEFAULT NULL,
  `prenom_speaker` varchar(255) DEFAULT NULL,
  `mail_speaker` varchar(255) DEFAULT NULL,
  `date_arrive` varchar(255) DEFAULT NULL,
  `date_depart` varchar(255) DEFAULT NULL,
  `description_speaker` varchar(255) DEFAULT NULL,
  `idU_fk` int(11) NOT NULL,
  `PhotoSpeaker` varchar(50000) DEFAULT NULL,
  `proprietaire_speaker` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_speaker`),
  KEY `idU_fk` (`idU_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `IdU_fk` int(255) NOT NULL,
  `PhotoStand` varchar(50000) DEFAULT NULL,
  `Actif` varchar(255) NOT NULL,
  PRIMARY KEY (`id_stand`),
  KEY `IdU_fk` (`IdU_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `photo_profil_user` varchar(50000) DEFAULT NULL,
  `role_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `conference`
--
ALTER TABLE `conference`
  ADD CONSTRAINT `conference_ibfk_1` FOREIGN KEY (`IdSalle`) REFERENCES `salle` (`idSalle`),
  ADD CONSTRAINT `conference_ibfk_2` FOREIGN KEY (`idSpeaker`) REFERENCES `speaker` (`id_speaker`);

--
-- Constraints for table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `evenement_ibfk_1` FOREIGN KEY (`IdCategorie`) REFERENCES `categorie` (`IdCategorie`);

--
-- Constraints for table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `formation_ibfk_1` FOREIGN KEY (`idSalle`) REFERENCES `salle` (`idSalle`);

--
-- Constraints for table `stand`
--
ALTER TABLE `stand`
  ADD CONSTRAINT `stand_ibfk_1` FOREIGN KEY (`IdU_fk`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
