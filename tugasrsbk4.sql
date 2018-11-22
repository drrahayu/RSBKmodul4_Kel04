-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2018 at 12:41 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tugasrsbk4`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `daftar`
-- (See below for the actual view)
--
CREATE TABLE `daftar` (
`NIM` bigint(15)
,`NAMA` varchar(50)
,`NAMA_PEMINATAN` varchar(50)
,`LAB` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `NIM` bigint(15) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `ID_MINAT` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`NIM`, `NAMA`, `ID_MINAT`) VALUES
(21128778, 'lisaaa', 111),
(21120115120028, 'Sam', 112),
(21120115120033, 'Hayu', 111),
(21128778444444, 'akakak', 111);

-- --------------------------------------------------------

--
-- Table structure for table `peminatan`
--

CREATE TABLE `peminatan` (
  `ID_MINAT` int(11) NOT NULL,
  `NAMA_PEMINATAN` varchar(50) NOT NULL,
  `LAB` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peminatan`
--

INSERT INTO `peminatan` (`ID_MINAT`, `NAMA_PEMINATAN`, `LAB`) VALUES
(101, 'software', 'se');

-- --------------------------------------------------------

--
-- Structure for view `daftar`
--
DROP TABLE IF EXISTS `daftar`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `daftar`  AS  select `mahasiswa`.`NIM` AS `NIM`,`mahasiswa`.`NAMA` AS `NAMA`,`peminatan`.`NAMA_PEMINATAN` AS `NAMA_PEMINATAN`,`peminatan`.`LAB` AS `LAB` from (`mahasiswa` left join `peminatan` on((`mahasiswa`.`ID_MINAT` = `peminatan`.`ID_MINAT`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`NIM`);

--
-- Indexes for table `peminatan`
--
ALTER TABLE `peminatan`
  ADD PRIMARY KEY (`ID_MINAT`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
