package strikergames.App.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Campo Nome obrigatorio.")
    private String nome;

    @NotEmpty(message = "Campo senha obrigatorio.")
    private String senha;

    @Email
    @NotEmpty(message = "Campo Email obrigatorio.")
    private String email;

    @NotEmpty(message = "Campo telefone obrigatorio.")
    private String telefone;

    @CPF
    private String cpf;

    private String cep;

    private String bairro;

    private String cidade;

    private String logradouro;

    private String complemento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", logradouro=" + logradouro +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
