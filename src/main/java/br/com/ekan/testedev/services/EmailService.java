package br.com.ekan.testedev.services;

import br.com.ekan.testedev.entities.AtendimentoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Async
    public void enviarEmailAtendimento(AtendimentoEntity atendimento) {
        try {
            String corpoEmail = "Olá!\n\nUm novo atendimento foi registrado:\n\n" +
                    "Paciente: " + atendimento.getPaciente().getNome() + "\n" +
                    "Data: " + atendimento.getDataAtendimento().toString() + "\n" +
                    "Anotação: " + atendimento.getCondicao().getAnotacao() + "\n" +
                    "CID: " + atendimento.getCondicao().getCid().getCodigo() + " - " + atendimento.getCondicao().getCid().getNome() + "\n\n" +
                    "Atenciosamente,\nEquipe Ekan";

            SimpleMailMessage mensagem = new SimpleMailMessage();
            mensagem.setFrom("hnino201333@gmail.com");
            mensagem.setTo("rdoni.ekan@iamspe.sp.gov.br");
            mensagem.setSubject("Novo Atendimento Registrado - Paciente: " + atendimento.getPaciente().getNome());
            mensagem.setText(corpoEmail);

            mailSender.send(mensagem);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar e-mail: " + e.getMessage());
        }
    }
}
