-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 29, 2019 at 10:24 AM
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
-- Table structure for table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `login_user` varchar(255) NOT NULL,
  `id_comment` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `id_formation` int(11) NOT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `id_user` (`id_user`,`id_formation`),
  KEY `id_formation` (`id_formation`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commentaire`
--

INSERT INTO `commentaire` (`login_user`, `id_comment`, `id_user`, `comment`, `id_formation`) VALUES
('elyes', 8, 36, 'poop', 6),
('elyes', 9, 36, 'me', 2),
('elyes', 10, 36, 'me', 6),
('elyes', 11, 36, 'elyes', 2),
('elyes', 12, 36, 'me', 6),
('elyes', 13, 36, 'off', 2),
('elyes', 14, 36, 'off', 6);

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evenement`
--

INSERT INTO `evenement` (`id_event`, `type_event`, `description_event`, `image_event`, `titre_event`, `date_event`, `heure_event`, `prix_event`, `salle_event`, `user_name_event`) VALUES
(28, 'oanzoitba', 'oanzoitba', 'oanzoitba', 'oanzoitba', 'oanzoitba', 'oanzoitba', 132, 'oanzoitba', 'oanzoitba'),
(29, 'oanzoitba', 'oanzoitba', 'oanzoitba', 'oanzoitba', 'oanzoitba', 'oanzoitba', 123, 'oanzoitba', 'feres'),
(30, 'azraz', 'azraz', 'C:wamp64wwwProjetPijavaCiteDeLaCultureIntegrationsrcmain\resourcesViewsStand.gif', 'azraz', 'azraz', 'azraz', 1234, 'azraz', 'feres feres');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `formation`
--

INSERT INTO `formation` (`id_formation`, `formateur_formation`, `classe_formation`, `prix_formation`, `type_formation`) VALUES
(1, 'keep out', 'keep out', 1, 'keep out 2'),
(3, 'koussay', 'is', 123, 'gay');

-- --------------------------------------------------------

--
-- Table structure for table `historique`
--

DROP TABLE IF EXISTS `historique`;
CREATE TABLE IF NOT EXISTS `historique` (
  `id_historique` int(11) NOT NULL AUTO_INCREMENT,
  `description_his` varchar(255) DEFAULT NULL,
  `image_his` varchar(50000) DEFAULT NULL,
  `video_his` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id_historique`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `historique`
--

INSERT INTO `historique` (`id_historique`, `description_his`, `image_his`, `video_his`) VALUES
(13, 'elyes', 'C:\\wamp64\\www\\Projectpi\\pics\\joojooo.jpg', 'C:\\wamp64\\www\\Projectpi\\pics\\joojooo.jpg'),
(12, 'me', 'C:\\Users\\kaskous\\Desktop\\joojooo.jpg', 'C:\\Users\\kaskous\\Desktop\\joojooo.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id_inscription` int(11) NOT NULL AUTO_INCREMENT,
  `id_event` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_formation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_inscription`),
  KEY `id_event` (`id_event`),
  KEY `id_user` (`id_user`),
  KEY `id_formation` (`id_formation`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inscription`
--

INSERT INTO `inscription` (`id_inscription`, `id_event`, `id_user`, `id_formation`) VALUES
(14, 28, 37, 1),
(15, 29, 37, 1),
(16, 30, 37, 1),
(17, 30, 47, 1),
(18, 30, 51, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id_reservation` int(11) NOT NULL AUTO_INCREMENT,
  `id_evenement` int(11) DEFAULT NULL,
  `date_debut` varchar(255) DEFAULT NULL,
  `date_fin` varchar(255) DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `titre_reservation` varchar(255) DEFAULT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_reservation`),
  KEY `id_user` (`id_user`),
  KEY `id_evenement` (`id_evenement`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `speaker`
--

INSERT INTO `speaker` (`id_speaker`, `nom_speaker`, `prenom_speaker`, `mail_speaker`, `date_arrive`, `date_depart`, `description_speaker`, `idU_fk`, `PhotoSpeaker`, `proprietaire_speaker`) VALUES
(5, 'ayedi', 'amin', 'amin.ayedi@gmail.com', '2019-10-17', '2019-10-25', 'speaker', 39, 'filepath', 'fakhar elyes'),
(6, 'kaffel', 'houssem', 'houssem.kaffe@esprit.Tn', '2019-10-17', '2019-11-22', 'houssem est un speaker de renommé', 39, 'C:\\Users\\Debagi\\Documents\\NetBeansProjects\\mavenproject1\\src\\main\\resources\\Views\\test.jpg', 'fakhar elyes');

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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stand`
--

INSERT INTO `stand` (`id_stand`, `titre_stand`, `proprietaire_stand`, `type_marchandise`, `date_debut_stand`, `date_fin_stand`, `IdU_fk`, `PhotoStand`, `Actif`) VALUES
(33, 'jchkchc', 'Fakhar elyes', 'vutcou', '2019-10-02', '2019-10-01', 47, 'filepath', 'no');

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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `login_user`, `mdp_user`, `mail_user`, `prenom_user`, `nom_user`, `cin_user`, `date_naissance_user`, `num_tel_user`, `photo_profil_user`, `role_user`) VALUES
(37, 'Feres', '1234', 'feres@feres.feres', 'feres', 'feres', 123, 'feres', 123, 'C:\\wamp64\\www\\ProjetPi\\java\\CiteDeLaCulture\\src\\main\\resources\\Views\\test.jpg', 'Admin'),
(41, 'houssem', '12345678', 'houssem@esprit.tn', 'houssem', 'houssem', 12345678, '2019-10-03', 12345678, 'C:\\wamp64\\www\\ProjetPi\\java\\CiteDeLaCulture\\src\\main\\resources\\Views\\test.jpg', 'Member'),
(44, 'loua', '12345678', 'loua@esprit.tn', 'loua', 'loua', 12345678, '2019-10-02', 12345678, 'C:\\wamp64\\www\\ProjetPi\\java\\CiteDeLaCulture\\src\\main\\resources\\Views\\test.jpg', 'Member'),
(45, 'sahar', '123', 'sahar', 'sahar', 'sahar', 123, 'sahar', 132, 'C:\\wamp64\\www\\ProjetPi\\java\\CiteDeLaCulture\\src\\main\\resources\\Views\\test.jpg', 'Member'),
(46, 'test', 'A123456789!', 'test.cite.de.la.culture@gmail.com', 'test', 'test', 123, '123', 123, 'C:\\wamp64\\www\\ProjetPi\\java\\CiteDeLaCulture\\src\\main\\resources\\Views\\test.jpg', 'Member'),
(47, 'elyes', '12345678', 'elyes.fakhar@esprit.tn', 'Fakhar', 'elyes', 1234567, '2019-10-02', 55532227, 'C:\\wamp64\\www\\ProjetPi\\java\\CiteDeLaCulture\\src\\main\\resources\\Views\\test.jpg', 'Admin'),
(49, 'koussay', 'koussay', 'koussay@esprit.tn', 'koussay', 'koussay', 123, 'koussay', 123, 'C:\\wamp64\\www\\ProjetPi\\java\\CiteDeLaCulture\\src\\main\\resources\\Views\\test.jpg', 'Admin'),
(51, 'amin', 'amin', 'amin@esprit.tn', 'amin', 'amin', 123, 'amin', 123, 'C:\\wamp64\\www\\ProjetPi\\java\\CiteDeLaCulture\\src\\main\\resources\\Views\\test.jpg', 'Admin'),
(52, '12345678', '12345678', 'salah@salah.com', 'salah', 'salah', 12345678, '2019-10-01', 123456789, 'C:\\wamp64\\www\\ProjetPi\\java\\CiteDeLaCulture\\src\\main\\resources\\Views\\test.jpg', 'Member'),
(53, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, NULL, NULL),
(54, 'hamza', '12345678', 'hamza@gmail.com', 'hamza', 'hamza', 12345678, '2019-10-02', 12345678, '', 'Member');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `inscription_ibfk_1` FOREIGN KEY (`id_event`) REFERENCES `evenement` (`id_event`),
  ADD CONSTRAINT `inscription_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `inscription_ibfk_3` FOREIGN KEY (`id_formation`) REFERENCES `formation` (`id_formation`);

--
-- Constraints for table `stand`
--
ALTER TABLE `stand`
  ADD CONSTRAINT `stand_ibfk_1` FOREIGN KEY (`IdU_fk`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
