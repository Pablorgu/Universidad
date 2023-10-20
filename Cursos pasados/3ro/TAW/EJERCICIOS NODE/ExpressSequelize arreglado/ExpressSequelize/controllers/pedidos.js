var initModels = require("../models/init-models");
const sequelize = require("sequelize");
var models = initModels(sequelize);

const controller = {};

//Listar pedidos////////////////////////////////////////////////////////////////////////////////////////////////////////
controller.listarPedidos= async function (req, res, next) {
    try{
       const pedidos = await models.PURCHASE_ORDER.findAll({
           where: {
               CUSTOMER_ID: req.params.id
           }
       });
       const productos = await models.PRODUCT.findAll();
       res.render("pedidos", {pedidos: pedidos, productos: productos});
    } catch (error){
        res.send("Se ha producido un error " + error);
    }
}

module.exports = controller;