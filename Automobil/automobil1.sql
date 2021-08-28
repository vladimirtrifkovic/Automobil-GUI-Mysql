-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2021 at 08:06 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `automobil1`
--

-- --------------------------------------------------------

--
-- Table structure for table `automobili`
--

CREATE TABLE `automobili` (
  `id` int(5) NOT NULL,
  `proizvodjac` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tip` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `godiste` int(11) NOT NULL,
  `cena` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `automobili`
--

INSERT INTO `automobili` (`id`, `proizvodjac`, `tip`, `godiste`, `cena`) VALUES
(15, 'Renault', 'megan', 2000, 60000),
(17, 'Opel', 'Ampera', 2015, 13000),
(18, 'Opel', 'Astra', 2015, 11000),
(19, 'Audi', 'A7', 2019, 52000),
(20, 'Audi', 'A4', 2016, 23000),
(21, 'Renault', 'Captur', 2014, 8000),
(22, 'Renault', 'Kadjar', 2017, 17000),
(23, 'Bmw', '318 Gran Turisimo', 2015, 15500),
(24, 'Bmw', 'M3', 2009, 27000),
(25, 'Fiat', '500L', 2018, 13000),
(26, 'Fiat', 'Stilo', 2007, 2500),
(27, 'Mercedes', 'C250', 2016, 23000),
(28, 'Mercedes', 'E220', 2018, 27500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `automobili`
--
ALTER TABLE `automobili`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `automobili`
--
ALTER TABLE `automobili`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
