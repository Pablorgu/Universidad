const express = require("express");
const router = express.Router();

const clientesController = require('../controllers/clientes');
const pedidosController = require('../controllers/pedidos');

router.get("/", clientesController.listarClientes);
router.get("/editar/:id",clientesController.editarCliente);
router.get("/nuevo",clientesController.nuevoCliente);
router.post ("/guardar", clientesController.guardarCliente);
router.get("/borrar/:id", clientesController.borrarCliente);
router.post("/filtrar", clientesController.filtrarClientes);
router.get("/pedidos/:id", pedidosController.listarPedidos);

module.exports = router;