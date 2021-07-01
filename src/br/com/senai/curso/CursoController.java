package br.com.senai.curso;

import java.util.List;
import java.util.Scanner;

public class CursoController {
	private Scanner tec;
	
	public CursoController() {
		tec = new Scanner(System.in);
		}
	
	public int leOpcao() {
		System.out.print("> ");
		return tec.nextInt();	
	}
	

	public Curso cadastrarCurso() {
		Curso curso = new Curso();
		
		System.out.println("--- CADASTRAR CURSO ---");
		System.out.println("Informe o nome do curso: ");
		curso.setNomeCurso(tec.next());
		
		return curso;
	}
	
	public List<Curso> listarCurso(List<Curso> cursos) {
		
		if(cursos.isEmpty()) {
			System.out.println("Não possui cursos para listar.");
			return null;
		}
		
		System.out.println("--- CURSOS CADASTRADOS ---");
		System.out.printf("| %2s | %10s |\n",
				"Id", "Nome do curso");
		
		for(int i = 0; i < cursos.size(); i++) {
			System.out.printf("| %2d | %10s |\n",
			i,
			cursos.get(i).getNomeCurso());
		}
		
		return cursos;
	}

	public List<Curso> editarCurso(List<Curso> cursos) {
		
		if(cursos.isEmpty()) {
			System.out.println("Não existem dados cadastrados");
			return cursos;
		}
		
		Curso curso = new Curso();
		listarCurso(cursos);
		
		if(cursos.isEmpty()) {
			return null;
		}
		
		System.out.println("Informe o Id do curso para editar: ");
		int iDCurso = tec.nextInt();
		
		System.out.println("1) Nome do curso");
		System.out.println("Informe a opção desejada: ");
		int opcao = tec.nextInt();
		
		switch(opcao) {
		case 1:
			System.out.println("--- EDITAR O NOME DO CURSO ---");
			System.out.print("Informe o novo nome do curso: ");
			curso.setNomeCurso(tec.next());
			
			cursos.set(iDCurso, curso);
			break;
		}
		
		return cursos;

	}
	public void excluirCurso(List<Curso> cursos) {
		
		if(cursos.isEmpty()) {
			System.out.println("Não existem dados cadastrados");
			return;
		}
		
		listarCurso(cursos);
		
		if(cursos.isEmpty()) {
			return;
		}
		
		System.out.println("--- EXCLUIR CURSO ---");
		
		System.out.print("Informe o Id do curso para excluir: ");
		int iDCurso = tec.nextInt();
		
		if(cursos.size() < iDCurso) {
			System.out.println("Curso não cadastrado");
			return;
		}
		
		cursos.remove(iDCurso);
	}
	
	public void menu(List<Curso> cursos) {
		System.out.println("--- MENU ---");
		System.out.println("1) Cadastrar curso");
		System.out.println("2) Listar cursos");
		System.out.println("3) Editar cursos");
		System.out.println("4) Excluir cursos");
		
		int opcao = leOpcao();
		
		switch(opcao) {
		case 1:
			cursos.add(cadastrarCurso());
			break;
			
		case 2:
			listarCurso(cursos);
			break;
			
		case 3:
			editarCurso(cursos);
			break;
			
		case 4:
			excluirCurso(cursos);
			break;
			
		}

	}
}
	


