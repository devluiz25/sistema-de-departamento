package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NiveisDosTrabalhadores;

public class Trabalhadores {

	private String nome;
	private NiveisDosTrabalhadores nivel;
	private Double salarioBase;

	private Departamento departamento;
	private List<Contratos> contratos = new ArrayList<>();

	public Trabalhadores() {
	}

	public Trabalhadores(String nome, NiveisDosTrabalhadores nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NiveisDosTrabalhadores getNivel() {
		return nivel;
	}

	public void setNivel(NiveisDosTrabalhadores nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Contratos> getContratos() {
		return contratos;
	}

	public void addContratos(Contratos contrato) {
		contratos.add(contrato);
	}

	public void removerContratos(Contratos contrato) {
		contratos.remove(contrato);
	}

	public double ganhoNoMes(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (Contratos c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);

			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
}
