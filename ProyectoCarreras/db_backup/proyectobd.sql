-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-10-2016 a las 17:17:47
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectobd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE `carrera` (
  `nombre` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `organizador` int(2) NOT NULL,
  `distancia` int(3) NOT NULL,
  `desnivel` int(5) NOT NULL,
  `precio` int(4) NOT NULL,
  `fecha` date NOT NULL,
  `lugar` varchar(25) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `carrera`
--

INSERT INTO `carrera` (`nombre`, `organizador`, `distancia`, `desnivel`, `precio`, `fecha`, `lugar`) VALUES
('Apuko Igoera', 1, 21, 2111, 21, '2005-10-02', 'Usan'),
('Gorbeia Suzien', 3, 34, 2500, 34, '2016-10-11', 'Zeanuri'),
('Upo Igoera', 2, 12, 1222, 23, '2016-10-04', 'Usansolo'),
('Vuelta al Aneto', 4, 58, 5600, 80, '2016-10-04', 'Benasque');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarioadmin`
--

CREATE TABLE `usuarioadmin` (
  `nombre` varchar(25) NOT NULL,
  `apellidos` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(10) NOT NULL,
  `direccion` varchar(25) NOT NULL,
  `telefono` int(9) NOT NULL,
  `club` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarioadmin`
--

INSERT INTO `usuarioadmin` (`nombre`, `apellidos`, `email`, `password`, `direccion`, `telefono`, `club`) VALUES
('admin', 'admin', 'admin@admin.com', 'Admin1234', 'admin', 123456789, 'admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarionormal`
--

CREATE TABLE `usuarionormal` (
  `nombre` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `apellidos` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `email` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `password` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `direccion` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` int(9) NOT NULL,
  `club` varchar(25) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuarionormal`
--

INSERT INTO `usuarionormal` (`nombre`, `apellidos`, `email`, `password`, `direccion`, `telefono`, `club`) VALUES
('aitor', 'barrena', 'aitor@aitor.com', 'Aitor1234', 'igorre', 946006265, 'Araiamendi'),
('asier', 'arrese', 'arres@arres.com', 'Arres1234', 'galdakao', 956008668, 'ttb'),
('unai', 'saisnazs ', 'un@unan.com', 'Unai1234', 'uansdu', 123456789, 'ttb'),
('unai', 'sainz', 'unaisa@unai.com', 'Unai1808', 'unai', 123456789, 'unai');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarioorganizador`
--

CREATE TABLE `usuarioorganizador` (
  `id` int(2) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellidos` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(10) NOT NULL,
  `direccion` varchar(25) NOT NULL,
  `telefono` int(9) NOT NULL,
  `club` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarioorganizador`
--

INSERT INTO `usuarioorganizador` (`id`, `nombre`, `apellidos`, `email`, `password`, `direccion`, `telefono`, `club`) VALUES
(1, 'unai', 'sainz', 'unai@unai.com', 'Unai1234', 'unaisainz', 123456789, 'ttb'),
(2, 'sendoa', 'santiago', 'sen@sen.com', 'Sen1234', 'barakaldo', 956006565, 'TTB'),
(3, 'Hanot', 'Echevarria', 'hanot@hanot.com', 'Hanot1234', 'Galdakao', 946002958, 'TTB'),
(4, 'David', 'Martin', 'david@david.com', 'David1234', 'Sestao', 946002965, 'TTB');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `organizador` (`organizador`);

--
-- Indices de la tabla `usuarioadmin`
--
ALTER TABLE `usuarioadmin`
  ADD PRIMARY KEY (`email`);

--
-- Indices de la tabla `usuarionormal`
--
ALTER TABLE `usuarionormal`
  ADD PRIMARY KEY (`email`);

--
-- Indices de la tabla `usuarioorganizador`
--
ALTER TABLE `usuarioorganizador`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarioorganizador`
--
ALTER TABLE `usuarioorganizador`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD CONSTRAINT `carrera_ibfk_1` FOREIGN KEY (`organizador`) REFERENCES `usuarioorganizador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
