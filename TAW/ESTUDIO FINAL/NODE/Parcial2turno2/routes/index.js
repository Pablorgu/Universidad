const express = require("express");
const router = express.Router();

const albumsController = require('../controllers/album');

router.get("/", albumsController.listarAlbums);
router.post("/enviar", albumsController.enviar);
router.get("/listar/:id", albumsController.listarCanciones);
router.get("/genero/:id", albumsController.mostrarGenero);
router.get("/editar/:id", albumsController.editar);
router.post("/guardar", albumsController.guardarCancion);

module.exports = router;