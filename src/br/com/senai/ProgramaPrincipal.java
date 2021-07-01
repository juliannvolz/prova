package br.com.senai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.aluno.Aluno;
import br.com.senai.aluno.AlunoController;
import br.com.senai.curso.Curso;
import br.com.senai.curso.CursoController;

public class ProgramaPrincipal {
	
	public static void main(String[] args) {
	 
		Scanner tec = new Scanner(System.in);
		List<Aluno> alunos = new ArrayList<>();
		List<Curso> cursos = new ArrayList<>();
		
		AlunoController alunoController = new AlunoController();
		CursoController cursoController = new CursoController();
		
		boolean sair = false;
		
		do {
			System.out.println("--- MENU ---");
			System.out.println("1) Registro de alunos");
			System.out.println("2) Registro de cursos");
			System.out.println("3) Sair do sistema");
			System.out.print("Informe a opção desejada: ");
			
			int opcao = tec.nextInt();
			
			switch(opcao) {
				case 1:
					alunoController.menu(alunos, cursos);
					break;
					
				case 2: 
					cursoController.menu(cursos);
					break;
				
				case 3:
					sair = true;
					break;
					
				default:
					System.out.println("Opção inválida");
					break;
			}
		} while(!sair);
		System.out.println("Sistema finalizado!");
		
	}
}
