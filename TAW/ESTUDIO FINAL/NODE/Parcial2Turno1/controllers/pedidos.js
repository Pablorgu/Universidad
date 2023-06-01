var initModels = require("../data/init-models");
const sequelize = require("sequelize");
var models = initModels(sequelize);

const controller = {};

controller.listarpedidos = async function(req, res, next) {
    try{
        const customer =  await models.invoices.findOne({
            where:{
                CustomerId: req.params.id
            }
        });
        const pedidos = await models.invoices.findAll({
            where:{
                CustomerId: req.params.id
            }
        });
        res.render("pedidos", {customer:customer, pedidos: pedidos})
    }catch(error) {
        res.send("Se ha producido un error" + error);
    }
}

controller.detalles = async function(req, res, next) {
    try{
        const pedido = await models.invoice_items.findAll({
            where:{
                InvoiceId: req.params.id
            }
        });
        res.json(pedido);
    }catch(error) {
        res.send("Se ha producido un error" + error);
    }
}


controller.editarpedido = async function(req, res, next) {
    try{
        const pedido = await models.invoices.findOne({
            where: {
                InvoiceId: req.params.id
            }
        });
        res.render("pedido", {pedido:pedido})
    }catch(error) {
    res.send("Se ha producido un error" + error);
    }
}

controller.guardarpedido = async function(req, res, next) {
    try{
        const pedido = await models.invoices.findOne({
            where:{
                InvoiceId: req.body.INVOICEID
            }
        });
        await pedido.update(
            {
                BillingAddress: req.body.ADDRESS,
                BillingCity: req.body.CITY,
                BillingState: req.body.STATE,
                Total: req.body.TOTAL
            }
        );
        res.redirect("/pedidos/"+pedido.CustomerId)
    }catch(error) {
        res.send("Se ha producido un error" + error);
    }
}
module.exports = controller;