-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 30, 2023 at 05:11 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crud_service`
--

DELIMITER $$
--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `get_key` () RETURNS VARCHAR(5) CHARSET utf8mb4 COLLATE utf8mb4_general_ci DETERMINISTIC BEGIN
	 DECLARE gen_key VARCHAR(4);
    INSERT INTO agit_increment() VALUE();
    SELECT CONVERT(MAX(id),CHAR(4)) INTO gen_key FROM agit_increment;
    RETURN LPAD(gen_key,4,'0');
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `agit_book`
--

CREATE TABLE `agit_book` (
  `id_book` varchar(50) NOT NULL,
  `judul` varchar(255) DEFAULT NULL,
  `peminjam` varchar(255) DEFAULT NULL,
  `penerbit` varchar(255) DEFAULT NULL,
  `pengarang` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tanggal_kembali` date DEFAULT NULL,
  `tanggal_pinjam` date DEFAULT NULL,
  `tanggal_terbit` date DEFAULT NULL,
  `tebal_buku` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `agit_book`
--

INSERT INTO `agit_book` (`id_book`, `judul`, `peminjam`, `penerbit`, `pengarang`, `status`, `tanggal_kembali`, `tanggal_pinjam`, `tanggal_terbit`, `tebal_buku`) VALUES
('A0001', '1', NULL, '1', '1', 0, NULL, NULL, '2023-07-29', '1');

-- --------------------------------------------------------

--
-- Table structure for table `agit_increment`
--

CREATE TABLE `agit_increment` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `agit_increment`
--

INSERT INTO `agit_increment` (`id`) VALUES
(1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agit_book`
--
ALTER TABLE `agit_book`
  ADD PRIMARY KEY (`id_book`);

--
-- Indexes for table `agit_increment`
--
ALTER TABLE `agit_increment`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agit_increment`
--
ALTER TABLE `agit_increment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
