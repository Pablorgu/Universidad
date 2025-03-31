var initModels = require("../data/init-models");
const sequelize = require("sequelize");
var models = initModels(sequelize);

const controller = {};

controller.mostrarlogin = async function(req, res, next) {
    try{
        const mensaje = "";
        const email= "";
        res.render("index", {mensaje: mensaje, email:email})
    }catch (error) {
        res.send("Se ha producido un error " + error);
    }
}

controller.comprobarlogin = async function(req, res, next) {
    try{
        const customer = await models.customers.findOne({
            where:{
                Email: req.body.EMAIL
            }
        })
        if(customer===null || customer.City != req.body.CLAVE){
            const mensaje= "Error de autenticación"
            const email= req.body.EMAIL
            res.render("index", {mensaje:mensaje, email:email})
        }else {
            res.redirect("/pedidos/"+customer.CustomerId)
        }
    }catch(error) {
        res.send("Se ha producido un error" + error);
    }
}


module.exports = controller;