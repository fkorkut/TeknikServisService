package egitim.uniyaz.web.converter;

import egitim.uniyaz.domain.Ariza;
import egitim.uniyaz.web.dto.ArizaDto;

import java.util.ArrayList;
import java.util.List;

public class ArizaConverter {

    public ArizaDto convertToArizaDto(Ariza ariza){

        ArizaDto arizaDto = new ArizaDto();
        arizaDto.setId(ariza.getId());
        arizaDto.setMusteriId(ariza.getMusteriId());
        arizaDto.setMusteriIsim(ariza.getMusteriIsim());
        arizaDto.setMusteriSoyisim(ariza.getMusteriSoyisim());
        arizaDto.setMusteriTC(ariza.getMusteriTC());
        arizaDto.setIcerik(ariza.getIcerik());
        arizaDto.setArizaDurum(ariza.getArizaDurum());
        arizaDto.setBaslangicTarihi(ariza.getBaslangicTarihi());

        return arizaDto;

    }


    public Ariza convertToAriza(ArizaDto arizaDto){
        Ariza ariza = new Ariza();

        ariza.setId(arizaDto.getId());
        ariza.setMusteriId(arizaDto.getMusteriId());
        ariza.setMusteriIsim(arizaDto.getMusteriIsim());
        ariza.setMusteriSoyisim(arizaDto.getMusteriSoyisim());
        ariza.setMusteriTC(arizaDto.getMusteriTC());
        ariza.setIcerik(arizaDto.getIcerik());
        ariza.setArizaDurum(arizaDto.getArizaDurum());
        ariza.setBaslangicTarihi(arizaDto.getBaslangicTarihi());

        return  ariza;

    }


    public List<ArizaDto> convertToArizaToList(List<Ariza> arizaList){
        List<ArizaDto> arizaDtoList = new ArrayList<>();

        for (Ariza ariza : arizaList) {
            ArizaDto arizaDto = convertToArizaDto(ariza);
            arizaDtoList.add(arizaDto);
        }
        return  arizaDtoList;
    }
}
