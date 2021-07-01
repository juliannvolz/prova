package br.com.senai.aluno;

import java.util.List;
import java.util.Scanner;

import br.com.senai.curso.Curso;
import br.com.senai.curso.CursoController;

public class AlunoController {

	private Scanner tec;
	private CursoController cursoController;
	
	
	public AlunoController() {
		tec = new Scanner(System.in);
		cursoController = new CursoController();
	}
	
	public int leOpcao() {
		System.out.print("> ");
		return tec.nextInt();	
	}
	
	public void menu (List<Aluno> alunos, List<Curso> cursos) {
		System.out.println("--- MENU ---");
		System.out.println("1) Cadastrar aluno");
		System.out.println("2) Listar alunos");
		System.out.println("3) Editar alunos");
		System.out.println("4) Excluir alunos");
		
		int opcao = leOpcao();
		
		switch(opcao) {
		case 1:
			alunos.add(cadastrarAluno(cursos));
			break;
			
		case 2:
			listarAluno(alunos);
			break;
			
		case 3:
			editarAluno(alunos);
			break;
			
		case 4:
			excluirAluno(alunos);
			break;
			
		}
	}
	
	public Aluno cadastrarAluno(List<Curso> cursos) {
		
		cursoController.listarCurso(cursos);
		
		Aluno aluno = new Aluno();
		Curso curso = new Curso();
		
		System.out.println("--- CADASTRAR ALUNO ---");
		System.out.print("Informe o nome: ");
		tec.nextLine();
		aluno.setNomeAluno(tec.nextLine());
		
		System.out.print("Informe a sua idade: ");
		aluno.setIdadeAluno(tec.nextInt());
		
		System.out.print("Informe o país de origem: ");
		tec.nextLine();
		aluno.setPais(tec.nextLine());
		
		System.out.print("Informe seu estado: ");
		aluno.setEstado(tec.nextLine());
		
		System.out.print("Informe sua cidade: ");
		aluno.setCidade(tec.nextLine());
	
		System.out.println("Informe o curso desejado: ");
		curso.getNomeCurso();
		curso.setNomeCurso(tec.next());
		return aluno;
	}
	
	public List<Aluno> listarAluno(List<Aluno> alunos) {
		
		if(alunos.isEmpty()) {
			System.out.println("Não possui dados para listar");
			return null;
		}
		
		System.out.println(" --- ALUNOS CADASTRADOS ---");
		System.out.printf("| %2s | %10s | %4s | %6s | %15s | %15s | %10s\n",
				"Id", "Nome" , "Idade", "País", "Estado", "Cidade", "Curso");
		
		for(int i = 0; i < alunos.size(); i++) {
			System.out.printf("| %2d | %11s | %4d | %6s | %15s | %9s | %9s |\n",
			i,
			alunos.get(i).getNomeAluno(),
			alunos.get(i).getIdadeAluno(),
			alunos.get(i).getPais(),
			alunos.get(i).getEstado(),
			alunos.get(i).getCidade(),
			alunos.get(i).getCursos());
		}
		
			
		return alunos;
	}
	
