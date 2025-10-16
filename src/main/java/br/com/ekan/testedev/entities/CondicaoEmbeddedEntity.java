package br.com.ekan.testedev.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CondicaoEmbeddedEntity {

    private String anotacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cid_id")
    private CidEntity cid;
}