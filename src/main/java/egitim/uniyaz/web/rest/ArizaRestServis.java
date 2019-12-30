package egitim.uniyaz.web.rest;


import egitim.uniyaz.dao.ArizaDao;
import egitim.uniyaz.domain.Ariza;
import egitim.uniyaz.web.converter.ArizaConverter;
import egitim.uniyaz.web.dto.ArizaDto;
import egitim.uniyaz.web.dto.KullaniciDto;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;


@Provider
@Path("/ariza")
public class ArizaRestServis {

    @POST
    @Path("/findAllAriza")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllAriza() {
        ArizaDao arizaDao = new ArizaDao();
        List<Ariza> arizaList = arizaDao.findAllAriza();

        ArizaConverter arizaConverter = new ArizaConverter();
        List<ArizaDto> arizaDtoList = arizaConverter.convertToArizaToList(arizaList);

        return Response.ok().entity(arizaDtoList).build();
    }


    @POST
    @Path("/findArizaByName")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findArizaByName(String musteriIsim) {
        ArizaConverter arizaConverter = new ArizaConverter();

        ArizaDao arizaDao = new ArizaDao();
        List<Ariza> arizaList = arizaDao.searchAriza(musteriIsim);

        List<ArizaDto> arizaDtoList = arizaConverter.convertToArizaToList(arizaList);

        return Response.ok().entity(arizaDtoList).build();
    }


    @POST
    @Path("/saveAriza")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveAriza(ArizaDto arizaDto) {
        ArizaConverter arizaConverter = new ArizaConverter();
        Ariza ariza = arizaConverter.convertToAriza(arizaDto);

        ArizaDao arizaDao = new ArizaDao();
        ariza = arizaDao.saveAriza(ariza);

        arizaDto = arizaConverter.convertToArizaDto(ariza);

        return Response.ok().entity(arizaDto).build();
    }

}