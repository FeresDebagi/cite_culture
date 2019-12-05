-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 04, 2019 at 08:49 PM
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`IdCategorie`, `TypeCategorie`) VALUES
(3, 'aaa'),
(4, 'bbb'),
(5, 'ccc');

-- --------------------------------------------------------

--
-- Table structure for table `conference`
--

DROP TABLE IF EXISTS `conference`;
CREATE TABLE IF NOT EXISTS `conference` (
  `id_conference` int(11) NOT NULL AUTO_INCREMENT,
  `TitreConference` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DescriptionConference` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DateConference` datetime NOT NULL,
  `IdSalle` int(11) DEFAULT NULL,
  `idSpeaker` int(11) DEFAULT NULL,
  `nbr` int(11) DEFAULT NULL,
  `image_conference` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_conference`),
  KEY `IdSalle` (`IdSalle`),
  KEY `idSpeaker` (`idSpeaker`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `conference`
--

INSERT INTO `conference` (`id_conference`, `TitreConference`, `DescriptionConference`, `DateConference`, `IdSalle`, `idSpeaker`, `nbr`, `image_conference`) VALUES
(1, 'Dont Touch', 'Dont Touch', '2019-12-17 00:45:00', 3, 3, 0, NULL),
(2, 'aztazta', 'aztazta', '2019-12-31 00:00:00', 3, 3, 10, NULL),
(3, 'image', 'image', '2014-03-01 00:00:00', 2, 3, 1, '5b89499a98e69010e7f0ffd3a3c96898.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id_event` int(11) NOT NULL AUTO_INCREMENT,
  `IdCategorie` int(11) DEFAULT NULL,
  `description_event` varchar(255) DEFAULT NULL,
  `titre_event` varchar(255) DEFAULT NULL,
  `date_event` datetime DEFAULT NULL,
  `prix_event` int(11) DEFAULT NULL,
  `salle_event` int(11) DEFAULT NULL,
  `image_event` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `nbr` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_event`),
  KEY `IdCategorie` (`IdCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evenement`
--

INSERT INTO `evenement` (`id_event`, `IdCategorie`, `description_event`, `titre_event`, `date_event`, `prix_event`, `salle_event`, `image_event`, `updated_at`, `nbr`) VALUES
(1, 3, 'Dont Touch', 'Dont Touch', '2019-12-01 00:00:00', 132, 1, 'Dont Touch', '2019-12-01 00:00:00', 0),
(15, 4, 'test', 'test', '2019-12-06 00:12:00', 2, 12, 'favicon.ico', '2019-12-02 17:19:58', 2),
(16, 3, 'aaaaa', 'aaaaaaa', '0012-12-12 00:12:00', 12, 21, NULL, NULL, 2),
(17, 3, 'test2', 'test2', '0015-12-15 03:15:00', 12, 15, 'favicon.ico', '2019-12-02 18:07:14', 3),
(18, 3, 'try this 1', 'try this 1', '2019-11-04 00:12:00', 12, 12, 'favicon.ico', '2019-12-04 15:19:31', 0),
(19, 3, 'aaaaaaa', 'aaaaaaa', '2019-12-05 00:12:00', 12, 2, 'C:\\wamp64\\tmp\\php8441.tmp', NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `foire`
--

DROP TABLE IF EXISTS `foire`;
CREATE TABLE IF NOT EXISTS `foire` (
  `id_foire` int(11) NOT NULL AUTO_INCREMENT,
  `description_foire` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_foire` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `titre_foire` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prix_foire` int(11) DEFAULT NULL,
  `idStand` int(11) DEFAULT NULL,
  `DateFoire` datetime DEFAULT NULL,
  PRIMARY KEY (`id_foire`),
  KEY `idStand` (`idStand`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `foire`
--

INSERT INTO `foire` (`id_foire`, `description_foire`, `image_foire`, `titre_foire`, `prix_foire`, `idStand`, `DateFoire`) VALUES
(3, 'image', '31a2aeddc4aa15153996e1813689bc1d.jpeg', 'image', 2, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `formation`
--

DROP TABLE IF EXISTS `formation`;
CREATE TABLE IF NOT EXISTS `formation` (
  `id_formation` int(11) NOT NULL AUTO_INCREMENT,
  `prixformation` double DEFAULT NULL,
  `idSalle` int(11) DEFAULT NULL,
  `DateFormation` datetime NOT NULL,
  `formateurformation` varchar(255) DEFAULT NULL,
  `classeformation` varchar(255) DEFAULT NULL,
  `typeformation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_formation`),
  KEY `idSalle` (`idSalle`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `formation`
--

INSERT INTO `formation` (`id_formation`, `prixformation`, `idSalle`, `DateFormation`, `formateurformation`, `classeformation`, `typeformation`) VALUES
(1, 1, 2, '2019-12-05 00:12:00', 'Dont Touch', 'Dont Touch', 'Dont Touch'),
(2, 11, 3, '2019-12-04 00:00:00', 'testtest', 'testtest', 'testtest');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
CREATE TABLE IF NOT EXISTS `history` (
  `id_history` int(11) NOT NULL AUTO_INCREMENT,
  `description_history` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_history` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `titre_history` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IdCategorie` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_history`),
  KEY `IdCategorie` (`IdCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id_history`, `description_history`, `image_history`, `titre_history`, `IdCategorie`) VALUES
