package candidatura;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        //analisarCandidato(1900.0);
        //analisarCandidato(2200.0);
        //analisarCandidato(2000.0);

        //selecaoCandidato();
        //String[] candidatosSelecionados = {"PEDRO", "JULIANA", "PATRICIA", "MARINA", "HELENA"};
        List<String> candidatosSelecionados = selecaoCandidato();
        imprimirSelecionados(candidatosSelecionados);

        for(String candidato: candidatosSelecionados) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if(atendeu) {
            System.out.printf("CONSEGUIMOS CONTATO COM %s NA TENTATIVA %d.\n", candidato, tentativasRealizadas);
        } else {
            System.out.printf("NÃO CONSEGUIMOS CONTATO COM O CANDIDATO %s, SENDO REALIZADAS %d TENTATIVAS.\n", candidato, tentativasRealizadas);
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados(List<String> candidatosSelecionados) {
        System.out.println("Imprimindo a lista de candidatos selecionados informando o indice do elemento");
        for(int indice = 0; indice < candidatosSelecionados.size(); indice++) {
            System.out.printf("O candidato de nº %d é o %s.\n",indice + 1, candidatosSelecionados.get(indice));
        }

        System.out.println("Forma abreviada de iteração for each");
        for(String candidado: candidatosSelecionados) {
            System.out.printf("O candidato selecionado foi %s.\n", candidado);
        }
    }

    static List<String> selecaoCandidato() {

        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO","MIRELA", "DANIELA", "FABIANA", "PEDRO", "ANA JULIA"};
        
        List<String> candidatosSelecionados = new ArrayList<String>();    
        
        int qtdCandidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (qtdCandidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("O candidato %s solicitou um salario no valor de %.2f.\n", candidato, salarioPretendido);
            if(salarioBase >= salarioPretendido) {
                System.out.printf("O candidato %s foi selecionado para a vaga.\n", candidato);
                candidatosSelecionados.add(candidato);
                qtdCandidatosSelecionados++;
            }
            candidatosAtual++;
        }

        return candidatosSelecionados;
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1750, 2350);
    }

    static void analisarCandidato(double salarioPretendido) {

        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        }
        else if(salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }
        else {
            System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATOS");
        }
    }

}
