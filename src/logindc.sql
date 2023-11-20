-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2023 a las 03:20:14
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `logindc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuariobd`
--

CREATE TABLE `usuariobd` (
  `correo` varchar(30) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `contraseña` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuariobd`
--

INSERT INTO `usuariobd` (`correo`, `usuario`, `contraseña`) VALUES
('cam@dc.com', 'fals', 0x313233343536),
('da.123@gm.com', 'camd123', 0x313233343536),
('davidccr2@gmail.com', 'davidccr2', 0x313233343536),
('prueba@prueba.com', 'prueba', 0x343536373839);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuariobd`
--
ALTER TABLE `usuariobd`
  ADD PRIMARY KEY (`correo`,`usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
