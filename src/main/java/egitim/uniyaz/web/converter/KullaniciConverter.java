package egitim.uniyaz.web.converter;

import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.web.dto.KullaniciDto;

public class KullaniciConverter {

    public KullaniciDto convertToKullaniciDto(Kullanici kullanici){

        KullaniciDto kullaniciDto = new KullaniciDto();
        kullaniciDto.setId(kullanici.getId());
        kullaniciDto.setIsim(kullanici.getIsim());
        kullaniciDto.setSifre(kullanici.getSifre());

        return kullaniciDto;
    }

    public Kullanici covertToKullanici(KullaniciDto kullaniciDto){

        Kullanici kullanici = new Kullanici();
        kullanici.setId(kullaniciDto.getId());
        kullanici.setIsim(kullaniciDto.getIsim());
        kullanici.setSifre(kullaniciDto.getSifre());

        return  kullanici;
    }
}