(20, 'test', 'favicon.ico', 'test', 4),
(21, 'test', 'favicon.ico', 'test', 4),
(22, 'Dont Touch', NULL, 'Dont Touch', 3),
(23, 'aaaaaaa', NULL, 'aaaaaaa', 3),
(24, 'aaaaaaa', NULL, 'aaaaaaa', 3),
(25, 'try this 1', NULL, 'try this 1', 3),
(26, 'try this 1', 'favicon.ico', 'try this 1', 3);

-- --------------------------------------------------------

--
-- Table structure for table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `idinscription` int(11) NOT NULL AUTO_INCREMENT,
  `id_formation` int(11) DEFAULT NULL,
  `iduser` int(11) DEFAULT NULL,
  `dateAjout` datetime DEFAULT NULL,
  PRIMARY KEY (`idinscription`),
  KEY `iduser` (`iduser`),
  KEY `id_formation` (`id_formation`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `inscription`
--

INSERT INTO `inscription` (`idinscription`, `id_formation`, `iduser`, `dateAjout`) VALUES
(21, 2, 3, '2019-12-04 12:09:26');

-- --------------------------------------------------------

--
-- Table structure for table `inscriptionconference`
--

DROP TABLE IF EXISTS `inscriptionconference`;
CREATE TABLE IF NOT EXISTS `inscriptionconference` (
  `idinscription` int(11) NOT NULL AUTO_INCREMENT,
  `id_conference` int(11) DEFAULT NULL,
  `iduser` int(11) DEFAULT NULL,
  `dateAjout` datetime DEFAULT NULL,
  PRIMARY KEY (`idinscription`),
  KEY `iduser` (`iduser`),
  KEY `id_conference` (`id_conference`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `inscriptionconference`
--

INSERT INTO `inscriptionconference` (`idinscription`, `id_conference`, `iduser`, `dateAjout`) VALUES
(1, 2, 1, '2019-12-04 12:40:50');

-- --------------------------------------------------------

--
-- Table structure for table `inscriptionevent`
--

DROP TABLE IF EXISTS `inscriptionevent`;
CREATE TABLE IF NOT EXISTS `inscriptionevent` (
  `idinscription` int(11) NOT NULL AUTO_INCREMENT,
  `id_event` int(11) DEFAULT NULL,
  `iduser` int(11) DEFAULT NULL,
  `dateAjout` datetime DEFAULT NULL,
  PRIMARY KEY (`idinscription`),
  KEY `iduser` (`iduser`),
  KEY `id_event` (`id_event`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `inscriptionevent`
--

INSERT INTO `inscriptionevent` (`idinscription`, `id_event`, `iduser`, `dateAjout`) VALUES
(1, 15, 1, '2019-12-04 12:35:59'),
(2, 16, 3, '2019-12-04 15:15:49'),
(3, 18, 1, '2019-12-04 15:20:00'),
(4, 18, 1, '2019-12-04 15:20:12'),
(5, 18, 1, '2019-12-04 15:20:41'),
(6, 18, 1, '2019-12-04 15:21:11'),
(7, 18, 1, '2019-12-04 15:21:16'),
(8, 18, 1, '2019-12-04 15:22:36');

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `idSalle` int(11) NOT NULL AUTO_INCREMENT,
  `numSalle` int(11) NOT NULL,
  PRIMARY KEY (`idSalle`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salle`
--

INSERT INTO `salle` (`idSalle`, `numSalle`) VALUES
(2, 1),
(3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `speaker`
--

DROP TABLE IF EXISTS `speaker`;
CREATE TABLE IF NOT EXISTS `speaker` (
  `idspeaker` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) DEFAULT NULL,
  `nomspeaker` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prenomspeaker` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mailspeaker` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `datearrive` date DEFAULT NULL,
  `datedepart` date DEFAULT NULL,
  `descriptionspeaker` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PhotoSpeaker` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_speaker` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idspeaker`),
  KEY `idU_fk` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `speaker`
--

INSERT INTO `speaker` (`idspeaker`, `iduser`, `nomspeaker`, `prenomspeaker`, `mailspeaker`, `datearrive`, `datedepart`, `descriptionspeaker`, `PhotoSpeaker`, `image_speaker`) VALUES
(3, 1, 'aaaaaa', 'aaaaaa', 'aaaaaa', '2014-01-02', '2015-01-17', 'aaaaaa', 'aaaaaa', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `stand`
--

DROP TABLE IF EXISTS `stand`;
CREATE TABLE IF NOT EXISTS `stand` (
  `id_stand` int(11) NOT NULL AUTO_INCREMENT,
  `titre_stand` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `proprietaire_stand` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type_marchandise` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `taille` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_stand`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `stand`
--

INSERT INTO `stand` (`id_stand`, `titre_stand`, `proprietaire_stand`, `type_marchandise`, `taille`) VALUES
(1, 'aaaaaaaa', 'aaaaaaaa', 'aaaaaaaa', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `UNIQ_8D93D64992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_8D93D649A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_8D93D649C05FB297` (`confirmation_token`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `iduser`, `nom`, `prenom`) VALUES
('test', 'test', 'test@test.test', 'test@test.test', 1, NULL, '$2y$13$j9CTKsITMObsRI3CjanNaO8eXKQAtuQyZp3yVXpgJDyoR96vGi/q2', '2019-12-04 20:38:50', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_CLIENT\";}', 1, 'test', 'test'),
('elyes', 'elyes', 'elyes.fakhar@esprit.tn', 'elyes.fakhar@esprit.tn', 1, NULL, '$2y$13$pQSpwTmHrJ9dP5xlXUAnXeEZJlr64pkO4ROtK7Eo72IXpGanLxKEC', '2019-12-04 19:20:15', NULL, NULL, 'a:2:{i:0;s:11:\"ROLE_CLIENT\";i:1;s:10:\"ROLE_ADMIN\";}', 2, 'elyes', 'elyes'),
('koussay', 'koussay', 'koussay@koussay.koussay', 'koussay@koussay.koussay', 1, NULL, '$2y$13$MbfWZwR9bH/6p1Th1JoUSeCOx8N9sg1eW1YcAK.VxPz9rE2faPQ92', '2019-12-04 12:56:45', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_CLIENT\";}', 3, 'koussay', 'koussay');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `conference`
--
ALTER TABLE `conference`
  ADD CONSTRAINT `FK_911533C86B3CB093` FOREIGN KEY (`idSpeaker`) REFERENCES `speaker` (`idspeaker`),
  ADD CONSTRAINT `FK_911533C896EE04DD` FOREIGN KEY (`IdSalle`) REFERENCES `salle` (`idSalle`);

--
-- Constraints for table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `evenement_ibfk_1` FOREIGN KEY (`IdCategorie`) REFERENCES `categorie` (`IdCategorie`);

--
-- Constraints for table `foire`
--
ALTER TABLE `foire`
  ADD CONSTRAINT `FK_D4C2ECA9737D5BAB` FOREIGN KEY (`idStand`) REFERENCES `stand` (`id_stand`);

--
-- Constraints for table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `formation_ibfk_1` FOREIGN KEY (`idSalle`) REFERENCES `salle` (`idSalle`);

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `FK_27BA704B330B72B5` FOREIGN KEY (`IdCategorie`) REFERENCES `categorie` (`IdCategorie`);

--
-- Constraints for table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `FK_5E90F6D65E5C27E9` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`),
  ADD CONSTRAINT `FK_5E90F6D6C0759D98` FOREIGN KEY (`id_formation`) REFERENCES `formation` (`id_formation`);

--
-- Constraints for table `inscriptionconference`
--
ALTER TABLE `inscriptionconference`
  ADD CONSTRAINT `FK_35C1531D349FB31F` FOREIGN KEY (`id_conference`) REFERENCES `conference` (`id_conference`),
  ADD CONSTRAINT `FK_35C1531D5E5C27E9` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`);

--
-- Constraints for table `inscriptionevent`
--
ALTER TABLE `inscriptionevent`
  ADD CONSTRAINT `FK_86FC2E0B5E5C27E9` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`),
  ADD CONSTRAINT `FK_86FC2E0BD52B4B97` FOREIGN KEY (`id_event`) REFERENCES `evenement` (`id_event`);

--
-- Constraints for table `speaker`
--
ALTER TABLE `speaker`
  ADD CONSTRAINT `FK_7B85DB615E5C27E9` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
