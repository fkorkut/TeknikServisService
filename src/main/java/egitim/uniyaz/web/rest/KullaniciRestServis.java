package egitim.uniyaz.web.rest;

import egitim.uniyaz.dao.KullaniciDao;
import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.web.converter.KullaniciConverter;
import egitim.uniyaz.web.dto.KullaniciDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.ws.rs.Path;


@Path("/kullanici")
public class KullaniciRestServis{

    @POST
    @Path("/findKullanici")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByIdPost(KullaniciDto kullaniciDto) {
        KullaniciConverter kullaniciConverter = new KullaniciConverter();
        Kullanici kullanici = kullaniciConverter.covertToKullanici(kullaniciDto);


        KullaniciDao kullaniciDao = new KullaniciDao();
        kullanici = kullaniciDao.findKullanici(kullanici);

        kullaniciDto = kullaniciConverter.convertToKullaniciDto(kullanici);

        return  Response.ok().entity(kullaniciDto).build();
    }
}
