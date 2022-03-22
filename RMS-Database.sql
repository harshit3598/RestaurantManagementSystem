-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2020 at 09:51 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rms`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `CategoryId` int(11) NOT NULL,
  `CategoryName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`CategoryId`, `CategoryName`) VALUES
(1, 'Chinese'),
(2, 'South Indian'),
(3, 'Mexican');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `MobileNumber` varchar(10) NOT NULL,
  `CustomerName` char(30) NOT NULL,
  `DOB` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`MobileNumber`, `CustomerName`, `DOB`) VALUES
('123456789', 'Idris', '2019-09-10'),
('27791189', 'Darshan', NULL),
('4567890098', 'Darshan', NULL),
('7729219280', 'Idris', NULL),
('928190109', 'Darshan', NULL),
('9586892020', 'Mustafa', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customersitting`
--

CREATE TABLE `customersitting` (
  `CustomerSittingId` int(11) NOT NULL,
  `MobileNumber` varchar(10) NOT NULL,
  `TableId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customersitting`
--

INSERT INTO `customersitting` (`CustomerSittingId`, `MobileNumber`, `TableId`) VALUES
(1, '123456789', 1),
(1227, '27791189', 2),
(1842, '928190109', 1),
(4722, '9586892020', 1),
(4729, '7729219280', 3),
(4920, '4567890098', 1),
(9878, '9586892020', 3);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `ItemId` int(11) NOT NULL,
  `ItemName` varchar(30) NOT NULL,
  `ItemDescription` varchar(100) NOT NULL,
  `ItemPrice` float NOT NULL,
  `CategoryId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`ItemId`, `ItemName`, `ItemDescription`, `ItemPrice`, `CategoryId`) VALUES
(1, 'Dosa', '...', 120, 2),
(2, 'Manchurian', '...', 200, 1),
(5, 'Dosa', '...', 120, 2);

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

CREATE TABLE `orderdetail` (
  `OrderId` varchar(80) NOT NULL,
  `OrderDate` date NOT NULL,
  `OrderDiscount` float NOT NULL DEFAULT 0,
  `OrderTotal` float NOT NULL DEFAULT 0,
  `CustomerSittingId` int(11) NOT NULL,
  `isComplete` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`OrderId`, `OrderDate`, `OrderDiscount`, `OrderTotal`, `CustomerSittingId`, `isComplete`) VALUES
('1', '2020-12-02', 0, 120, 1, 0),
('2', '2020-12-12', 0, 680, 1, 0),
('Order_Sat_Dec_26_14:07:50_IST_2020', '2020-12-26', 0, 120, 1227, 0),
('Order_Sat_Dec_26_14:07:59_IST_2020', '2020-12-26', 0, 120, 4920, 0),
('Order_Sat_Dec_26_14:09:15_IST_2020', '2020-12-26', 0, 0, 9878, 0);

-- --------------------------------------------------------

--
-- Table structure for table `ordereditems`
--

