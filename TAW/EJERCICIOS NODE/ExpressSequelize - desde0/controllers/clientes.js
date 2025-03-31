var initModels = require("../models/init-models");
const sequelize = require("sequelize");
var models = initModels(sequelize);

const controller = {};

controller.listarClientes = async function (req, res, next) {
    try{
        await models.CUSTOMER.findAll().then(async (data) => {
            res.render("index", {clientes: data});
        });
    }catch (error) {
        res.send("Se ha producido un error" + error);
    }
};

