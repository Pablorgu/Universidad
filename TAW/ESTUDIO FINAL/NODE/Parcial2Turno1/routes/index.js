const express = require("express");
const router = express.Router();

const autenticacionController = require('../controllers/autenticacion');
const pedidosController = require('../controllers/pedidos')

router.get("/", autenticacionController.mostrarlogin)
router.post("/comprobar", autenticacionController.comprobarlogin)
router.get("/pedidos/:id", pedidosController.listarpedidos)
router.get("/detalle/:id", pedidosController.detalles)
router.get("/editar/:id", pedidosController.editarpedido)
router.post("/guardar", pedidosController.guardarpedido)


module.exports = router;