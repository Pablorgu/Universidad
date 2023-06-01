var initModels = require("../data/init-models");
const sequelize = require("sequelize");
var models = initModels(sequelize);


const controller = {};

controller.listarAlbums = async function (req, res, next) {
    try{
        const albums = await models.albums.findAll();
        res.render("index", {albums: albums})
    } catch (error) {
        res.send("Se ha producido un error" + error);
    }
}

controller.enviar = async function (req, res, next) {
    try {
        const album = await models.albums.findOne({
            where: {
                AlbumId: req.body.AlbumId
            }
        });
        res.redirect("/listar/"+album.AlbumId);
    } catch (error) {
        res.send("Se ha producido un error " + error);
    }
}

controller.listarCanciones = async function (req, res, next) {
    try{
        const canciones = await models.tracks.findAll({
            where: {
                AlbumId: req.params.id
            }
            });
        const album = await models.albums.findOne({
            where: {
                AlbumId: req.params.id
            }
        });
        res.render("canciones", {canciones: canciones, album: album})
    }catch (error) {
        res.send("Se ha producido un error " + error);
    }
}

controller.mostrarGenero = async function(req, res, next) {
    try{
        const genero = await models.genres.findOne({
            where: {
                GenreId: req.params.id
            }
        });
        res.send("El genero de la cancion es: "+ genero.Name)
    }catch (error) {
        res.send("Se ha producido un error " + error);
    }
}

controller.editar = async function(req, res, next) {
    try{
        const cancion = await models.tracks.findOne({
            where: {
                TrackId: req.params.id
            }
        });
        res.render("cancion", {cancion: cancion});
    }catch (error) {
        res.send("Se ha producido un error " + error);
    }
}


controller.guardarCancion = async function(req, res, next) {
    try{
        const cancion = await models.tracks.findOne({
            where: {
                TrackId: req.body.TrackId
            }
        });
        if(cancion){
                await cancion.update(
                    {
                        AlbumId: req.body.AlbumId,
                        MediaTypeId: req.body.MediaTypeId,
                        GenreId: req.body.GenreId,
                        UnitPrice: req.body.UnitPrice,
                        Name: req.body.Name,
                        Composer: req.body.Composer,
                        Milliseconds: req.body.Milliseconds,
                        Bytes: req.body.Bytes,
                    }
                );
            }
        res.redirect('/listar/'+cancion.AlbumId);
    }catch (error) {
        res.send("Se ha producido un error" + error);
    }
};

module.exports = controller;