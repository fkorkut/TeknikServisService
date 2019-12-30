package egitim.uniyaz.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Ariza")
public class Ariza extends BaseDomain{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String musteriTC;

    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String musteriIsim;


    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String musteriSoyisim;


    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long musteriId;


    @Column(length = 300)
    @Size(max = 300)
    private String icerik;


    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private ArizaDurum arizaDurum;


    private Date baslangicTarihi;

    public String getMusteriSoyisim() {
        return musteriSoyisim;
    }

    public void setMusteriSoyisim(String musteriSoyisim) {
        this.musteriSoyisim = musteriSoyisim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public ArizaDurum getArizaDurum() {
        return arizaDurum;
    }

    public void setArizaDurum(ArizaDurum arizaDurum) {
        this.arizaDurum = arizaDurum;
    }

    public Date getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(Date baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public String getMusteriTC() {
        return musteriTC;
    }

    public void setMusteriTC(String musteriTC) {
        this.musteriTC = musteriTC;
    }

    public String getMusteriIsim() {
        return musteriIsim;
    }

    public void setMusteriIsim(String musteriIsim) {
        this.musteriIsim = musteriIsim;
    }

    public Long getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(Long musteriId) {
        this.musteriId = musteriId;
    }


}
