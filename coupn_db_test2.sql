-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 12, 2018 at 07:28 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coupn_db_test2`
--

-- --------------------------------------------------------

--
-- Table structure for table `Company`
--

CREATE TABLE `Company` (
  `ID` int(20) UNSIGNED NOT NULL,
  `COMP_NAME` varchar(50) NOT NULL DEFAULT '',
  `PASSWORD` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Company`
--

INSERT INTO `Company` (`ID`, `COMP_NAME`, `PASSWORD`, `EMAIL`) VALUES
(2, 'Google', '6452341', 'google@gmail.com'),
(7, 'PureBeauty', '31234333', 'beautypure@gmail.com'),
(16, 'Angel', '4444', 'an@ang.comm'),
(17, 'Mr.Backery', '5555', 'foodmarket@gmail.com'),
(18, 'Nudels Factory', '6666', 'nudels@gmail.com'),
(19, 'BigElectric', '777879', 'electric@gmail.com'),
(20, 'BigElectric1', '888098', 'flews@wgmail.com'),
(21, 'Tracklin', '8888', 'track@gmail.com'),
(22, 'Fast Food', '8888', 'ff@gmail.com'),
(23, 'Maps', '8888', 'maps@gmail.com'),
(24, 'AmudAnan', '8888', 'amudanan@gmail.com'),
(33, 'FoodliC122312', '8888', 'el34f@walla.com'),
(34, 'BUG', '1111', 'bug@gmail.com'),
(35, 'BUG2', '2222', 'bug1@gmail.com'),
(36, 'Foodli', '8888', 'el34f@walla.com'),
(37, 'BUG22', '2222', 'bug1@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `Company_Coupon`
--

CREATE TABLE `Company_Coupon` (
  `COMP_ID` decimal(10,0) NOT NULL,
  `COUPON_ID` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Coupon`
--

CREATE TABLE `Coupon` (
  `ID` int(20) UNSIGNED NOT NULL,
  `TITLE` varchar(50) NOT NULL DEFAULT '',
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `AMOUNT` int(20) DEFAULT NULL,
  `TYPE` varchar(50) DEFAULT '',
  `MESSAGE` varchar(50) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `IMAGE` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Coupon`
--

INSERT INTO `Coupon` (`ID`, `TITLE`, `START_DATE`, `END_DATE`, `AMOUNT`, `TYPE`, `MESSAGE`, `PRICE`, `IMAGE`) VALUES
(11, 'Health', '2023-11-04', '2025-11-05', 149, 'HEALTH', 'health service', 150, 'medical'),
(107, 'Food', '2019-06-06', '2019-12-12', 297, 'FOOD', 'A food tasting tour', 199, 'food plate'),
(108, 'Special vacation', '2020-01-01', '2020-12-31', 497, 'TRAVELLING', 'vacation ', 2000, 'Madrid'),
(109, 'Drinks', '2018-03-02', '2018-12-31', 247, 'RESTURANTS', 'Rest', 99, 'coffee'),
(117, 'Health Care', '2018-12-01', '2019-01-01', 999, 'HEALTH', 'A Special health care coupon', 300, 'doctor'),
(118, 'Camping fun', '2020-12-02', '2020-12-12', 399, 'CAMPING', 'Camping kit', 200, 'fire'),
(119, 'Sport star', '2019-04-14', '2021-05-05', 600, 'SPORTS', 'Sport', 400, 'fitness'),
(120, 'Dinning', '2025-01-01', '2025-09-09', 300, 'RESTURANTS', 'Dinning', 500, 'food'),
(123, 'Breakfast', '2020-03-03', '2022-03-03', 1000, 'RESTURANTS', 'Breakfast', 300, 'nature'),
(124, 'TV', '2021-03-04', '2023-03-04', 200, 'ELECTRICITY', 'Get a TV', 2000, 'tv flat'),
(125, 'Sport', '2022-01-01', '2022-12-31', 450, 'SPORTS', 'sport kit', 500, 'sport kit'),
(126, 'Food2', '2019-01-01', '2019-08-08', 99, 'FOOD', 'big food', 200, 'basket'),
(127, 'Beauty', '2021-04-05', '2022-05-05', 348, 'HEALTH', 'health special care', 150, 'woman');

-- --------------------------------------------------------

--
-- Table structure for table `Customer`
--

CREATE TABLE `Customer` (
  `ID` int(20) UNSIGNED NOT NULL,
  `CUST_NAME` varchar(50) NOT NULL DEFAULT '',
  `PASSWORD` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Customer`
--

INSERT INTO `Customer` (`ID`, `CUST_NAME`, `PASSWORD`) VALUES
(1, 'User1', '1111'),
(3, 'User2', '2222'),
(6, 'User3', '3333'),
(8, 'User4', '4444'),
(9, 'User5', '5555'),
(11, 'Joert Dar', '6666'),
(12, 'Joe Dar', '999');

-- --------------------------------------------------------

--
-- Table structure for table `Customer_Coupon`
--

CREATE TABLE `Customer_Coupon` (
  `CUST_ID` decimal(10,0) NOT NULL,
  `COUPON_ID` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Customer_Coupon`
--

INSERT INTO `Customer_Coupon` (`CUST_ID`, `COUPON_ID`) VALUES
('1', '11'),
('1', '107'),
('1', '108'),
('1', '109'),
('3', '117'),
('3', '118'),
('6', '107'),
('6', '127'),
('8', '109'),
('9', '107'),
('9', '108'),
('9', '109'),
('9', '127');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Company`
--
ALTER TABLE `Company`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Company_Coupon`
--
ALTER TABLE `Company_Coupon`
  ADD PRIMARY KEY (`COMP_ID`,`COUPON_ID`);

--
-- Indexes for table `Coupon`
--
ALTER TABLE `Coupon`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Customer`
--
ALTER TABLE `Customer`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Customer_Coupon`
--
ALTER TABLE `Customer_Coupon`
  ADD PRIMARY KEY (`CUST_ID`,`COUPON_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Company`
--
ALTER TABLE `Company`
  MODIFY `ID` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `Coupon`
--
ALTER TABLE `Coupon`
  MODIFY `ID` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=205;

--
-- AUTO_INCREMENT for table `Customer`
--
ALTER TABLE `Customer`
  MODIFY `ID` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