CREATE TABLE `ordereditems` (
  `OrderedItemsId` int(11) NOT NULL,
  `OrderId` varchar(80) NOT NULL,
  `ItemId` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Status` int(11) NOT NULL,
  `Instruction` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ordereditems`
--

INSERT INTO `ordereditems` (`OrderedItemsId`, `OrderId`, `ItemId`, `Quantity`, `Status`, `Instruction`) VALUES
(6, 'Order_Sat_Dec_26_14:07:59_IST_2020', 1, 1, 0, 'D'),
(7, 'Order_Sat_Dec_26_14:07:50_IST_2020', 1, 1, 0, 'Jain');

-- --------------------------------------------------------

--
-- Table structure for table `restauranttable`
--

CREATE TABLE `restauranttable` (
  `TableId` int(11) NOT NULL,
  `TableCapacity` int(11) NOT NULL,
  `Occupied` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restauranttable`
--

INSERT INTO `restauranttable` (`TableId`, `TableCapacity`, `Occupied`) VALUES
(1, 4, 1),
(2, 6, 1),
(3, 8, 1),
(4, 12, 0),
(5, 6, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `mobileNumber` char(10) NOT NULL,
  `password` varchar(30) NOT NULL,
  `userType` int(11) NOT NULL,
  `userName` char(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`mobileNumber`, `password`, `userType`, `userName`) VALUES
('1234567890', 'LVOm2yCx9ASjp4xLuv4R9Q==', 3, ''),
('3456789', 'LVOm2yCx9ASjp4xLuv4R9Q==', 3, ''),
('9408548950', 'Darshan2020@', 3, ''),
('9586892020', 'Idris2020@', 2, '');

-- --------------------------------------------------------

--
-- Table structure for table `usertype`
--

CREATE TABLE `usertype` (
  `UserTypeId` int(11) NOT NULL,
  `UserTypeName` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usertype`
--

INSERT INTO `usertype` (`UserTypeId`, `UserTypeName`) VALUES
(1, 'Manager'),
(2, 'Waiter'),
(3, 'Chef');

-- --------------------------------------------------------

--
-- Table structure for table `waitinglist`
--

CREATE TABLE `waitinglist` (
  `WaitingNumber` int(11) NOT NULL,
  `NumberOfPerson` int(11) NOT NULL,
  `MobileNumber` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CategoryId`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`MobileNumber`);

--
-- Indexes for table `customersitting`
--
ALTER TABLE `customersitting`
  ADD PRIMARY KEY (`CustomerSittingId`),
  ADD KEY `MobileNumber` (`MobileNumber`),
  ADD KEY `TableId` (`TableId`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`ItemId`),
  ADD KEY `ItemCategoryId` (`CategoryId`);

--
-- Indexes for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`OrderId`),
  ADD KEY `CustomerSittingId` (`CustomerSittingId`);

--
-- Indexes for table `ordereditems`
--
ALTER TABLE `ordereditems`
  ADD PRIMARY KEY (`OrderedItemsId`),
  ADD KEY `ItemId` (`ItemId`),
  ADD KEY `OrderId` (`OrderId`);

--
-- Indexes for table `restauranttable`
--
ALTER TABLE `restauranttable`
  ADD PRIMARY KEY (`TableId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`mobileNumber`),
  ADD KEY `UserType` (`userType`);

--
-- Indexes for table `usertype`
--
ALTER TABLE `usertype`
  ADD PRIMARY KEY (`UserTypeId`);

--
-- Indexes for table `waitinglist`
--
ALTER TABLE `waitinglist`
  ADD PRIMARY KEY (`WaitingNumber`),
  ADD KEY `MobileNumber` (`MobileNumber`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `CategoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `customersitting`
--
ALTER TABLE `customersitting`
  MODIFY `CustomerSittingId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9879;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `ItemId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `ordereditems`
--
ALTER TABLE `ordereditems`
  MODIFY `OrderedItemsId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `restauranttable`
--
ALTER TABLE `restauranttable`
  MODIFY `TableId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `waitinglist`
--
ALTER TABLE `waitinglist`
  MODIFY `WaitingNumber` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customersitting`
--
ALTER TABLE `customersitting`
  ADD CONSTRAINT `customersitting_ibfk_3` FOREIGN KEY (`MobileNumber`) REFERENCES `customer` (`MobileNumber`),
  ADD CONSTRAINT `customersitting_ibfk_4` FOREIGN KEY (`TableId`) REFERENCES `restauranttable` (`TableId`);

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`CategoryId`) REFERENCES `category` (`CategoryId`);

--
-- Constraints for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`CustomerSittingId`) REFERENCES `customersitting` (`CustomerSittingId`);

--
-- Constraints for table `ordereditems`
--
ALTER TABLE `ordereditems`
  ADD CONSTRAINT `ordereditems_ibfk_1` FOREIGN KEY (`ItemId`) REFERENCES `item` (`ItemId`),
  ADD CONSTRAINT `ordereditems_ibfk_2` FOREIGN KEY (`OrderId`) REFERENCES `orderdetail` (`OrderId`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`userType`) REFERENCES `usertype` (`UserTypeId`);

--
-- Constraints for table `waitinglist`
--
ALTER TABLE `waitinglist`
  ADD CONSTRAINT `waitinglist_ibfk_1` FOREIGN KEY (`MobileNumber`) REFERENCES `customer` (`MobileNumber`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