	public List<Aluno> editarAluno(List<Aluno> alunos) {
		
		if(alunos.isEmpty()) {
			System.out.println("Não existem dados cadastrados");
			return null;
		}
		
		Aluno aluno = new Aluno();
		listarAluno(alunos);
		
		if(alunos.isEmpty()) {
			return null;
		}
		
		System.out.println("Informe o Id do aluno para editar: ");
		int iDAluno = tec.nextInt();
		
		System.out.println("1) Nome do aluno");
		System.out.println("2) Idade do aluno");
		System.out.println("3) Pais");
		System.out.println("4) Estado");
		System.out.println("5) Cidade");
		System.out.println("6) Curso");
		System.out.println("Informe o campo para ser editado");
		int opcao = tec.nextInt();
		
		switch(opcao) {
		case 1:
			System.out.println("--- EDITAR O NOME ---");
			System.out.println("Informe o novo nome do aluno: ");
			aluno.setNomeAluno(tec.next());
			
			aluno.setIdadeAluno(alunos.get(iDAluno).getIdadeAluno());
			aluno.setPais(alunos.get(iDAluno).getPais());
			aluno.setEstado(alunos.get(iDAluno).getEstado());
			aluno.setCidade(alunos.get(iDAluno).getCidade());
			aluno.setCursos(alunos.get(iDAluno).getCursos());
			
			alunos.set(iDAluno, aluno);
			break;
			
		case 2:
			System.out.println("--- EDITAR A IDADE ---");
			System.out.println("Informe a nova idade: ");
			aluno.setIdadeAluno(tec.nextInt());
			
			aluno.setNomeAluno(alunos.get(iDAluno).getNomeAluno());
			aluno.setPais(alunos.get(iDAluno).getPais());
			aluno.setEstado(alunos.get(iDAluno).getEstado());
			aluno.setCidade(alunos.get(iDAluno).getCidade());
			aluno.setCursos(alunos.get(iDAluno).getCursos());
			
			alunos.set(iDAluno, aluno);
			break;
			
		case 3:
			System.out.println("--- EDITAR O PAÍS ---");
			System.out.println("Informe o novo nome do país: ");
			aluno.setPais(tec.next());
			
			aluno.setNomeAluno(alunos.get(iDAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(iDAluno).getIdadeAluno());
			aluno.setEstado(alunos.get(iDAluno).getEstado());
			aluno.setCidade(alunos.get(iDAluno).getCidade());
			aluno.setCursos(alunos.get(iDAluno).getCursos());
			
			alunos.set(iDAluno, aluno);
			break;
			
		case 4:
			System.out.println("--- EDITAR O ESTADO ---");
			System.out.println("Informe o novo estado: ");
			aluno.setEstado(tec.next());
			
			aluno.setNomeAluno(alunos.get(iDAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(iDAluno).getIdadeAluno());
			aluno.setPais(alunos.get(iDAluno).getPais());
			aluno.setCidade(alunos.get(iDAluno).getCidade());
			aluno.setCursos(alunos.get(iDAluno).getCursos());
			
			alunos.set(iDAluno, aluno);
			break;
			
		case 5:
			System.out.println("--- EDITAR A CIDADE ---");
			System.out.println("Informe a nova cidade: ");
			aluno.setCidade(tec.next());
			
			aluno.setNomeAluno(alunos.get(iDAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(iDAluno).getIdadeAluno());
			aluno.setPais(alunos.get(iDAluno).getPais());
			aluno.setEstado(alunos.get(iDAluno).getEstado());
			aluno.setCursos(alunos.get(iDAluno).getCursos());
			
			alunos.set(iDAluno, aluno);
			break;
			
		case 6:
			System.out.println("--- EDITAR O CURSO DESEJADO ---");
			System.out.println("Informe o novo nome do curso: ");
			aluno.setCursos(tec.next());
			
			aluno.setNomeAluno(alunos.get(iDAluno).getNomeAluno());
			aluno.setIdadeAluno(alunos.get(iDAluno).getIdadeAluno());
			aluno.setPais(alunos.get(iDAluno).getPais());
			aluno.setEstado(alunos.get(iDAluno).getEstado());
			aluno.setCidade(alunos.get(iDAluno).getCidade());
			
			alunos.set(iDAluno, aluno);
			break;
			
		}
		
		return alunos;
		
	}
	public void excluirAluno(List<Aluno> alunos) {
		
		if(alunos.isEmpty()) {
			System.out.println("Não existem dados cadastrados");
			return;
		}
		
		listarAluno(alunos);
		
		if(alunos.isEmpty()) {
			return;
		}
		
		System.out.println("--- EXCLUIR ALUNO ---");
		
		System.out.print("Informe o Id do aluno para excluir: ");
		int iDAluno = tec.nextInt();
		
		if(alunos.size() < iDAluno) {
			System.out.println("Aluno não cadastrado");
			return;
		} 
		
		alunos.remove(iDAluno);
		
		
	}
	
}
