package fr.centralelille.ig2i.la2.poo.jpa.domain.personne.medecin;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.BusinessException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.ErrorMessage;
import fr.centralelille.ig2i.la2.poo.jpa.repository.MedecinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedecinServiceImpl implements MedecinService {

    private final MedecinRepository medecinRepository;

    @Override
    public Medecin findMedecin(String idMedecin) throws MedecinNotFoundException {
        return Optional.ofNullable(medecinRepository.getMedecinById(idMedecin))
                .orElseThrow(() -> new MedecinNotFoundException(idMedecin));
    }

    @Override
    public String createMedecin(Medecin medecin) throws BusinessException {
        Optional.ofNullable(medecin).orElseThrow(() -> new BusinessException(ErrorMessage.builder()
                .error("medecin.notProvided")
                .message("Aucun médecin fourni")
                .build()));

        medecin.setId(UUID.randomUUID().toString());

        medecinRepository.save(medecin);
        return medecin.getId();
    }

    // Sans JPQL, on navigue des les objets afin de retrouver les informations voulues
    // Ici par exemple de Medecin ver la liste des Service qu'il dirige puis vers les listes
    // de Medecin qui composent ces services
    @Override
    public List<Medecin> getSubordonnedMedecin(String idMedecin) throws MedecinNotFoundException {

        return Optional.ofNullable(medecinRepository.getMedecinById(idMedecin))
                .orElseThrow(() -> new MedecinNotFoundException(idMedecin))
                .getServicesDiriges()
                .stream()
                .flatMap(service -> service.getMedecins().stream())
                .collect(Collectors.toList());
    }

    // Ici on appelle simplement la fonction suivante qui possède une Query JQPL
    // Pas de navigation, on vient directement retrouvé les informations en BDD
    @Override
    public List<Medecin> getSubordonnedMedecinJPQL(String idMedecin) {
        return medecinRepository.getSubordonnedMedecin(idMedecin);
    }

    @Override
    public List<String> getSubordonnedMedecinIdsJPQL(String idMedecin) {
        return medecinRepository.getSubordonnedMedecinIds(idMedecin);
    }
}
