-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 16-11-2016 a las 15:56:55
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.21

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
('Apuko Igoera', 1, 24, 2300, 12, '2000-10-08', 'Galda'),
('Gorbeia Suzien', 3, 40, 2500, 50, '2000-10-01', 'Zeanuri'),
('Gran Trail del Aneto', 5, 108, 7500, 90, '2016-08-24', 'Benasque'),
('Karraderan', 6, 31, 2000, 25, '2016-04-12', 'Larrabetzu'),
('Laudio Trail', 6, 24, 1300, 34, '2016-05-05', 'Laudio'),
('Lemoatx', 4, 16, 700, 30, '2016-11-08', 'Lemoa'),
('Maraton de las tucas', 5, 42, 2600, 40, '2016-08-24', 'Benasque'),
('Upo Igoera', 2, 12, 1222, 23, '2016-10-04', 'Usansolo'),
('Vuelta al aneto', 5, 58, 4000, 70, '2016-08-24', 'Benasque'),
('Vuelta al pico cerler', 5, 21, 1200, 20, '2016-08-24', 'Benasque');

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
('Anartz', 'Mugika', 'anartz@an.com', 'Anartz1234', 'Bergara 13', 946002818, 'Trail Team Bizkaia'),
('fernando', 'lopez', 'fer@fer.com', 'Fer1234', 'Goikoetxea', 946002111, 'Trail Team Gipuzkoa'),
('unaiN', 'unaiNa', 'unai@un.com', 'Nunai123', 'unaiNN', 946002912, 'TTB'),
('unai', 'sainz', 'unai@unai.com', 'Unai1808', 'unai', 123456789, 'unai');

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
(4, 'alex', 'alex', 'david@david.com', 'Alex1234', 'alexdir', 946002941, 'AlexClub'),
(5, 'esti', 'gamboa', 'esti@esti.com', 'Esti1234', 'Usansolo 13', 946003030, 'Trail Team Gipuzkoa'),
(6, 'Aitor', 'Sanchez', 'sanchez@aitor.com', 'Aitor1234', 'Pertxin bidea', 691536098, 'Athletic');

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
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
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
