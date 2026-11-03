import java.util.Locale;
import java.util.Scanner;

public class Main {

    static final double MEDIA_APROVACAO = 7.0;
    static final double MEDIA_RECUPERACAO = 5.0;

    // v1.0 - Calcula a média de um aluno
    static double calcularMediaAluno(double[] notas) {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    // v2.0 - Calcula a média da turma (média das médias dos alunos)
    static double calcularMediaTurma(double[] mediasAlunos) {
        double soma = 0;
        for (double media : mediasAlunos) {
            soma += media;
        }
        return soma / mediasAlunos.length;
    }

    // v3.0 - Indica a situação do aluno
    static String obterSituacao(double media) {
        if (media >= MEDIA_APROVACAO) {
            return "Aprovado";
        } else if (media >= MEDIA_RECUPERACAO) {
            return "Recuperação";
        } else {
            return "Reprovado,tente novamente no proximo semestre!";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.forLanguageTag("pt-BR"));

        System.out.print("Quantidade de alunos: ");
        int qtdAlunos = sc.nextInt();
        System.out.print("Quantidade de notas por aluno: ");
        int qtdNotas = sc.nextInt();
        sc.nextLine();

        String[] nomes = new String[qtdAlunos];
        double[] medias = new double[qtdAlunos];

        for (int a = 0; a < qtdAlunos; a++) {
            System.out.print("\nNome do aluno " + (a + 1) + ": ");
            nomes[a] = sc.nextLine();

            double[] notas = new double[qtdNotas];
            for (int i = 0; i < qtdNotas; i++) {
                System.out.print("  Nota " + (i + 1) + ": ");
                notas[i] = sc.nextDouble();
            }
            sc.nextLine();
            medias[a] = calcularMediaAluno(notas);
        }

        System.out.println("\n===== RESULTADO =====");
        for (int a = 0; a < qtdAlunos; a++) {
            System.out.printf("%s -> média %.2f -> %s%n", nomes[a], medias[a], obterSituacao(medias[a]));
        }
        System.out.printf("Média da turma: %.2f%n", calcularMediaTurma(medias));
    }
}
