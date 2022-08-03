package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Contratos;
import entidades.Departamento;
import entidades.Trabalhadores;
import entidades.enums.NiveisDosTrabalhadores;

public class PrincipaSistemaDeDepartamento {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("INFORME O NOME DO DEPARTAMENTO: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("### DADOS DO TRABALHADOR ###");
		System.out.print("INFORME O NOME: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("INFORME O NÍVEL: ");
		String nomeNivel = sc.nextLine();
		System.out.print("INFORME O SALARIO BASE: ");
		double salarioBase = sc.nextDouble();
		Trabalhadores trabalhador = new Trabalhadores(nomeTrabalhador, NiveisDosTrabalhadores.valueOf(nomeNivel),
				salarioBase, new Departamento(nomeDepartamento));

		System.out.println("--------------------------------------------------------------------------------");
		System.out.print("INFORME A QUANTIDADE DE CONTRATOS DO FUNCIONARIO: ");
		int qtdContrato = sc.nextInt();

		for (int i = 0; i < qtdContrato; i++) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("### DADOS DO " + (i + 1) + "º CONTRATO ###");
			System.out.print("INFORME A DATA(DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("INFORME O VALOR POR HORA: R$");
			double valorHora = sc.nextDouble();
			System.out.print("DURAÇÃO(HORAS): ");
			int qtdHoras = sc.nextInt();
			Contratos contrato = new Contratos(dataContrato, valorHora, qtdHoras);

			trabalhador.addContratos(contrato);
		}

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("### CALCULO DE GANHOS SALARIAL ###");

		System.out.print("INFORME O MÊS E O ANO PARA CALCULAR O SALARIO(MM/YYYY): ");
		String mesAndAno = sc.next();
		int mes = Integer.parseInt(mesAndAno.substring(0, 2));
		int ano = Integer.parseInt(mesAndAno.substring(3));

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("### EXIBIR DADOS DO FUNCIONARIO ###");
		System.out.println("NOME: " + trabalhador.getNome());
		System.out.println("DEPARTAMENTO: " + trabalhador.getDepartamento().getNome());
		System.out.println("GANHO TOTAL " + mesAndAno + ": " + String.format("%.2f", trabalhador.ganhoNoMes(ano, mes)));

		sc.close();
	}
}
